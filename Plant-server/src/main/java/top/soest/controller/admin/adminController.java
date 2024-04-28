package top.soest.controller.admin;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.soest.constant.JwtClaimsConstant;
import top.soest.dto.LoginDTO;
import top.soest.dto.ManagerDTO;
import top.soest.entity.Manager;
import top.soest.properties.JwtProperties;
import top.soest.result.Result;
import top.soest.service.adminService;
import top.soest.utils.JwtUtil;
import top.soest.vo.LoginVO;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/admin")
@Api(tags = "管理员相关接口")
@Slf4j
public class adminController {

	@Autowired
	JwtProperties jwtProperties ;

	@Autowired
	adminService adminService;

	@PostMapping("/login")
	@ApiOperation(value = "用户登录", notes = "登录")
	public Result<LoginVO> login(@RequestBody LoginDTO loginDTO) {

		log.info("登录信息：{}", loginDTO);

		Manager manager = adminService.ManagerLogin(loginDTO);

		Map<String, Object> claims = new HashMap<>() ;
		claims.put(JwtClaimsConstant.EMP_ID, manager.getId());
		String token = JwtUtil.createJWT(
				jwtProperties.getAdminSecretKey(),
				jwtProperties.getAdminTtl(),
				claims
		);

		log.info("jwt令牌：{}", token);

		LoginVO loginVO = LoginVO.builder()
				.id(manager.getId())
				.name(manager.getName())
				.username(manager.getAccount())
				.token(token)
				.build() ;

		return Result.success(loginVO);
	}

	@PostMapping("/mag")
	@ApiOperation(value = "新增管理员", notes = "新增管理员")
	public Result add(@RequestBody ManagerDTO managerDTO) {

		log.info("新增管理员信息：{}", managerDTO);
		adminService.addManager(managerDTO);
		return Result.success();
	}

}
