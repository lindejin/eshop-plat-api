package com.eshop.util.platform.api.service.logistics.xiaohongshu;

import com.eshop.util.platform.api.client.xiaohongshu.XiaohongshuApiInvoker;
import com.eshop.util.platform.api.client.xiaohongshu.request.XiaohongshuAppClientDTO;
import com.eshop.util.platform.api.service.logistics.xiaohongshu.dto.XiaohongshuEbillOrderReqDTO;
import com.eshop.util.platform.api.service.logistics.xiaohongshu.dto.XiaohongshuEbillTemplatesReqDTO;
import com.eshop.util.platform.api.service.logistics.xiaohongshu.vo.XiaohongshuEbillOrderRespVO;
import com.eshop.util.platform.api.service.logistics.xiaohongshu.vo.XiaohongshuEbillTemplatesRespVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class XiaohongshuLogisticsCall {

    @Autowired
    private XiaohongshuApiInvoker xiaohongshuApiInvoker;

    /**
     * 查询面单
     * express.queryEbillOrder
     *
     */
    public XiaohongshuEbillOrderRespVO queryEbillOrder(XiaohongshuAppClientDTO temuAcDTO, XiaohongshuEbillOrderReqDTO reqDTO) throws Exception {
        String method = "express.queryEbillOrder";
        return xiaohongshuApiInvoker.execute(
                temuAcDTO,
                method,
                XiaohongshuEbillOrderRespVO.class,
                reqDTO
        );
    }

    /**
     * 查询电子面单模板列表
     * express.queryEbillTemplates
     *
     */
    public XiaohongshuEbillTemplatesRespVO queryEbillTemplates(XiaohongshuAppClientDTO temuAcDTO, XiaohongshuEbillTemplatesReqDTO reqDTO) throws Exception {
        String method = "express.queryEbillTemplates";
        return xiaohongshuApiInvoker.execute(
                temuAcDTO,
                method,
                XiaohongshuEbillTemplatesRespVO.class,
                reqDTO
        );
    }
}
