/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.javatunes.config.SpringConfig;
import com.javatunes.domain.MusicItem;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={SpringConfig.class})
public class CatalogTest {

    @Autowired
    Catalog cat;
    
	@Test
	public void testFindOnePositive() {
		Long id = 1L;
		
		System.out.println("\n*** Retrieving item from the database ***");
		MusicItem item = cat.findById(id);
		assertNotNull("The MusicItem should not be null", item);
		System.out.println(item);
		System.out.println("***\n");
	}

}
