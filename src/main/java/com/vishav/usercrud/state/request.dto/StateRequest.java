package com.vishav.usercrud.state.request.dto;

import com.vishav.usercrud.state.pojo.StatePojo;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter


public class StateRequest extends StatePojo{
    private String name;
    private Long countryId;
    private String countryName;
}