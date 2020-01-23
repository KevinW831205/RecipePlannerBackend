package com.github.kevinw831205.model;

import javax.persistence.*;
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
    private String name;

//    @ManyToMany(mappedBy = "categoryTags",fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
//    private Set<Recipe> recipes;

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


}
