package com.carpooling.response;

//import java.util.List;

public class ShowRides {
	private long id;
	private long rideId;
	private String role;
	private String rideDate;
	private String source;
	private String destination;
	private String carName;
	private int costPerSeat;
	private String offeredBy;
	//private String userName;
/*	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	} */
	public String getOfferedBy() {
		return offeredBy;
	}
	public void setOfferedBy(String offeredBy) {
		this.offeredBy = offeredBy;
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getRideDate() {
		return rideDate;
	}
	public void setRideDate(String rideDate) {
		this.rideDate = rideDate;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public int getCostPerSeat() {
		return costPerSeat;
	}
	public void setCostPerSeat(int costPerSeat) {
		this.costPerSeat = costPerSeat;
	}
	
	
	
	

}
