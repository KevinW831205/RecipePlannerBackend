package com.github.kevinw831205.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table(name="recipe")
@Entity
public class Recipe {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name="account_id")
    private Long accountId;



    public Recipe() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }
}
