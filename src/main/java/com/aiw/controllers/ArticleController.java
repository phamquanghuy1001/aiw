package com.aiw.controllers;

import java.util.List;
import java.util.Set;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.aiw.entities.Article;
import com.aiw.entities.Author;
import com.aiw.entities.Comment;
import com.aiw.entities.Tag;

@Controller
public class ArticleController {
    @RequestMapping(value = "/article1/{id}", method = RequestMethod.GET)
    public String index(@PathVariable long id, ModelMap modelMap, Model model){
        RestTemplate restTemplate = new RestTemplate();
        String uri ="http://localhost:8080/article/getbyarticleid/" + id;
        Article article = restTemplate.getForObject(uri, Article.class);
        Author author = article.getAuthor();
        Set<Tag> tags = article.getTags();
        modelMap.put("article", article);
        modelMap.put("author", author);
        modelMap.put("tags", tags);
        Comment comment = new Comment();
        model.addAttribute("com", comment);
        ResponseEntity<List<Comment>> res = restTemplate.exchange(
                "http://localhost:8080/comment/getallbyarticle/" + id,
                HttpMethod.GET, null, new ParameterizedTypeReference<List<Comment>>() {
                }
        );
        List<Comment> commentList = res.getBody();
        modelMap.put("commentList", commentList);
        return "articledetail";
    }
    @RequestMapping(value = "/addcomment", method = RequestMethod.POST)
    public String index2(@ModelAttribute("com") Comment comment){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForObject("http://localhost:8080/comment/add/" + comment.getCommentor()
                +"/" + comment.getMessage() +"/" + comment.getIdarticle(),comment,Comment.class);
        return "redirect:/article1/" + comment.getIdarticle();
    }
}
