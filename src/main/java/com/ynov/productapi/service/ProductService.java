package com.ynov.productapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ynov.productapi.exceptions.NotFoundException;
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
		return productTransformer.transform(productRepository.save(product));
	}
	
	public ProductFull upsert(ProductFull product) {
		return upsert(productTransformer.untransform(product));
	}

	public ProductFull getProduct(Integer id) throws NotFoundException {
		Optional<Product> res = productRepository.findById(id);
		if (res.isPresent()) {
			return productTransformer.transform(res.get());
		} else {
			throw new NotFoundException();
		}
	}
	
	public Optional<Product> getEntityProduct(Integer id) {
		return productRepository.findById(id);
	}

	public List<ProductFull> getProducts() {
		return productTransformer.transform(productRepository.findAll());
	}

	public void deleteProduct(Integer id) {
		productRepository.deleteById(id);
	}

	public Iterable<ProductFull> getProductsByName(String name) {
		return productTransformer.transform(productRepository.findByName(name));
	}

}
