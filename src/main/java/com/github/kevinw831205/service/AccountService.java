package com.github.kevinw831205.service;

import com.github.kevinw831205.model.Account;
import com.github.kevinw831205.model.AccountJSON;
import com.github.kevinw831205.model.SignupInfo;
import com.github.kevinw831205.repository.AccountRepository;
import com.github.kevinw831205.security.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AccountService {
    private AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Iterable<AccountJSON> findAll() {
        Iterable<Account> accounts = accountRepository.findAll();
        Iterable<AccountJSON> result = StreamSupport.stream(accounts.spliterator(), false)
                .map(a -> new AccountJSON(a))
                .collect(Collectors.toList());
        return result;
    }

    public AccountJSON findById(Long id) {
        return new AccountJSON(accountRepository.findById(id).get());
    }

    public AccountJSON findByUsername(String username) {
//        Iterable<Account> accounts = findAll();
//        for (Account account : accounts) {
//            if (account.getUsername().equals(username)) {
//                return account;
//            }
//        }
//        return null;

        return new AccountJSON(accountRepository.findByUserName(username).get(0));
    }

    public AccountJSON create(SignupInfo signupInfo) {
        // some account validation
        Account account = new Account();
        account.setUsername(signupInfo.getUsername());
        String password = signupInfo.getPassword();
        account.setPassword(MD5.getMd5(password));
        account.setProfileImageUrl("https://via.placeholder.com/150");
        account.setAdmin(false);
        return new AccountJSON(accountRepository.save(account));
    }

    public AccountJSON createAdmin(Account account) {
        String password = account.getPassword();
        account.setPassword(MD5.getMd5(password));
        account.setProfileImageUrl("https://via.placeholder.com/150");
        account.setAdmin(true);
        return new AccountJSON(accountRepository.save(account));
    }

    public AccountJSON update(Long id, Account account) {
        Account accountInDatabase = accountRepository.findById(id).get();
        if (accountInDatabase == null) {
            return null;
        }
        return new AccountJSON(accountRepository.save(account));
    }

    public AccountJSON delete(Long id) {
        Account account = accountRepository.findById(id).get();
        accountRepository.delete(account);
        return new AccountJSON(account);
    }
}
