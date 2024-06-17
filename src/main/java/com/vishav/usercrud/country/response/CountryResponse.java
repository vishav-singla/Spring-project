package com.vishav.usercrud.country.response;

import com.vishav.usercrud.country.pojo.CountryPojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CountryResponse extends CountryPojo {
    private Long id;
    private String name;
    private String cuid;
    @JsonFormat(shape = Shape.STRING, pattern = "dd-MM-yyyy", timezone = "IST")
    private Date created_at;

    @JsonFormat(shape = Shape.STRING, pattern = "dd-MM-yyyy", timezone = "IST")
    private Date updated_at;
}
