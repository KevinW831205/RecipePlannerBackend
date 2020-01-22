package com.github.kevinw831205.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Rating {
    @Id
    @NotNull
    @Column(name = "rating_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "account_id")
    @NotNull
    private Long accountId;

    private Double rating;

    public Rating() {
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

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
}
