package com.vishav.usercrud.country.mapper;

import com.vishav.usercrud.country.pojo.CountryPojo;
import com.vishav.usercrud.country.entity.CountryEntity;
import com.vishav.usercrud.country.response.CountryResponse;
import org.springframework.stereotype.Component;

@Component
public class CountryMapper {

    public CountryPojo toPojo(CountryEntity country) {
        CountryPojo pojo = new CountryPojo();
        pojo.setId(country.getId());
        pojo.setName(country.getName());
        return pojo;
    }

    public CountryEntity toEntity(CountryPojo pojo) {
        CountryEntity country = new CountryEntity();
        country.setId(pojo.getId());
        country.setName(pojo.getName());
        return country;
    }

    public CountryResponse toResponse(CountryEntity countryEntity) {
        CountryResponse response = new CountryResponse();
        response.setId(countryEntity.getId());
        response.setName(countryEntity.getName());
        response.setCuid(countryEntity.getCuid());
        response.setCreated_at(countryEntity.getCreatedAt());
        response.setUpdated_at(countryEntity.getUpdatedAt());
        return response;
    }
}