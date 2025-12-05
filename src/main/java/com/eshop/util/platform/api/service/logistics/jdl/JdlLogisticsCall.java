package com.eshop.util.platform.api.service.logistics.jdl;

import com.eshop.util.platform.api.client.douyin.DouyinApiInvoker;
import com.eshop.util.platform.api.client.douyin.request.DouyinAppClientDTO;
import com.eshop.util.platform.api.client.jd.JdLogisticsApiInvoker;
import com.eshop.util.platform.api.client.jd.request.JdLogisticsAppClientDTO;
import com.eshop.util.platform.api.service.logistics.douyin.dto.DouyinWaybillApplyReqDTO;
import com.eshop.util.platform.api.service.logistics.douyin.vo.DouyinWaybillApplyRespVO;
import com.eshop.util.platform.api.service.logistics.jdl.dto.JdlGetTemplatesReqDTO;
import com.eshop.util.platform.api.service.logistics.jdl.dto.JdlJdlPullDataReqDTO;
import com.eshop.util.platform.api.service.logistics.jdl.vo.JdlGetTemplatesRespVO;
import com.eshop.util.platform.api.service.logistics.jdl.vo.JdlPullDataRespVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JdlLogisticsCall {


    @Autowired
    private JdLogisticsApiInvoker jdLogisticsApiInvoker;

    /**
     * 获取打印模板列表
     * /cloud/print/getTemplates
     *
     */
    public JdlGetTemplatesRespVO getTemplates(JdLogisticsAppClientDTO acDTO, JdlGetTemplatesReqDTO reqDTO) throws Exception {

        String domain = "jdcloudprint";
        String urlPath = "/cloud/print/getTemplates";
        String method = "POST";
        String version = "2.0";
        return jdLogisticsApiInvoker.execute(
                acDTO,
                domain,
                urlPath,
                method,
                version,
                JdlGetTemplatesRespVO.class,
                reqDTO
        );
    }


    /**
     * 获取打印模板列表
     * /PullDataService/pullData
     *
     */
    public JdlPullDataRespVO pullData(JdLogisticsAppClientDTO acDTO, JdlJdlPullDataReqDTO reqDTO) throws Exception {

        String domain = "jdcloudprint";
        String urlPath = "/PullDataService/pullData";
        String method = "POST";
        String version = "2.0";
        return jdLogisticsApiInvoker.execute(
                acDTO,
                domain,
                urlPath,
                method,
                version,
                JdlPullDataRespVO.class,
                reqDTO
        );
    }
}
