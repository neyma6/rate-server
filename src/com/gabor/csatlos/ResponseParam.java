package com.gabor.csatlos;

public enum ResponseParam {

	STATUS("status"),
	ERROR("error"),
	USER("response"),
	IMAGE("image");
	
	private String name;

	private ResponseParam(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	
}
