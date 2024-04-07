package top.soest.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;

public class JwtUtil {

    /**
     * 生成jwt
     * 使用Hs256加密，私钥使用固定密钥
     *
     * @param secretKey jwt密钥
     * @param ttlMillis 过期时间
     * @param claims 设置的信息
     * @return jwt
     */
    public static String createJWT(String secretKey, long ttlMillis, Map<String, Object> claims) {

        // 指定签名的时候使用的签名算法，也就是header那部分
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        // 生成JWT的时间
        long expMillis = System.currentTimeMillis() + ttlMillis;
        Date exp = new Date(expMillis);

        // 设置jwt的body部分
        JwtBuilder builder = Jwts.builder()
                // 如果有私有声明，一定要先设置这个自己创建的私有的声明，这个是给builder的claim赋值，一旦写在标准的声明赋值之后，就是覆盖了那些标准的声明的
                .setClaims(claims)
                // 设置签名的时候使用的签名算法，和签名使用的密钥
                .signWith(signatureAlgorithm, secretKey.getBytes(StandardCharsets.UTF_8))
                // 设置过期时间
                .setExpiration(exp);
        return builder.compact();
    }

    /**
     * 解析jwt
     *
     * @param secretKey jwt密钥
     * @param token 加密后的token
     * @return
     */
    public static Claims parseJWT(String secretKey, String token) {

        // 通过密钥解析jwt
        Claims claims = Jwts.parser()
                // 设置签名的时候使用的签名算法，和签名使用的密钥
                .setSigningKey(secretKey.getBytes(StandardCharsets.UTF_8))
                // 指定要解析的jwt
                .parseClaimsJws(token).getBody();
        return claims;
    }
}
