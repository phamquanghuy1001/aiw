package com.aiw.repositories;

import com.aiw.entities.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {
	List<Comment> findByIdarticle(long id);
}
