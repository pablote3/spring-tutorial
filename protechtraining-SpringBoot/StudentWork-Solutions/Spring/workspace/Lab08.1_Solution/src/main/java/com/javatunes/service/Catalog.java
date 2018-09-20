/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.service;

import java.util.Collection;

import com.javatunes.domain.MusicItem;

public interface Catalog {
   public void persist(MusicItem item);
   public void persistBatch(Collection<MusicItem> items);
   public void remove(MusicItem item);
   public void remove(Long id);
   public MusicItem findById(Long id);
   public Collection<MusicItem> findAll();
   public Collection<MusicItem> findByKeyword(String keyword);
   public Collection<MusicItem> findByCategory(String category);
   public long size();
   public MusicItem add(MusicItem item);

}
