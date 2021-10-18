package com.lucaslevi.citiesapi;

import com.lucaslevi.citiesapi.countries.Country;
import com.lucaslevi.citiesapi.repository.CountryRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryResource {

    private CountryRepository repository;

    @GetMapping()
    public List<Country> countries(){
        return repository.findAll();
    }
}
