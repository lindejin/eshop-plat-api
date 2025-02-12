package com.eshop.util.platform.call.order.temu.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TemuOrderPoLogisticsShipmentShipmentInfoDTOVO {

    //carrierId	INTEGER	否	物流公司ID
    private Long carrierId;
    //carrierName	STRING	否	物流公司名称
    private String carrierName;
    //trackingNumber	STRING	否	运单号
    private String trackingNumber;
    //skuId	INTEGER	否	商品skuId
    private Long skuId;
    //quantity	INTEGER	否	商品skuId对应发货数量
    private Long quantity;
    //packageSn	STRING	否	包裹号
    private String packageSn;
    //packageDeliveryType update	INTEGER	否	发货包裹履约类型，新增枚举值3和4
    //● 1：导入运单发货
    //● 2：在线下单发货
    //● 3：合作对接仓导入运单发货
    //● 4：合作对接仓在线下单发货
    private Integer packageDeliveryType;
    //cooperativeWarehouseDTO update	STRING	否	只在packageDeliveryType=3或4（合作对接仓导入运单发货/合作对接仓在线下单发货）时返回，在packageDeliveryType=1或2时，返回为空
    //a. 合作对接仓服务商编码：warehouseProviderCode：
    //b. 合作对接仓服务商名字：warehouseProviderBrandName
    //c. 合作对接仓编码：warehouseCode
    //d. 合作对接仓名字：warehouseName
    private Integer cooperativeWarehouseDTO;
    //trackingWarningLabel	INTEGER	否	运单物流提醒标签
    //0-无问题，1-查无轨迹，2-疑似有误，3-收货地址不一致，4-未揽收
    private Integer trackingWarningLabel;
    //subPackageShipmentInfoList	LIST	否	附属包裹列表
    // 当为单sku拆单发货场景时，后续增加补充的运单信息将作为附属包裹展示
    private List<TemuOrderPoLogisticsShipmentShipmentInfoDTOSubPackageShipmentInfoListVO> subPackageShipmentInfoList;
}
