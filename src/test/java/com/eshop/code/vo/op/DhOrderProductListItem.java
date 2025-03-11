package com.eshop.code.vo.op;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DhOrderProductListItem {
    /**
     * 包装重量
     * 示例值：10.00
     */
    private Double grossWeight;

    /**
     * 产品数量
     * 示例值：10,如果单位是件，则为10件，如果单位是包，则是10包
     */
    private Long itemCount;

    /**
     * 产品编号
     * 产品最终页的URL中有产品编码；示例值:184942450
     */
    private String itemcode;

    /**
     * 产品包装尺寸:宽
     * 单位：cm，示例值：10.00
     */
    private Double width;

    /**
     * 产品地址URL
     * 示例值：product/test-20130828001/151000415.html
     */
    private String itemUrl;

    /**
     * 商品售卖单位
     * 示例值：包、件、套、千克、千米
     */
    private String measureName;

    /**
     * 是否定制商品
     * 1：是
     */
    private Integer isCustomer;

    /**
     * 产品图片URL
     * 示例值：100x100/albu_255699841_00
     */
    private String itemImage;

    /**
     * 产品打包数量
     * 大于1表示按包买，同时也代表每包的数量,<=1表示非按包买，itemCount代表购买数量，示例值：10
     */
    private Long packingQuantity;

    /**
     * 产品单价
     * 示例值：100.00
     */
    private Double itemPrice;

    /**
     * 商品编码Id
     * 示例值：000000000000000000000
     */
    private String skuId;

    /**
     * 产品包装尺寸:高
     * 单位：cm，示例值：10.00
     */
    private Double height;

    /**
     * 定制商品对象
     * isCustomer = 1此对象才有值
     */
    private DhOrderProductRespVO customerDTO;

    /**
     * 产品属性
     * 示例值：颜色、大小、尺码等
     */
    private String itemAttr;

    /**
     * 产品包装尺寸:长
     * 单位：cm，示例值：10.00
     */
    private Double length;

    /**
     * 产品类目
     * 示例值：Martial Arts Clothing, Shoes & Accessories
     */
    private String categoryName;

    /**
     * 产品名称
     * 示例值:Bluetooth Mini Speakers
     */
    private String itemName;

    /**
     * 商品编码
     * 示例值：W00000001
     */
    private String skuCode;

    /**
     * 买家备注
     * 示例值：易碎，轻拿轻放
     */
    private String buyerRemark;

}