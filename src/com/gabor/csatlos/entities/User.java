package com.gabor.csatlos.entities;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
public class User {

	@Id @Index private String id;
	
	private String name;
	private String password;
	private double rateValues;
	private int numberOfRates;
	private boolean facebookUser;
	
	public User() {
	}

	public User(String id, String name, String password, double rateValues, int numberOfRates, boolean facebookUser) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.rateValues = rateValues;
		this.numberOfRates = numberOfRates;
		this.facebookUser = facebookUser;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getRateValues() {
		return rateValues;
	}

	public void setRateValues(double rateValues) {
		this.rateValues = rateValues;
	}

	public int getNumberOfRates() {
		return numberOfRates;
	}

	public void setNumberOfRates(int numberOfRates) {
		this.numberOfRates = numberOfRates;
	}

	public boolean isFacebookUser() {
		return facebookUser;
	}

	public void setFacebookUser(boolean facebookUser) {
		this.facebookUser = facebookUser;
	}

}
