package top.soest.controller.user;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.soest.constant.JwtClaimsConstant;
import top.soest.dto.LoginDTO;
import top.soest.dto.UserDTO;
import top.soest.entity.Manager;
import top.soest.entity.User;
import top.soest.properties.JwtProperties;
import top.soest.result.Result;
import top.soest.service.UserService;
import top.soest.utils.JwtUtil;
import top.soest.vo.LoginVO;
import top.soest.vo.UserVO;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Api(value = "用户模块", tags = "用户模块")
@Slf4j
public class UserController {

	@Autowired
	UserService userService;
	@Autowired
	JwtProperties jwtProperties ;

	@GetMapping("/login")
	@ApiOperation(value = "用户登录", notes = "登录")
	public Result<LoginVO> login(@RequestBody LoginDTO loginDTO) {

		log.info("登录信息：{}", loginDTO);

		User user = userService.userLogin(loginDTO);

		Map<String, Object> claims = new HashMap<>() ;
		claims.put(JwtClaimsConstant.USER_ID, user.getId());
		String token = JwtUtil.createJWT(
				jwtProperties.getAdminSecretKey(),
				jwtProperties.getAdminTtl(),
				claims
		);

		log.info("jwt令牌：{}", token);

		LoginVO loginVO = LoginVO.builder()
				.id(user.getId())
				.username(user.getUserName())
				.username(user.getAccount())
				.token(token)
				.build() ;

		return Result.success(loginVO);
	}

	@PostMapping
	@ApiOperation(value = "用户注册", notes = "注册")
	public Result register(@RequestBody UserVO userVO) {

		log.info("注册信息：{}", userVO);
		userService.register(userVO);
		return Result.success();
	}

	@GetMapping("/info")
	@ApiOperation(value = "获取用户信息", notes = "获取用户信息")
	public Result<UserVO> getInfo(Long id) {

		UserVO userVo = userService.getInfoById(id);
		return Result.success(userVo);
	}

	@PutMapping("/info")
	@ApiOperation(value = "更新用户信息", notes = "更新用户信息")
	public Result updateInfo(@RequestBody UserDTO userDTO) {

		//TODO:更新用户信息
		userService.updateInfo(userDTO);
		return Result.success();
	}
}
