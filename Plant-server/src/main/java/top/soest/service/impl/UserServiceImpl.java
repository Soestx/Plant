package top.soest.service.impl;

import org.springframework.stereotype.Service;
import top.soest.dto.LoginDTO;
import top.soest.entity.Manager;
import top.soest.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Override
	public Manager userLogin(LoginDTO loginDTO) {
		return null;
	}
}
