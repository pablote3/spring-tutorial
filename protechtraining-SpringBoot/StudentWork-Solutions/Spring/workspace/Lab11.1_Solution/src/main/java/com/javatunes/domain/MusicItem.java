/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.domain;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="MusicItem")
public class MusicItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title, artist;
	private Date releaseDate;
	private BigDecimal price;
	@Enumerated(EnumType.STRING)
	private MusicCategory musicCategory;
	
	@Transient
	private SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

	public MusicItem() {
	}

	public MusicItem(Long id) {
		setId(id);
	}

	private Long getId() {
		return id;
	}

	private void setId(Long id) {
		this.id = id;
	}

	public MusicItem(String title, String artist, String releaseDate,
			BigDecimal price, MusicCategory musicCategory) {
		this.setTitle(title);
		this.setArtist(artist);
		this.setReleaseDateString(releaseDate);
		this.setPrice(price);
		this.setMusicCategory(musicCategory);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public void setReleaseDateString(String releaseDateString) {
		try {
			releaseDate = df.parse(releaseDateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public boolean equals(Object compare) {
		boolean result = false;
		MusicItem other = null;

		if (compare instanceof MusicItem) {
			other = (MusicItem) compare;
			result = other.getId().equals(this.getId());
		}
		return result;
	}

	public MusicCategory getMusicCategory() {
		return musicCategory;
	}

	public void setMusicCategory(MusicCategory musicCategory) {
		this.musicCategory = musicCategory;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "MusicItem [id=" + id + ", title=" + title + ", artist="
				+ artist + ", releaseDate=" + releaseDate + ", price=" + price
				+ ", musicCategory=" + musicCategory + "]";
	}

}
