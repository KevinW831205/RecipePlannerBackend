package com.github.kevinw831205.repository;

import com.github.kevinw831205.model.Rating;
import com.github.kevinw831205.model.Template;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends CrudRepository<Rating, Long> {
//    @Query(countByRecipeId)
//    Integer countByRecipeId(Long recipeId);
//    final String countByRecipeId = "SELECT COUNT(ra) FROM rating ra WHERE ra.recipe_id = ?1";
}
