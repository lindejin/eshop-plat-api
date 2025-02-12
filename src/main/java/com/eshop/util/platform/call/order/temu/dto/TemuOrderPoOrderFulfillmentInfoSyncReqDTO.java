package com.eshop.util.platform.call.order.temu.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TemuOrderPoOrderFulfillmentInfoSyncReqDTO {
    //orderSn	STRING	是	订单号
    private String orderSn;
    //operationTime	INTEGER	是	已发货对应仓库接收指令时间、已配送对应仓库回传运单号时间(秒级时间戳)
    private Long operationTime;
    //warehouseOperationStatus	INTEGER	是	仓库作业状态：0-已发货(仓库接收发货指令节点) 1-已配送(仓库回传运单号节点)
    private Integer warehouseOperationStatus;
    //trackingNumber	STRING	否	运单号
    private String trackingNumber;
    //warehouseBrandName	STRING	是	仓库品牌名称
    private String warehouseBrandName;
    //warehouseName	STRING	是	仓库名称
    private String warehouseName;
    //warehouseRegion1	STRING	否	仓库对应一级地址
    private String warehouseRegion1;
    //warehouseRegion2	STRING	否	仓库对应二级地址
    private String warehouseRegion2;
    //warehouseRegion3	STRING	否	仓库对应三级地址
    private String warehouseRegion3;
    //warehouseRegion4	STRING	否	仓库对应四级地址
    private String warehouseRegion4;
    //warehouseAddressLine1	STRING	否	仓库对应详细地址1
    private String warehouseAddressLine1;
    //warehouseAddressLine2	STRING	否	仓库对应详细地址2
    private String warehouseAddressLine2;
    //warehousePostCode	STRING	否	仓库所在地对应邮编
    private String warehousePostCode;
}
