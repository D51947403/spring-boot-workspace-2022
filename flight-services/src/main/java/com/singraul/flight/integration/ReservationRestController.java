package com.singraul.flight.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.singraul.flight.dto.CreateReservationRequest;
import com.singraul.flight.dto.UpdateReservationRequest;
import com.singraul.flight.entity.Flight;
import com.singraul.flight.entity.Passenger;
import com.singraul.flight.entity.Reservation;
import com.singraul.flight.repos.FlightRepository;
import com.singraul.flight.repos.PassengerRepository;
import com.singraul.flight.repos.ReservationRepository;

@RestController
// to enable angular application to communicate with back end app
@CrossOrigin
@RequestMapping("/reservations")
public class ReservationRestController {

	@Autowired
	FlightRepository flightRepository;

	@Autowired
	PassengerRepository passengerRepository;

	@Autowired
	ReservationRepository reservationRepository;



	@PostMapping("/save")
	@Transactional
	public Reservation saveReservation(@RequestBody CreateReservationRequest reservationRequest) {
		Flight flight = flightRepository.findById(reservationRequest.getFlightId()).get();

		Passenger passenger = new Passenger();
		passenger.setFirstName(reservationRequest.getPassengerFirstName());
		passenger.setLastName(reservationRequest.getPassengerLastName());
		passenger.setMiddleName(reservationRequest.getPassengerMiddleName());
		passenger.setEmail(reservationRequest.getPassengerEmail());
		passenger.setPhone(reservationRequest.getPassengerPhone());

		Passenger savedpassenger = passengerRepository.save(passenger);

		Reservation reservation = new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(savedpassenger);
		reservation.setCheckedIn(false);

		return reservationRepository.save(reservation);

	}

	@GetMapping("{id}")
	public Reservation findReservation(@PathVariable("id") int id) {
		return reservationRepository.findById(id).get();
	}

	@PutMapping("/update")
	@Transactional
	public Reservation updateReservation(@RequestBody UpdateReservationRequest updateRequest) {
		Reservation reservation = reservationRepository.findById(updateRequest.getId()).get();
		reservation.setCheckedIn(updateRequest.isCheckIn());
		reservation.setNumberOfBags(updateRequest.getNumberOfBags());
		return reservationRepository.save(reservation);
	}
}
