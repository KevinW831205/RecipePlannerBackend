package com.example.demo.service;

import com.example.demo.model.Template;
import com.example.demo.repository.TemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    private TemplateRepository templateRepository;

    @Autowired
    public AccountService(TemplateRepository templateRepository) {
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
