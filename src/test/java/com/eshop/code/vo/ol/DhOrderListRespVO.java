package com.eshop.code.vo.ol;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DhOrderListRespVO {

    /**
     * 总页数
     * 20,表示总共20页
     */
    private Integer pages;

    /**
     * 订单基础信息列表
     * 订单基础信息列表
     */
    private List<DhOrderListItem> orderBaseInfoList;

    /**
     * 总记录数
     * 1000,表示总记录数为1000
     */
    private Integer count;

}