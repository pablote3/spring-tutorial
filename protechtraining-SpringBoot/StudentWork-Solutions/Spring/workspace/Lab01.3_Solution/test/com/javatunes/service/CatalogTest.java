/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */
 
package com.javatunes.service;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.javatunes.domain.MusicItem;

public class CatalogTest {

	@Test
	public void testCatalogLookupPositive() {
		// Pass applicationContext.xml to the constructor
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		assertNotNull("spring container should not be null", ctx);
		/*
		 * Look up the musicCatalog, 
		 * assert that it's not null
	     * and invoke its toString method.  
		 * Don't forget to close spring context
		 */	
		Catalog cat = (Catalog)ctx.getBean(Catalog.class);
		assertNotNull("Catalog should not be null", cat);
		System.out.println(cat.toString());
		
		/*
		 * Optional - You should have two different beans when declared in XML with different name.
		 * Comment out first lookup/test above if you're going to run this one, as lookup by type 
		 * will fail with two different beans of same type but different name.
		 */
//		Catalog cat = (Catalog)ctx.getBean("musicCatalog");
//		Catalog cat2 = (Catalog)ctx.getBean("musicCatalog2");
//		assertNotEquals("The beans should not be equal", cat, cat2);
		
		ctx.close();
	}

	// DONE: DI Lab - annotate as test method
	@Test
	public void testCatalogPositive() {
		String keyword = "a";
		// DONE: Create the context, lookup the catalog.
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Catalog cat = (Catalog)ctx.getBean(Catalog.class);

		// DONE: DI Lab - call the size method test that it's greater than zero, and output its value
		long size = cat.size();
		assertTrue("Size should be greater than zero", size>0);
		System.out.println("Catalog size is " + cat.size());
		
		// DONE: DI Lab - call the findByKeyword method with "a", test that there is at least 
		// one item found, and output the found items
		Collection<MusicItem> results = cat.findByKeyword(keyword);
		assertTrue("Should find at least one item in findByKeyword(a)", results.size()>0);
		System.out.println("Number of items found: " + results.size());
		System.out.println(results);

		// DONE: Close the context.
		ctx.close();
	}


}
