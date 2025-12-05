package com.eshop.util.platform.api.service.logistics.douyin.vo;


import java.util.List;

@lombok.Getter
@lombok.Setter
public class DouyinWaybillApplyDataVO {

    /**
     * 正常返回结构体
     */
    private List<DouyinWaybillApplyDataInfoVO> waybill_infos;

    /**
     *
     */
    private List<DouyinWaybillApplyDataErrInfoVO>  err_infos;
}
