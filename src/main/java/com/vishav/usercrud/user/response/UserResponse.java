package com.vishav.usercrud.user.response;

import lombok.Data;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class UserResponse {
    private Long id;
    private String name;
    private String email;
    private String username;

    @JsonFormat(shape = Shape.STRING, pattern = "dd-MM-yyyy", timezone = "IST")
    private Date createdAt;

    @JsonFormat(shape = Shape.STRING, pattern = "dd-MM-yyyy", timezone = "IST")
    private Date updatedAt;

    private String city;
    private String country;
    private String state;
    private String zip;
}
