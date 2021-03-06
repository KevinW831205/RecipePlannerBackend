package com.github.kevinw831205.seed;

import com.github.kevinw831205.model.Account;
import com.github.kevinw831205.model.CategoryTag;
import com.github.kevinw831205.repository.AccountRepository;
import com.github.kevinw831205.repository.CategoryTagRepository;
import com.github.kevinw831205.security.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Seed {
    private AccountRepository accountRepository;
    private CategoryTagRepository categoryTagRepository;

    @Value("${app.salt}")
    private String salt;


    @Autowired
    public Seed(AccountRepository accountRepository, CategoryTagRepository categoryTagRepository) {
        this.accountRepository = accountRepository;
        this.categoryTagRepository = categoryTagRepository;
    }

    @EventListener
    public void seed(ApplicationReadyEvent event) {
        seedAccountTable();
        seedTags();
    }

    private void seedAccountTable() {
        if (this.accountRepository.findByUserName("demouser").isEmpty()) {
            Account demoUser = new Account();
            demoUser.setUsername("demouser");
            demoUser.setPassword(MD5.getMd5("demo123", salt));
            demoUser.setProfileImageUrl("https://via.placeholder.com/150");
            demoUser.setAdmin(false);
            this.accountRepository.save(demoUser);

            Account demoAdmin = new Account();
            demoAdmin.setUsername("demoadmin");
            demoAdmin.setPassword(MD5.getMd5("demo123", salt));
            demoAdmin.setProfileImageUrl("https://via.placeholder.com/150");
            demoAdmin.setAdmin(true);
            this.accountRepository.save(demoAdmin);
        }


    }

    private void seedTags() {
        CategoryTag tag = new CategoryTag();

        List<CategoryTag> ct = (List<CategoryTag>) categoryTagRepository.findAll();
        if (ct.isEmpty()) {
            tag.setName("breakfast");
            categoryTagRepository.save(tag);
            tag = new CategoryTag();
            tag.setName("italian");
            categoryTagRepository.save(tag);
            tag = new CategoryTag();
            tag.setName("steak");
            categoryTagRepository.save(tag);
            tag = new CategoryTag();
            tag.setName("asian");
            categoryTagRepository.save(tag);
        }

    }

}
