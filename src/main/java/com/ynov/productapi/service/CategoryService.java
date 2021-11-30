package com.ynov.productapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ynov.productapi.model.Category;
import com.ynov.productapi.repository.CategoryRepository;
import com.ynov.productapi.transformer.CategoryFull;
import com.ynov.productapi.transformer.CategoryTransformer;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<CategoryFull> getCategories() {
		Iterable<Category> categories = categoryRepository.findAll();
		CategoryTransformer transformer = new CategoryTransformer();
		return transformer.transform(categories);
	}
	
}
