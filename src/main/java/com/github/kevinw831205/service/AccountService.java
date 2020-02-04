package com.github.kevinw831205.service;

import com.github.kevinw831205.model.Account;
import com.github.kevinw831205.model.SignupInfo;
import com.github.kevinw831205.repository.AccountRepository;
import com.github.kevinw831205.security.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;

@Service
public class AccountService {
    private AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Iterable<Account> findAll() {
        return accountRepository.findAll();
    }

    public Account findById(Long id) {
        return accountRepository.findById(id).get();
    }

    public Account findByUsername(String username) {
//        Iterable<Account> accounts = findAll();
//        for (Account account : accounts) {
//            if (account.getUsername().equals(username)) {
//                return account;
//            }
//        }
//        return null;

        return accountRepository.findByUserName(username).get(0);
    }

    public Account create(SignupInfo signupInfo) {
        // some account validation
        Account account = new Account();
        account.setUsername(signupInfo.getUsername());
        String password = signupInfo.getPassword();
        account.setPassword(MD5.getMd5(password));
        account.setAdmin(false);
        return accountRepository.save(account);
    }

    public Account createAdmin(Account account){
        return accountRepository.save(account);
    }

    public Account update(Long id, Account account) {
        Account accountInDatabase = findById(id);
        if (accountInDatabase == null) {
            return null;
        }
        accountRepository.save(account);
        return account;
    }

    public Account delete(Long id) {
        Account account = findById(id);
        accountRepository.delete(account);
        return account;
    }
}
