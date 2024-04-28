package top.soest.service;

import top.soest.dto.LoginDTO;
import top.soest.entity.Manager;

public interface UserService {
	Manager userLogin(LoginDTO loginDTO);
}
