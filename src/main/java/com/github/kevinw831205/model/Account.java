package com.github.kevinw831205.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.transaction.Transactional;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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

    @Size(min = 6, max = 20, message = "username size must be greater than 6")
    @NotNull
    @Column(unique = true)
    private String username;

    @Size(message = "password size must be greater than 6")
    @NotNull
    private String password;

    private Boolean isAdmin;
    private String profileImageUrl;

    @Size(max=500)
    private String aboutMe;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "account")
    @JsonIgnoreProperties(value = {"account"})
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

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", isAdmin=" + isAdmin +
                ", profileImageUrl='" + profileImageUrl + '\'' +
                ", aboutMe='" + aboutMe + '\'' +
                ", recipesCreated=" + recipesCreated +
                ", ratingsGiven=" + ratingsGiven +
                '}';
    }
}
