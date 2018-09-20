package com.javatunes;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class BootDataRestDemo extends SpringBootServletInitializer {

	
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(BootDataRestDemo.class);
    }
	
    public static void main(String[] args) {
    	System.out.println("BootDataWebDemo.main() called");
        SpringApplication.run(BootDataRestDemo.class, args);
    }   
}
