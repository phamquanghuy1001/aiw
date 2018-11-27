package com.aiw.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aiw.entities.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

}
