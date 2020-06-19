package com.carpooling.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class RideRequest {
	
	@NotBlank
	private String source;
	
	@NotBlank
	private String destination;
	
	@NotBlank
	private String rideDate;
	
	@NotBlank
	private String carName;
	
	@NotBlank
	private String offerBy;
	
	@NotNull
	private int vacency;
	
	@NotNull
	private int costPerSeat;
	
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
	public String getRideDate() {
		return rideDate;
	}
	public void setRideDate(String rideDate) {
		this.rideDate = rideDate;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public String getOfferBy() {
		return offerBy;
	}
	public void setOfferBy(String offerBy) {
		this.offerBy = offerBy;
	}
	public int getVacency() {
		return vacency;
	}
	public void setVacency(int vacency) {
		this.vacency = vacency;
	}
	public int getCostPerSeat() {
		return costPerSeat;
	}
	public void setCostPerSeat(int costPerSeat) {
		this.costPerSeat = costPerSeat;
	}
	
	

}
