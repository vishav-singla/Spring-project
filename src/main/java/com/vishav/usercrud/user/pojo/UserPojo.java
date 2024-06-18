
package com.vishav.usercrud.user.pojo;

import com.vishav.usercrud.country.pojo.CountryPojo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserPojo{
    private Long id;
    private String name;
    private String password;
    private String email;
    private String city;
//    private String country;
    private CountryPojo country;
    private String state;
    private String zip;
    private String username;
}