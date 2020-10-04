package com.redflag.project.city;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    CityRepository repository;

    public CityService(CityRepository cityRepository) {
        this.repository = cityRepository;
    }

    public List<City> getCities() {
        return this.repository.findAll();
    }
}
