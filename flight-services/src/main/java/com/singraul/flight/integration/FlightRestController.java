package com.singraul.flight.integration;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.singraul.flight.entity.Flight;
import com.singraul.flight.repos.FlightRepository;

@RestController
//to enable angular application to communicate with back end app
@CrossOrigin
@RequestMapping("/flights")
public class FlightRestController {
	
	@Autowired
	FlightRepository flightRepository;

	
	@GetMapping
	public List<Flight> findFlights() {
		return flightRepository.findAll();
	}
	
	@GetMapping("{id}")
	public Flight findFlightById(@PathVariable("id") int id) {
		return flightRepository.findById(id).get();
	}
	
	@GetMapping("/search")
	public List<Flight> searchFlights(@RequestParam("departureCity")String departureCity , @RequestParam("arrivalCity")String arrivalCity,
			@RequestParam("dateOfDeparture") @DateTimeFormat(pattern="MM-dd-yyy") Date dateOfDeparture) {
		return flightRepository.searchFlights(departureCity, arrivalCity, dateOfDeparture);
	}
}
