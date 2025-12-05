package com.eshop.douyin.print;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Address {
    private String cityName;
    private String countryCode;
    private String detailAddress;
    private String districtName;
    private String provinceName;
    private String streetName;
}
