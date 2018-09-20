/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */

package com.javatunes;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.javatunes.listeners.MyListener;

// DONE: Declare this to be a Spring Boot application class
@SpringBootApplication
// DONE: Uncomment the below when you can
@Import({SpringServicesConfig.class})
public class HelloBootWorld {

	public static void main(String[] args) {
		runWithoutInstance(args);
		// Comment out above, and uncomment below to see optional part run.
		// optionallyRunWithInstance(args);
	}

    public static void runWithoutInstance(String[] args) {
      System.out.println("HelloBootWorld.main() called");
	  // DONE: Run the app as a Spring Boot app
      SpringApplication.run(HelloBootWorld.class, args);
    }


    // Optional part - customize by creating an instance
    public static void optionallyRunWithInstance(String[] args) {
    	System.out.println("HelloBootWorldOptional.main() called");
    	   SpringApplication app = new SpringApplication(HelloBootWorld.class);
    	   app.setBannerMode(Banner.Mode.OFF);
    	   app.addListeners(new MyListener());
    	   app.run(args);
    }    
}
