package com.ynov.productapi.transformer;

import java.util.ArrayList;
import java.util.List;

import com.ynov.productapi.model.Category;
import com.ynov.productapi.model.Product;

public class CategoryTransformer {

	public CategoryFull transform(Category category) {
		CategoryFull categoryFull = new CategoryFull();
		categoryFull.setCategoryId(category.getCategoryId());
		categoryFull.setName(category.getName());
		
		for(Product product : category.getProducts()) {
			ProductLight productLight = new ProductLight();
			productLight.setId(product.getId());
			productLight.setName(product.getName());
			productLight.setDescription(product.getDescription());
			productLight.setCost(product.getCost());
			
			categoryFull.getProducts().add(productLight);
		}		
		return categoryFull;
	}
	
	public List<CategoryFull> transform(Iterable<Category> categories) {
		List<CategoryFull> categoriesFull = new ArrayList<>();
		for(Category category : categories) {
			categoriesFull.add(transform(category));
		}
		return categoriesFull;
	}
	
	
	
}
