package com.vishav.usercrud.state.mapper;

import com.vishav.usercrud.state.entity.StateEntity;
import com.vishav.usercrud.state.request.dto.StateRequest;
import com.vishav.usercrud.state.response.StateResponse;
import org.springframework.stereotype.Component;

@Component
public class StateMapper {

    public StateEntity toEntity(StateRequest stateRequest) {
        StateEntity state = new StateEntity();
        state.setName(stateRequest.getName());
        // Here you should set the country using the countryId from the request
        return state;
    }

    public StateResponse toResponse(StateEntity stateEntity) {
        StateResponse response = new StateResponse();
        response.setId(stateEntity.getId());
        response.setName(stateEntity.getName());
        response.setCountryId(stateEntity.getCountry().getId());
        return response;
    }
}