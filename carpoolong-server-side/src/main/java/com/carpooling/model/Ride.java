package com.carpooling.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Ride {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long rideId;
	
	@NotBlank
	private String source;
	
	@NotBlank
	private String destination;
	
	@NotBlank
	private String rideDate;
	
	@NotNull
	private int vacency;
	
	@NotNull
	private int costPerSeat;
	
	@NotBlank
	private String carName;
	
	@NotBlank
	private String offerBy;
	
	/*
	@OneToMany(mappedBy="ride")
	private Set<String> rider=new HashSet<>();
	*/
	
	public Ride() {}
	
	public Ride(String source,String destination,String rideDate, int vacency,
			int costPerSeat,String carName,String offerBy) {
		//super();
		this.source = source;
		this.destination = destination;
		this.rideDate = rideDate;
		this.vacency = vacency;
		this.costPerSeat = costPerSeat;
		this.carName = carName;
		this.offerBy=offerBy;
	}
	public long getId() {
		return rideId;
	}
	public void setId(long rideId) {
		this.rideId = rideId;
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
	public String getRideDate() {
		return rideDate;
	}
	public void setRideDate(String rideDate) {
		this.rideDate = rideDate;
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
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	
	/*
	public Set<String> getRides() {
		return rider;
	}
	public void setRides(Set<String> rider) {
		this.rider = rider;
	}
	*/
	public String getOfferBy() {
		return offerBy;
	}
	public void setOfferBy(String offerBy) {
		this.offerBy = offerBy;
	}
	@Override
	public String toString() {
		return "Ride [rideId=" + rideId + ", source=" + source + ", destination=" + destination + ", rideDate="
				+ rideDate + ", vacency=" + vacency + ", costPerSeat=" + costPerSeat + ", carName=" + carName
				+ ", offerBy=" + offerBy + "]";
	}
	
	
	
	
	
	
		

}
