package com.shopping.cartapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {

    @GetMapping("/")
    public String goHome(){
        return "login";
    }
    
    @GetMapping("/index")
    public String goIndex(){
        return "index";
    }
    
  
	/*
	 * @GetMapping("sellars") public String sellar(){ return "/sellars/index"; }
	 */
	/*
	 * @GetMapping("productcategory") public String productcategory(){ return
	 * "product/productcategory/index"; }
	 * 
	 * @GetMapping("productsubcategory") public String productsubcategory(){ return
	 * "product/productsubcategory/index"; }
	 * 
	 * @GetMapping("addproduct") public String addproduct(){ return
	 * "product/addproduct/index"; }
	 * 
	 * @GetMapping("accounts") public String accounts(){ return "/accounts/index"; }
	 * 
	 * @GetMapping("payroll") public String payroll(){ return "/payroll/index"; }
	 * 
	 * @GetMapping("helpdesk") public String helpdesk(){ return "/helpdesk/index"; }
	 */

    @GetMapping("parameters")
    public String parameters(){
        return "/parameters/index";
    }
    
    @GetMapping("sellars")
    public String sellars(){
        return "/sellars/index";
    }

	/*
	 * @GetMapping("reports") public String reports(){ return "/reports/index"; }
	 * 
	 * @GetMapping("security") public String security(){ return "/security/index"; }
	 */
}
