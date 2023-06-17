package com.shopping.cartapp.country;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.shopping.cartapp.state.State;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import model.CommonEntity;

@Entity(name = "tbl_country")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Country extends CommonEntity {

	@Column(name = "country", length = 200, nullable = false, columnDefinition = "text")
	String countryName;

	@Column(name = "code", length = 4, nullable = false, columnDefinition = "text")
	String countryCode;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_country_id", referencedColumnName = "id")
	private List<State> states;

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public List<State> getStates() {
		return states;
	}

	public void setStates(List<State> states) {
		this.states = states;
	}

	public Country(Long id, String countryName, String countryCode, List<State> states) {
		super();
		this.countryName = countryName;
		this.countryCode = countryCode;
		this.states = states;
	}

	public Country() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Country(String countryName, String countryCode, List<State> states) {
		super();
		this.countryName = countryName;
		this.countryCode = countryCode;
		this.states = states;
	}

}
