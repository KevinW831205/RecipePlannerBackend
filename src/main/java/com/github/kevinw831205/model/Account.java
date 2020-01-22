package com.github.kevinw831205.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

@Table(name = "account")
@Entity
public class Account {
    @Id
    @NotNull
    @Column(name = "account_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;

    @OneToMany
    @JoinColumn(name = "account_id", referencedColumnName = "account_id")
    private List<Recipe> recipesCreated;

    @OneToMany
    @JoinColumn(name = "account_id", referencedColumnName = "account_id")
    private List<Rating> ratingsGiven;

    public Account() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Recipe> getRecipesCreated() {
        return recipesCreated;
    }

    public void setRecipesCreated(List<Recipe> recipesCreated) {
        this.recipesCreated = recipesCreated;
    }

    public List<Rating> getRatingsGiven() {
        return ratingsGiven;
    }

    public void setRatingsGiven(List<Rating> ratingsGiven) {
        this.ratingsGiven = ratingsGiven;
    }
}
