package com.aiw.controllers;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.aiw.entities.Article;
@Controller
public class EducationController {
    @RequestMapping("/education")
    public String index(ModelMap modelMap){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Article>> res = restTemplate.exchange(
                "http://localhost:8080/article/getbycategory/3",
                HttpMethod.GET, null, new ParameterizedTypeReference<List<Article>>() {
                }
        );
        List<Article> articleList = res.getBody();
        modelMap.put("articleList", articleList);
        return "education";
    }
}
