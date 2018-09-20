/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */
 
package com.javatunes.services;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

// DONE: Make the code in the class run first
@Order(Ordered.HIGHEST_PRECEDENCE)
// DONE: Make this class a runner
public class AnotherRunner implements CommandLineRunner {

	MessageService theMessageService;
	public MessageService getTheMessageService() { return theMessageService; }
	public void setTheMessageService(MessageService theMessageService) { this.theMessageService = theMessageService; }
	
	// DONE: Add @Override when you can.	
	@Override
	public void run(String... arg0) throws Exception {
		System.out.println("*** AnotherRunner.run ***");
		System.out.format("Message is %s\n", theMessageService.getMessage());
		System.out.println();
	}

}
