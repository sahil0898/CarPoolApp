package com.carpooling.controller;


import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carpooling.dao.RideRepository;
import com.carpooling.dao.User_rideRepository;
import com.carpooling.model.Ride;
import com.carpooling.model.User_ride;
import com.carpooling.request.OfferedRides;
import com.carpooling.request.RideRequest;
import com.carpooling.response.DetailsForProvider;
import com.carpooling.response.MessageResponse;
import com.carpooling.response.RideDetails;
import com.carpooling.response.ShowRides;
import com.carpooling.services.RideService;
//import com.carpooling.services.BookARideService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
	
	@Autowired
	private RideRepository riderepo;
	
	@Autowired
	private User_rideRepository user_rideRepo;
	
	@Autowired
	private RideService rideService;
	//@Autowired
	//private BookARideService bookARideService;
	
	@GetMapping("/all")
	public String allAccess() {
		return "Public Content.";
	}
	
	@GetMapping("/findRideByDate/{date}/{userName}")
	@PreAuthorize("hasRole('USER')")
	public List<Ride> findByDate(@PathVariable String date,@PathVariable String userName){
		List<Ride> rides=riderepo.findByRideDateAndVaceny(date,userName);
		if(rides.size()>0)
			return rides;
		else 
			return null;
	}
	
	@GetMapping("/user")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public String userAccess() {
		return "User Content.";
	}
	
	@PostMapping("/bookARide")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<?> bookRide(@Valid @RequestBody User_ride ride){
		
		long rideId=ride.getRideId();
		if(rideService.updateRide(rideId)==1) {
			user_rideRepo.save(ride);
			return ResponseEntity.ok(new MessageResponse("Booked"));
		}
		return (ResponseEntity<?>) ResponseEntity.badRequest();
	}
	
	@PostMapping("/offerRide")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<?> addRide(@Valid @RequestBody RideRequest ride) {
		
		//Have to add Error Condition.
		
		Ride ride1=new Ride(ride.getSource(),ride.getDestination(),ride.getRideDate(),ride.getVacency(),
				ride.getCostPerSeat(),ride.getCarName(),ride.getOfferBy());
		riderepo.save(ride1);
		
		User_ride user_ride=new User_ride(ride1.getId(),ride.getOfferBy(),"driver");
		user_rideRepo.save(user_ride);
		
		return ResponseEntity.ok(new MessageResponse("Ride added successfully!"+ride1.getId()));
		//return "Added Successfully";
	}
	
	@GetMapping("/seeOfferedRides/{username}")
	@PreAuthorize("hasRole('USER')")
	public Optional<Ride> seeOfferedRides(@PathVariable String username ){
		//add error condition;
		System.out.print(username);
		Optional<Ride> ride=riderepo.findByOfferBy(username);
		System.out.print(ride.toString());
		return ride;
	}
	
	@GetMapping("/myrides/{userName}")
	@PreAuthorize("hasRole('USER')")
	public List<ShowRides> myRides(@PathVariable String userName) {
			return rideService.MyRides(userName);
	}
	
	@GetMapping("/deletepassenger/{id}/{userName}/{rideId}")
	@PreAuthorize("hasRole('USER')")
	public List<ShowRides> myRides(@PathVariable long id, @PathVariable String userName,@PathVariable long rideId){
		Ride ride=riderepo.findById(rideId).orElse(new Ride());
		ride.setVacency(ride.getVacency()+1);
		riderepo.save(ride);
		user_rideRepo.deleteById(id);
		return rideService.MyRides(userName);
	}
	
	@Transactional
	@GetMapping("/deletedriverandpassenger/{id}/{userName}")
	@PreAuthorize("hasRole('USER')")
	public List<ShowRides> allRides(@PathVariable long id, @PathVariable String userName){
		riderepo.deleteById(id);
		user_rideRepo.deleteByRideId(id);
		
		return rideService.MyRides(userName);
	}
	
	@Transactional
	@GetMapping("/ridedetails/{id}/{userName}")
	@PreAuthorize("hasRole('USER')")
	public RideDetails rideDetails(@PathVariable long id,@PathVariable String userName) {
		return rideService.detailsForPassenger(id, userName);
		
	}
	
	@Transactional
	@GetMapping("detailsforprovider/{id}")
	//@PreAuthorize("hasRole('USER')")
	public List<DetailsForProvider> detailsForProvider(@PathVariable long id) {
		List<User_ride> user_rideList=user_rideRepo.findByRideIdAndRole(id);
		return rideService.completeRideDetailsList(user_rideList);
		
	}

	@GetMapping("/mod")
	@PreAuthorize("hasRole('MODERATOR')")
	public String moderatorAccess() {
		return "Moderator Board.";
	}
	

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return "Admin Board.";
	} 
}