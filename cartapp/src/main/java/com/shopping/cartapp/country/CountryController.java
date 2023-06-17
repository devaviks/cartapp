package com.shopping.cartapp.country;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CountryController {

	@Autowired
	private CountryServices countryServices;

	@GetMapping("countryAdd")
	public String country() {
		return "parameters/country/countryAdd";
	}

	@GetMapping("/parameters/country/countries")
	public String getAllPages(Model model) {
		return getOnePage(model, 1);
	}

	@GetMapping("/parameters/country/countries/page/{pageNumber}")
	public String getOnePage(Model model, @PathVariable("pageNumber") int currentPage) {
		Page<Country> page = countryServices.findPage(currentPage);
		int totalPages = page.getTotalPages();
		long totalItems = page.getTotalElements();
		List<Country> countries = page.getContent();

		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("totalItems", totalItems);
		model.addAttribute("countries", countries);

		return "/parameters/country/countries";
	}

	@PostMapping("/savecountry")
	public String addCounry(@ModelAttribute Country cnt) {
		countryServices.addCountry(cnt);
		return "redirect:countryAdd";
	}

	@GetMapping("/parameters/country/{id}")
	@ResponseBody
	public Country getCountry(@PathVariable Long id) {
		return countryServices.getCoutryById(id);
	}

	@GetMapping("/allcountries")
	@ResponseBody
	public List<Country> getCountry() {
		return countryServices.getAllCountries();
	}
}
