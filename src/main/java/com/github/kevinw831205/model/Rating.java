package com.github.kevinw831205.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table(name = "rating")
@Entity
public class Rating {
    @Id
    @NotNull
    @Column(name = "rating_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rating_generator")
    private Long id;

    @Column(name = "account_id")
    @NotNull
    private Long accountId;

    @Column(name="recipe_id")
//    @NotNull
    private Long recipeId;

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

    public Long getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Long recipeId) {
        this.recipeId = recipeId;
    }
}
