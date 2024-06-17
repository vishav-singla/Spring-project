
package com.vishav.usercrud.user.pojo;

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
    private String country;
    private String state;
    private String zip;
}