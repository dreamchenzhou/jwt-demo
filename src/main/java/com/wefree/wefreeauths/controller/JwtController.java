package com.wefree.wefreeauths.controller;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.wefree.wefreeauths.JwtUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.Date;

/**
 * @author yong.chen
 * @date 2020/5/26
 */

@RestController
@RequestMapping("/jwt")
public class JwtController {

    @GetMapping("/createToken")
    public String createToken(){
        Calendar calendar =Calendar.getInstance();
        return JwtUtils.buildToken();
    }

    @GetMapping("/decodeToken")
    public DecodedJWT decodeToken(String token){
        return JwtUtils.decodeToken(token);
    }
}
