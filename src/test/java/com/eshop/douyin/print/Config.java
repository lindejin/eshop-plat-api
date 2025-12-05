package com.eshop.douyin.print;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Config {
    private String packageNumber; // 包裹号，格式如"1/3"
}
