package top.soest.service;

import top.soest.dto.LoginDTO;
import top.soest.dto.UserDTO;
import top.soest.entity.Manager;
import top.soest.entity.User;
import top.soest.vo.UserVO;

public interface UserService {
	User userLogin(LoginDTO loginDTO);

	void register(UserVO userVO);
}
