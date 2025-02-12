package com.eshop.util.platform.call.order.temu.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TemuOrderPoDetailOrderListVO {

    //orderSn	STRING	否	子单号
    private String orderSn;
    //orderLabel 	LIST	否	子订单O单标签，内部请求异常返回为空，返回为空时请重试
    private List<TemuOrderPoDetailOrderListOrderLabelVO> orderLabel;

    //quantity	INTEGER	否	O单应履约件数
    //  备注：代表商家实际需要发货件数，在O单部分取消时：
    //  应履约件数=下单件数-发货前售后件数
    private Long quantity;
    //originalOrderQuantity	INTEGER	否	用户初始下单时的 O 单件数
    private Long originalOrderQuantity;
    //canceledQuantityBeforeShipmentNew 	INTEGER	否	O 单发货前，用户发起部分取消的件数（用户申请且退款已受理）
    private Long canceledQuantityBeforeShipment;
    //goodsId	INTEGER	否	商品id
    private Long goodsId;
    //skuId	LONG	否	商品skuId
    private Long skuId;
    //spec	STRING	否	商品描述
    private String spec;
    //thumbUrl	STRING	否	缩略图
    private String thumbUrl;
    //goodsName	STRING	否	商品名称
    private String goodsName;
    //orderStatus	INTEGER	否	子单状态
    private Integer orderStatus;
    //inventoryDeductionWarehouseId	STRING	否	库存扣减仓库id
    private String inventoryDeductionWarehouseId;
    //inventoryDeductionWarehouseName	STRING	否	库存扣减仓库名字
    private String inventoryDeductionWarehouseName;
    //fulfillmentType 	STRING	否	卖家履约订单值返回：fulfillBySeller 合作仓履约订单返回：fulfillByCooperativeWarehouse
    private String fulfillmentType;

    //productList	LIST	否	商品名称
    private List<TemuOrderPoDetailOrderListProductListVO> productList;


}
