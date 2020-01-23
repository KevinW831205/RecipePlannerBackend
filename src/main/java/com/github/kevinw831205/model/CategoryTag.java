package com.github.kevinw831205.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class CategoryTag {
    @Id
    @NotNull
    @Column(name = "categoryTag_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categoryTag_generator")
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "categoryTags")
    private List<Recipe> recipes;

    public CategoryTag() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }


}
