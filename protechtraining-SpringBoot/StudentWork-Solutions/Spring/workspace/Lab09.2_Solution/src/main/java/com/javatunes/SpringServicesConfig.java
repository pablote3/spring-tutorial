/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */
 
package com.javatunes;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.javatunes.services.AnotherRunner;
import com.javatunes.services.MessageService;
import com.javatunes.services.MessageServiceImpl;

@Configuration
public class SpringServicesConfig {
	
	// Define the catalog bean
	@Bean
	public MessageService messageService() {
		
		MessageService messageService= new MessageServiceImpl();
		return messageService;
	}
	
	@Bean
	public CommandLineRunner anotherRunner() {
		AnotherRunner runner = new AnotherRunner();
		runner.setTheMessageService(messageService());
		// DONE: Return the runner
		return runner;
	}

}