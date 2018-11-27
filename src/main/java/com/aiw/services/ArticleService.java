package com.aiw.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aiw.entities.Article;
import com.aiw.repositories.ArticleRepository;
import com.aiw.repositories.TagRepository;

@Service
public class ArticleService {
	@Autowired
	ArticleRepository articleRepository;
	@Autowired
	TagRepository tagRepository;

	public List<Article> findAll() {
		List<Article> articleList = new ArrayList<>();
		articleRepository.findAll().forEach(articleList::add);
		return articleList;
	}

	public Article findOne(long id) {
		return articleRepository.findById(id).get();
	}

	public List<Article> findAllByCategoryId(long id) {
		List<Article> articleList = new ArrayList<>();
		articleRepository.findByCategoryId(id).forEach(articleList::add);
		return articleList;
	}

	public List<Article> findAllByAuthorId(long id) {
		List<Article> articleList = new ArrayList<>();
		articleRepository.findByAuthorId(id).forEach(articleList::add);
		return articleList;
	}

	public List<Article> findAllTagByTagId(long id) {
		List<Article> articleList = new ArrayList<>();
		articleRepository.findByTagsId(id).forEach(articleList::add);
		return articleList;
	}

}
