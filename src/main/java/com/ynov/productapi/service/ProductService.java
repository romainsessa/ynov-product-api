package com.ynov.productapi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ynov.productapi.model.Product;
import com.ynov.productapi.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public Product upsert(Product product) {
		return productRepository.save(product);
	}
	
	public Optional<Product> getProduct(Integer id) {
		return productRepository.findById(id);
	}
	
	public Iterable<Product> getProducts() {
		return productRepository.findAll();
	}
	
	public void deleteProduct(Integer id) {
		productRepository.deleteById(id);
	}
	
	public Iterable<Product> getProductsByName(String name) {
		return productRepository.findByName(name);
	}
	
}
