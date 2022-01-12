package com.singraul.boot.country;

import org.springframework.stereotype.Component;

@Component
public class Country {
  
	public String getCountryName() {
		System.out.println("Country Name : India");
		System.out.println("Country Capital : Delhi");
		System.out.println("Prime Minister : Narendra Modi");
		System.out.println("President : Ramnath Kovind");
		return "India";
	}
}
