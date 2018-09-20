/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.services;

import java.util.List;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


@Component
// DONE: Make this an application runner
public class MyApplicationRunner implements ApplicationRunner {
	
	// DONE: Write the needed run()
	@Override
	public void run(ApplicationArguments args) throws Exception {
		// Get debug and myOpt options
        boolean debug = args.containsOption("debug");
        boolean myOpt = args.containsOption("myOpt");
        // Get any other arguments
        List<String>otherArgs = args.getNonOptionArgs();
		
		System.out.println("*** MyApplicationRunner.run ***");
		// Output options and args to console
        // if run with "--myOpt file1.txt --myOpt2 file2.txt" debug===false, myOpt==true, --myOpt2==true, otherArgs=["file1.txt file2.txt"]
		System.out.format("debug = %s\n",debug);
        System.out.format("myOpt = %s\n",myOpt);
        System.out.println("Other args are");
        for (String cur : otherArgs) {
        		System.out.format("%s, ",cur);
        }
        System.out.println();
		

		System.out.println();
	}    
}
