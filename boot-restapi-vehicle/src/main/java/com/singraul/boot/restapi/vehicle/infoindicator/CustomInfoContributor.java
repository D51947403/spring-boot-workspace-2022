package com.singraul.boot.restapi.vehicle.infoindicator;

import org.springframework.boot.actuate.info.Info.Builder;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;
@Component
public class CustomInfoContributor implements InfoContributor {

	@Override
	public void contribute(Builder builder) {
		
		builder.withDetail("vehicle-app", "This is Vehicle crud application");

	}

}
