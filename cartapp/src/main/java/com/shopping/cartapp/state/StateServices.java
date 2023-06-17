package com.shopping.cartapp.state;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.cartapp.country.Country;


@Service
public class StateServices {
	
	
	@Autowired
	private StateRepo stateRepo;
	
	public void addState(State s) {
		stateRepo.save(s);
	}
	
	public List<State> getAllState() {
		return stateRepo.findAll();
	}

	
	public State getStateById(Long id) {
		return stateRepo.findById(id).orElse(null);
	}
}
