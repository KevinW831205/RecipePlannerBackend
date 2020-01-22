package com.github.kevinw831205.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="ingredient")
public class Ingredient {
    @Id
    @NotNull
    @Column(name = "ingredient_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ingredient_generator")
    private Long id;


    @Column(name = "recipe_id")
    @NotNull
    private Long recipeId;

    private String name;
    private String amount;

    public Ingredient() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Long recipeId) {
        this.recipeId = recipeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
