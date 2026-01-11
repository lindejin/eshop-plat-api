package com.eshop.util.platform.api.service.logistics.taobao;

import com.eshop.util.platform.api.client.taobao.TaoBaoApiInvoker;
import com.eshop.util.platform.api.client.taobao.request.TaoBaoAppClientDTO;
import com.eshop.util.platform.api.service.logistics.taobao.dto.*;
import com.eshop.util.platform.api.service.logistics.taobao.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @program: eshop-plat-api
 * @description:
 * @author: lindz
 * @create: 2026-01-08 11:07
 **/
@Component
public class TaoBaoLogisticsCall {

    @Autowired
    private TaoBaoApiInvoker taoBaoApiInvoker;

    /**
     * 查询面单
     * cainiao.waybill.ii.query.by.waybillcode
     *
     */
    public TaoBaoEbillOrderRespVO queryEcBillOrder(TaoBaoAppClientDTO temuAcDTO, TaoBaoEbillOrderReqDTO reqDTO) throws Exception {
        String method = "cainiao.waybill.ii.query.by.waybillcode";
        return taoBaoApiInvoker.execute(
                temuAcDTO,
                method,
                TaoBaoEbillOrderRespVO.class,
                reqDTO
        );
    }

    /*
    模板获取相关接口 TOP
    接口名称	说明	模板维护方	是否需要商家授权	详细参考
    cainiao.cloudprint.stdtemplates.get	    获取菜鸟标准电子面单模板	菜鸟	否	详细文档参考
    cainiao.cloudprint.isv.resources.get	获取isv维护的资源（包括打印项、isv模板、isv预设自定义区）	isv	否	详细文档参考
    cainiao.cloudprint.isvtemplates.get	    获取商家自定义模板列表	商家	是	详细文档参考
    cainiao.cloudprint.mystdtemplates.get	获取商家标准电子面单自定义区列表	商家	是	详细文档参考
    cainiao.cloudprint.customares.get	    获取单个商家自定义区信息	商家	是	详细文档参考
     */

    /**
     * 获取菜鸟标准电子面单模板
     * cainiao.cloudprint.stdtemplates.get
     *
     */
    public TaoBaoEbillTemplatesRespVO queryEcBillTemplates(TaoBaoAppClientDTO temuAcDTO, TaoBaoEbillTemplatesReqDTO reqDTO) throws Exception {
        String method = "cainiao.cloudprint.stdtemplates.get";
        return taoBaoApiInvoker.execute(
                temuAcDTO,
                method,
                TaoBaoEbillTemplatesRespVO.class,
                reqDTO
        );
    }

    /**
     * 获取isv维护的资源（包括打印项、isv模板、isv预设自定义区）
     * cainiao.cloudprint.isv.resources.get
     *
     */
    public CainiaoCloudprintIsvResourcesGetRespVO cainiaoCloudprintIsvResourcesGet(TaoBaoAppClientDTO temuAcDTO, CainiaoCloudprintIsvResourcesGetReqDTO reqDTO) throws Exception {
        String method = "cainiao.cloudprint.isv.resources.get";
        return taoBaoApiInvoker.execute(
                temuAcDTO,
                method,
                CainiaoCloudprintIsvResourcesGetRespVO.class,
                reqDTO
        );
    }

    /**
     * 获取商家自定义模板列表
     * cainiao.cloudprint.isvtemplates.get
     *
     */
    public CainiaoCloudprintIsvtemplatesGetRespVO cainiaoCloudprintIsvtemplatesGet(TaoBaoAppClientDTO temuAcDTO, CainiaoCloudprintIsvtemplatesGetReqDTO reqDTO) throws Exception {
        String method = "cainiao.cloudprint.isvtemplates.get";
        return taoBaoApiInvoker.execute(
                temuAcDTO,
                method,
                CainiaoCloudprintIsvtemplatesGetRespVO.class,
                reqDTO
        );
    }

    /**
     * 获取商家标准电子面单自定义区列表
     * cainiao.cloudprint.mystdtemplates.get
     *
     */
    public CainiaoCloudprintMystdtemplatesGetRespVO cainiaoCloudprintMystdtemplatesGet(TaoBaoAppClientDTO temuAcDTO, CainiaoCloudprintMystdtemplatesGetReqDTO reqDTO) throws Exception {
        String method = "cainiao.cloudprint.mystdtemplates.get";
        return taoBaoApiInvoker.execute(
                temuAcDTO,
                method,
                CainiaoCloudprintMystdtemplatesGetRespVO.class,
                reqDTO
        );
    }


    /**
     * 获取单个商家自定义区信息
     * cainiao.cloudprint.customares.get
     *
     */
    public CainiaoCloudprintCustomaresGetGetRespVO cainiaoCloudprintCustomaresGet(TaoBaoAppClientDTO temuAcDTO, CainiaoCloudprintCustomaresGetReqDTO reqDTO) throws Exception {
        String method = "cainiao.cloudprint.customares.get";
        return taoBaoApiInvoker.execute(
                temuAcDTO,
                method,
                CainiaoCloudprintCustomaresGetGetRespVO.class,
                reqDTO
        );
    }
}