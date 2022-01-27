package com.singraul.city.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.singraul.city.entity.City;
import com.singraul.city.repository.CityRepository;

@Service
public class CityServiceImpl implements CityService {

	@Autowired
	CityRepository cityRepo;

	@Override
	public List<City> findByNameEndsWith(String name) {

		return cityRepo.findByNameEndsWith(name);
	}

}
