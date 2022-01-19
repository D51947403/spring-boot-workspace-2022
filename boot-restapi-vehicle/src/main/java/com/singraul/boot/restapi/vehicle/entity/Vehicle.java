package com.singraul.boot.restapi.vehicle.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tt_vehicle")
public class Vehicle {

	// for primary key
	@Id
	// for auto increment
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="vehicle_id")
	private int vehicleId;
	
	@Column(name="reg_no")
	// registration number
	private String regNo;
	
	@Column(name="eng_no")
	// engine number
	private String engNo;
	
	@Column(name="chas_no")
	// Chassis Number
	private String chasNo;
	@Column(name="vehicle_model")
	// vehicle model
	private String vehicleModel;
	@Column(name="wheel_type")
	// wheel type
	private String wheelType;

	
	
	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public String getEngNo() {
		return engNo;
	}

	public void setEngNo(String engNo) {
		this.engNo = engNo;
	}

	public String getChasNo() {
		return chasNo;
	}

	public void setChasNo(String chasNo) {
		this.chasNo = chasNo;
	}
	public String getVehicleModel() {
		return vehicleModel;
	}

	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	public String getWheelType() {
		return wheelType;
	}

	public void setWheelType(String wheelType) {
		this.wheelType = wheelType;
	}

}
