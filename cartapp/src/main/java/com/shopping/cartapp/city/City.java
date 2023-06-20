package com.shopping.cartapp.city;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.shopping.cartapp.sellars.Sellars;
import com.shopping.cartapp.state.State;
import com.shopping.cartapp.zipcodes.ZipCode;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import model.CommonEntity;

@Entity(name = "tbl_city")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class City extends CommonEntity {

	String cityName;

	@ManyToOne
	@JoinColumn(name = "fk_state_id")
	private State state;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_city_id", referencedColumnName = "id")
	private List<ZipCode> zipcodes;

	@OneToMany(mappedBy = "city")
	private List<Sellars> sellars;

	public City() {
		super();
		// TODO Auto-generated constructor stub
	}

	public City(String cityName, State state, List<ZipCode> zipcodes) {
		super();
		this.cityName = cityName;
		this.state = state;
		this.zipcodes = zipcodes;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public List<ZipCode> getZipcodes() {
		return zipcodes;
	}

	public void setZipcodes(List<ZipCode> zipcodes) {
		this.zipcodes = zipcodes;
	}

}
