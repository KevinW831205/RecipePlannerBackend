package com.github.kevinw831205.model;

import java.util.Set;

public class RecipeSimple {
    private Long id;
    private String name;
    private String description;
    private Long authorId;
    private String author;
    private Integer numberOfRating;
    private Double averageRating;
    private Set<CategoryTag> categoryTags;

    public RecipeSimple(Long id, String name, String description, Long authorId, String author, Integer numberOfRating, Double averageRating, Set<CategoryTag> categoryTags) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.authorId = authorId;
        this.author = author;
        this.numberOfRating = numberOfRating;
        this.averageRating = averageRating;
        this.categoryTags = categoryTags;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getNumberOfRating() {
        return numberOfRating;
    }

    public void setNumberOfRating(Integer numberOfRating) {
        this.numberOfRating = numberOfRating;
    }

    public Double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(Double averageRating) {
        this.averageRating = averageRating;
    }

    public Set<CategoryTag> getCategoryTags() {
        return categoryTags;
    }

    public void setCategoryTags(Set<CategoryTag> categoryTags) {
        this.categoryTags = categoryTags;
    }
}
