package com.github.kevinw831205.controller;

import com.github.kevinw831205.model.Ingredient;
import com.github.kevinw831205.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value = "/api/ingredient")
@Controller
public class IngredientController {
    private IngredientService ingredientService;

    @Autowired
    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<?> findAll(){
        Iterable<Ingredient> allEntity = ingredientService.findAll();
        ResponseEntity<?> response = new ResponseEntity<>(allEntity, HttpStatus.OK);
        return response;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable Long id){
        Ingredient entity = ingredientService.findById(id);
        ResponseEntity<?> response = new ResponseEntity<>(entity ,HttpStatus.OK);
        return response;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody Ingredient ingredient){
        Ingredient responseBody = ingredientService.create(ingredient);
        ResponseEntity<?> responseEntity = new ResponseEntity<>(responseBody ,HttpStatus.CREATED);
        return responseEntity;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> create(@PathVariable Long id, @RequestBody Ingredient ingredient){
        Ingredient responseBody = ingredientService.update(id, ingredient);
        ResponseEntity responseEntity = new ResponseEntity<>(responseBody, HttpStatus.OK);
        return responseEntity;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable Long id){
        Ingredient responseBody = ingredientService.delete(id);
        ResponseEntity responseEntity = new ResponseEntity<>(responseBody, HttpStatus.OK);
        return responseEntity;
    }

}
