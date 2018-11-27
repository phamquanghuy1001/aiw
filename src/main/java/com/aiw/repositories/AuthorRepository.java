package com.aiw.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aiw.entities.Author;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
