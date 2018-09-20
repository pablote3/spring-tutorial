/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */
 
package com.javatunes.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
// DONE: Make the code in the class run last
@Order(Ordered.LOWEST_PRECEDENCE)
// DONE: Make this class a runner
public class ARunner implements CommandLineRunner {
	
	// TODO: Inject the property when you can (after adding the property in properties file)
	// @Value("${javatunes.database.name}")
	private String dbName = "Not Initialized";

	// DONE: Add @Override when you can.
	@Override
	public void run(String... arg0) throws Exception {
		System.out.println("*** ARunner.run ***");
		System.out.format("Database name is: %s\n",dbName);
		System.out.println("Arguments are");
		for (String cur : arg0) {
			System.out.println(cur);
		}
		System.out.println();
	}

}
