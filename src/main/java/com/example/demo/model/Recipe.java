package com.example.demo.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table(name="RECIPE")
@Entity
public class Recipe {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name="authorId", nullable = true)
    private Long authorId;



    public Recipe() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }
}
