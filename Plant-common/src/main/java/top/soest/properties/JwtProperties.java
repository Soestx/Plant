package top.soest.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "plant.jwt")
@Data
public class JwtProperties {

    /** 管理员token秘钥 */
    private String adminSecretKey;
    private long adminTtl;
    private  String adminTokenName;

    /** 用户token秘钥 */
    private String userSecretKey;
    private long userTtl;
    private  String userTokenName;
}
