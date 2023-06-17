package com.shopping.cartapp.sellars;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface SellarsRepository extends JpaRepository<Sellars, Long>{
	
	  @Query(value = "SELECT u.*, c.country, s.state,ci.cityName" +
	  " FROM tbl_sellars u" + " JOIN tbl_city ci ON u.city_id = ci.id" +
	  " JOIN tbl_state s ON ci.fk_state_id = s.id" +
	  " JOIN tbl_country c ON s.fk_country_id = c.id", nativeQuery = true)
	  List<Sellars> getAllSellarsWithRegion();
	  
	    @Query(value = "SELECT c FROM tbl_sellars c WHERE c.gstNumber LIKE %?1% OR c.panNumber LIKE %?1% OR c.phone LIKE %?1%")
	    List<Sellars> findByKeyword1(String keyword);

	    @Query(value = "SELECT c FROM tbl_sellars c WHERE CONCAT(c.gstNumber, c.panNumber, c.phone, c.sellarEmail) LIKE %?1%")
	    List<Sellars> findByKeyword(String keyword);
	 
	
	
//	  @Query(value = "Select * from tbl_sellars", nativeQuery = true)
	//  List<Sellars> getAllSellarsWithRegion();
		/*
		 * @Query(value = "SELECT JSON_ARRAYAGG(" + "    JSON_OBJECT(" +
		 * "        'sellarName', u.sellar_name," +
		 * "        'sellarAddress1', u.address_line1, " +
		 * "        'sellarAddress2', u.address_line2, " +
		 * "        'sellarEmail', u.sellar_email, " + "        'country', c.country, "
		 * + "        'state', s.state, " + "        'city_name', ci.city_name " +
		 * "    )" + " ) AS json_response " + " FROM tbl_sellars u " +
		 * " JOIN tbl_city ci ON u.fk_city_id = ci.id " +
		 * " JOIN tbl_state s ON ci.fk_state_id = s.id " +
		 * " JOIN tbl_country c ON s.fk_country_id = c.id ", nativeQuery = true)
		 * List<Sellars> getAllSellarsWithRegion();
		 */
	  


}
