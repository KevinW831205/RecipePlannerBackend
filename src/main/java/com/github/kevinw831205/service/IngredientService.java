package com.github.kevinw831205.service;

import com.github.kevinw831205.model.Ingredient;
import com.github.kevinw831205.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredientService {
    private IngredientRepository ingredientRepository;

    @Autowired
    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public Iterable<Ingredient> findAll() {
        return ingredientRepository.findAll();
    }

    public Ingredient findById(Long id){
        return ingredientRepository.findById(id).get();
    }

    public Ingredient create(Ingredient ingredient){
        return ingredientRepository.save(ingredient);
    }

    public Ingredient update(Long id, Ingredient ingredient) {
        Ingredient ingredientInDatabase = findById(id);
        if(ingredientInDatabase == null){
            return null;
        }
        ingredientRepository.save(ingredient);
        return ingredient;
    }

    public Ingredient delete(Long id) {
        Ingredient ingredient = findById(id);
        ingredientRepository.delete(ingredient);
        return ingredient;
    }
}
