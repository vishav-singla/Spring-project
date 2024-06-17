package com.vishav.usercrud.state.response;

import com.vishav.usercrud.state.pojo.StatePojo;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter

public class StateResponse extends StatePojo {
    private Long id;
    private String name;
    private Long countryId;
    private String countryName;
}