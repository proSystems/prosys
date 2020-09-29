package com.feng.springcloud.pojo;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;

/**
 *  JwtUtil:用来进行签名和校验Token
 */

public class JwtUtil {
    /**
     * JWT验证过期时间
     */
    private static final long EXPIRE_TIME = 30 * 60 * 1000;

    /**
     * 校验token是否正确
     */
    public static boolean verify(String token, String username, String secret) {
        try {
            //根据密码生成JWT效验器
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withClaim("username", username)
                    .build();
            //效验TOKEN
            DecodedJWT jwt = verifier.verify(token);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }
    /**
     * 获得token中的信息无需secret解密也能获得
     */
    public static String getUsername(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);   //将token对象转换成jwt的对象
            return jwt.getClaim("username").asString();    //获取jwt对象中的username字段 转成字符串 也就是获得了用户名
        } catch (JWTDecodeException e) {
            return null;
        }
    }
    /**
     *生成token签名EXPIRE_TIME 分钟后过期
     */
    public static String sign(String username, String secret) {
        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        Algorithm algorithm = Algorithm.HMAC256(secret);
        // 附带username信息
        return JWT.create()
                .withClaim("username", username)
                .withExpiresAt(date)
                .sign(algorithm);

    }
    public static void main(String[] args) {
        /**
         * 测试生成一个token
         */
        String sign = sign("18888888888", "123456");
        System.out.println("测试生成一个token\n"+sign);
    }
}
