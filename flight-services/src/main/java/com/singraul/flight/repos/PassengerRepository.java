package com.singraul.flight.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.singraul.flight.entity.Flight;
import com.singraul.flight.entity.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Integer> {

}
