package com.shopping.cartapp.city;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shopping.cartapp.country.Country;
import com.shopping.cartapp.country.CountryServices;
import com.shopping.cartapp.state.State;
import com.shopping.cartapp.state.StateServices;

@Controller
public class CityController {
	
	@Autowired
	private CountryServices countryServices;
	
	@Autowired
	private StateServices stateServics;
	
	@Autowired
	private CityServices cityServics;

	@GetMapping("cityAdd")
	public String ZipCode(Model model) {
		List<Country> coutriesList = countryServices.getAllCountries();
		List<State> stateList = stateServics.getAllState();
		model.addAttribute("stateList", stateList);
		model.addAttribute("coutriesList", coutriesList);
		return "parameters/city/cityAdd";
	}
	@PostMapping("/addCities")
	public String addZipCode(@ModelAttribute City city) {
		cityServics.addCity(city);
		return "redirect:cityAdd";
	}
	
	
}
