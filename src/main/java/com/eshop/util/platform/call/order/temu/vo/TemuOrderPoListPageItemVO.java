package com.eshop.util.platform.call.order.temu.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TemuOrderPoListPageItemVO {

    //parentOrderMap
    private TemuOrderPoListParentOrderMapVO parentOrderMap;
    //orderList
    private List<TemuOrderPoListOrderListVO> orderList;

}
