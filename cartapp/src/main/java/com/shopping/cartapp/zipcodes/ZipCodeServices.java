package com.shopping.cartapp.zipcodes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZipCodeServices {
	
	@Autowired
	private ZipCodeRepo zipRepo;

	public void addZipCode(ZipCode zipcode) {
		zipRepo.save(zipcode);
	}

	public List<ZipCode> getAllZipCodes() {
		return zipRepo.findAll();
	}

	public ZipCode getZipCodeById(Long id) {
		return zipRepo.findById(id).orElse(null);
	}
}
