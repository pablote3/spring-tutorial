/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */
 
package com.javatunes.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.javatunes.persistence.InMemoryItemRepository;
import com.javatunes.persistence.ItemRepository;

@Configuration
// DONE: Annotate this class for profile "dev"
@Profile("dev")
public class SpringDevRepositoryConfig {

	@Autowired
	private Integer maxSearchResults;
	
	@Bean
	ItemRepository itemRepository() {		
		// DONE: create an instance of the dev repository
		// DONE: set the max search results to maxSearchResults
		// DONE: return the instance reference
		InMemoryItemRepository repository = new InMemoryItemRepository();
		repository.setMaxSearchResults(maxSearchResults);
		return repository;	}

}