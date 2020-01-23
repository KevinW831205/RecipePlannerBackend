package com.github.kevinw831205.repository;

import com.github.kevinw831205.model.Template;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeCategoryTagRepository extends CrudRepository<Template, Long> {
}
