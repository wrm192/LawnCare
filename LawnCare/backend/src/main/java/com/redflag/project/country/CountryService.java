package com.redflag.project.country;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    CountryRepository repository;

    public CountryService(CountryRepository repository) {
        this.repository = repository;
    }

    public List<Country> getAllCountries() {
        return this.repository.findAll();
    }


    public Country getCountryById(Long countryId) throws Exception {
        Optional<Country> country = this.repository.findById(countryId);

        if(country.isPresent()) {
            return country.get();
        } else {
            throw new Exception();
        }
    }
}
