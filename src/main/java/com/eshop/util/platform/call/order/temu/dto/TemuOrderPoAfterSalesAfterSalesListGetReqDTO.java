package com.eshop.util.platform.call.order.temu.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TemuOrderPoAfterSalesAfterSalesListGetReqDTO {
    //parentAfterSalesSnList	LIST	是	限定查询的售后父单号列表，为空时不限定售后父单号范围
    private List<String> parentAfterSalesSnList;
    //pageNo	INTEGER	否	页码,默认第1页开始
    private Integer pageNo;
    //pageSize	INTEGER	否	页面大小,默认每页10条,max<=200
    private Integer pageSize;

}
