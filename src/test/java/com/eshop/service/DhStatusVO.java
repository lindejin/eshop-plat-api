package com.eshop.service;

import com.alibaba.fastjson.JSONArray;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DhStatusVO {

    // "code": "00000000",
    private String code;
    // "message": "OK",
    private String message;
    // "solution": "",
    private String solution;
    // "subErrors": []
    private JSONArray subErrors;
}
