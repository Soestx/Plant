package top.soest.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import top.soest.constant.MessageConstant;
import top.soest.constant.StatusConstant;
import top.soest.dto.LoginDTO;
import top.soest.dto.UserDTO;
import top.soest.entity.Manager;
import top.soest.entity.User;
import top.soest.exception.*;
import top.soest.mapper.UserMapper;
import top.soest.service.UserService;
import top.soest.vo.UserVO;

import java.time.LocalDateTime;
import java.util.Objects;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

	@Autowired
	UserMapper userMapper;

	@Override
	public User userLogin(LoginDTO loginDTO) {
		log.info("登录信息：{}", loginDTO);
		String account = loginDTO.getAccount();
		String password = loginDTO.getPassword();

		User user = new User();
		user.setAccount(account);
		user = userMapper.getByMap(user);

		if (user == null) {
			throw new AccountNotFoundException(MessageConstant.ACCOUNT_NOT_FOUND);
		}

		password = DigestUtils.md5DigestAsHex(password.getBytes());

		if (!Objects.equals(user.getPassword(), password)) {
			throw new PasswordErrorException(MessageConstant.PASSWORD_ERROR);
		}
		if (Objects.equals(user.getStatus(), StatusConstant.DISABLE)) {
			throw new AccountLockedException(MessageConstant.ACCOUNT_LOCKED);
		}
		return user;
	}

	@Override
	public void register(UserVO userVO) {
		log.info("注册信息：{}", userVO);
		User user = new User();

		// 检查账号是否已存在
		User newUser = userMapper.getByAccount(userVO.getAccount());
		if (newUser != null) {
			throw new AccountAlreadyExists(MessageConstant.ACCOUNT_ALREADY_EXISTS);
		}

		// 检查手机号是否已存在
		user.setPhone(userVO.getPhone());
		newUser = userMapper.getByMap(user);
		if (newUser != null) {
			throw new PhoneAlreadyExists(MessageConstant.PHONE_ALREADY_EXISTS);
		}

		BeanUtils.copyProperties(userVO, user);
		user.setCreateTime(LocalDateTime.now());
		user.setStatus(StatusConstant.ENABLE);
		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
		userMapper.addUser(user);
	}

	@Override
	public UserVO getInfoById(Long id) {

		User user = new User();
		user.setId(id);
		user = userMapper.getByMap(user);
		if (user == null) {
			throw new IdNotFoundException(MessageConstant.USER_NOT_FOUND);
		}
		UserVO userVO = new UserVO();
		BeanUtils.copyProperties(user, userVO);
		return userVO;
	}

	@Override
	public void updateInfo(UserDTO userDTO) {
		User user = new User();
		BeanUtils.copyProperties(userDTO, user);
		userMapper.updateUser(user);
	}


}
