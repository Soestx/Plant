package top.soest.interceptor;

import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import top.soest.context.BaseContext;
import top.soest.properties.JwtProperties;
import top.soest.utils.JwtUtil;

@Component
@Slf4j
public class JwtTokenAdminInterceptor implements HandlerInterceptor {

    @Autowired
    private JwtProperties jwtProperties;

    public boolean preHandle(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, Object handler) throws Exception {
        //判断是否为HandlerMethod，是则进入
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        log.info("进入拦截器");
        //判断是否为管理员身份
        String token = request.getHeader(jwtProperties.getAdminTokenName());

        try{
            log.info("token: " + token);
            Claims claims = JwtUtil.parseJWT(jwtProperties.getAdminSecretKey(), token);
            Long id = Long.valueOf(claims.get("empId").toString());
            BaseContext.setThreadLocal(id);
            return true;
        }catch (Exception e){
            response.setStatus(401);
            return false;
        }

    }
}
