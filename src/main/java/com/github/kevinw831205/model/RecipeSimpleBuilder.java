package com.github.kevinw831205.model;

import java.util.Set;

public class RecipeSimpleBuilder {
    private Long id;
    private String name;
    private String description;
    private Long authorId;
    private String author;
    private Integer numberOfRating;
    private Double averageRating;
    private Set<CategoryTag> categoryTags;

    public RecipeSimpleBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public RecipeSimpleBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public RecipeSimpleBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public RecipeSimpleBuilder setAuthorId(Long authorId) {
        this.authorId = authorId;
        return this;
    }

    public RecipeSimpleBuilder setAuthor(String author) {
        this.author = author;
        return this;
    }

    public RecipeSimpleBuilder setNumberOfRating(Integer numberOfRating) {
        this.numberOfRating = numberOfRating;
        return this;
    }

    public RecipeSimpleBuilder setAverageRating(Double averageRating) {
        this.averageRating = averageRating;
        return this;
    }

    public RecipeSimpleBuilder setCategoryTags(Set<CategoryTag> categoryTags) {
        this.categoryTags = categoryTags;
        return this;
    }

    public RecipeSimple build() {
        return new RecipeSimple(id, name, description, authorId, author, numberOfRating, averageRating, categoryTags);
    }
}