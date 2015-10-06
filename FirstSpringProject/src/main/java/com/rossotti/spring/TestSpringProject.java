package com.rossotti.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringProject {
	public static void main(String[] args) {
		//interface for accessing Spring framework
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringConfig.xml");
		
		//request object from application context
		Restaurant restaurantObj = (Restaurant)context.getBean("restaurantBean");
		restaurantObj.greetCustomer();
	}
}
