package com.ynov.productapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductApiApplication implements CommandLineRunner {

//	@Autowired
//	private CategoryRepository categoryRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ProductApiApplication.class, args);
	}

//	@Transactional
	@Override
	public void run(String... args) throws Exception {
//		Optional<Category> optCategory = categoryRepository.findById(1);
//		Category categoryId1 = optCategory.get();
//		
//		System.out.println(categoryId1.getName());	
// 
//		categoryId1.getProducts().forEach(
//				product -> System.out.println(product.getName()));
		
	}
	
	

}
