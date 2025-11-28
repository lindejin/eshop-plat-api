package com.eshop.util.platform.api.service.order.jushuitan.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JushuitanConfirmDeliverySaleOrderDataItemVO {

    //msg	string		执行结果
    private String msg;
    //issuccess	boolean		是否成功
    private Boolean issuccess;
    //o_id	integer		出库单号
    private Long o_id;
}
