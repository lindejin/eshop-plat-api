package com.eshop.util.platform.api.service.product.temu.dto;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuModelInfoGetReqDTO {
    //参数接口	参数类型	是否必填	说明
    //modelName	STRING	否	-
    private String modelName;
    //pageNo	INTEGER	是	-
    private Integer pageNo;
    //pageSize	INTEGER	是	-
    private Integer pageSize;
    //id	INTEGER	否	-
    private Long id;
    //modelType	INTEGER	是	可选值含义说明:[0:成衣模特;1:鞋模;]
    private Integer modelType;
}
