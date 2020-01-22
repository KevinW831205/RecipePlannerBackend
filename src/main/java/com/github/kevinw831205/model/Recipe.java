package com.github.kevinw831205.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Table(name = "recipe")
@Entity
public class Recipe {
    @Id
    @NotNull
    @Column(name = "recipe_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "recipe_generator")
    private Long id;

    @Column(name = "account_id")
    @NotNull
    private Long accountId;

    @OneToMany
    @JoinColumn(name = "recipe_id", referencedColumnName = "recipe_id")
    private List<Instruction> instructionList;

    @OneToMany
    @JoinColumn(name = "recipe_id", referencedColumnName = "recipe_id")
    private List<Ingredient> ingredientList;

    @OneToMany
    @JoinColumn(name = "recipe_id", referencedColumnName = "recipe_id")
    private List<Rating> ratings;

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

    public List<Instruction> getInstructionList() {
        return instructionList;
    }

    public void setInstructionList(List<Instruction> instructionList) {
        this.instructionList = instructionList;
    }

    public List<Ingredient> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(List<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }
}
