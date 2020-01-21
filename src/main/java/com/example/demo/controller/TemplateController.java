package com.example.demo.controller;

import com.example.demo.model.Template;
import com.example.demo.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

@RequestMapping(value = "/template")
@Controller
public class TemplateController {
    private TemplateService templateService;

    @Autowired
    public TemplateController(TemplateService templateService) {
        this.templateService = templateService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<?> findAll(){
        Iterable<Template> allEntity = templateService.findAll();
        ResponseEntity<?> response = new ResponseEntity<>(allEntity, HttpStatus.OK);
        return response;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable Long id){
        Template entity = templateService.findById(id);
        ResponseEntity<?> response = new ResponseEntity<>(entity ,HttpStatus.OK);
        return response;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody Template template){
        Template responseBody = templateService.create(template);
        ResponseEntity<?> responseEntity = new ResponseEntity<>(responseBody ,HttpStatus.CREATED);
        return responseEntity;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> create(@PathVariable Long id, @RequestBody Template template){
        Template responseBody = templateService.update(id, template);
        ResponseEntity responseEntity = new ResponseEntity<>(responseBody, HttpStatus.OK);
        return responseEntity;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable Long id){
        Template responseBody = templateService.delete(id);
        ResponseEntity responseEntity = new ResponseEntity<>(responseBody, HttpStatus.OK);
        return responseEntity;
    }

}
