package com.gabor.csatlos.domain;

public enum ResponseParam {

	STATUS("status"),
	ERROR("error"),
	USER("user"),
	URL("url");
	
	private String name;

	private ResponseParam(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	
}
