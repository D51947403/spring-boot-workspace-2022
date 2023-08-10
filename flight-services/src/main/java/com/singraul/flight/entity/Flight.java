package com.singraul.flight.entity;

import java.sql.Date;
import java.sql.Timestamp;

import jakarta.persistence.Entity;

@Entity
public class Flight extends AbstractEntity{
	
	private String flightNumber;
	private String operatingAirlines;
	private String departureCity;
	private String arrivalCity;
	private Date dateOfDeparture;
	private Timestamp estimatedDepartureTime;


	public String getFlightnumber() {
		return flightNumber;
	}

	public void setFlightnumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getOperatingAirLines() {
		return operatingAirlines;
	}

	public void setOperatingAirLines(String operatingAirLines) {
		this.operatingAirlines = operatingAirLines;
	}

	public String getDepartureCity() {
		return departureCity;
	}

	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}

	public String getArrivalCity() {
		return arrivalCity;
	}

	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}

	public Date getDateOfDeparture() {
		return dateOfDeparture;
	}

	public void setDateOfDeparture(Date dateOfDeparture) {
		this.dateOfDeparture = dateOfDeparture;
	}

	public Timestamp getEstimatedDepartureTime() {
		return estimatedDepartureTime;
	}

	public void setEstimatedDepartureTime(Timestamp estimatedDepartureTime) {
		this.estimatedDepartureTime = estimatedDepartureTime;
	}

}
