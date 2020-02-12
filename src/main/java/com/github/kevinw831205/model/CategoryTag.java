package com.github.kevinw831205.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="categoryTag")
public class CategoryTag implements Serializable {
    @Id
    @NotNull
    @Column(name = "categoryTag_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categoryTag_generator")
    private Long id;

    @NotBlank(message = "must have name")
    @Column(unique = true)
    private String name;

    @ManyToMany(mappedBy = "categoryTags",fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value={"categoryTags","ingredientList","instructionList"})
    private Set<Recipe> recipes;

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

    public Set<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(Set<Recipe> recipes) {
        this.recipes = recipes;
    }

    @PreRemove
    public void removeTagFromRecipe(){
        for(Recipe r: recipes){
            r.getCategoryTags().remove(this);
        }
    }
}
