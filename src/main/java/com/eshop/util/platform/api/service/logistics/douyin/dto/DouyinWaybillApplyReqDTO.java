package com.eshop.util.platform.api.service.logistics.douyin.dto;

import java.util.List;

@lombok.Getter
@lombok.Setter
public class DouyinWaybillApplyReqDTO {
    //waybill_applies List  请求结构体
    private List<DouyinWaybillApplyItemReqDTO> waybill_applies;
}
