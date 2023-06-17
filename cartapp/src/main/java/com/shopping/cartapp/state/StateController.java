package com.shopping.cartapp.state;

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


@Controller
public class StateController {
	
	@Autowired
	private StateServices stateservices;

	@Autowired
	private CountryServices countryServices;

	@GetMapping("/stateAdd")
	public String State(Model model) {
		List<Country> coutries = countryServices.getAllCountries();
		model.addAttribute("coutriesList", coutries);
		return "parameters/state/stateAdd";
	}

	@PostMapping("/addstate")
	public String addSate(@ModelAttribute State state) {
		stateservices.addState(state);
		return "redirect:stateAdd";
	}
	
	@GetMapping("/parameters/state/{id}")
	@ResponseBody
	public State getState(@PathVariable Long id) {
		return stateservices.getStateById(id);
	}
	
	@GetMapping("/allState")
	@ResponseBody
	public List<State> getCountry() {
		return stateservices.getAllState();
	}
	
}
