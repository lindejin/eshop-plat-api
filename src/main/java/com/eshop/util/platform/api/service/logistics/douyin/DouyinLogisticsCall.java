package com.eshop.util.platform.api.service.logistics.douyin;

import com.eshop.util.platform.api.client.douyin.DouyinApiInvoker;
import com.eshop.util.platform.api.client.douyin.request.DouyinAppClientDTO;
import com.eshop.util.platform.api.service.logistics.douyin.dto.DouyinCustomTemplateListReqDTO;
import com.eshop.util.platform.api.service.logistics.douyin.dto.DouyinCustomTemplateListV2ReqDTO;
import com.eshop.util.platform.api.service.logistics.douyin.dto.DouyinTemplateListReqDTO;
import com.eshop.util.platform.api.service.logistics.douyin.dto.DouyinWaybillApplyReqDTO;
import com.eshop.util.platform.api.service.logistics.douyin.vo.DouyinCustomTemplateListRespVO;
import com.eshop.util.platform.api.service.logistics.douyin.vo.DouyinCustomTemplateListV2RespVO;
import com.eshop.util.platform.api.service.logistics.douyin.vo.DouyinTemplateListRespVO;
import com.eshop.util.platform.api.service.logistics.douyin.vo.DouyinWaybillApplyRespVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DouyinLogisticsCall {


    @Autowired
    private DouyinApiInvoker douyinApiInvoker;

    /**
     * 查询面单
     * /logistics/waybillApply
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

    /**
     * /logistics/templateList
     * 获取商家所有标准模版信息
     * 查询物流商的标准模板。
     * 注意：物流商模板平台会定期更新或新增，请开发者定期扫描该接口，保持和平台数据一致
     */
    public DouyinTemplateListRespVO templateList(DouyinAppClientDTO temuAcDTO, DouyinTemplateListReqDTO reqDTO) throws Exception {
        String method = "logistics.templateList";
        String version = "2";
        String urlPath ="/logistics/templateList";
        return douyinApiInvoker.execute(
                temuAcDTO,
                method,
                version,
                urlPath,
                DouyinTemplateListRespVO.class,
                reqDTO
        );
    }

    /**
     * /logistics/getCustomTemplateList
     *
     */
    public DouyinCustomTemplateListRespVO getCustomTemplateList(DouyinAppClientDTO temuAcDTO, DouyinCustomTemplateListReqDTO reqDTO) throws Exception {
        String method = "logistics.getCustomTemplateList";
        String version = "2";
        String urlPath ="/logistics/getCustomTemplateList";
        return douyinApiInvoker.execute(
                temuAcDTO,
                method,
                version,
                urlPath,
                DouyinCustomTemplateListRespVO.class,
                reqDTO
        );
    }

    /**
     * 查询商家自定义区域数据
     */
    ///logistics/customTemplateList
    public DouyinCustomTemplateListV2RespVO customTemplateList(DouyinAppClientDTO temuAcDTO, DouyinCustomTemplateListV2ReqDTO reqDTO) throws Exception {
        String method = "logistics.customTemplateList";
        String version = "2";
        String urlPath ="/logistics/customTemplateList";
        return douyinApiInvoker.execute(
                temuAcDTO,
                method,
                version,
                urlPath,
                DouyinCustomTemplateListV2RespVO.class,
                reqDTO
        );
    }
}
