package com.aiw.services;

import com.aiw.entities.Category;
import com.aiw.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> getAllCategory(){
        List<Category> categoryList = new ArrayList<>();
        categoryRepository.findAll().forEach(categoryList::add);
        return categoryList;
    }


    public Category getCategory(long categoryId){
        return categoryRepository.findById(categoryId).get();
    }
    public void addCategory(Category category){
        categoryRepository.save(category);
    }
    public void updateCategory(Category category){
        categoryRepository.save(category);
    }
    public void deleteCategory(long categoryId){
        categoryRepository.deleteById(categoryId);
    }
}
