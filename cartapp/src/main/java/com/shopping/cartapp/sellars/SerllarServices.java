package com.shopping.cartapp.sellars;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.shopping.cartapp.country.Country;


@Service
public class SerllarServices {
	
	@Autowired
	private SellarsRepository sellarRepo;
	
	public void addSellars(Sellars salers) {
		sellarRepo.save(salers);
	}
	
	public List<Sellars> getAllSellars() {
		return sellarRepo.findAll();
	}
	
	public Sellars getSellarsById(Long id) {
		return sellarRepo.findById(id).orElse(null);
	}
	
	
    public List<Sellars> getALlEmployeebyRegion(){
        return sellarRepo.getAllSellarsWithRegion();
    }

    public Page<Sellars> findPage(int pageNumber) {
		Pageable pageable = PageRequest.of(pageNumber - 1, 5);
		return sellarRepo.findAll(pageable);
	}
    
    public void delete(Long id) {
    	sellarRepo.deleteById(id);
    }

    public Sellars getById(Long id) {
        return sellarRepo.findById(id).orElse(null);
    }

    public void update(Sellars country) {
    	sellarRepo.save(country);
    }

    public List<Sellars> findByKeyword(String keyword){
        return sellarRepo.findByKeyword(keyword);
    }


    public Page<Sellars> findAllWithSort(String field, String direction, int pageNumber) {
        Sort sort = direction.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                Sort.by(field).ascending() : Sort.by(field).descending();

        Pageable pageable = PageRequest.of(pageNumber - 1, 5, sort);

        return sellarRepo.findAll(pageable);
    }
}
