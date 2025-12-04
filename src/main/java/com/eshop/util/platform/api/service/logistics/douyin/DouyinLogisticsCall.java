package com.eshop.util.platform.api.service.logistics.douyin;

import com.eshop.util.platform.api.client.douyin.DouyinApiInvoker;
import com.eshop.util.platform.api.client.douyin.request.DouyinAppClientDTO;
import com.eshop.util.platform.api.service.logistics.douyin.dto.DouyinWaybillApplyReqDTO;
import com.eshop.util.platform.api.service.logistics.douyin.vo.DouyinWaybillApplyRespVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DouyinLogisticsCall {


    @Autowired
    private DouyinApiInvoker douyinApiInvoker;

    /**
     * 查询面单
     * express.queryEbillOrder
     *
     */
    public DouyinWaybillApplyRespVO waybillApply(DouyinAppClientDTO temuAcDTO, DouyinWaybillApplyReqDTO reqDTO) throws Exception {
        String method = "logistics.waybillApply";
        String version = "2";
        String urlPath ="/logistics/waybillApply";
        return douyinApiInvoker.execute(
                temuAcDTO,
                method,
                version,
                urlPath,
                DouyinWaybillApplyRespVO.class,
                reqDTO
        );
    }
}
