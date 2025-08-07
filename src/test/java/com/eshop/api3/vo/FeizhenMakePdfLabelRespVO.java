package com.eshop.api3.vo;

@lombok.Setter
@lombok.Getter
@lombok.ToString
public class FeizhenMakePdfLabelRespVO {

    /**
     * 返回body
     */
    private String respBody;

    /**
     * boolean
     * 必需
     */
    private Boolean success;

    /**
     * string
     * 必需
     */
    private String msg;

    /**
     * 创建运单返回对象
     */
    private FeizhenMakePdfLabelDataVO data;
}
