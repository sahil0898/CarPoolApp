package com.carpooling.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Query;

import com.carpooling.model.User_ride;

public interface User_rideRepository extends JpaRepository<User_ride, Long>{
	
	List<User_ride> findByUserName(String userName);
	long deleteByRideId(long rideId);
	
	@Query("select count(userName) from User_ride ur where ride_id=?1 and role=?2")
	int countPassenger(long id,String role);
	
	@Query("select ur from User_ride ur where ride_id=?1 and role='passenger'")
	List<User_ride> findByRideIdAndRole(long id);

}
