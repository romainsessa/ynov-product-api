package com.ynov.productapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ynov.productapi.model.InternalUser;

@Repository
public interface InternalUserRepository 
	extends CrudRepository<InternalUser, Integer> {

	public InternalUser findByUsername(String username);
	
}
