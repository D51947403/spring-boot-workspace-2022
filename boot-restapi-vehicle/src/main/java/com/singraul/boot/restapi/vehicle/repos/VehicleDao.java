package com.singraul.boot.restapi.vehicle.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.singraul.boot.restapi.vehicle.entity.Vehicle;

public interface VehicleDao extends JpaRepository<Vehicle, Integer> {

}
