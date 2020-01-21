package com.example.demo.repository;

import com.example.demo.model.Recipe;
import com.example.demo.model.Template;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
