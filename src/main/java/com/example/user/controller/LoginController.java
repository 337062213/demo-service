package com.example.user.controller;

import com.example.user.vo.Login;
import com.example.user.vo.RetObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:8000","http://localhost:8001","http://localhost:8002","http://localhost:8003","http://localhost:8004"},maxAge = 3600)
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${login.name}")
    private String name;

    @Value("${login.password}")
    private String password;

    @PostMapping("/login")
    public RetObject login(@RequestBody Login login, HttpServletRequest request) {

        logger.info("name = " + login.getName());
        logger.info("password = " + login.getPassword());

        if(name.equals(login.getName()) && password.equals(login.getPassword())) {

            request.getSession().setAttribute("name", login.getName());
            request.getSession().setAttribute("password", login.getPassword());

            return new RetObject(0, "OK");
        }
        return new RetObject(-1, "ERROR");
    }

    @PostMapping("/logout")
    public RetObject logout(HttpServletRequest request) {

        request.getSession().invalidate();
        return new RetObject(0, "OK");
    }

}
