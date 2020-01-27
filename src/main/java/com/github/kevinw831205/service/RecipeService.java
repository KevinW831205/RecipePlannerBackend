package com.github.kevinw831205.service;

import com.github.kevinw831205.model.*;
import com.github.kevinw831205.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
public class RecipeService {
    private RecipeRepository recipeRepository;
    private CategoryTagRepository categoryTagRepository;
    private AccountRepository accountRepository;

    public RecipeService(RecipeRepository recipeRepository, CategoryTagRepository categoryTagRepository, AccountRepository accountRepository) {
        this.recipeRepository = recipeRepository;
        this.categoryTagRepository = categoryTagRepository;
        this.accountRepository = accountRepository;
    }

    @Autowired


    public Iterable<Recipe> findAll() {
        Iterable<Recipe> allRecipes = recipeRepository.findAll();

        allRecipes.forEach(r->{
            Collections.sort(r.getInstructionList());
        });

        return allRecipes;
    }

    public List<Recipe> findAllPublished() {
        Iterable<Recipe> allRecipes = recipeRepository.findAll();
        List<Recipe> publishedRecipes = StreamSupport.stream(allRecipes.spliterator(), false)
                .filter(r -> r.getPublished().equals(true))
                .collect(Collectors.toList());

        publishedRecipes.forEach(r->{
            Collections.sort(r.getInstructionList());
        });

        return publishedRecipes;
    }

    public List<RecipeSimple> findAllPublishedSimple() {
        Iterable<Recipe> allRecipes = recipeRepository.findAll();
        Spliterator<Recipe> splitertaor = allRecipes.spliterator();
        Stream<Recipe> stream = StreamSupport.stream(splitertaor, false);
        stream = stream.filter(r -> r.getPublished().equals(true));

        Stream<RecipeSimple> recipeSimpleStream = stream.map((r) -> {
            RecipeSimple recipeSimple = new RecipeSimpleBuilder()
                    .setId(r.getId())
                    .setName(r.getName())
                    .setDescription(r.getDescription())
                    .setAuthorId(r.getAccount().getId())
                    .setAuthor(r.getAccount().getUsername())
                    .setNumberOfRating(r.getNumberOfRating())
                    .setAverageRating(r.getAverageRating())
                    .setCategoryTags(r.getCategoryTags())
                    .build();
            return recipeSimple;
        });

        List<RecipeSimple> list = recipeSimpleStream.collect(Collectors.toList());
        return list;
    }

    /*
            this.id = id;
        this.name = name;
        this.description = description;
        this.authorId = authorId;
        this.author = author;
        this.numberOfRating = numberOfRating;
        this.averageRating = averageRating;
        this.categoryTags = categoryTags;
     */

    public Recipe findById(Long id) {
        return recipeRepository.findById(id).get();
    }

    public Recipe create(Recipe recipe) {
        // recipe validation
        return recipeRepository.save(recipe);
    }

    public Recipe update(Long id, Recipe recipe) {
        // update validation
        Recipe recipeInDatabase = findById(id);
        if (recipeInDatabase == null) {
            return null;
        }
        recipeRepository.save(recipe);
        return recipe;
    }

    public Recipe delete(Long id) {
        Recipe recipe = findById(id);

//        Iterator<Rating> ratingsIterator = recipe.getRatings().iterator();
//        while (ratingsIterator.hasNext()) {
//            System.out.println("delete rating");
//            ratingRepository.delete(ratingsIterator.next());
//        }
//        Iterator<Instruction> instructionsIterator = recipe.getInstructionList().iterator();
//        while(instructionsIterator.hasNext()) {
//            System.out.println("delete instruction");
//            instructionRepository.delete(instructionsIterator.next());
//        }
//        Iterator<Ingredient> ingredientsIterator = recipe.getIngredientList().iterator();
//        while(ingredientsIterator.hasNext()) {
//            System.out.println("delete ingredients");
//            ingredientRepository.delete(ingredientsIterator.next());
//        }

//
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


//
//
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
