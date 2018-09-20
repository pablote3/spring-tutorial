/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitablity for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
 
package com.javatunes.rest;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatunes.domain.MusicItem;
import com.javatunes.service.Catalog;

// DONE: Annotate as REST controller
// DONE: Annotate to map this controller to /items
@RestController
@RequestMapping("/items")
public class ItemsResource {
	
	@Autowired
	Catalog cat;

	// DONE: annotate as a handler method
 	@RequestMapping
	public String getAllItems() {
		Collection<MusicItem> results = cat.findAll();
		return results.toString();
	}

	// DONE: Annotate as a handler method that matches URI of form /items/5
	// DONE: Annotate to bind the URI template variable to the id parameter	
    @RequestMapping("/{id}") 
 	public String findItem(@PathVariable("id")Long id) {
	   return cat.findById(id).toString();
	}

}