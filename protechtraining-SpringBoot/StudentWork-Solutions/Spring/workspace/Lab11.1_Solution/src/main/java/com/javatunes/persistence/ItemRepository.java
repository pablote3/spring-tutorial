/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.persistence;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;

import com.javatunes.domain.MusicItem;

public interface ItemRepository extends CrudRepository<MusicItem, Long> {

	// Spring Data Lab 2: UNcomment the method declarations below, then test them in the test program

	// Query by the given artist
	public List<MusicItem> findByArtist(@Param("artist") String artist);

	// Query by the given title, ignoring case
	public List<MusicItem> findByTitleIgnoreCase(@Param("title") String title);	

	// Query by artist or title, using LIKE for pattern matching (uses a JPQL query for this)
	// You can define the query using @Query and JPQL, instead of naming conventions, as shown below	
	@Query("SELECT mi FROM MusicItem mi WHERE LOWER(mi.title) LIKE LOWER(CONCAT('%',:keyword, '%')) OR LOWER(mi.artist) LIKE LOWER(CONCAT('%',:keyword, '%'))")
	public List<MusicItem> findByKeyword(@Param("keyword")String keyword);

	// Query by comparison on release date
	public List<MusicItem> findByReleaseDateGreaterThan(@DateTimeFormat(pattern="yyyy-MM-dd")@Param("date") Date theDate);
	// Query by comparison on release date, order results by artist
	public List<MusicItem> findByReleaseDateGreaterThanOrderByArtist(@DateTimeFormat(pattern="yyyy-MM-dd")@Param("date") Date theDate);

	// Query by comparison on being between two release dates
	public List<MusicItem> findByReleaseDateBetween(@Param("start") Date start, @Param("end") Date end);

	// Query by comparison on price, only return first 5 results, order results by title
	public List<MusicItem> queryFirst5ByPriceLessThanOrderByTitle(@Param("price") BigDecimal thePrice);

}
