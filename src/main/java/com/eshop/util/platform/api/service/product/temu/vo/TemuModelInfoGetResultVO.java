package com.eshop.util.platform.api.service.product.temu.vo;

import java.util.List;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuModelInfoGetResultVO {
    //        "total": 1,
    private Integer total;
    //        "modelList": [
    //            {
    //                "modelName": "jo ke",
    //                "supplierId": 634418217307252,
    //                "clothesModel": {
    //                    "hipline": 90.8,
    //                    "bust": 85.4,
    //                    "waist": 83.7,
    //                    "height": 178.0
    //                },
    //                "canEdit": false,
    //                "shoeModel": null,
    //                "id": 2409210004037,
    //                "modelType": 0,
    //                "headPortrait": "https://img.cdnfe.com/product/1f14f501298/038c189d-3ffd-4698-861f-1d5916db5c30_480x480.png"
    //            }
    //        ]
    private List<TemuModelInfoGetResultModelListVO> modelList;

}
