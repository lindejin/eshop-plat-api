package com.eshop.util.platform.api.service.product.temu.vo;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuModelInfoGetResultModelListVO {
    //            {
    //                "modelName": "jo ke",
    private String modelName;
    //                "supplierId": 634418217307252,
    private Long supplierId;
    //                "clothesModel": {
    //                    "hipline": 90.8,
    //                    "bust": 85.4,
    //                    "waist": 83.7,
    //                    "height": 178.0
    //                },
    private TemuModelInfoGetResultModelListVOClothesModelVO clothesModel;
    //                "canEdit": false,
    private Boolean canEdit;
    //                "shoeModel": null,
    private TemuModelInfoGetResultModelListVOShoeModelVO shoeModel;
    //                "id": 2409210004037,
    private Long id;
    //                "modelType": 0,
    private Integer modelType;
    //                "headPortrait": "https://img.cdnfe.com/product/1f14f501298/038c189d-3ffd-4698-861f-1d5916db5c30_480x480.png"
    private String headPortrait;
    //            }
}
