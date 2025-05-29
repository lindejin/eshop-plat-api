package com.eshop.util.platform.api.service.media.temu.vo;

import com.eshop.util.platform.api.structure.BaseResponseVO;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuGoodsTextToPictureAddRespVO extends BaseResponseVO {

    //{
    //    "result": {
    //        "imageUrl": "https://img.cdnfe.com/product/dc9beaf5/17260147-4a2f-48b4-a45b-cbe5352a04e2.jpeg"
    //    },
    private TemuGoodsTextToPictureAddResultVO result;
    //    "success": true,
    private Boolean success;
    //    "requestId": "cn-fb92c2cd-4eb3-46b5-b86b-53cb63e6b809",
    private String requestId;
    //    "errorCode": 1000000,
    private Integer errorCode;
    //    "errorMsg": ""
    private String errorMsg;
    //}


    //额外处理返回结果
    private String imageUrl;
}
