package com.singraul.boot.restapi.vehicle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.singraul.boot.restapi.vehicle.entity.Vehicle;
import com.singraul.boot.restapi.vehicle.repos.VehicleDao;

@RestController
public class VehicleRestController {
 
	@Autowired 
	VehicleDao vehicleDao;
	
	@RequestMapping(value="/vehicle",  method=RequestMethod.GET)
	public List<Vehicle> getAllVehicle() {
	   return	vehicleDao.findAll();
	}
	
	@RequestMapping(value="/vehicle/{vehicleId}" , method=RequestMethod.GET)
	public Vehicle getVehicleById(@PathVariable("vehicleId") int vehicleId) {
		return vehicleDao.findById(vehicleId).get();
	}
	
	@RequestMapping(value="/vehicle" , method=RequestMethod.PUT)
	public Vehicle updateVehicle(@RequestBody Vehicle vehicle) {
		// save method first check object in table
		// if present then it update
		// and if not it will create
		return vehicleDao.save(vehicle);
	}
	
	@RequestMapping(value="/vehicle" , method=RequestMethod.POST)
	public Vehicle createVehicle(@RequestBody Vehicle vehicle) {
		return vehicleDao.save(vehicle);
	}
	
	@RequestMapping(value="/vehicle/{vehicleId}" , method=RequestMethod.DELETE)
	public void deleteVehicle(@PathVariable("vehicleId") int regNo) {
		 vehicleDao.deleteById(regNo);
	}
	
}
