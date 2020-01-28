package com.github.kevinw831205.controller;

import com.github.kevinw831205.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/api/login")
@Controller
public class LoginController {
    private LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }


//    @RequestMapping(value = "/", method = RequestMethod.POST)
//    public ResponseEntity<?> validateLogin(@RequestBody Login login){
//        Template responseBody = loginService.validateLogin(login);
//        ResponseEntity<?> responseEntity = new ResponseEntity<>(responseBody ,HttpStatus.CREATED);
//
////        HttpStatus.FORBIDDEN
//        return responseEntity;
//    }


}
