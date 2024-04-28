package top.soest.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserVO implements Serializable {

	//用户名
	private String username;

	//账号
	private String account;

	//密码
	private String password;

	//邮箱
	private String email;

	//手机号
	private String phone;

}
