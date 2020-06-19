package com.carpooling.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;

@Entity
public class User_ride {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	
	//@ManyToOne
	//@JoinColumn(name="username", nullable=false)
	private long rideId;
	
	private String userName;
	
	private String role;
	
	public User_ride() {
		
	}

	public User_ride(long rideId, String userName,String role) {
		//super();
		this.rideId = rideId;
		this.userName = userName;
		this.role=role;
	}
	
	

	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getRideId() {
		return rideId;
	}

	public void setRideId(long rideId) {
		this.rideId = rideId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	
	
}

