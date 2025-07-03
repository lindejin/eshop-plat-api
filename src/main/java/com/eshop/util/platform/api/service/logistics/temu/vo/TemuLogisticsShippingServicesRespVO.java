package com.eshop.util.platform.api.service.logistics.temu.vo;

import com.eshop.util.platform.api.structure.BaseResponseVO;

import java.util.List;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuLogisticsShippingServicesRespVO  extends BaseResponseVO {

    private TemuLogisticsShippingServicesResultVO result;

    //"requestId": "gl-70460947-91c2-4596-a405-5d8a1ef85edd",
    private String requestId;
    //      "success": true,
    private Boolean success;
    //		"errorCode": 0,
    private Integer errorCode;
    //		"serverTime": 1730094505258,
    private Long serverTime;
    //		"errorMsg": "SUC"
    private String errorMsg;


    //vo前移
    private List<TemuLogisticsShippingServicesResultOnlineChannelVO> onlineChannelDtoList;
    private List<TemuLogisticsShippingServicesResultUnavailableChannelVO> unavailableChannelDtoList;
}
