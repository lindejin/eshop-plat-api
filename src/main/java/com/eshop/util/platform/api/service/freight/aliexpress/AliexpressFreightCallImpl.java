package com.eshop.util.platform.api.service.freight.aliexpress;

import com.eshop.util.platform.api.service.freight.aliexpress.dto.AeFreightCalculateFreightDTO;
import com.eshop.util.platform.api.service.freight.aliexpress.dto.AeFreightGetFreightSettingByTemplateQueryDTO;
import com.eshop.util.platform.api.service.freight.aliexpress.dto.AeFreightListFreightTemplateDTO;
import com.eshop.util.platform.api.structure.aliexpress.dto.AeAppClientDTO;
import com.eshop.util.platform.api.structure.aliexpress.enumerate.AliexpressFreightEnu;
import com.global.iop.api.IopClient;
import com.global.iop.api.IopClientImpl;
import com.global.iop.api.IopRequest;
import com.global.iop.api.IopResponse;
import com.global.iop.domain.Protocol;
import com.global.iop.util.ApiException;
import org.springframework.stereotype.Service;

/**
 * @author ldj
 * @date 2024/3/7 9:33
 * @Description: ...
 * @Version 1.0
 */
@Service
public class AliexpressFreightCallImpl implements AliexpressFreightCall {


    //用户运费模板列表信息
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.freight.redefining.listfreighttemplate");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 用户运费模板列表信息
     */
    @Override
    public String listFreightTemplate(AeAppClientDTO acDTO, AeFreightListFreightTemplateDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressFreightEnu.LIST_FREIGHT_TEMPLATE.getApiName());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    //运费计算
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.freight.redefining.calculatefreight");
request.addApiParameter("height", "1");
request.addApiParameter("weight", "1");
request.addApiParameter("pack_add_weight", "1");
request.addApiParameter("count", "1");
request.addApiParameter("freight_template_id", "1000");
request.addApiParameter("pack_add_unit", "1");
request.addApiParameter("is_custom_pack_weight", "false");
request.addApiParameter("width", "1");
request.addApiParameter("length", "1");
request.addApiParameter("product_price", "{\"amount\":\"100.01\",\"cent\":\"10000\",\"currency_code\":\"USD\"}");
request.addApiParameter("pack_base_unit", "1");
request.addApiParameter("country", "RU");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 运费计算
     */

    @Override
    public String calculateFreight(AeAppClientDTO acDTO, AeFreightCalculateFreightDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressFreightEnu.CALCULATE_FREIGHT.getApiName());
        request.addApiParameter("height", reqDto.getHeight());
        request.addApiParameter("weight", reqDto.getWeight());
        request.addApiParameter("pack_add_weight", reqDto.getPack_add_weight());
        request.addApiParameter("count", reqDto.getCount());
        request.addApiParameter("freight_template_id", reqDto.getFreight_template_id());
        request.addApiParameter("pack_add_unit", reqDto.getPack_add_unit());
        request.addApiParameter("is_custom_pack_weight", reqDto.getIs_custom_pack_weight());
        request.addApiParameter("width", reqDto.getWidth());
        request.addApiParameter("length", reqDto.getLength());
        request.addApiParameter("product_price", reqDto.getProduct_price());
        request.addApiParameter("pack_base_unit", reqDto.getPack_base_unit());
        request.addApiParameter("country", reqDto.getCountry());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    //通过模板ID获取单个运费模板内容
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.freight.redefining.getfreightsettingbytemplatequery");
request.addApiParameter("template_id", "1000");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 通过模板ID获取单个运费模板内容
     */
    @Override
    public String getFreightSettingByTemplateQuery(AeAppClientDTO acDTO, AeFreightGetFreightSettingByTemplateQueryDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressFreightEnu.GET_FREIGHT_SETTING_BY_TEMPLATE_QUERY.getApiName());
        request.addApiParameter("template_id", reqDto.getTemplate_id());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

}
