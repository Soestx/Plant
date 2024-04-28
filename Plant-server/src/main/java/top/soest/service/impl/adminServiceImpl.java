package top.soest.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import top.soest.constant.MessageConstant;
import top.soest.constant.StatusConstant;
import top.soest.context.BaseContext;
import top.soest.dto.LoginDTO;
import top.soest.dto.ManagerDTO;
import top.soest.entity.Manager;
import top.soest.exception.AccountLockedException;
import top.soest.exception.AccountNotFoundException;
import top.soest.exception.NoPermissionException;
import top.soest.exception.PasswordErrorException;
import top.soest.mapper.adminMapper;
import top.soest.service.adminService;

import java.time.LocalDateTime;
import java.util.Objects;


@Service
@Slf4j
public class adminServiceImpl implements adminService {

	@Autowired
	adminMapper adminMapper;

	@Override
	public Manager ManagerLogin(LoginDTO loginDTO) {

		log.info("登录信息：{}", loginDTO);
		String account = loginDTO.getAccount();
		String password = loginDTO.getPassword();

		Manager manager = adminMapper.getByAccount(account);

		if (manager == null) {
			throw new AccountNotFoundException(MessageConstant.ACCOUNT_NOT_FOUND);
		}

		password = DigestUtils.md5DigestAsHex(password.getBytes());

		if (!Objects.equals(manager.getPassword(), password)) {
			throw new PasswordErrorException(MessageConstant.PASSWORD_ERROR);
		}
		if (Objects.equals(manager.getDegree(), StatusConstant.DISABLE)) {
			throw new AccountLockedException(MessageConstant.ACCOUNT_LOCKED);
		}
		return manager;
	}

	@Override
	public void addManager(ManagerDTO managerDTO) {

		Manager own = adminMapper.getById(BaseContext.getThreadLocal());
		if (own.getDegree() < StatusConstant.DEGREE_4 || own.getDegree() <= managerDTO.getDegree()) {
			throw new NoPermissionException(MessageConstant.NO_PERMISSION);
		}

		Manager manager = new Manager();
		BeanUtils.copyProperties(managerDTO, manager);
		manager.setCreateTime(LocalDateTime.now());
		manager.setPassword(DigestUtils.md5DigestAsHex(managerDTO.getPassword().getBytes()));
		adminMapper.insert(manager);
	}
}
