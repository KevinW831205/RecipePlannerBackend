package com.github.kevinw831205.service;

import com.github.kevinw831205.model.*;
import com.github.kevinw831205.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class RecipeService {
    private RecipeRepository recipeRepository;
    private CategoryTagRepository categoryTagRepository;
    private RatingRepository ratingRepository;
    private InstructionRepository instructionRepository;
    private IngredientRepository ingredientRepository;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository, CategoryTagRepository categoryTagRepository) {
        this.recipeRepository = recipeRepository;
        this.categoryTagRepository = categoryTagRepository;
    }

    public Iterable<Recipe> findAll() {
        return recipeRepository.findAll();
    }

    public List<Recipe> findAllPublished() {
        Iterable<Recipe> allRecipes = recipeRepository.findAll();
        List<Recipe> publishedRecipes = StreamSupport.stream(allRecipes.spliterator(), false)
                .filter(r -> r.getPublished().equals(true))
                .collect(Collectors.toList());

        return publishedRecipes;

//        return null;
    }

    public Recipe findById(Long id) {
        return recipeRepository.findById(id).get();
    }

    public Recipe create(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    public Recipe update(Long id, Recipe recipe) {
        Recipe recipeInDatabase = findById(id);
        if (recipeInDatabase == null) {
            return null;
        }
        recipeRepository.save(recipe);
        return recipe;
    }

    public Recipe delete(Long id) {
        Recipe recipe = findById(id);
//        Iterator<CategoryTag> tagsIterator = recipe.getCategoryTags().iterator();
//        while (tagsIterator.hasNext()) {
//            categoryTagRepository.delete(tagsIterator.next());
//        }
//        Iterator<Rating> ratingsIterator = recipe.getRatings().iterator();
//        while (ratingsIterator.hasNext()) {
//            ratingRepository.delete(ratingsIterator.next());
//        }
//        Iterator<Instruction> instructionsIterator = recipe.getInstructionList().iterator();
//        while(instructionsIterator.hasNext()) {
//            instructionRepository.delete(instructionsIterator.next());
//        }
//        Iterator<Ingredient> ingredientsIterator = recipe.getIngredientList().iterator();
//        while(ingredientsIterator.hasNext()) {
//            ingredientRepository.delete(ingredientsIterator.next());
//        }

        categoryTagRepository.deleteAll(recipe.getCategoryTags());
        ratingRepository.deleteAll(recipe.getRatings());
        instructionRepository.deleteAll(recipe.getInstructionList());
        ingredientRepository.deleteAll(recipe.getIngredientList());

        recipeRepository.delete(recipe);
        return recipe;
    }

    public Recipe addTag(Long recipe_id, Long tag_id) {
        Recipe recipe = recipeRepository.findById(recipe_id).get();
        CategoryTag categoryTag = categoryTagRepository.findById(tag_id).get();
        recipe.getCategoryTags().add(categoryTag);
        return recipeRepository.save(recipe);
    }
}
