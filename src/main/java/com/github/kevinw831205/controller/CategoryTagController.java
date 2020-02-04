package com.github.kevinw831205.controller;

import com.github.kevinw831205.model.CategoryTag;
import com.github.kevinw831205.service.CategoryTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value = "/api/categoryTag")
@Controller
public class CategoryTagController {
    private CategoryTagService categoryTagService;

    @Autowired
    public CategoryTagController(CategoryTagService categoryTagService) {
        this.categoryTagService = categoryTagService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<?> findAll(){
        Iterable<CategoryTag> allEntity = categoryTagService.findAll();
        ResponseEntity<?> response = new ResponseEntity<>(allEntity, HttpStatus.OK);
        return response;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable Long id){
        CategoryTag entity = categoryTagService.findById(id);
        ResponseEntity<?> response = new ResponseEntity<>(entity ,HttpStatus.OK);
        return response;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody CategoryTag categoryTag){
        CategoryTag responseBody = categoryTagService.create(categoryTag);
        ResponseEntity<?> responseEntity = new ResponseEntity<>(responseBody ,HttpStatus.CREATED);
        return responseEntity;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody CategoryTag categoryTag){
        CategoryTag responseBody = categoryTagService.update(id, categoryTag);
        ResponseEntity responseEntity = new ResponseEntity<>(responseBody, HttpStatus.OK);
        return responseEntity;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable Long id){
        CategoryTag responseBody = categoryTagService.delete(id);
        ResponseEntity responseEntity = new ResponseEntity<>(responseBody, HttpStatus.OK);
        return responseEntity;
    }

}
