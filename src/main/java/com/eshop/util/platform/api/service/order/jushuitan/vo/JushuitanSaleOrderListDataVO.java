package com.eshop.util.platform.api.service.order.jushuitan.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class JushuitanSaleOrderListDataVO {

    //page_size	integer	2	每页多少条
    private Integer page_size;
    //page_index	integer	1	第几页
    private Integer page_index;
    //data_count	integer	2	总条数
    private Integer data_count;
    //page_count	integer	1	总页数
    private Integer page_count;
    //has_next	boolean	false	是否有下一页
    private Boolean has_next;
    //datas	array		数据集合
    private List<JushuitanSaleOrderVO> datas;
}
