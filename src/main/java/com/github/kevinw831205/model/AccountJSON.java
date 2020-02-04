package com.github.kevinw831205.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;
import java.util.List;

public class AccountJSON {
    private Long id;
    private String username;
    private Boolean isAdmin;
    private String profileImageUrl;
    private List<Recipe> recipesCreated;
    private List<Rating> ratingsGiven;

    public AccountJSON() {
    }

    public AccountJSON(Account account){
        this.id = account.getId();
        this.username = account.getUsername();
        this.isAdmin = account.getAdmin();
        this.profileImageUrl = account.getProfileImageUrl();
        this.recipesCreated = account.getRecipesCreated();
        this.ratingsGiven = account.getRatingsGiven();
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

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
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
