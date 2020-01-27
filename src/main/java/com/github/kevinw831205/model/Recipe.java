package com.github.kevinw831205.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Table(name = "recipe")
@Entity
public class Recipe implements Serializable {
    @Id
    @NotNull
    @Column(name = "recipe_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "recipe_generator")
    private Long id;

    private String name;
    private String description;
    private Boolean isPublished;
    private String summary;

    @Column(name = "account_id")
    @NotNull
    private Long accountId;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "recipeId")
    private List<Instruction> instructionList;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "recipeId")
    private List<Ingredient> ingredientList;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "recipeId")
    @JsonIgnore
    private List<Rating> ratings;
    //
//    @MapKeyClass(value = Rating.class)
//    @Formula("SELECT COUNT(ra) FROM rating ra WHERE ra.recipe_id = id")
//    private Integer numberOfRating;
    @Transient
    private Integer numberOfRating;

    @Transient
    private Double averageRating;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "recipe_categoryTag",
            joinColumns = {@JoinColumn(name = "recipe_id")},
            inverseJoinColumns = {@JoinColumn(name = "categoryTag_id")}
    )
    @JsonIgnoreProperties("recipes")
    private Set<CategoryTag> categoryTags;

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

    @Transient
    public Integer getNumberOfRating() {
        if (ratings == null) {
            return 0;
        }
        return this.ratings.size();
    }

    public void setNumberOfRating(Integer numberOfRating) {
        this.numberOfRating = numberOfRating;
    }

    @Transient
    public Double getAverageRating() {
        if (ratings == null) {
            return null;
        }
        Double sum = 0D;
        for (Rating rating : ratings) {
            sum += rating.getRating();
        }
        return sum / ratings.size();
    }

    public void setAverageRating(Double averageRating) {
        this.averageRating = averageRating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<CategoryTag> getCategoryTags() {
        return categoryTags;
    }

    public void setCategoryTags(Set<CategoryTag> categoryTags) {
        this.categoryTags = categoryTags;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getPublished() {
        return isPublished;
    }

    public void setPublished(Boolean published) {
        isPublished = published;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

//    @PreRemove
//    public void removeListItems(){
////        this.ingredientList.clear();
////        this.ratings.clear();
////        this.instructionList.clear();
////        this.categoryTags.clear();
//
////        setIngredientList(null);
////        setRatings(null);
////        setInstructionList(null);
////        setCategoryTags(null);
//    }
}
