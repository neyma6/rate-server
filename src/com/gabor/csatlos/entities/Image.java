package com.gabor.csatlos.entities;

import com.google.appengine.api.datastore.Blob;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
public class Image {

	@Id @Index private String id;
	
	private Blob imageData;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Blob getImageData() {
		return imageData;
	}

	public void setImageData(Blob imageData) {
		this.imageData = imageData;
	}
}
