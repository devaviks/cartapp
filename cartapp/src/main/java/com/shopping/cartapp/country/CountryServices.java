package com.shopping.cartapp.country;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CountryServices {

	@Autowired
	private CountryRepo countryRepo;

	public void addCountry(Country country) {
		countryRepo.save(country);
	}

	public List<Country> getAllCountries() {
		return countryRepo.findAll();
	}

	public Country getCoutryById(Long id) {
		return countryRepo.findById(id).orElse(null);
	}

	public Page<Country> findPage(int pageNumber) {
		Pageable pageable = PageRequest.of(pageNumber - 1, 5);
		return countryRepo.findAll(pageable);
	}
}
