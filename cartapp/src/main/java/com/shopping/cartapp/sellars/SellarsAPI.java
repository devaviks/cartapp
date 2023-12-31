package com.shopping.cartapp.sellars;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("/api/v1/sellars")
@RestController
public class SellarsAPI {

    @Autowired
    private SerllarServices serllarServices;

    @GetMapping("/allSellars")
    @ResponseBody
    public List<Sellars> getAllSellarsWithRegion() {
        return serllarServices.getALlEmployeebyRegion();
    }

}
