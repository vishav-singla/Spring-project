package com.vishav.usercrud.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private Long id;
    private String name;
    private String email;
    private String city;
    private String country;
    private String state;
    private String zip;
}