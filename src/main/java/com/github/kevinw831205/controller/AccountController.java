package com.github.kevinw831205.controller;

import com.github.kevinw831205.model.Account;
import com.github.kevinw831205.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value = "/api/account")
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

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable Long id){
        Account entity = accountService.findById(id);
        ResponseEntity<?> response = new ResponseEntity<>(entity ,HttpStatus.OK);
        return response;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody Account account){
        Account responseBody = accountService.create(account);
        ResponseEntity<?> responseEntity = new ResponseEntity<>(responseBody ,HttpStatus.CREATED);
        return responseEntity;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> create(@PathVariable Long id, @RequestBody Account account){
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
