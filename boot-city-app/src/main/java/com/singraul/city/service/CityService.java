package com.singraul.city.service;

import java.util.List;

import com.singraul.city.entity.City;

public interface CityService {
	 List<City> findByNameEndsWith(String name);
}
