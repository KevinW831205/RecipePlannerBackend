package com.github.kevinw831205.controller;

import com.github.kevinw831205.model.Account;
import com.github.kevinw831205.model.Login;
import com.github.kevinw831205.model.Template;
import com.github.kevinw831205.service.LoginService;
import com.github.kevinw831205.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
    public ResponseEntity<?> validateLogin(@RequestBody Login login){
        Template responseBody = loginService.validateLogin(login);
        ResponseEntity<?> responseEntity = new ResponseEntity<>(responseBody ,HttpStatus.CREATED);

//        HttpStatus.FORBIDDEN
        return responseEntity;
    }


}
