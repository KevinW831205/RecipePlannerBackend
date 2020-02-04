package com.github.kevinw831205.service;


import com.github.kevinw831205.model.Account;
import com.github.kevinw831205.model.Login;
import com.github.kevinw831205.repository.AccountRepository;
import com.github.kevinw831205.security.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    AccountRepository accountRepository;

    @Autowired
    public LoginService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    private Boolean validateLogin(Login login, Account account) {
        String username = login.getUsername();
        account = this.accountRepository.findByUserName(username).get(0);
        String encryptedLoginPassword = MD5.getMd5(login.getPassword());
        return encryptedLoginPassword.equals(account.getPassword());
    }


    public Account login(Login loginInfo) {
        Account account = this.accountRepository.findByUserName(loginInfo.getUsername()).get(0);
        if(validateLogin(loginInfo, account)){
            return account;
        } else {
            return null;
        }
    }
}
