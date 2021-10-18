package com.lucaslevi.citiesapi.repository;

import com.lucaslevi.citiesapi.countries.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
