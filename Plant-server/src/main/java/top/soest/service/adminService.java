package top.soest.service;

import top.soest.dto.LoginDTO;
import top.soest.dto.ManagerDTO;
import top.soest.entity.Manager;

public interface adminService {
	Manager ManagerLogin(LoginDTO loginDTO);

	void addManager(ManagerDTO managerDTO);
}
