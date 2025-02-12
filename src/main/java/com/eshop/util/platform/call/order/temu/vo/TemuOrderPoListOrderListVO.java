package com.eshop.util.platform.call.order.temu.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TemuOrderPoListOrderListVO {
    //orderSn	STRING	否
    private String orderSn;
    //quantity	INTEGER	否	O单应履约件数
    private Integer quantity;
    //originalOrderQuantity	INTEGER	否	用户初始下单时的 O 单件数
    private Integer originalOrderQuantity;
    //canceledQuantityBeforeShipment	INTEGER	否	O 单发货前，用户发起部分取消的件数（用户申请且退款已受理）
    private Integer canceledQuantityBeforeShipment;
    //inventoryDeductionWarehouseId	STRING	否	库存扣减仓库id
    private String inventoryDeductionWarehouseId;
    //inventoryDeductionWarehouseName	STRING	否	库存扣减仓库名称
    private String inventoryDeductionWarehouseName;
    //orderLabel 	LIST	否	子订单O单标签，内部请求异常返回为空，返回为空时请重试
    private List<TemuOrderPoListOrderListOrderLabelVO> orderLabel;


    //spec	STRING	否	商品信息描述
    private String spec;
    //thumbUrl	STRING	否	商品缩略图图片
    private String thumbUrl;
    //orderStatus	INTEGER	否	订单状态，3是已取消
    private Integer orderStatus;
    //fulfillmentTypeupdate	STRING	否	子订单履约类型
    private String fulfillmentTypeupdate;
    //goodsName	STRING	否	商品名称
    private String goodsName;
    //productList	LIST	否	货品信息
    private List<TemuOrderPoListOrderListProductListVO> productList;


    //regionId  	INTEGER	否	区域ID
    private Long regionId;
    //siteId  	INTEGER	否	站点ID
    private Long siteId;

}
