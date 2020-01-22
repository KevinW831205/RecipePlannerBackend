package com.github.kevinw831205.service;

import com.github.kevinw831205.model.Template;
import com.github.kevinw831205.repository.TemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TemplateService {
    private TemplateRepository templateRepository;

    @Autowired
    public TemplateService(TemplateRepository templateRepository) {
        this.templateRepository = templateRepository;
    }

    public Iterable<Template> findAll() {
        return templateRepository.findAll();
    }

    public Template findById(Long id){
        return templateRepository.findById(id).get();
    }

    public Template create(Template template){
        return templateRepository.save(template);
    }

    public Template update(Long id, Template template) {
        Template templateInDatabase = findById(id);
        if(templateInDatabase == null){
            return null;
        }
        templateRepository.save(template);
        return template;
    }

    public Template delete(Long id) {
        Template template = findById(id);
        templateRepository.delete(template);
        return template;
    }
}
