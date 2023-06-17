package com.shopping.cartapp.zipcodes;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.shopping.cartapp.city.City;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import model.CommonEntity;

@Entity(name="tbl_deliverable_zipcodes")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class ZipCode extends CommonEntity {
	
	@Column(name = "zipcodes", length = 20)
	String zipcodes;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "fk_city_id")
	private City city;
	
	public ZipCode() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public ZipCode(String zipcodes, City city) {
		super();
		this.zipcodes = zipcodes;
		this.city = city;
	}



	public String getZipcodes() {
		return zipcodes;
	}

	public void setZipcodes(String zipcodes) {
		this.zipcodes = zipcodes;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}
}
