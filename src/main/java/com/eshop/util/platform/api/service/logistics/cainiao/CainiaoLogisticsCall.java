package com.eshop.util.platform.api.service.logistics.cainiao;


import com.eshop.util.platform.api.client.cainiao.CainiaoApiInvoker;
import com.eshop.util.platform.api.client.cainiao.request.CainiaoAppClientDTO;
import com.eshop.util.platform.api.service.logistics.cainiao.dto.CainiaoCloudPrintStandardTemplatesReqDTO;
import com.eshop.util.platform.api.service.logistics.cainiao.dto.CainiaoCloudSellerCustomAreaDetailReqDTO;
import com.eshop.util.platform.api.service.logistics.cainiao.dto.CainiaoCloudSellerCustomAreasReqDTO;
import com.eshop.util.platform.api.service.logistics.cainiao.vo.CainiaoCloudPrintStandardTemplatesRespVO;
import com.eshop.util.platform.api.service.logistics.cainiao.vo.CainiaoCloudSellerCustomAreaDetailRespVO;
import com.eshop.util.platform.api.service.logistics.cainiao.vo.CainiaoCloudSellerCustomAreasRespVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CainiaoLogisticsCall {


    @Autowired
    private CainiaoApiInvoker cainiaoApiInvoker;

    /**
     * isv 通过 link 获取和使用标准面单
     * CLOUDPRINT_STANDARD_TEMPLATES
     *
     */
    public CainiaoCloudPrintStandardTemplatesRespVO cloudPrintStandardTemplates(CainiaoAppClientDTO appDTO, CainiaoCloudPrintStandardTemplatesReqDTO reqDTO) throws Exception {
        String msgType = "CLOUDPRINT_STANDARD_TEMPLATES";
        return cainiaoApiInvoker.execute(
                appDTO,
                msgType,
                CainiaoCloudPrintStandardTemplatesRespVO.class,
                reqDTO
        );
    }

    /**
     * isv 调用此接口获取商家自定义区列表。
     * CLOUDPRINT_SELLER_CUSTOM_AREAS
     *
     */
    public CainiaoCloudSellerCustomAreasRespVO cloudSellerCustomAreas(CainiaoAppClientDTO appDTO, CainiaoCloudSellerCustomAreasReqDTO reqDTO) throws Exception {
        String msgType = "CLOUDPRINT_SELLER_CUSTOM_AREAS";
        return cainiaoApiInvoker.execute(
                appDTO,
                msgType,
                CainiaoCloudSellerCustomAreasRespVO.class,
                reqDTO
        );
    }

    /**
     * isv 根据 mappingId 获取自定义区详情，url、keys 等
     * CLOUDPRINT_SELLER_CUSTOM_AREA_DETAIL
     *
     */
    public CainiaoCloudSellerCustomAreaDetailRespVO cloudSellerCustomAreaDetail(CainiaoAppClientDTO appDTO, CainiaoCloudSellerCustomAreaDetailReqDTO reqDTO) throws Exception {
        String msgType = "CLOUDPRINT_SELLER_CUSTOM_AREA_DETAIL";
        return cainiaoApiInvoker.execute(
                appDTO,
                msgType,
                CainiaoCloudSellerCustomAreaDetailRespVO.class,
                reqDTO
        );
    }
}