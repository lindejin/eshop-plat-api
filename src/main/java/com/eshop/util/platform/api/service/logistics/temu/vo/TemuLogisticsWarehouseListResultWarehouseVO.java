package com.eshop.util.platform.api.service.logistics.temu.vo;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuLogisticsWarehouseListResultWarehouseVO {
    //                "warehouseId": "WH-10971324948630058",
    private String warehouseId;
    //                "warehouseName": "NYC-PH"
    private String warehouseName;
    //                "regionId1": 160,
    private Long regionId1;

    //                "defaultWarehouse": true,
    private Boolean defaultWarehouse;

    //                "warehouseManagementType": 1,
    private Integer warehouseManagementType;

    //                "warehouseBrand": null,
    private String warehouseBrand;

}
