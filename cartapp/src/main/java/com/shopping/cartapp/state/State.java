package com.shopping.cartapp.state;


import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.shopping.cartapp.city.City;
import com.shopping.cartapp.country.Country;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import model.CommonEntity;

@Entity(name = "tbl_state")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class State extends CommonEntity {

	@Column(name = "state", length = 200)
	String stateName;
	
	@ManyToOne
	@JoinColumn(name = "fk_country_id")
	private Country country;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_state_id", referencedColumnName = "id")
	private List<City> cities;
	

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	/*
	 * public State(Long id, int status, LocalDateTime createDate, LocalDateTime
	 * modifiedDate, String stateName, Country country, List<City> cities) {
	 * super(id, status, createDate, modifiedDate); this.stateName = stateName;
	 * this.country = country; this.cities = cities; }
	 */

	public State() {
		super();
		// TODO Auto-generated constructor stub
	}

	public State(String stateName, Country country, List<City> cities) {
		super();
		this.stateName = stateName;
		this.country = country;
		this.cities = cities;
	}

	/*
	 * public State(Long id, int status, LocalDateTime createDate, LocalDateTime
	 * modifiedDate) { super(id, status, createDate, modifiedDate); // TODO
	 * Auto-generated constructor stub }
	 */
	
	
	

	

}
