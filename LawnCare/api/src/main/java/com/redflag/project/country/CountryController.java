package com.redflag.project.country;

import com.redflag.project.common.constants.AppConstants;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(AppConstants.API_BASE  + "countries")
public class CountryController {

    CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Country> getAllCountries () {
        return this.countryService.getAllCountries();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Country findCountryById (@Param("id") Long id) throws Exception{
        return this.countryService.getCountryById(id);
    }
}
