package com.ynov.productapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ynov.productapi.model.Comment;
import com.ynov.productapi.model.Product;
import com.ynov.productapi.service.CommentService;
import com.ynov.productapi.service.ProductService;
import com.ynov.productapi.transformer.product.ProductFull;

@RestController
public class CommentController {
	
	@Autowired
	private ProductService productService;

	@Autowired
	private CommentService commentService;
	
	@PostMapping("/comment/{id}")
	public ProductFull addComment(@PathVariable("id") Integer id, @RequestBody Comment comment) {
		Product existingProduct = productService.getEntityProduct(id).get();
		existingProduct.getComments().add(comment);			
		return productService.upsert(existingProduct);		
	}
	
	@DeleteMapping("/comment/{id_comment}/product/{id_product}")
	public void delete(@PathVariable("id_comment") Integer id_comment, 
			@PathVariable("id_product") Integer id_product) {
		Comment c = commentService.getComment(id_comment).get();
		Product p = productService.getEntityProduct(id_product).get();
		p.getComments().remove(c);
		productService.upsert(p);
	}
	
}
