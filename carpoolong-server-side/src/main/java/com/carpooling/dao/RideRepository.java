package com.carpooling.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.carpooling.model.Ride;

public interface RideRepository extends JpaRepository<Ride, Long> {
	Optional<Ride> findByOfferBy(String userName);
	
	@Query("select r from Ride r where rideDate=?1 And vacency>0 and offerBy != ?2")
	List<Ride> findByRideDateAndVaceny(String date,String userName);

}
