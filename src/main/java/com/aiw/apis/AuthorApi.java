package com.aiw.apis;

import com.aiw.entities.Author;
import com.aiw.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/author")
public class AuthorApi {
    @Autowired
    AuthorService authorService;
    @RequestMapping(value = "/getall")
    public List<Author> getAll(){
        return authorService.findAll();
    }

}
