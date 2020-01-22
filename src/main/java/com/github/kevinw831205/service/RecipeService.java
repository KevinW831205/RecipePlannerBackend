package com.github.kevinw831205.service;

import com.github.kevinw831205.model.Recipe;
import com.github.kevinw831205.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeService {
    private RecipeRepository recipeRepository;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public Iterable<Recipe> findAll() {
        return recipeRepository.findAll();
    }

    public Recipe findById(Long id){
        return recipeRepository.findById(id).get();
    }

    public Recipe create(Recipe recipe){
        return recipeRepository.save(recipe);
    }

    public Recipe update(Long id, Recipe recipe) {
        Recipe recipeInDatabase = findById(id);
        if(recipeInDatabase == null){
            return null;
        }
        recipeRepository.save(recipe);
        return recipe;
    }

    public Recipe delete(Long id) {
        Recipe recipe = findById(id);
        recipeRepository.delete(recipe);
        return recipe;
    }
}