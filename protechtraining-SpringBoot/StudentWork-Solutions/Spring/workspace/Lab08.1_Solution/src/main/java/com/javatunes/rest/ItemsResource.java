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

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.javatunes.domain.MusicItemCollectionWrapper;
import com.javatunes.domain.MusicItem;
import com.javatunes.service.Catalog;

@RestController
@RequestMapping("/items")
public class ItemsResource {
	
	@Autowired
	Catalog cat;

	// GET all items - Return wrapped collection
		@RequestMapping
		public MusicItemCollectionWrapper getAllItems() {
			Collection<MusicItem> results = cat.findAll();
			return new MusicItemCollectionWrapper(results);
		}


		// GET one item by id
		@RequestMapping("/{id}")
		public MusicItem findItem(@PathVariable("id") Long id) {
		   return cat.findById(id);
		}
		
	 	// Create an item for POST request and URL like /items
	   	// DONE: Add @RequestMapping specifying the correct URL and HTTP method
 		// DONE: Add @ResponseStatus to specify CREATED status
	 	@RequestMapping(method=RequestMethod.POST)
	 	@ResponseStatus(HttpStatus.CREATED)
	 	public MusicItem createItem (@RequestBody MusicItem item, HttpServletResponse response) {
	 		System.out.println("ItemController: createItem called with: " + item);
	 		MusicItem newItem = cat.add(item);
	 		
	 		response.setHeader("Location", "/items/" + newItem.getId());
	 		
	 		return newItem;
	 	} 	
	 	
	 	// Delete an item for DELETE request and URL like /items/2
	 	// DONE: Add @RequestMapping specifying the correct URL and HTTP method
 		// DONE: Add @ResponseStatus to specify NO_CONTENT status
 		// DONE: Add @PathVariable to method signature to correctly bind the id parameter
	 	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	 	@ResponseStatus(HttpStatus.NO_CONTENT)
	 	public void deleteItem (@PathVariable("id") Long id) {
	 		System.out.println("ItemController: deleteItem called with: " + id);
	 		cat.remove(id);
	 	} 	
		

	 	// Update an item for PUT request and URL like /items/2
	 	// DONE: Add @RequestMapping specifying the correct URL and HTTP method
 		// DONE: Add @PathVariable to method signature to correctly bind the id parameter
 		// DONE: Add @RequestBody to method signature to correctly bind the item parameter
	 	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	 	public MusicItem updateItem (@PathVariable("id") Long id, @RequestBody MusicItem item) {
	 		System.out.println("ItemController: updateItem called with: " + item);
	 		MusicItem update = cat.findById(id);
	 		System.out.println("updateItem itemIn = " + item);
	 		System.out.println("updateItem item to update = " + update);
	 		if (update != null) {
	 			update.setTitle(item.getTitle());
	 			update.setArtist(item.getArtist());
	 			update.setPrice(item.getPrice());
	 		}
	 		return update;
	 	} 	  	
}