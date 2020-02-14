package com.github.kevinw831205.seed;

import com.github.kevinw831205.model.Account;
import com.github.kevinw831205.repository.AccountRepository;
import com.github.kevinw831205.security.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

public class Seed {
    private AccountRepository accountRepository;

    @Autowired
    public Seed(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @EventListener
    public void seed(ContextRefreshedEvent event) {
        seedAccountTable();
    }

    private void seedAccountTable() {
        Account demoUser = new Account();
        demoUser.setUsername("demouser");
        demoUser.setPassword(MD5.getMd5("demo123"));
        demoUser.setProfileImageUrl("https://via.placeholder.com/150");
        demoUser.setAdmin(false);
        this.accountRepository.save(demoUser);

        Account demoAdmin = new Account();
        demoUser.setUsername("demoadmin");
        demoUser.setPassword(MD5.getMd5("demo123"));
        demoUser.setProfileImageUrl("https://via.placeholder.com/150");
        demoUser.setAdmin(true);
        this.accountRepository.save(demoUser);



    }

}
