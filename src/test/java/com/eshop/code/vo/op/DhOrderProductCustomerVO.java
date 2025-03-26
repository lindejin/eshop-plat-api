package com.eshop.code.vo.op;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DhOrderProductCustomerVO {
    /**
     * 定制商品Logo是否勾选
     * 1：是
     */
    private Integer customerLogo;

    /**
     * 定制商品Packing是否勾选
     * 1：是
     */
    private Integer customerPacking;

    /**
     * 定制商品Color是否勾选
     * 1：是
     */
    private Integer customerColor;

    /**
     * 定制商品备注
     */
    private String customerRemark;

    /**
     * 定制商品Graphic是否勾选
     * 1：是
     */
    private Integer customerGraphic;

    /**
     * 定制商品图片地址
     * 多个,相隔
     */
    private String customerImageList;

    /**
     * 定制商品Logo是否勾选
     * 1：是
     */
    private Integer customerDesign;

    /**
     * 定制商品Size是否勾选
     * 1：是
     */
    private Integer customerSize;

}
