package com.rossotti.spring;

import java.util.List;
import javax.annotation.*;

public class Restaurant {

	private String welcomeNote;
	private IHotDrink hotDrink;
	private List<String> restaurantWaitersList;
	
	//constructor injection
//	Restaurant(IHotDrink hotDrink) {
//		this.hotDrink = hotDrink;
//	}
	
	//setter injection
//	public void setHotDrink(IHotDrink hotDrink) {
//		this.hotDrink = hotDrink;
//	}
	
	public void setRestaurantWaitersList(List<String> restaurantWaitersList) {
		this.restaurantWaitersList = restaurantWaitersList;
	}

	public void displayWaitersNames() {
		System.out.println("All waiters working in Restaurant : " + restaurantWaitersList);
	}
	
	public void prepareHotDrink() {
		hotDrink.prepareHotDrink();
	}

	public void setWelcomeNote(String welcomeNote) {
		this.welcomeNote = welcomeNote;
	}
	
	public void greetCustomer() {
		System.out.println(welcomeNote);
	}
	
//	@PostConstruct
	public void init() {
		System.out.println("Restaurant Bean is going through init");
	}
	
//	@PreDestroy
	public void destroy() {
		System.out.println("Restaurant Bean is going to destroy");
	}
	
}
