package com.vishav.usercrud.state.controller;

import com.vishav.usercrud.state.request.dto.StateRequest;
import com.vishav.usercrud.state.response.StateResponse;
import com.vishav.usercrud.state.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/states")

public class StateController {

    @Autowired
    private StateService stateService;

    @GetMapping
    public List<StateResponse> getAllStates() {
        return stateService.getAllStates();
    }

    @GetMapping("/{id}") public Optional<StateResponse> getState(@PathVariable Long id) {
        return stateService.getStateById(id);
    }

    @PostMapping
    public StateResponse createState(@RequestBody StateRequest state) {
        return stateService.createState(state);
    }

    @PutMapping("/{id}")
    public StateResponse updateState(@PathVariable Long id, @RequestBody StateRequest state) {
        return stateService.updateState(id, state);
    }

    @DeleteMapping("/{id}")
    public void deleteState(@PathVariable Long id) {
        stateService.deleteState(id);
    }
}