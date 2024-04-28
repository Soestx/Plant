package top.soest.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "登录返回数据格式")
public class LoginVO {

	@ApiModelProperty(value = "用户id")
	private long id;

	@ApiModelProperty(value = "用户昵称")
	private String username;

	@ApiModelProperty(value = "用户账号")
	private String account;

	@ApiModelProperty(value = "用户token")
	private String token;

}
