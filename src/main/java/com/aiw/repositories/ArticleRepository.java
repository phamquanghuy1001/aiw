package com.aiw.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aiw.entities.Article;

@Repository
public interface ArticleRepository extends CrudRepository<Article, Long> {
	List<Article> findByCategoryId(long id);

	List<Article> findByAuthorId(long id);

	List<Article> findByTagsId(long id);
}
