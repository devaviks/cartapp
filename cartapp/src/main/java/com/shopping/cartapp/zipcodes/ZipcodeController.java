package com.shopping.cartapp.zipcodes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shopping.cartapp.city.City;
import com.shopping.cartapp.city.CityServices;
import com.shopping.cartapp.country.Country;
import com.shopping.cartapp.country.CountryServices;
import com.shopping.cartapp.state.State;
import com.shopping.cartapp.state.StateServices;

@Controller
public class ZipcodeController {
	
	@Autowired
	private CountryServices countryServices;
	@Autowired
	private StateServices stateServics;
	@Autowired
	private ZipCodeServices zipServics;
	@Autowired
	private CityServices cityServics;
	
	@GetMapping("deliveryzipcodes")
	public String ZipCode(Model model) {
		List<Country> coutriesList = countryServices.getAllCountries();
		List<State> stateList = stateServics.getAllState();
		List<City> cityList = cityServics.getAllcities();
		model.addAttribute("coutriesList", coutriesList);
		model.addAttribute("stateList", stateList);
		model.addAttribute("cityList", cityList);
		return "parameters/deliveryzipcodes/deliveryzipcodes";
	}

	@PostMapping("/addZipCodes")
	public String addZipCode(@ModelAttribute ZipCode state) {
		zipServics.addZipCode(state);
		return "redirect:deliveryzipcodes";
	}
	
	
	

}
