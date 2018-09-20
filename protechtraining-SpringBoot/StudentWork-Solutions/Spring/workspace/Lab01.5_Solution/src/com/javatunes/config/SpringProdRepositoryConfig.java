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

import com.javatunes.persistence.ItemRepository;
import com.javatunes.persistence.ProductionItemRepository;

@Configuration
// DONE: annotate this class for profile "prod"
@Profile("prod")
public class SpringProdRepositoryConfig {

	@Autowired
	private Integer maxSearchResults;
	
	@Bean
	ItemRepository itemRepository() {
		// DONE: Create an instance of the production repository
		// DONE: Set maxSearchResults
		// DONE: Return the instance reference
		ProductionItemRepository repository = new ProductionItemRepository();
		repository.setMaxSearchResults(maxSearchResults);
		return repository;
	}

}