package com.github.kevinw831205.service;

import com.github.kevinw831205.model.*;
import com.github.kevinw831205.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class RecipeService {
    private RecipeRepository recipeRepository;
    private CategoryTagRepository categoryTagRepository;
    private RatingRepository ratingRepository;
    private InstructionRepository instructionRepository;
    private IngredientRepository ingredientRepository;

    public RecipeService(RecipeRepository recipeRepository, CategoryTagRepository categoryTagRepository, RatingRepository ratingRepository, InstructionRepository instructionRepository, IngredientRepository ingredientRepository) {
        this.recipeRepository = recipeRepository;
        this.categoryTagRepository = categoryTagRepository;
        this.ratingRepository = ratingRepository;
        this.instructionRepository = instructionRepository;
        this.ingredientRepository = ingredientRepository;
    }

    @Autowired



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
        Iterator<Rating> ratingsIterator = recipe.getRatings().iterator();
        while (ratingsIterator.hasNext()) {
            ratingRepository.delete(ratingsIterator.next());
        }
        Iterator<Instruction> instructionsIterator = recipe.getInstructionList().iterator();
        while(instructionsIterator.hasNext()) {
            instructionRepository.delete(instructionsIterator.next());
        }
        Iterator<Ingredient> ingredientsIterator = recipe.getIngredientList().iterator();
        while(ingredientsIterator.hasNext()) {
            ingredientRepository.delete(ingredientsIterator.next());
        }


//        Map<CrudRepository<?, Long>,Iterable> deleteMap = new ConcurrentHashMap<>();
//        deleteMap.put(categoryTagRepository ,recipe.getCategoryTags());
//        deleteMap.put(ingredientRepository, recipe.getIngredientList());
//        deleteMap.put(instructionRepository, recipe.getInstructionList());
//        deleteMap.put(ratingRepository, recipe.getRatings());
//
//        Set<CrudRepository<?,Long>> repositorySet = deleteMap.keySet();
//        Iterator<CrudRepository<?,Long>> deleteIterator = repositorySet.iterator();
//        while(deleteIterator.hasNext()){
//            CrudRepository<?,Long> deleteRepo = deleteIterator.next();
//            deleteRepo.deleteAll(deleteMap.get(deleteRepo));
//        }


//        categoryTagRepository.deleteAll(recipe.getCategoryTags());
//        ratingRepository.deleteAll(recipe.getRatings());
//        instructionRepository.deleteAll(recipe.getInstructionList());
//        ingredientRepository.deleteAll(recipe.getIngredientList());

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
