package com.github.kevinw831205.service;

import com.github.kevinw831205.model.CategoryTag;
import com.github.kevinw831205.repository.CategoryTagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryTagService {
    private CategoryTagRepository categoryTagRepository;

    @Autowired
    public CategoryTagService(CategoryTagRepository categoryTagRepository) {
        this.categoryTagRepository = categoryTagRepository;
    }

    public Iterable<CategoryTag> findAll() {
        return categoryTagRepository.findAll();
    }

    public CategoryTag findById(Long id){
        return categoryTagRepository.findById(id).get();
    }

    public CategoryTag create(CategoryTag categoryTag){
        return categoryTagRepository.save(categoryTag);
    }

    public CategoryTag update(Long id, CategoryTag categoryTag) {
        CategoryTag categoryTagInDatabase = findById(id);
        if(categoryTagInDatabase == null){
            return null;
        }
        categoryTagRepository.save(categoryTag);
        return categoryTag;
    }

    public CategoryTag delete(Long id) {
        CategoryTag categoryTag = findById(id);
        categoryTagRepository.delete(categoryTag);
        return categoryTag;
    }
}
