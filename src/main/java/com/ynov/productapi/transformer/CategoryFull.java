package com.ynov.productapi.transformer;

import java.util.ArrayList;
import java.util.List;

public class CategoryFull {
	
	private Integer categoryId;
	private String name;
	private List<ProductLight> products = new ArrayList<>();
	
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<ProductLight> getProducts() {
		return products;
	}
	public void setProducts(List<ProductLight> products) {
		this.products = products;
	}
}
