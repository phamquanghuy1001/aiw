package com.aiw.apis;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aiw.entities.Article;
import com.aiw.services.ArticleService;

@RestController
@RequestMapping(value = "/article")
public class ArticleApi {
    @Autowired
    ArticleService articleService;

    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    public List<Article> getAll(){
        return articleService.findAll();
    }
    @RequestMapping(value = "/getbycategory/{id}", method = RequestMethod.GET)
    public List<Article> getByCategory(@PathVariable long id){
        return articleService.findAllByCategoryId(id);
    }
    @RequestMapping(value = "/getbyarticleid/{id}", method = RequestMethod.GET)
    public Article getByArticleId(@PathVariable long id){
        return articleService.findOne(id);
    }
    @RequestMapping(value = "/getbyauthor/{id}", method = RequestMethod.GET)
    public List<Article> getByAuthor(@PathVariable long id){
        return articleService.findAllByAuthorId(id);
    }
    @RequestMapping(value = "/getbytag/{id}", method = RequestMethod.GET)
    public List<Article> getByTag(@PathVariable long id){
        return articleService.findAllTagByTagId(id);
    }



}
