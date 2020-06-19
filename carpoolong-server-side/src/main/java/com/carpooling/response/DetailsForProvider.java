package com.carpooling.response;

import java.util.List;

public class DetailsForProvider {
	private String fullName;
	private String email;
	private String mobileNumber;
	
	
	public DetailsForProvider() {

	}
	public DetailsForProvider(String fullName, String email, String mobileNumber) {
		super();
		this.fullName = fullName;
		this.email = email;
		this.mobileNumber = mobileNumber;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
}


