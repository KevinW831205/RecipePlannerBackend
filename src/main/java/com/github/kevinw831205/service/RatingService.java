package com.github.kevinw831205.service;

import com.github.kevinw831205.model.Rating;
import com.github.kevinw831205.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingService {
    private RatingRepository ratingRepository;

    @Autowired
    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    public Iterable<Rating> findAll() {
        return ratingRepository.findAll();
    }

    public Rating findById(Long id) {
        return ratingRepository.findById(id).get();
    }

    public Rating create(Rating rating) {
        return ratingRepository.save(rating);
    }

    public Rating update(Long id, Rating rating) {
        Rating ratingInDatabase = findById(id);
        if (ratingInDatabase == null) {
            return null;
        }
        ratingRepository.save(rating);
        return rating;
    }

    public Rating delete(Long id) {
        Rating rating = findById(id);
        ratingRepository.delete(rating);
        return rating;
    }

    public Rating findRated(Long recipe_id, Long account_id) {

        return null;
    }

//    public Integer countByRecipeId(Long id) {
//        return ratingRepository.countByRecipeId(id);
//    }
}
