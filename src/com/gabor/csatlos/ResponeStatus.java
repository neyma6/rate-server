package com.gabor.csatlos;

public enum ResponeStatus {

	SUCCESS("success"),
	ERROR("error");
	
	private String name;

	private ResponeStatus(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	
}
