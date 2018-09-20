/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.rest.client;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.javatunes.domain.MusicItem;

public class RestClient {

	private final static String BASE_URI = "http://localhost:8080/javatunes/rest/items";
	
	// DONE: Finish the declaration below to include a URI Template variable for an item id
	private final static String ID_URI = BASE_URI + "/{id}";

	public static void main(String[] args) {
		
		//DONE: use getForEntity( ) from RestTemplate
		RestTemplate rt = new RestTemplate();
		rt.getMessageConverters().add(new MappingJackson2XmlHttpMessageConverter());

		// Use getForEntity and HttpEntity
		ResponseEntity<MusicItem> foundEntity = rt.getForEntity(ID_URI, MusicItem.class,"2");
		System.out.println("\ngetForEntity of item by id has content type: " + foundEntity.getHeaders().getContentType());
		System.out.println("getForEntity of item by id has status code: " + foundEntity.getStatusCode());
		System.out.println("Found item 2 using getForEntity: " + foundEntity.getBody());		
	}
}
