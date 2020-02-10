package com.github.kevinw831205.controller;

import com.github.kevinw831205.model.Recipe;
import com.github.kevinw831205.model.RecipeSimple;
import com.github.kevinw831205.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/api/recipe")
@Controller
public class RecipeController {
    private RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<?> findAll() {
        Iterable<Recipe> allEntity = recipeService.findAll();
        ResponseEntity<?> response = new ResponseEntity<>(allEntity, HttpStatus.OK);
        return response;
    }

    @RequestMapping(value = "/published", method = RequestMethod.GET)
    public ResponseEntity<?> findAllPublished() {
        Iterable<Recipe> publishedEntity = recipeService.findAllPublished();
        ResponseEntity<?> response = new ResponseEntity<>(publishedEntity, HttpStatus.OK);
        return response;
    }

    @RequestMapping(value = "/published/{id}", method = RequestMethod.PATCH)
    public ResponseEntity<?> togglePublished(@PathVariable Long id) {
        Recipe entity = recipeService.togglePublished(id);
        ResponseEntity<?> response = new ResponseEntity<>(entity, HttpStatus.OK);
        return response;
    }


    @RequestMapping(value = "/simple", method = RequestMethod.GET)
    public ResponseEntity<?> findAllPublishedSimple() {
        List<RecipeSimple> publishedEntitySimple = recipeService.findAllPublishedSimple();
        ResponseEntity<?> response = new ResponseEntity<>(publishedEntitySimple, HttpStatus.OK);
        return response;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Recipe entity = recipeService.findById(id);
        ResponseEntity<?> response = new ResponseEntity<>(entity, HttpStatus.OK);
        return response;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody Recipe recipe) {
        Recipe responseBody = recipeService.create(recipe);
        ResponseEntity<?> responseEntity = new ResponseEntity<>(responseBody, HttpStatus.CREATED);
        return responseEntity;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Recipe recipe) {
        Recipe responseBody = recipeService.update(id, recipe);
        ResponseEntity responseEntity = new ResponseEntity<>(responseBody, HttpStatus.OK);
        return responseEntity;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Recipe responseBody = recipeService.delete(id);
        ResponseEntity responseEntity = new ResponseEntity<>(responseBody, HttpStatus.OK);
        return responseEntity;
    }

    @RequestMapping(value = "/add-tag", method = RequestMethod.PUT)
    // example: http://localhost:8080/api/recipe/add-tag?recipe_id=1&tag_id=1
    public ResponseEntity<?> addTag(@RequestParam Long recipe_id, @RequestParam Long tag_id) {
        Recipe responseBody = recipeService.addTag(recipe_id, tag_id);
        ResponseEntity responseEntity = new ResponseEntity<>(responseBody, HttpStatus.OK);
        return responseEntity;
    }


    @RequestMapping(value = "/name/{id}", method = RequestMethod.PATCH)
    public ResponseEntity<?> patchName(@PathVariable Long id, @RequestParam String name) {
        Recipe entity = recipeService.patchName(id,name);
        ResponseEntity<?> response = new ResponseEntity<>(entity, HttpStatus.OK);
        return response;
    }
}
