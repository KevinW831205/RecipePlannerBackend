package com.github.kevinw831205.repository;

import com.github.kevinw831205.model.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
    @Query("select a from Account a where a.username like ?1")
    List<Account> findByUserName(String username);

}
