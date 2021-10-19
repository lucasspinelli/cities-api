package com.lucaslevi.citiesapi.countries.repository;

import com.lucaslevi.citiesapi.countries.Entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
