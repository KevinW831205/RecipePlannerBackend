package com.github.kevinw831205.service;


import com.github.kevinw831205.model.Account;
import com.github.kevinw831205.model.AccountJSON;
import com.github.kevinw831205.model.Login;
import com.github.kevinw831205.repository.AccountRepository;
import com.github.kevinw831205.security.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {

    AccountRepository accountRepository;

    @Autowired
    public LoginService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    private Boolean validateLogin(Login login, Account account) {
        String encryptedLoginPassword = MD5.getMd5(login.getPassword());
        return encryptedLoginPassword.equals(account.getPassword());
    }


    public AccountJSON login(Login loginInfo) {

        List<Account> accountList = this.accountRepository.findByUserName(loginInfo.getUsername());

        if (accountList.size()>0){
            Account account = accountList.get(0);
            AccountJSON accountJSON = new AccountJSON(account);
            if(validateLogin(loginInfo, account)){
                return accountJSON;
            } else {
                return null;
            }
        }
        return null;


    }
}
