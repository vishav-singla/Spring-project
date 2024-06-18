package com.vishav.usercrud.user.mapper;

import com.vishav.usercrud.country.entity.CountryEntity;
import com.vishav.usercrud.country.pojo.CountryPojo;
import com.vishav.usercrud.user.pojo.UserPojo;
import com.vishav.usercrud.user.entity.User;
import com.vishav.usercrud.user.response.UserResponse;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserPojo toPojo(User user) {
        UserPojo pojo = new UserPojo();
        pojo.setId(user.getId());
        pojo.setName(user.getName());
        pojo.setUsername(user.getUsername());
        pojo.setEmail(user.getEmail());
        pojo.setCity(user.getCity());
        pojo.setCountry(countryEntityToCountryPojo(user.getCountry()));
        pojo.setState(user.getState());
        pojo.setZip(user.getZip());
        pojo.setPassword(user.getPassword());
        return pojo;
    }

    public User toEntity(UserPojo pojo) {
        User user = new User();
        user.setId(pojo.getId());
        user.setName(pojo.getName());
        user.setUsername(pojo.getUsername());
        user.setEmail(pojo.getEmail());
        user.setCity(pojo.getCity());
        user.setCountry(countryPojoToCountryEntity(pojo.getCountry()));
        user.setState(pojo.getState());
        user.setZip(pojo.getZip());
        user.setPassword(pojo.getPassword());
        return user;
    }

    public UserResponse toResponse(User user) {
        UserResponse response = new UserResponse();
        response.setId(user.getId());
        response.setName(user.getName());
        response.setUsername(user.getUsername());
        response.setEmail(user.getEmail());
        response.setCreatedAt(user.getCreatedAt());
        response.setUpdatedAt(user.getUpdatedAt());
        response.setCity(user.getCity());
        response.setCountry(user.getCountry().getName());
        response.setState(user.getState());
        response.setZip(user.getZip());
        return response;
    }

    public CountryEntity countryPojoToCountryEntity(CountryPojo countryPojo) {
        CountryEntity countryEntity = new CountryEntity();
        countryEntity.setId(countryPojo.getId());
        countryEntity.setName(countryPojo.getName());
        return countryEntity;
    }

    public CountryPojo countryEntityToCountryPojo(CountryEntity countryEntity) {
        CountryPojo countryPojo = new CountryPojo();
        countryPojo.setId(countryEntity.getId());
        countryPojo.setName(countryEntity.getName());
        return countryPojo;
    }
}