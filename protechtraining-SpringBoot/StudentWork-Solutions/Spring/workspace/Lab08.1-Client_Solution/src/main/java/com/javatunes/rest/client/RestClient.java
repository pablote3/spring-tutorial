	/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.rest.client;

import java.math.BigDecimal;
import java.net.URI;
import java.time.LocalDate;

import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.javatunes.domain.MusicCategory;
import com.javatunes.domain.MusicItem;
import com.javatunes.domain.MusicItemCollectionWrapper;


public class RestClient {

	private final static String BASE_URI = "http://localhost:8080/javatunes/rest/items";
	private final static String ID_URI = BASE_URI + "/{id}";

	public static void main(String[] args) {
		RestTemplate rt = new RestTemplate();
		
		rt.getMessageConverters().add(new MappingJackson2XmlHttpMessageConverter());

		
		MusicItem found;
		MusicItemCollectionWrapper allItems;
		
		String deleteId = "5";


		found = rt.getForObject(ID_URI, MusicItem.class,deleteId);
		System.out.println();
		System.out.println("Found item - " + deleteId + " : " + found);
		System.out.println();

		// Comment out to run client more than once
		// DONE: Add Call to DELETE using RestTemplate		
		rt.delete(ID_URI,deleteId);

		allItems = rt.getForObject(BASE_URI, MusicItemCollectionWrapper.class);
		System.out.println();
		System.out.println("All Objects found after delete: ");
		for (MusicItem cur: allItems.getItems()) {
			System.out.println(cur);
		}
		System.out.println();


		String putId = "6";

		found = rt.getForObject(ID_URI, MusicItem.class,putId);
		System.out.println();
		System.out.println("Found item - " + putId + " : " + found);
		System.out.println();
		
		found.setTitle("Changed this");
		// DONE: Add call to PUT, using the putId variable above, and the found object		
		rt.put(ID_URI, found, putId);

		found = rt.getForObject(ID_URI, MusicItem.class,putId);
		System.out.println();
		System.out.println("Found item after put - " + putId + " : " + found);
		System.out.println();


		// Testing POST for create.
		MusicItem newItem = new MusicItem();
		newItem.setTitle("MyTitle");
		newItem.setArtist("Me!");
		newItem.setReleaseDate(LocalDate.now());
		newItem.setPrice(new BigDecimal("12.95"));
		newItem.setMusicCategory(MusicCategory.ALTERNATIVE);
		
		// DONE: Add call to POST (for object), using the newItem object as the request object
		MusicItem createdItem = rt.postForObject(BASE_URI, newItem, MusicItem.class);
		System.out.println();
		System.out.println("Created new item: " + createdItem);
		System.out.println();
		
		// DONE: Add call to POST (for location), using the newItem object as the request object
		URI createdURI = rt.postForLocation(BASE_URI, newItem);
		System.out.println();
		System.out.println("Created another new item at location: " + createdURI);
		System.out.println();

		allItems = rt.getForObject(BASE_URI, MusicItemCollectionWrapper.class);
		System.out.println();
		System.out.println("All Objects found after POST: ");
		for (MusicItem cur: allItems.getItems()) {
			System.out.println(cur);
		}
		System.out.println();

	}

}
