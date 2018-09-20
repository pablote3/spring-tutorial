/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitablity for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
 
package com.javatunes.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatunes.service.Catalog;

// Annotate as REST controller
// Annotate to map this controller to /test
@RestController
@RequestMapping("/test")
public class TestingResource {
	
	@Autowired
	Catalog cat;

	// Annotate as a handler method
 	@RequestMapping
	public String getTestString() {
 		return "SUCCESS!";
	}

}