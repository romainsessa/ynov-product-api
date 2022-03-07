package com.ynov.productapi;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTests {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void getProducts() throws Exception {
		mockMvc.perform(get("/api/private/product").with(httpBasic("romain", "password"))).andExpect(status().isOk());
	}
	
	@Test
	public void postProduct() throws Exception {
		mockMvc.perform(
				post("/api/private/product")
					.contentType(MediaType.APPLICATION_JSON)
					.content("{\"name\": \"test\",\"description\": \"test apple\",\"cost\": 1000}")
					.with(httpBasic("romain", "password"))
				).andExpect(status().isOk());
	}
	
}
