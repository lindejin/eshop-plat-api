package com.eshop.util.platform.call.order.temu.order.vo;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TemuOrderPoDetailResultResultVO {

    // parentOrderMap 父单信息
    private TemuOrderPoDetailParentOrderMapVO parentOrderMap;
    // orderList
    private List<TemuOrderPoDetailOrderListVO> orderList;
}
