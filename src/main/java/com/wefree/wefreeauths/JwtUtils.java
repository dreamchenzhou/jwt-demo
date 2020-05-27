package com.wefree.wefreeauths;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

/**
 * @author yong.chen
 * @date 2020/5/26
 */

public class JwtUtils {

    private static String secret ="123456789";
    private static int expireSeconds = 30*60;
    private static String issuer="auth0";

    public static String buildToken(){
        String token = "";
        Algorithm algorithm = Algorithm.HMAC256(secret);
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND,expireSeconds);
        token =JWT.create().
                withExpiresAt(calendar.getTime()).
                withClaim("loginName","admin").
                withIssuer(issuer).
                withIssuedAt(new Date()).
                withJWTId(UUID.randomUUID().toString()).
                sign(algorithm);
        return token;
    }

    public static DecodedJWT decodeToken(String token){
        Algorithm algorithm =Algorithm.HMAC256(secret);
        JWTVerifier jwtVerifier= JWT.require(algorithm).withIssuer(issuer).build();
        DecodedJWT decodedJWT= jwtVerifier.verify(token);
        return decodedJWT;
    }
}
