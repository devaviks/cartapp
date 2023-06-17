package com.shopping.cartapp.city;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServices {

	@Autowired
	private CityRepo cityRepo;
	
	public void addCity(City city) {
		cityRepo.save(city);
	}

	public List<City> getAllcities() {
		return cityRepo.findAll();
	}

	public City getCityById(Long id) {
		return cityRepo.findById(id).orElse(null);
	}
	
}
