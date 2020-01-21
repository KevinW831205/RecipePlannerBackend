package com.example.demo.repository;

import com.example.demo.model.Account;
import com.example.demo.model.Template;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
}
