package com.singraul.city.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.singraul.city.entity.City;
import com.singraul.city.service.CityService;

@Controller
public class CityController {

	@Autowired
	CityService cityService;
	
	@GetMapping("/showCitiesEnding")
	public String findByNameEndsWith(Model model , @RequestParam("name") String name) {
		//System.out.println("findByNameEndsWith "+name);
		List<City> cityList= cityService.findByNameEndsWith(name);
		model.addAttribute("cityList", cityList);
		
		return "showCities";
	}
}
