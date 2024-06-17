package com.vishav.usercrud.country.service;

import com.vishav.usercrud.country.entity.CountryEntity;
import com.vishav.usercrud.country.request.dto.CountryRequest;
import com.vishav.usercrud.country.response.CountryResponse;
import com.vishav.usercrud.country.repository.CountryRepository;
import com.vishav.usercrud.country.mapper.CountryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private CountryMapper countryMapper;

    public List<CountryResponse> getAllCountries() {
        List<CountryEntity> countries = countryRepository.findAll();
        return countries.stream().map(countryMapper::toResponse).collect(Collectors.toList());
    }

    public Optional<CountryResponse> getCountryById(Long id) {
        return countryRepository.findById(id).map(countryMapper::toResponse);
    }

    public CountryResponse createCountry(CountryRequest countryRequest) {
        CountryEntity country = countryMapper.toEntity(countryRequest);
        CountryEntity savedCountry = countryRepository.save(country);
        return countryMapper.toResponse(savedCountry);
    }

    public CountryResponse updateCountry(Long id, CountryRequest countryDetails) {
        return countryRepository.findById(id).map(country -> {
            country.setName(countryDetails.getName());
            CountryEntity updatedCountry = countryRepository.save(country);
            return countryMapper.toResponse(updatedCountry);
        }).orElseGet(() -> {
            CountryEntity country = countryMapper.toEntity(countryDetails);
            country.setId(id);
            CountryEntity newCountry = countryRepository.save(country);
            return countryMapper.toResponse(newCountry);
        });
    }

    public void deleteCountry(Long id) {
        countryRepository.deleteById(id);
    }
}