package com.eshop.code.vo.tr;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class DhWaybillFrtTrackInfoListItem {
    /**
     * 发生时间

     */
    private String occurDate;

    /**
     * 物流方式

     */
    private String shippingtype;

    /**
     * 语言

     */
    private String language;

    /**
     * 发生事件

     */
    private String info;

    /**
     * 运单号

     */
    private String trackno;

    /**
     * 发生地点

     */
    private String place;

}