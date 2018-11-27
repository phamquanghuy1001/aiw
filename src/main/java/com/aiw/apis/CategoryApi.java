package com.aiw.apis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aiw.entities.Category;
import com.aiw.services.CategoryService;

@RestController
@RequestMapping(value = "/category")
public class CategoryApi {
	@Autowired
	CategoryService categoryService;

	@RequestMapping("/getall")
	public List<Category> getall() {
		return categoryService.getAllCategory();
	}
}
