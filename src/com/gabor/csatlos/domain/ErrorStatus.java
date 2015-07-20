package com.gabor.csatlos.domain;

public enum ErrorStatus {

	USER_EXISTS("user_exists"),
	INVALID_USER("invalid_user"),
	ERROR_OCCURED("error_occured"),
	INVALID_PARAMETER("invalid_parameter"),
	INVALID_PARAMETER_TYPE("invalid_parameter_type");
	
	private String name;

	private ErrorStatus(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	
}
