package com.vishav.usercrud.state.mapper;

import com.vishav.usercrud.state.entity.StateEntity;
import com.vishav.usercrud.state.request.dto.StateRequest;
import com.vishav.usercrud.state.response.StateResponse;
import com.vishav.usercrud.country.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StateMapper {

    @Autowired
    private CountryRepository countryRepository;

    public StateEntity toEntity(StateRequest stateRequest) {
        StateEntity state = new StateEntity();
        state.setName(stateRequest.getName());
        state.setCountry(countryRepository.findById(stateRequest.getCountryId()).orElse(null));
        return state;
    }

    public StateResponse toResponse(StateEntity stateEntity) {
        StateResponse response = new StateResponse();
        response.setId(stateEntity.getId());
        response.setName(stateEntity.getName());
        response.setCountryId(stateEntity.getCountry().getId());
        response.setCountryName(stateEntity.getCountry().getName());
        return response;
    }
}