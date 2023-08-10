package com.singraul.flight.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.singraul.flight.entity.Flight;
import com.singraul.flight.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

}
