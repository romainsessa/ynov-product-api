package com.ynov.productapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ynov.productapi.service.CategoryService;
import com.ynov.productapi.transformer.category.CategoryFull;

@RestController
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/category")
	public List<CategoryFull> getCategories() {
		return categoryService.getCategories();
	}
	
}
