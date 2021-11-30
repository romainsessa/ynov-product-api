package com.ynov.productapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ynov.productapi.model.Product;
import com.ynov.productapi.repository.ProductRepository;
import com.ynov.productapi.transformer.product.ProductFull;
import com.ynov.productapi.transformer.product.ProductTransformer;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductTransformer productTransformer;
	
	public ProductFull upsert(Product product) {
		return productTransformer.transform(
				productRepository.save(product));
	}
	
	public ProductFull getProduct(Integer id) {
		return productTransformer.transform(		
				productRepository.findById(id).get()
				);
	}
	
	public List<ProductFull> getProducts() {
		return productTransformer.transform(productRepository.findAll());
	}
	
	public void deleteProduct(Integer id) {
		productRepository.deleteById(id);
	}
	
	public Iterable<Product> getProductsByName(String name) {
		return productRepository.findByName(name);
	}
	
}
