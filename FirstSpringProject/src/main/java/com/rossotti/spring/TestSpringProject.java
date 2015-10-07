package com.rossotti.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringProject {
	public static void main(String[] args) {
		//interface for accessing Spring framework
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringConfig.xml");
		
		((AbstractApplicationContext)context).registerShutdownHook();
		
		//request object from application context
		Restaurant restaurantObj = (Restaurant)context.getBean("restaurantBean");
		restaurantObj.greetCustomer();
		//restaurantObj.prepareHotDrink();
		//restaurantObj.displayWaitersNames();
		
//		Restaurant restaurantObj1 = (Restaurant)context.getBean("restaurantBean");
//		restaurantObj1.setWelcomeNote("Object1 setting welcome note property");
//		restaurantObj1.greetCustomer();		
//		Restaurant restaurantObj2 = (Restaurant)context.getBean("restaurantBean");
//		restaurantObj2.greetCustomer();
	}
}
