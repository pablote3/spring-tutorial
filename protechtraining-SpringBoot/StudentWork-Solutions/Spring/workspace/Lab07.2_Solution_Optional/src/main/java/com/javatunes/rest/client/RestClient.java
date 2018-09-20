/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.rest.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
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

		// Use getForEntity and HttpEntity
		ResponseEntity<MusicItem> foundEntity = rt.getForEntity(ID_URI, MusicItem.class,"2");
		System.out.println("\ngetForEntity of item by id has content type: " + foundEntity.getHeaders().getContentType());
		System.out.println("getForEntity of item by id has status code: " + foundEntity.getStatusCode());
		System.out.println("Found item 2 using getForEntity: " + foundEntity.getBody());		
		System.out.println();

		// OPTIONAL part - setting headers
		HttpHeaders headers = new HttpHeaders();
		List<MediaType> accepts = new ArrayList<MediaType>();
		// Line below is for using JSON 
		accepts.add(MediaType.APPLICATION_JSON);
		
		headers.setAccept(accepts);
		HttpEntity<MusicItem> requestEntity = new HttpEntity<MusicItem>(headers);
		ResponseEntity<MusicItem> exchangeEntity = rt.exchange(ID_URI, HttpMethod.GET, requestEntity, MusicItem.class,"2");
		System.out.println();
		System.out.println("exchangeEntity of item by id has content type: " + exchangeEntity.getHeaders().getContentType());
		System.out.println("exchangeEntity of item by id has body: " + exchangeEntity.getBody());
		System.out.println();

 		// This section gets the response as a string.
		HttpEntity<String> requestForStringEntity = new HttpEntity<String>(headers);
		ResponseEntity<String> exchangeForStringEntity = rt.exchange(ID_URI, HttpMethod.GET, requestForStringEntity, String.class,"2");
		System.out.println();
		System.out.println("exchangeForStringEntity = " + exchangeForStringEntity.getBody());
		System.out.println();
	}
}
