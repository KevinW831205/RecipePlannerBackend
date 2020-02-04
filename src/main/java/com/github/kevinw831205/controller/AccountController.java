package com.github.kevinw831205.controller;

import com.github.kevinw831205.model.Account;
import com.github.kevinw831205.model.AccountJSON;
import com.github.kevinw831205.model.SignupInfo;
import com.github.kevinw831205.service.AccountService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/api/account")
@CrossOrigin(origins = "*")
@Controller
public class AccountController {
    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<?> findAll(){
        Iterable<Account> allEntity = accountService.findAll();


        ResponseEntity<?> response = new ResponseEntity<>(allEntity, HttpStatus.OK);
        return response;
    }

    @RequestMapping(value="/user", method = RequestMethod.GET) // example: http://localhost:8080/api/account/user?username=123
    public ResponseEntity<?> findByUsername(@RequestParam String username){
        Account entity = accountService.findByUsername(username);
        ResponseEntity<?> response = new ResponseEntity<>(entity, HttpStatus.OK);
        return response;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable Long id){
        Account entity = accountService.findById(id);
        ResponseEntity<?> response = new ResponseEntity<>(entity ,HttpStatus.OK);
        return response;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody SignupInfo signupInfo){
        Account account = accountService.create(signupInfo);
        AccountJSON responseBody = new AccountJSON(account);
        ResponseEntity<?> responseEntity = new ResponseEntity<>(responseBody ,HttpStatus.CREATED);
        return responseEntity;
    }

    @RequestMapping(value = "/admin", method = RequestMethod.POST)
    public ResponseEntity<?> createAdmin(@RequestBody Account account){
        Account responseBody = accountService.createAdmin(account);
        ResponseEntity<?> responseEntity = new ResponseEntity<>(responseBody ,HttpStatus.CREATED);
        return responseEntity;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Account account){
        Account responseBody = accountService.update(id, account);
        ResponseEntity responseEntity = new ResponseEntity<>(responseBody, HttpStatus.OK);
        return responseEntity;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable Long id){
        Account responseBody = accountService.delete(id);
        ResponseEntity responseEntity = new ResponseEntity<>(responseBody, HttpStatus.OK);
        return responseEntity;
    }

}
