package com.shopping.cartapp.sellars;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shopping.cartapp.city.CityServices;
import com.shopping.cartapp.country.Country;
import com.shopping.cartapp.country.CountryServices;
import com.shopping.cartapp.state.StateServices;


@Controller
public class SellarsController {
	
	@Autowired
	private CountryServices countryServices;

	@Autowired
	private StateServices stateServics;

	@Autowired
	private CityServices cityServics;

	@Autowired
	private SerllarServices serllarServices;

	@GetMapping("sellarsaddForm")
	public String sellars(Model model) {
		List<Country> coutriesList = countryServices.getAllCountries();
		model.addAttribute("coutriesList", coutriesList);
		return "/sellars/sellarsAdd";
	}
	
	/*
	 * @GetMapping("sellarshome") public String country(Model model) { List<Sellars>
	 * sellarsList = serllarServices.getAllSellars();
	 * model.addAttribute("sellarsList", sellarsList); return "sellars/sellars"; }
	 */

	
	@PostMapping("addSellars")
	public String addZipCode(@ModelAttribute Sellars salers) {
		serllarServices.addSellars(salers);
		return "redirect:sellars";
	}

	@GetMapping("/sellars/{id}")
	@ResponseBody
	public Sellars getSellarsById(@PathVariable Long id) {
		return serllarServices.getSellarsById(id);
	}
	
	@GetMapping("sellarshome")
	public String getAllPages(Model model) {
		return getOnePage(model, 1);
	}

	@GetMapping("sellarshome/page/{pageNumber}")
	public String getOnePage(Model model, @PathVariable("pageNumber") int currentPage) {
		Page<Sellars> page = serllarServices.findPage(currentPage);
		int totalPages = page.getTotalPages();
		long totalItems = page.getTotalElements();
		List<Sellars> sellarsList = page.getContent();

		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("totalItems", totalItems);
		model.addAttribute("sellarsList", sellarsList);

		return "/sellars/sellars";
	}

	
	 @RequestMapping(value = "/sellarshome/delete/{id}", method = {RequestMethod.GET, RequestMethod.DELETE})
	    public  String delete(@PathVariable Long id){
		 serllarServices.delete(id);
	        return "redirect:/sellarshome";
	    }
	 
	 @GetMapping("/sellarshome/page/{pageNumber}/{field}")
	    public String getPageWithSort(Model model,
	                                  @PathVariable("pageNumber") int currentPage,
	                                  @PathVariable String field,
	                                  @jakarta.websocket.server.PathParam("sortDir") String sortDir) {

	        Page<Sellars> page = serllarServices.findAllWithSort(field, sortDir, currentPage);
	        List<Sellars> sellarsList = page.getContent();
	        int totalPages = page.getTotalPages();
	        long totalItems = page.getTotalElements();

	        model.addAttribute("currentPage", currentPage);
	        model.addAttribute("totalPages", totalPages);
	        model.addAttribute("totalItems", totalItems);

	        model.addAttribute("sortDir", sortDir);
	        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
	        model.addAttribute("sellarsList", sellarsList);
	        return "/parameters/countries";
	    }

	    //The Get Country By Id
	    @GetMapping("/sellarshome/{id}")
	    @ResponseBody
	    public Sellars getSellars(@PathVariable Long id){
	        return serllarServices.getById(id);
	    }

		/*
		 * @GetMapping("/parameters/countryAdd") public String addCountry(){ return
		 * "parameters/countryAdd"; }
		 */

	    //The op parameter is either Edit or Details
	    @GetMapping("/sellarshome/{op}/{id}")
	    public String editCountry(@PathVariable Long id, @PathVariable String op, Model model){
	        Sellars sellars = serllarServices.getById(id);
	        model.addAttribute("country", sellars);
	        return "/sellarshome"+ op;
	    }
	 

}
