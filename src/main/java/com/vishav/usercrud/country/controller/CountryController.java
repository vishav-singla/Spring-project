package com.vishav.usercrud.country.controller;

import com.vishav.usercrud.country.pojo.CountryPojo;
import com.vishav.usercrud.country.request.dto.CountryRequest;
import com.vishav.usercrud.country.response.CountryResponse;
import com.vishav.usercrud.country.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/countries")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping
    public List<CountryResponse> getAllCountries() {
        return countryService.getAllCountries();
    }

    @GetMapping("/{id}")
    public Optional<CountryResponse> getCountry(@PathVariable Long id) {
        return countryService.getCountryById(id);
    }

    @PostMapping
    public CountryPojo createCountry(@RequestBody CountryPojo country) {
        return countryService.createCountry((CountryRequest) country);
    }

    @PutMapping("/{id}")
    public CountryPojo updateCountry(@PathVariable Long id, @RequestBody CountryPojo country) {
        return countryService.updateCountry(id, (CountryRequest) country);
    }

    @DeleteMapping("/{id}")
    public void deleteCountry(@PathVariable Long id) {
        countryService.deleteCountry(id);
    }
}