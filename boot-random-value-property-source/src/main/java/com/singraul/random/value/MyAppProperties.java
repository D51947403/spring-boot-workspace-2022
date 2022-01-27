package com.singraul.random.value;

import java.util.UUID;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//@Value
//or
@ConfigurationProperties("app")
@Component
public class MyAppProperties {

	private int locationX;
	private int locationY;
	private int userAge;
	private int maxUsers;
	private long refreshRateMilli;
	private long initialDelayMilli;
	private String userPassword;
	private UUID instanceId;
	public int getLocationX() {
		return locationX;
	}
	public void setLocationX(int locationX) {
		this.locationX = locationX;
	}
	public int getLocationY() {
		return locationY;
	}
	public void setLocationY(int locationY) {
		this.locationY = locationY;
	}
	public int getUserAge() {
		return userAge;
	}
	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}
	public int getMaxUsers() {
		return maxUsers;
	}
	public void setMaxUsers(int maxUsers) {
		this.maxUsers = maxUsers;
	}
	public long getRefreshRateMilli() {
		return refreshRateMilli;
	}
	public void setRefreshRateMilli(long refreshRateMilli) {
		this.refreshRateMilli = refreshRateMilli;
	}
	public long getInitialDelayMilli() {
		return initialDelayMilli;
	}
	public void setInitialDelayMilli(long initialDelayMilli) {
		this.initialDelayMilli = initialDelayMilli;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public UUID getInstanceId() {
		return instanceId;
	}
	public void setInstanceId(UUID instanceId) {
		this.instanceId = instanceId;
	}
	@Override
	public String toString() {
		return "MyAppProperties [locationX=" + locationX + ", locationY=" + locationY + ", userAge=" + userAge
				+ ", maxUsers=" + maxUsers + ", refreshRateMilli=" + refreshRateMilli + ", initialDelayMilli="
				+ initialDelayMilli + ", userPassword=" + userPassword + ", instanceId=" + instanceId + "]";
	}
	
	
}
