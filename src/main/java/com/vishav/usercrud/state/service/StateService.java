package com.vishav.usercrud.state.service;

import com.vishav.usercrud.state.entity.StateEntity;
import com.vishav.usercrud.state.mapper.StateMapper;
import com.vishav.usercrud.state.repository.StateRepository;
import com.vishav.usercrud.state.request.dto.StateRequest;
import com.vishav.usercrud.state.response.StateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StateService {

    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private StateMapper stateMapper;

    public List<StateResponse> getAllStates() {
        List<StateEntity> states = stateRepository.findAll();
        return states.stream().map(stateMapper::toResponse).collect(Collectors.toList());
    }

    public Optional<StateResponse> getStateById(Long id) {
        return stateRepository.findById(id).map(stateMapper::toResponse);
    }

    public StateResponse createState(StateRequest stateRequest) {
        StateEntity state = stateMapper.toEntity(stateRequest);
        StateEntity savedState = stateRepository.save(state);
        return stateMapper.toResponse(savedState);
    }

    public StateResponse updateState(Long id, StateRequest stateDetails) {
        return stateRepository.findById(id).map(state -> {
            state.setName(stateDetails.getName());
            // Here you should update the country using the countryId from the request
            StateEntity updatedState = stateRepository.save(state);
            return stateMapper.toResponse(updatedState);
        }).orElseGet(() -> {
            StateEntity state = stateMapper.toEntity(stateDetails);
            state.setId(id);
            StateEntity newState = stateRepository.save(state);
            return stateMapper.toResponse(newState);
        });
    }

    public void deleteState(Long id) {
        stateRepository.deleteById(id);
    }
}