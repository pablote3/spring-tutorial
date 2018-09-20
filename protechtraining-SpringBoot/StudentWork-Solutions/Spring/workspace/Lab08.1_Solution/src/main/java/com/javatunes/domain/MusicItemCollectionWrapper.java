/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
 
package com.javatunes.domain;

import java.util.Collection;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

// Specify that the top-level element is named items
@JacksonXmlRootElement(localName="items")
public class MusicItemCollectionWrapper {

    private Collection<MusicItem> collection;
    
    public MusicItemCollectionWrapper(Collection<MusicItem> colIn) {
    	collection = colIn;
    }

    public MusicItemCollectionWrapper() {    }

    
    // Do not put an extra wrapper element around the elements generated for this collection
    @JacksonXmlElementWrapper(useWrapping=false)
    // Name the element generated for each item in the collection "item"
    @JacksonXmlProperty(localName = "item")
    public Collection<MusicItem> getItems() {
        return collection;
    }

    public void setItems(Collection<MusicItem> colIn) {
        collection = colIn;
    }

}

