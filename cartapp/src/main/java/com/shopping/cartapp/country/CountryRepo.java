package com.shopping.cartapp.country;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface CountryRepo extends JpaRepository<Country, Long>{}