package com.github.kevinw831205.service;


import com.github.kevinw831205.model.Account;
import com.github.kevinw831205.model.Login;
import com.github.kevinw831205.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    AccountRepository accountRepository;

    @Autowired
    public LoginService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Boolean validateLogin(Login login){
        login.getUsername();
        login.getPassword();
    }

    public Account findById(Long id) {
        return accountRepository.findById(id).get();
    }


}
