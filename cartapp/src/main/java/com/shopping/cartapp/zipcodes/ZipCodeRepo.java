package com.shopping.cartapp.zipcodes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZipCodeRepo extends JpaRepository<ZipCode, Long>{

}
