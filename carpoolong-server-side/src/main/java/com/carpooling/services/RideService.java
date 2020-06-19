package com.carpooling.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.carpooling.dao.RideRepository;
import com.carpooling.dao.UserRepository;
import com.carpooling.dao.User_rideRepository;
import com.carpooling.model.Ride;
import com.carpooling.model.User;
import com.carpooling.model.User_ride;
import com.carpooling.response.DetailsForProvider;
import com.carpooling.response.RideDetails;
import com.carpooling.response.ShowRides;

@Service
@Transactional
public class RideService {
	@Autowired
	RideRepository riderepo;
	
	@Autowired
	User_rideRepository user_riderepo;
	
	@Autowired
	UserRepository userrepo;
	
	
	
	public int updateRide(long rideId) {
		Ride ride=riderepo.findById(rideId).orElse(null);
		if(ride==null) {
			return 0;
		}
		else if(ride.getVacency()>0) {
			ride.setVacency(ride.getVacency()-1);
			return 1;
		}
		else 
			return 0;
	}
	
	public List<ShowRides> MyRides(String userName) {
		List<ShowRides> ridesList=new ArrayList<>();
		List<User_ride> user_rideList=user_riderepo.findByUserName(userName);
		if(user_rideList.size()==0) {
			return null;
		}
		else {
			for(int i=0;i<user_rideList.size();i++) {
				ShowRides showRides=new ShowRides();
				User_ride user_ride =user_rideList.get(i);
				showRides.setId(user_ride.getId());
				showRides.setRideId(user_ride.getRideId());
				showRides.setRole(user_ride.getRole());
				//showRides.setUserName(userName);
				Ride ride= riderepo.findById(user_ride.getRideId()).orElse(null);
				showRides.setCarName(ride.getCarName());
				showRides.setDestination(ride.getDestination());
				showRides.setSource(ride.getSource());
				showRides.setRideDate(ride.getRideDate());
				showRides.setCostPerSeat(ride.getCostPerSeat());
				showRides.setOfferedBy(ride.getOfferBy());
				ridesList.add(showRides);				
			}
		}
		return ridesList;
	}
	
	@Transactional
	public RideDetails detailsForPassenger(long id,String userName) {
		Ride ride=riderepo.findById(id).orElse(null);
		RideDetails rideDetails=new RideDetails();
		rideDetails.setSource(ride.getSource());
		rideDetails.setDestination(ride.getDestination());
		rideDetails.setRideDate(ride.getRideDate());
		rideDetails.setVacency(ride.getVacency());
		rideDetails.setCount(user_riderepo.countPassenger(id, "passenger"));
		User user=userrepo.findByUsername(userName).orElse(null);
		rideDetails.setEmailAddress(user.getEmail());
		rideDetails.setMobileNumber(user.getMobileNumber());
		rideDetails.setName(user.getFullName());
		return rideDetails;
		 
	}
	
	@Transactional
	public List<DetailsForProvider> completeRideDetailsList(List<User_ride> user_rides) {
		if (user_rides.size()==0) {
			return null;
		}
		else {
			List<DetailsForProvider> detailsForProviderList=new ArrayList<>();
			for(int i=0;i<user_rides.size();i++) {
				User user=userrepo.findByUsername(user_rides.get(i).getUserName()).orElse(new User());
				DetailsForProvider detailsForProvider=new DetailsForProvider(user.getFullName(),user.getEmail(),
						user.getMobileNumber());
				detailsForProviderList.add(detailsForProvider);
			}
			return detailsForProviderList;
		}
	}
}
