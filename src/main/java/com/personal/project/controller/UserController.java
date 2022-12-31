package com.personal.project.controller;

import com.personal.project.service.JwtTokenService;
import com.personal.project.vo.TokenLoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private JwtTokenService jwtTokenService;

    @PostMapping(value = "/login")
    public TokenLoginVO login(@RequestParam("username") String username,
                              @RequestParam("password") String password) {
        String token = jwtTokenService.getJwtToken(username, password);
        TokenLoginVO tokenLogin = new TokenLoginVO();
        tokenLogin.setUsername(username);
        tokenLogin.setToken(token);
        return tokenLogin;
    }

    @GetMapping(value = "/hello")
    public String helloWorld() {
        return "Hello World";
    }
}
