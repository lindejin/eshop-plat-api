package com.eshop.util.platform.call.order.temu.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TemuOrderPoAfterSalesAfterSalesListGetResultBaseVO {

    //total	LONG	是	总记录数
    private Long total;
    //pageNumber	INTEGER	是	分页数
    private Long pageNumber;
    //data	LIST	是	此次查询返回的记录数据
    private List<TemuOrderPoAfterSalesAfterSalesListGetResultBaseDataVO> data;
}
