package com.javatunes.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class JavaTunesWebAppInitializer extends
		AbstractAnnotationConfigDispatcherServletInitializer {

	  @Override
	  protected String[] getServletMappings() {
	    return new String[] { "/rest/*" };  // DONE: set the mapping to /rest/*
	  }
	  
	  @Override
	  protected Class<?>[] getRootConfigClasses() {
		// DONE: Return the root Spring config class
	    return new Class<?>[] { SpringConfig.class };
	  }

	  @Override
	  protected Class<?>[] getServletConfigClasses() {
		// DONE: Return the Web config class
		  return new Class<?>[] { WebConfig.class };
	  }
}
