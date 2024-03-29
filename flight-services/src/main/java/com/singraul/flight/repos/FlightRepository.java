package com.singraul.flight.repos;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.singraul.flight.entity.Flight;

public interface FlightRepository extends JpaRepository<Flight, Integer> {
	
	@Query("from Flight where departureCity=:departureCity and arrivalCity=:arrivalCity and dateOfDeparture=:dateOfDeparture")
	List<Flight> searchFlights(@Param("departureCity")String departureCity , @Param("arrivalCity")String arrivalCity,@Param("dateOfDeparture") Date dateOfDeparture);

}
