package com.github.kevinw831205.controller;

import com.github.kevinw831205.model.AccountJSON;
import com.github.kevinw831205.model.Login;
import com.github.kevinw831205.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value = "/api/login")
@Controller
public class LoginController {
    private LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<?> validateLogin(@RequestBody Login loginInfo){
        AccountJSON responseBody = loginService.login(loginInfo);
        if(responseBody == null){
            return new ResponseEntity<>(null,HttpStatus.FORBIDDEN);
        }
        ResponseEntity<?> responseEntity = new ResponseEntity<>(responseBody , HttpStatus.CREATED);
        return responseEntity;
    }


}
