package top.soest.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "登录需传递的数据模型")
public class LoginDTO implements Serializable {

	@ApiModelProperty(value = "账号")
	private String account;

	@ApiModelProperty(value = "密码")
	private String password;


}
