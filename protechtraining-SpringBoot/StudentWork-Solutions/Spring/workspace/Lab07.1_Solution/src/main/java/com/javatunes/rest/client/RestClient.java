/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.rest.client;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.client.RestTemplate;

import com.javatunes.domain.MusicItem;

public class RestClient {

	private final static String BASE_URI = "http://localhost:8080/javatunes/rest/items";
	
	// DONE: Finish the declaration below to include a URI Template variable for an item id
	private final static String ID_URI = BASE_URI + "/{id}";

	public static void main(String[] args) {
		// DONE: Create instance of RestTemplate
		RestTemplate rt = new RestTemplate();
		
		MusicItem found = null;

        // DONE: Get a MusicItem using RestTemplate's getForObject,the ID_URI and an item id
		found = rt.getForObject(ID_URI, MusicItem.class, "2");
		System.out.format("\nFound item 2: %s\n\n",found);

		// DONE: Get an item as a string using getForObject(), the ID_URI, and an item id
		// use String.class as the response type in getForObject()
		String foundString = rt.getForObject(ID_URI, String.class, "2");
		System.out.format("\nFound item 2 as string: %s\n\n",foundString);
		
		Map<String,String> varsMap = new HashMap<String,String>();
		varsMap.put("id", "2");

		// DONE: Call getForObject using varsMap		
		found = rt.getForObject(ID_URI, MusicItem.class, varsMap);
		System.out.format("\nFound item 2 using varsMap: %s\n\n",found);
	
		
		// DONE (Optional): Get all the items using getForObject, the BASE_URI, and MusicItemCollectionWrapper.class 
		// as the response type.	
		Collection<MusicItem> items = rt.getForObject(BASE_URI, Collection.class);
		System.out.format("\nAll Objects found:\n");
		for (Object cur: items) {
			System.out.println(cur);
		}
			}
}
