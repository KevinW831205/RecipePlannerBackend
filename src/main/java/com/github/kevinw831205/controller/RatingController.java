package com.github.kevinw831205.controller;

import com.github.kevinw831205.model.Rating;
import com.github.kevinw831205.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/api/rating")
@Controller
public class RatingController {
    private RatingService ratingService;

    @Autowired
    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<?> findAll() {
        Iterable<Rating> allEntity = ratingService.findAll();
        ResponseEntity<?> response = new ResponseEntity<>(allEntity, HttpStatus.OK);
        return response;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Rating entity = ratingService.findById(id);
        ResponseEntity<?> response = new ResponseEntity<>(entity, HttpStatus.OK);
        return response;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody Rating rating) {
        Rating responseBody = ratingService.create(rating);
        ResponseEntity<?> responseEntity = new ResponseEntity<>(responseBody, HttpStatus.CREATED);
        return responseEntity;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Rating rating) {
        Rating responseBody = ratingService.update(id, rating);
        ResponseEntity responseEntity = new ResponseEntity<>(responseBody, HttpStatus.OK);
        return responseEntity;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Rating responseBody = ratingService.delete(id);
        ResponseEntity responseEntity = new ResponseEntity<>(responseBody, HttpStatus.OK);
        return responseEntity;
    }

    @RequestMapping(value = "/rated", method = RequestMethod.GET)
    public ResponseEntity<?> checkRated(@RequestParam Long recipe_id, @RequestParam Long account_id ) {
        Rating entity = ratingService.findRated(recipe_id,account_id);
        ResponseEntity<?> response = new ResponseEntity<>(entity, HttpStatus.OK);
        return response;
    }


}
