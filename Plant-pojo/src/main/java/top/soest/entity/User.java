package top.soest.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;



@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    //序列化版本号
    private static final long serialVersionUID = 1L;

    //用户id
    private Long id;

    //用户名
    private String username;

    //账号
    private String account;

    //密码
    private String password;

    //邮箱
    private String email;

    //创建时间
    private LocalDateTime createTime;

    //手机号
    private String phone;

    //余额
    private Long balance;

    //卡号
    private String cardId;

    //状态
    private Integer status;
}
