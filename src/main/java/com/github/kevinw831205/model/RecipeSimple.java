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
}
