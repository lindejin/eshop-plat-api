package com.eshop.douyin.print;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SenderInfo {
    private Address address;
    private Contact contact;
}