package com.gabor.csatlos.entities;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class TestEntity {

	@Id private String id;
	
	private String message;
	
	
	
	public TestEntity() {
		super();
	}

	public TestEntity(String id, String message) {
		super();
		this.id = id;
		this.message = message;
	}


	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	
}
