package com.ynov.productapi.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ynov.productapi.model.Category;
import com.ynov.productapi.model.Product;
import com.ynov.productapi.service.CategoryService;
import com.ynov.productapi.service.ProductService;
import com.ynov.productapi.transformer.category.CategoryFull;

@RestController
@RequestMapping("api/private")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/category")
	public List<CategoryFull> getCategories() {
		return categoryService.getCategories();
	}
	
	@PostMapping("/category/{idCategory}/{idProduct}")
	public void addProductToCategory(
			@PathVariable(name = "idCategory") Integer idCategory,
			@PathVariable(name = "idProduct") Integer idProduct) {
		
		Category category = categoryService.getEntityCategory(idCategory).get();
		Product product = productService.getEntityProduct(idProduct).get();
		
		category.addProduct(product);
		
		categoryService.saveCategory(category);
	
	}
	
}
