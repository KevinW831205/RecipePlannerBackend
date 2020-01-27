package com.github.kevinw831205.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

@Table(name = "account")
@Entity
public class Account {
    @Id
    @NotNull
    @Column(name = "account_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_generator")
    private Long id;
    private String username;
    private String password;
    private Boolean isAdmin;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "account")
    @JsonIgnoreProperties(value={"account"})
    private List<Recipe> recipesCreated;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "accountId")
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

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

}
