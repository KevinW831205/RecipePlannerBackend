package com.github.kevinw831205.service;

import com.github.kevinw831205.model.Account;
import com.github.kevinw831205.repository.AccountRepository;
import com.github.kevinw831205.security.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Account create(Account account) {
        String password = account.getPassword();
        account.setPassword(MD5.getMd5(password));
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
