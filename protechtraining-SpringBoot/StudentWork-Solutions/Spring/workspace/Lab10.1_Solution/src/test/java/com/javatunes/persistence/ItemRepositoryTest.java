/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.persistence;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.javatunes.config.SpringConfig;
import com.javatunes.domain.MusicItem;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={SpringConfig.class})
public class ItemRepositoryTest {

	// Used to control transactions - we will do this more elegantly with Spring Transactions
	@Autowired
	private PlatformTransactionManager transactionManager;
	DefaultTransactionDefinition definition = new DefaultTransactionDefinition();

	// DONE: Autowire the ItemRepository
	@Autowired
	ItemRepository repo;

	@Test
	public void testFindPositive() {
		Long id = 1L;

		TransactionStatus transaction = transactionManager.getTransaction(definition);
		System.out.println("\n*** Retrieving item from the database ***");

		// DONE: Get an item by id.
		MusicItem item = repo.getOne(id);
		
		assertNotNull("The MusicItem should not be null", item);
		System.out.println(item);
		System.out.println("***\n");
		transactionManager.commit(transaction);
	}    

}
