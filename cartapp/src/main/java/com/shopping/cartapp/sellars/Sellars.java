package com.shopping.cartapp.sellars;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.shopping.cartapp.city.City;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.CommonEntity;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
	@Column(name = "password")
	String password;

	@ManyToOne
	private City city;
}
