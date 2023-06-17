package com.shopping.cartapp.sellars;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.shopping.cartapp.city.City;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import model.CommonEntity;

@Entity(name = "tbl_sellars")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Sellars extends CommonEntity {
	
	@Column(name = "sellarName")
	String sellarName;
	@Column(name = "sellarEmail")
	String sellarEmail;
	@Column(name = "sellarWebsite")
	String sellarWebsite;
	@Column(name = "gstNumber")
	String gstNumber;
	@Column(name = "aadharNumber")
	String aadharNumber;
	@Column(name = "panNumber")
	String panNumber;
	@Column(name = "addressLine1")
	String addressLine1;
	@Column(name = "addressLine2")
	String addressLine2;
	@Column(name = "pincode")
	String pincode;
	@Column(name = "phone")
	String phone;
	@Column(name = "alternatephone")
	String alternatephone;
	@Column(name = "sellarDetails")
	String sellarDetails;
	@Column(name = "tinNumber")
	String tinNumber;
	
	/*
	 * @JsonIgnore
	 * 
	 * @Column(name = "fk_city_id") String fk_city_id;
	 */
	@ManyToOne
	private City city;
	  
	
	public String getSellarName() {
		return sellarName;
	}
	public void setSellarName(String sellarName) {
		this.sellarName = sellarName;
	}
	public String getSellarEmail() {
		return sellarEmail;
	}
	public void setSellarEmail(String sellarEmail) {
		this.sellarEmail = sellarEmail;
	}
	public String getSellarWebsite() {
		return sellarWebsite;
	}
	public void setSellarWebsite(String sellarWebsite) {
		this.sellarWebsite = sellarWebsite;
	}
	public String getGstNumber() {
		return gstNumber;
	}
	public void setGstNumber(String gstNumber) {
		this.gstNumber = gstNumber;
	}
	public String getAadharNumber() {
		return aadharNumber;
	}
	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}
	public String getPanNumber() {
		return panNumber;
	}
	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAlternatephone() {
		return alternatephone;
	}
	public void setAlternatephone(String alternatephone) {
		this.alternatephone = alternatephone;
	}
	public String getSellarDetails() {
		return sellarDetails;
	}
	public void setSellarDetails(String sellarDetails) {
		this.sellarDetails = sellarDetails;
	}
	public String getTinNumber() {
		return tinNumber;
	}
	public void setTinNumber(String tinNumber) {
		this.tinNumber = tinNumber;
	}
	
	public Sellars() {
		super();
		// TODO Auto-generated constructor stub
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public Sellars(String sellarName, String sellarEmail, String sellarWebsite, String gstNumber, String aadharNumber,
			String panNumber, String addressLine1, String addressLine2, String pincode, String phone,
			String alternatephone, String sellarDetails, String tinNumber, City city) {
		super();
		this.sellarName = sellarName;
		this.sellarEmail = sellarEmail;
		this.sellarWebsite = sellarWebsite;
		this.gstNumber = gstNumber;
		this.aadharNumber = aadharNumber;
		this.panNumber = panNumber;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.pincode = pincode;
		this.phone = phone;
		this.alternatephone = alternatephone;
		this.sellarDetails = sellarDetails;
		this.tinNumber = tinNumber;
		this.city = city;
	}
	
	
	


}
