package com.eshop.util.platform.api.service.product.aliexpress;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.eshop.util.platform.api.service.product.aliexpress.dto.*;
import com.eshop.util.platform.api.service.product.aliexpress.vo.*;
import com.eshop.util.platform.api.structure.aliexpress.dto.AeAppClientDTO;
import com.eshop.util.platform.api.structure.aliexpress.enumerate.AliexpressPopChoiceProductEnu;
import com.global.iop.api.IopClient;
import com.global.iop.api.IopClientImpl;
import com.global.iop.api.IopRequest;
import com.global.iop.api.IopResponse;
import com.global.iop.domain.Protocol;
import com.global.iop.util.ApiException;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ldj
 * @date 2024/3/30 17:28
 * @Description: ...
 * @Version 1.0
 */
@Service
public class AliexpressPopChoiceProductCallImpl implements AliexpressPopChoiceProductCall {

    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.offer.pop.choice.draft.post");
request.addApiParameter("aeop_a_e_product", "{\"lot_num\":\"1\",\"aeop_ae_product_propertys\":[{\"attr_name_id\":\"14\",\"attr_name\":\"color\",\"attr_value_id\":\"12343444\",\"attr_value_unit\":\"0\",\"attr_value\":\"white\",\"attr_value_end\":\"2000561\",\"attr_value_start\":\"2000568\"},{\"attr_name_id\":\"14\",\"attr_name\":\"color\",\"attr_value_id\":\"12343444\",\"attr_value_unit\":\"0\",\"attr_value\":\"white\",\"attr_value_end\":\"2000561\",\"attr_value_start\":\"2000568\"}],\"mode_size_chart_list\":[{\"mode_size\":\"R\",\"hips\":\"2.1\",\"waist\":\"2\",\"bust\":\"2\",\"height\":\"2\"},{\"mode_size\":\"R\",\"hips\":\"2.1\",\"waist\":\"2\",\"bust\":\"2\",\"height\":\"2\"}],\"ws_valid_num\":\"30\",\"product_price\":\"11.00\",\"aeop_national_quote_configuration\":{\"configuration_data\":\"[{\\\"absoluteQuoteMap\\\":{\\\"\\\":1.0},\\\"shiptoCountry\\\":\\\"RU\\\"},{\\\"absoluteQuoteMap\\\":{\\\"\\\":2.0},\\\"shiptoCountry\\\":\\\"US\\\"}]\",\"configuration_type\":\"absolute\"},\"delivery_time\":\"3\",\"locale\":\"en_US\",\"package_type\":\"false\",\"detail_source_list\":[{\"mobile_detail\":\"detail stuff here\",\"locale\":\"en_US\",\"web_detail\":\"detail stuff here\"},{\"mobile_detail\":\"detail stuff here\",\"locale\":\"en_US\",\"web_detail\":\"detail stuff here\"}],\"base_unit\":\"1\",\"currency_code\":\"USD;RUB\",\"is_pack_sell\":\"false\",\"package_height\":\"40\",\"add_weight\":\"3.03\",\"subject_list\":[{\"locale\":\"en_US\",\"value\":\"title content here\"},{\"locale\":\"en_US\",\"value\":\"title content here\"}],\"aeop_ae_product_s_k_us\":[{\"sku_discount_price\":\"10.01\",\"ipm_sku_stock\":\"10\",\"aeop_s_k_u_national_discount_price\":[{\"discount_price\":\"9.09\",\"shipto_country\":\"RU\"},{\"discount_price\":\"9.09\",\"shipto_country\":\"RU\"}],\"ean_code\":\"12345678\",\"currency_code\":\"USD;RUB\",\"package_width\":\"3\",\"package_height\":\"2\",\"sku_price\":\"9.05\",\"package_length\":\"4\",\"aeop_s_k_u_property\":[{\"sku_image\":\"http://ae01.alicdn.com/kf/HTB19KVYX6LuK1Rjy0Fhq6xpdFXac.jpg\",\"property_value_definition_name\":\"\u6807\u51C6\u5957\u9910\",\"property_value_id\":\"23123444\",\"sku_property_id\":\"120001\",\"image_url_list\":[\"[http://ae01.alicdn.com/kf/HTB19KVYX6LuK1Rjy0Fhq6xpdFXac.jpg]\",\"[http://ae01.alicdn.com/kf/HTB19KVYX6LuK1Rjy0Fhq6xpdFXac.jpg]\"]},{\"sku_image\":\"http://ae01.alicdn.com/kf/HTB19KVYX6LuK1Rjy0Fhq6xpdFXac.jpg\",\"property_value_definition_name\":\"\u6807\u51C6\u5957\u9910\",\"property_value_id\":\"23123444\",\"sku_property_id\":\"120001\",\"image_url_list\":[\"[http://ae01.alicdn.com/kf/HTB19KVYX6LuK1Rjy0Fhq6xpdFXac.jpg]\",\"[http://ae01.alicdn.com/kf/HTB19KVYX6LuK1Rjy0Fhq6xpdFXac.jpg]\"]}],\"gross_weight\":\"1\",\"barcode\":\"AEfgsdg334\",\"sku_code\":\"AE235de2\"},{\"sku_discount_price\":\"10.01\",\"ipm_sku_stock\":\"10\",\"aeop_s_k_u_national_discount_price\":[{\"discount_price\":\"9.09\",\"shipto_country\":\"RU\"},{\"discount_price\":\"9.09\",\"shipto_country\":\"RU\"}],\"ean_code\":\"12345678\",\"currency_code\":\"USD;RUB\",\"package_width\":\"3\",\"package_height\":\"2\",\"sku_price\":\"9.05\",\"package_length\":\"4\",\"aeop_s_k_u_property\":[{\"sku_image\":\"http://ae01.alicdn.com/kf/HTB19KVYX6LuK1Rjy0Fhq6xpdFXac.jpg\",\"property_value_definition_name\":\"\u6807\u51C6\u5957\u9910\",\"property_value_id\":\"23123444\",\"sku_property_id\":\"120001\",\"image_url_list\":[\"[http://ae01.alicdn.com/kf/HTB19KVYX6LuK1Rjy0Fhq6xpdFXac.jpg]\",\"[http://ae01.alicdn.com/kf/HTB19KVYX6LuK1Rjy0Fhq6xpdFXac.jpg]\"]},{\"sku_image\":\"http://ae01.alicdn.com/kf/HTB19KVYX6LuK1Rjy0Fhq6xpdFXac.jpg\",\"property_value_definition_name\":\"\u6807\u51C6\u5957\u9910\",\"property_value_id\":\"23123444\",\"sku_property_id\":\"120001\",\"image_url_list\":[\"[http://ae01.alicdn.com/kf/HTB19KVYX6LuK1Rjy0Fhq6xpdFXac.jpg]\",\"[http://ae01.alicdn.com/kf/HTB19KVYX6LuK1Rjy0Fhq6xpdFXac.jpg]\"]}],\"gross_weight\":\"1\",\"barcode\":\"AEfgsdg334\",\"sku_code\":\"AE235de2\"}],\"category_id\":\"200002101\",\"image_u_r_ls\":\"http://g01.a.alicdn.com/kf/HTB13GKLJXXXXXbYaXXXq6xXFXXXi.jpg;http://g02.a.alicdn.com/kf/HTB1DkaWJXXXXXb6XFXXq6xXFXXXp.jpg;http://g02.a.alicdn.com/kf/HTB1pMCQJXXXXXcvXVXXq6xXFXXXm.jpg;http://g03.a.alicdn.com/kf/HTB1QhORJXXXXXbiXVXXq6xXFXXXx.jpg;http://g02.a.alicdn.com/kf/HTB1q1aLJXXXXXcfaXXXq6xXFXXXv.jpg\",\"package_length\":\"20\",\"reduce_strategy\":\"place_order_withhold\u6216payment_success_deduct\",\"gross_weight\":\"10.020\",\"freight_template_id\":\"1000\",\"promise_template_id\":\"100\",\"msr_eu_id\":\"12\",\"sizechart_id\":\"100\",\"aeop_a_e_multimedia\":{\"aeop_a_e_videos\":[{\"media_type\":\"video\",\"media_id\":\"23423423\",\"poster_url\":\"http://img01.taobaocdn.com/bao/uploaded/TB1rNdGIVXXXXbTXFXXXXXXXXXX.jpg\"},{\"media_type\":\"video\",\"media_id\":\"23423423\",\"poster_url\":\"http://img01.taobaocdn.com/bao/uploaded/TB1rNdGIVXXXXbTXFXXXXXXXXXX.jpg\"}]},\"aeop_qualification_struct_list\":[{\"type\":\"image\",\"value\":\"https://ae01.alicdn.com/kf/S23b9cb05c8e844648d48324f23f0c123T.jpeg\",\"key\":\"item_EU_CE_certificate\"},{\"type\":\"image\",\"value\":\"https://ae01.alicdn.com/kf/S23b9cb05c8e844648d48324f23f0c123T.jpeg\",\"key\":\"item_EU_CE_certificate\"}],\"bulk_order\":\"5\",\"draft_id\":\"1005005004845613\",\"product_unit\":\"100000000\",\"market_images\":[{\"url\":\"https://ae01.alicdn.com/kf/HTB1C72NbcvrXXX.jpg\",\"image_type\":\"1\"},{\"url\":\"https://ae01.alicdn.com/kf/HTB1C72NbcvrXXX.jpg\",\"image_type\":\"1\"}],\"package_width\":\"30\",\"group_id\":\"124\",\"add_unit\":\"2\",\"bulk_discount\":\"90\",\"ext_param\":\"{     \\\"category_forecast\\\":\\\"100000015;100000014;100000013;100000012;100000011;100000010\\\" }\"}");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */
    @Override
    public AePopAeProductRespVO productPopChoiceDraftPost(AeAppClientDTO acDTO, AeopAeProductPostReqDTO reqDTO) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressPopChoiceProductEnu.POP_CHOICE_DRAFT_POST.getApiName());
        if (reqDTO.getAeop_a_e_product() != null) {
            request.addApiParameter("aeop_a_e_product", JSON.toJSONString(reqDTO.getAeop_a_e_product()));
        }
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        AePopAeProductRespVO respVO = new AePopAeProductRespVO();
        respVO.setRespBody(response.getGopResponseBody());
        JSONObject respJson = JSONObject.parseObject(response.getGopResponseBody());
        JSONObject result = respJson.getJSONObject("result");
        if (result != null) {
            respVO.setDraftId(result.getLong("draft_id"));
        }
        return respVO;
    }

    /*
    IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.pop.choice.product.post");
request.addApiParameter("pop_choice_product", "{\"product_sku_list\":[{\"package_width\":\"1.1\",\"package_height\":\"1.1\",\"sku_property_list\":[{\"sku_property_value\":\"\u7C73\u8272\",\"sku_image\":\"https://ae04.alicdn.com/kf/S5c57c6002a4545d5b0cfa9effb494b334.png\",\"sku_property_name\":\"\u989C\u8272\",\"sku_property_id_long\":\"14\",\"property_value_definition_name\":\"\u7C73\u8272test\",\"property_value_id_long\":\"771\",\"image_url_list\":[\"[]\",\"[]\"]},{\"sku_property_value\":\"\u7C73\u8272\",\"sku_image\":\"https://ae04.alicdn.com/kf/S5c57c6002a4545d5b0cfa9effb494b334.png\",\"sku_property_name\":\"\u989C\u8272\",\"sku_property_id_long\":\"14\",\"property_value_definition_name\":\"\u7C73\u8272test\",\"property_value_id_long\":\"771\",\"image_url_list\":[\"[]\",\"[]\"]}],\"package_length\":\"1.1\",\"pop_choice_product_sku_sc_item_info\":{\"sc_item_code\":\"123\",\"sc_item_bar_code\":\"123abc\",\"special_product_type_list\":[\"[       \\\"274452\\\",             \\\"274526\\\" ]\",\"[       \\\"274452\\\",             \\\"274526\\\" ]\"],\"original_box\":\"1\"},\"base_price\":\"1.1\",\"package_weight\":\"1.1\",\"sku_id\":\"1232412312\",\"pop_choice_sku_warehouse_stock_list\":[{\"warehouse_code\":\"test001-JIT\",\"sellable_quantity\":\"12\"},{\"warehouse_code\":\"test001-JIT\",\"sellable_quantity\":\"12\"}],\"sku_code\":\"123abc\"},{\"package_width\":\"1.1\",\"package_height\":\"1.1\",\"sku_property_list\":[{\"sku_property_value\":\"\u7C73\u8272\",\"sku_image\":\"https://ae04.alicdn.com/kf/S5c57c6002a4545d5b0cfa9effb494b334.png\",\"sku_property_name\":\"\u989C\u8272\",\"sku_property_id_long\":\"14\",\"property_value_definition_name\":\"\u7C73\u8272test\",\"property_value_id_long\":\"771\",\"image_url_list\":[\"[]\",\"[]\"]},{\"sku_property_value\":\"\u7C73\u8272\",\"sku_image\":\"https://ae04.alicdn.com/kf/S5c57c6002a4545d5b0cfa9effb494b334.png\",\"sku_property_name\":\"\u989C\u8272\",\"sku_property_id_long\":\"14\",\"property_value_definition_name\":\"\u7C73\u8272test\",\"property_value_id_long\":\"771\",\"image_url_list\":[\"[]\",\"[]\"]}],\"package_length\":\"1.1\",\"pop_choice_product_sku_sc_item_info\":{\"sc_item_code\":\"123\",\"sc_item_bar_code\":\"123abc\",\"special_product_type_list\":[\"[       \\\"274452\\\",             \\\"274526\\\" ]\",\"[       \\\"274452\\\",             \\\"274526\\\" ]\"],\"original_box\":\"1\"},\"base_price\":\"1.1\",\"package_weight\":\"1.1\",\"sku_id\":\"1232412312\",\"pop_choice_sku_warehouse_stock_list\":[{\"warehouse_code\":\"test001-JIT\",\"sellable_quantity\":\"12\"},{\"warehouse_code\":\"test001-JIT\",\"sellable_quantity\":\"12\"}],\"sku_code\":\"123abc\"}],\"category_id\":\"123\",\"joined_country_list\":[\"[                 \\\"PL\\\",                 \\\"UK\\\",                 \\\"NL\\\",                 \\\"IT\\\",                 \\\"PT\\\",                 \\\"BE\\\",                 \\\"LT\\\",                 \\\"NO\\\",                 \\\"HU\\\",                 \\\"RO\\\"             ]\",\"[                 \\\"PL\\\",                 \\\"UK\\\",                 \\\"NL\\\",                 \\\"IT\\\",                 \\\"PT\\\",                 \\\"BE\\\",                 \\\"LT\\\",                 \\\"NO\\\",                 \\\"HU\\\",                 \\\"RO\\\"             ]\"],\"draft_id\":\"1234\",\"currency_code\":\"USD\"}");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */
    @Override
    public AePopChoiceProductRespVO productPopChoiceProductPost(AeAppClientDTO acDTO, AliexpressPopChoiceProductPostDTO reqDTO) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressPopChoiceProductEnu.POP_CHOICE_PRODUCT_POST.getApiName());
        request.addApiParameter("pop_choice_product", JSON.toJSONString(reqDTO.getPop_choice_product()));
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);

        AePopChoiceProductRespVO respVO = new AePopChoiceProductRespVO();
        respVO.setRespBody(response.getGopResponseBody());
        JSONObject respJson = JSONObject.parseObject(response.getGopResponseBody());
        JSONObject result = respJson.getJSONObject("result");
        if (result != null) {
            respVO.setProductId(result.getLong("product_id"));
        }
        return respVO;
    }

    /*
    IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.pop.choice.product.edit");
request.addApiParameter("pop_choice_product", "{\"product_sku_list\":[{\"package_width\":\"1.1\",\"package_height\":\"1.1\",\"sku_property_list\":[{\"sku_property_value\":\"\u7C73\u8272\",\"sku_image\":\"https://ae04.alicdn.com/kf/S5c57c6002a4545d5b0cfa9effb494b334.png\",\"sku_property_name\":\"\u989C\u8272\",\"sku_property_id_long\":\"14\",\"property_value_definition_name\":\"\u7C73\u8272test\",\"property_value_id_long\":\"771\",\"image_url_list\":[\"[]\",\"[]\"]},{\"sku_property_value\":\"\u7C73\u8272\",\"sku_image\":\"https://ae04.alicdn.com/kf/S5c57c6002a4545d5b0cfa9effb494b334.png\",\"sku_property_name\":\"\u989C\u8272\",\"sku_property_id_long\":\"14\",\"property_value_definition_name\":\"\u7C73\u8272test\",\"property_value_id_long\":\"771\",\"image_url_list\":[\"[]\",\"[]\"]}],\"package_length\":\"1.1\",\"pop_choice_product_sku_sc_item_info\":{\"sc_item_code\":\"123\",\"sc_item_bar_code\":\"123abc\",\"special_product_type_list\":[\"[       \\\"274452\\\",             \\\"274526\\\" ]\",\"[       \\\"274452\\\",             \\\"274526\\\" ]\"],\"original_box\":\"1\"},\"base_price\":\"1.1\",\"package_weight\":\"1.1\",\"sku_id\":\"1232412312\",\"pop_choice_sku_warehouse_stock_list\":[{\"warehouse_code\":\"test001-JIT\",\"sellable_quantity\":\"12\"},{\"warehouse_code\":\"test001-JIT\",\"sellable_quantity\":\"12\"}],\"sku_code\":\"123abc\"},{\"package_width\":\"1.1\",\"package_height\":\"1.1\",\"sku_property_list\":[{\"sku_property_value\":\"\u7C73\u8272\",\"sku_image\":\"https://ae04.alicdn.com/kf/S5c57c6002a4545d5b0cfa9effb494b334.png\",\"sku_property_name\":\"\u989C\u8272\",\"sku_property_id_long\":\"14\",\"property_value_definition_name\":\"\u7C73\u8272test\",\"property_value_id_long\":\"771\",\"image_url_list\":[\"[]\",\"[]\"]},{\"sku_property_value\":\"\u7C73\u8272\",\"sku_image\":\"https://ae04.alicdn.com/kf/S5c57c6002a4545d5b0cfa9effb494b334.png\",\"sku_property_name\":\"\u989C\u8272\",\"sku_property_id_long\":\"14\",\"property_value_definition_name\":\"\u7C73\u8272test\",\"property_value_id_long\":\"771\",\"image_url_list\":[\"[]\",\"[]\"]}],\"package_length\":\"1.1\",\"pop_choice_product_sku_sc_item_info\":{\"sc_item_code\":\"123\",\"sc_item_bar_code\":\"123abc\",\"special_product_type_list\":[\"[       \\\"274452\\\",             \\\"274526\\\" ]\",\"[       \\\"274452\\\",             \\\"274526\\\" ]\"],\"original_box\":\"1\"},\"base_price\":\"1.1\",\"package_weight\":\"1.1\",\"sku_id\":\"1232412312\",\"pop_choice_sku_warehouse_stock_list\":[{\"warehouse_code\":\"test001-JIT\",\"sellable_quantity\":\"12\"},{\"warehouse_code\":\"test001-JIT\",\"sellable_quantity\":\"12\"}],\"sku_code\":\"123abc\"}],\"category_id\":\"123\",\"product_id\":\"1234\",\"joined_country_list\":[\"[                 \\\"PL\\\",                 \\\"UK\\\",                 \\\"NL\\\",                 \\\"IT\\\",                 \\\"PT\\\",                 \\\"BE\\\",                 \\\"LT\\\",                 \\\"NO\\\",                 \\\"HU\\\",                 \\\"RO\\\"             ]\",\"[                 \\\"PL\\\",                 \\\"UK\\\",                 \\\"NL\\\",                 \\\"IT\\\",                 \\\"PT\\\",                 \\\"BE\\\",                 \\\"LT\\\",                 \\\"NO\\\",                 \\\"HU\\\",                 \\\"RO\\\"             ]\"],\"currency_code\":\"USD\"}");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */
    @Override
    public String productPopChoiceProductEdit(AeAppClientDTO acDTO, AliexpressPopChoiceProductEditDTO reqDTO) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressPopChoiceProductEnu.POP_CHOICE_PRODUCT_EDIT.getApiName());
        request.addApiParameter("pop_choice_product", reqDTO.getPop_choice_product());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    /*
    IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.draft.product.edit");
request.addApiParameter("aeop_a_e_product", "{\"lot_num\":\"1\",\"aeop_ae_product_propertys\":[{\"attr_name_id\":\"200000043\",\"attr_value_unit\":\"0\",\"attr_value_id\":\"493\",\"attr_name\":\"size\",\"attr_value_start\":\"0\",\"attr_value_end\":\"0\",\"attr_value\":\"2 - 5 kg\"},{\"attr_name_id\":\"200000043\",\"attr_value_unit\":\"0\",\"attr_value_id\":\"493\",\"attr_name\":\"size\",\"attr_value_start\":\"0\",\"attr_value_end\":\"0\",\"attr_value\":\"2 - 5 kg\"}],\"mode_size_chart_list\":[{\"mode_size\":\"1\",\"hips\":\"1\",\"bust\":\"1\",\"waist\":\"1\",\"height\":\"1\"},{\"mode_size\":\"1\",\"hips\":\"1\",\"bust\":\"1\",\"waist\":\"1\",\"height\":\"1\"}],\"ws_valid_num\":\"30\",\"product_price\":\"10.11\",\"delivery_time\":\"3\",\"aeop_national_quote_configuration\":{\"configuration_data\":\"[{\\\"absoluteQuoteMap\\\":{\\\"\\\":1.0},\\\"shiptoCountry\\\":\\\"RU\\\"},{\\\"absoluteQuoteMap\\\":{\\\"\\\":2.0},\\\"shiptoCountry\\\":\\\"US\\\"}]\",\"configuration_type\":\"absolute\"},\"package_type\":\"false\",\"detail_source_list\":[{\"mobile_detail\":\"{\\\\\\\"version\\\\\\\":\\\\\\\"2.0.0\\\\\\\",\\\\\\\"moduleList\\\\\\\":[{\\\\\\\"type\\\\\\\":\\\\\\\"text\\\\\\\",\\\\\\\"texts\\\\\\\":[{\\\\\\\"content\\\\\\\":\\\\\\\"Thisistitle\\\\\\\",\\\\\\\"class\\\\\\\":\\\\\\\"title\\\\\\\"},{\\\\\\\"content\\\\\\\":\\\\\\\"Thisisdescription\\\\\\\",\\\\\\\"class\\\\\\\":\\\\\\\"body\\\\\\\"}]}]}\",\"locale\":\"en_US\",\"web_detail\":\"{\\\\\\\"version\\\\\\\":\\\\\\\"2.0.0\\\\\\\",\\\\\\\"moduleList\\\\\\\":[{\\\\\\\"type\\\\\\\":\\\\\\\"text\\\\\\\",\\\\\\\"texts\\\\\\\":[{\\\\\\\"content\\\\\\\":\\\\\\\"Thisistitle\\\\\\\",\\\\\\\"class\\\\\\\":\\\\\\\"title\\\\\\\"},{\\\\\\\"content\\\\\\\":\\\\\\\"Thisisdescription\\\\\\\",\\\\\\\"class\\\\\\\":\\\\\\\"body\\\\\\\"}]}]}\"},{\"mobile_detail\":\"{\\\\\\\"version\\\\\\\":\\\\\\\"2.0.0\\\\\\\",\\\\\\\"moduleList\\\\\\\":[{\\\\\\\"type\\\\\\\":\\\\\\\"text\\\\\\\",\\\\\\\"texts\\\\\\\":[{\\\\\\\"content\\\\\\\":\\\\\\\"Thisistitle\\\\\\\",\\\\\\\"class\\\\\\\":\\\\\\\"title\\\\\\\"},{\\\\\\\"content\\\\\\\":\\\\\\\"Thisisdescription\\\\\\\",\\\\\\\"class\\\\\\\":\\\\\\\"body\\\\\\\"}]}]}\",\"locale\":\"en_US\",\"web_detail\":\"{\\\\\\\"version\\\\\\\":\\\\\\\"2.0.0\\\\\\\",\\\\\\\"moduleList\\\\\\\":[{\\\\\\\"type\\\\\\\":\\\\\\\"text\\\\\\\",\\\\\\\"texts\\\\\\\":[{\\\\\\\"content\\\\\\\":\\\\\\\"Thisistitle\\\\\\\",\\\\\\\"class\\\\\\\":\\\\\\\"title\\\\\\\"},{\\\\\\\"content\\\\\\\":\\\\\\\"Thisisdescription\\\\\\\",\\\\\\\"class\\\\\\\":\\\\\\\"body\\\\\\\"}]}]}\"}],\"locale\":\"en_US\",\"base_unit\":\"1\",\"currency_code\":\"USD;RUB\",\"is_pack_sell\":\"false\",\"package_height\":\"40\",\"add_weight\":\"30.11\",\"aeop_ae_product_s_k_us\":[{\"sku_discount_price\":\"12.05\",\"ipm_sku_stock\":\"111\",\"aeop_s_k_u_national_discount_price\":[{\"discount_price\":\"10.01\",\"shipto_country\":\"RU\"},{\"discount_price\":\"10.01\",\"shipto_country\":\"RU\"}],\"ean_code\":\"212131231\",\"currency_code\":\"USD;RUB\",\"package_width\":\"3\",\"package_height\":\"2\",\"sku_price\":\"200.07\",\"package_length\":\"4\",\"id\":\"\\\"200000182:193;200007763:201336100\\\"\",\"gross_weight\":\"1\",\"aeop_s_k_u_property\":[{\"sku_image\":\"http://ae01.alicdn.com/kf/HTB19KVYX6LuK1Rjy0Fhq6xpdFXac.jpg\",\"property_value_definition_name\":\"pink\",\"property_value_id\":\"366\",\"image_url_list\":[\"[http://ae01.alicdn.com/kf/HTB19KVYX6LuK1Rjy0Fhq6xpdFXac.jpg]\",\"[http://ae01.alicdn.com/kf/HTB19KVYX6LuK1Rjy0Fhq6xpdFXac.jpg]\"],\"sku_property_id\":\"14\"},{\"sku_image\":\"http://ae01.alicdn.com/kf/HTB19KVYX6LuK1Rjy0Fhq6xpdFXac.jpg\",\"property_value_definition_name\":\"pink\",\"property_value_id\":\"366\",\"image_url_list\":[\"[http://ae01.alicdn.com/kf/HTB19KVYX6LuK1Rjy0Fhq6xpdFXac.jpg]\",\"[http://ae01.alicdn.com/kf/HTB19KVYX6LuK1Rjy0Fhq6xpdFXac.jpg]\"],\"sku_property_id\":\"14\"}],\"sku_code\":\"cfas00978\"},{\"sku_discount_price\":\"12.05\",\"ipm_sku_stock\":\"111\",\"aeop_s_k_u_national_discount_price\":[{\"discount_price\":\"10.01\",\"shipto_country\":\"RU\"},{\"discount_price\":\"10.01\",\"shipto_country\":\"RU\"}],\"ean_code\":\"212131231\",\"currency_code\":\"USD;RUB\",\"package_width\":\"3\",\"package_height\":\"2\",\"sku_price\":\"200.07\",\"package_length\":\"4\",\"id\":\"\\\"200000182:193;200007763:201336100\\\"\",\"gross_weight\":\"1\",\"aeop_s_k_u_property\":[{\"sku_image\":\"http://ae01.alicdn.com/kf/HTB19KVYX6LuK1Rjy0Fhq6xpdFXac.jpg\",\"property_value_definition_name\":\"pink\",\"property_value_id\":\"366\",\"image_url_list\":[\"[http://ae01.alicdn.com/kf/HTB19KVYX6LuK1Rjy0Fhq6xpdFXac.jpg]\",\"[http://ae01.alicdn.com/kf/HTB19KVYX6LuK1Rjy0Fhq6xpdFXac.jpg]\"],\"sku_property_id\":\"14\"},{\"sku_image\":\"http://ae01.alicdn.com/kf/HTB19KVYX6LuK1Rjy0Fhq6xpdFXac.jpg\",\"property_value_definition_name\":\"pink\",\"property_value_id\":\"366\",\"image_url_list\":[\"[http://ae01.alicdn.com/kf/HTB19KVYX6LuK1Rjy0Fhq6xpdFXac.jpg]\",\"[http://ae01.alicdn.com/kf/HTB19KVYX6LuK1Rjy0Fhq6xpdFXac.jpg]\"],\"sku_property_id\":\"14\"}],\"sku_code\":\"cfas00978\"}],\"subject_list\":[{\"locale\":\"en_US\",\"value\":\"product subject\"},{\"locale\":\"en_US\",\"value\":\"product subject\"}],\"category_id\":\"200002101\",\"image_u_r_ls\":\"http://g01.a.alicdn.com/kf/HTB13GKLJXXXXXbYaXXXq6xXFXXXi.jpg;http://g02.a.alicdn.com/kf/HTB1DkaWJXXXXXb6XFXXq6xXFXXXp.jpg;http://g02.a.alicdn.com/kf/HTB1pMCQJXXXXXcvXVXXq6xXFXXXm.jpg;http://g03.a.alicdn.com/kf/HTB1QhORJXXXXXbiXVXXq6xXFXXXx.jpg;http://g02.a.alicdn.com/kf/HTB1q1aLJXXXXXcfaXXXq6xXFXXXv.jpg\",\"product_id\":\"1239273\",\"package_length\":\"20\",\"reduce_strategy\":\"place_order_withhold\",\"gross_weight\":\"50\",\"freight_template_id\":\"1000\",\"promise_template_id\":\"100\",\"aeop_a_e_multimedia\":{\"aeop_a_e_videos\":[{\"media_type\":\"video\",\"poster_url\":\"http://img01.taobaocdn.com/bao/uploaded/TB1rNdGIVXXXXbTXFXXXXXXXXXX.jpg\",\"media_id\":\"12345678\"},{\"media_type\":\"video\",\"poster_url\":\"http://img01.taobaocdn.com/bao/uploaded/TB1rNdGIVXXXXbTXFXXXXXXXXXX.jpg\",\"media_id\":\"12345678\"}]},\"sizechart_id\":\"123\",\"msr_eu_id\":\"12\",\"aeop_qualification_struct_list\":[{\"type\":\"image\",\"value\":\"https://ae01.alicdn.com/kf/S23b9cb05c8e844648d48324f23f0c123T.jpeg\",\"key\":\"item_EU_CE_certificate\"},{\"type\":\"image\",\"value\":\"https://ae01.alicdn.com/kf/S23b9cb05c8e844648d48324f23f0c123T.jpeg\",\"key\":\"item_EU_CE_certificate\"}],\"bulk_order\":\"5\",\"product_unit\":\"100000000\",\"market_images\":[{\"url\":\"https://ae01.alicdn.com/kf/HTB1C72NbcvrXXX.jpg\",\"image_type\":\"1\"},{\"url\":\"https://ae01.alicdn.com/kf/HTB1C72NbcvrXXX.jpg\",\"image_type\":\"1\"}],\"package_width\":\"30\",\"add_unit\":\"2\",\"bulk_discount\":\"90\",\"ext_param\":\"{     \\\"deleteMarketImageFlag\\\":\\\"false\\\",     \\\"deleteQualificationFlag\\\":\\\"false\\\", \\\"edit_reason\\\":\\\"product_diagnosis\\\"}\"}");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */
    @Override
    public String productPopChoiceDraftEdit(AeAppClientDTO acDTO, AliexpressPopChoiceProductDraftEditDTO reqDTO) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressPopChoiceProductEnu.POP_CHOICE_DRAFT_EDIT.getApiName());
        request.addApiParameter("aeop_a_e_product", reqDTO.getAeop_a_e_product());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    /*
    IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.pop.choice.product.query");
request.addApiParameter("product_id", "1005005906923241");
request.addApiParameter("language", "zh_CN");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */
    @Override
    public AePopChoiceProductQueryRespVO productPopChoiceProductQuery(AeAppClientDTO acDTO, AliexpressPopChoiceProductQueryDTO reqDTO) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressPopChoiceProductEnu.POP_CHOICE_PRODUCT_QUERY.getApiName());
        request.addApiParameter("product_id", reqDTO.getProduct_id());
        request.addApiParameter("language", reqDTO.getLanguage());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);

        AePopChoiceProductQueryRespVO aePopChoiceProductQueryRespVO = new AePopChoiceProductQueryRespVO();
        // TODO json解析
        JSONObject respJson = JSONObject.parseObject(response.getGopResponseBody());
        JSONObject result = respJson.getJSONObject("result");
        if (result != null) {
            aePopChoiceProductQueryRespVO.setErrorCode(result.getString("error_code"));
            aePopChoiceProductQueryRespVO.setErrorMessage(result.getString("error_message"));
            aePopChoiceProductQueryRespVO.setSuccess(result.getBoolean("success"));

            JSONObject popChoiceProductObj = result.getJSONObject("pop_choice_product");
            AePopChoiceProductQueryVO aePopChoiceProductQueryVO = new AePopChoiceProductQueryVO();
            aePopChoiceProductQueryVO.setProductId(popChoiceProductObj.getLong("product_id"));
            aePopChoiceProductQueryVO.setCurrencyCode(popChoiceProductObj.getString("currency_code"));
            aePopChoiceProductQueryVO.setCategoryId(popChoiceProductObj.getLong("category_id"));

            JSONArray popProductSkuArry = popChoiceProductObj.getJSONArray("product_sku_list");
            if (CollectionUtils.isNotEmpty(popProductSkuArry)) {
                List<AePopChoiceProductSkuQueryRespVO> popChoiceProductSkuQueryVOList = new ArrayList<>();
                for (int i = 0; i < popProductSkuArry.size(); i++) {
                    JSONObject object = popProductSkuArry.getJSONObject(i);
                    AePopChoiceProductSkuQueryRespVO popChoiceProductSkuQueryRespVO = new AePopChoiceProductSkuQueryRespVO();
                    popChoiceProductSkuQueryRespVO.setSkuId(object.getString("sku_id"));
                    popChoiceProductSkuQueryRespVO.setSkuCode(object.getString("sku_code"));

                    AePopChoiceProductSkuScItemInfoRespVO aePopChoiceProductSkuScItemInfoRespVO = new AePopChoiceProductSkuScItemInfoRespVO();
                    JSONObject popChoiceProductSkuScItemInfo = object.getJSONObject("pop_choice_product_sku_sc_item_info");
                    if (ObjectUtil.isNotEmpty(popChoiceProductSkuScItemInfo)) {
                        aePopChoiceProductSkuScItemInfoRespVO.setScItemCode(popChoiceProductSkuScItemInfo.getString("sc_item_code"));
                        aePopChoiceProductSkuScItemInfoRespVO.setScItemId(popChoiceProductSkuScItemInfo.getLong("sc_item_id"));
                        aePopChoiceProductSkuScItemInfoRespVO.setOriginalBox(popChoiceProductSkuScItemInfo.getString("original_box"));
                    }

                    popChoiceProductSkuQueryVOList.add(popChoiceProductSkuQueryRespVO);
                }
                aePopChoiceProductQueryVO.setProductSkuList(popChoiceProductSkuQueryVOList);
            }
            aePopChoiceProductQueryRespVO.setAePopChoiceProductQueryVO(aePopChoiceProductQueryVO);
        }
        return aePopChoiceProductQueryRespVO;
    }

    /*
    IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.pop.choice.product.stocks.update");
request.addApiParameter("pop_choice_sku_stock_list", "[{\"sku_id\":\"123\",\"pop_choice_sku_warehouse_stock_list\":[{\"warehouse_code\":\"test-001JIT\",\"sellable_quantity\":\"100\"},{\"warehouse_code\":\"test-001JIT\",\"sellable_quantity\":\"100\"}]}]");
request.addApiParameter("product_id", "123");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */
    @Override
    public String productPopChoiceProductStocksUpdate(AeAppClientDTO acDTO, AliexpressPopChoiceProductStocksUpdateDTO reqDTO) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressPopChoiceProductEnu.POP_CHOICE_PRODUCT_STOCKS_UPDATE.getApiName());
        request.addApiParameter("pop_choice_sku_stock_list", reqDTO.getPop_choice_sku_stock_list());
        request.addApiParameter("product_id", reqDTO.getProduct_id());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.pop.choice.pre.product.query");
request.addApiParameter("product_id", "1005005906923241");
request.addApiParameter("language", "zh_CN");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */
    @Override
    public String productPopChoicePreProductQuery(AeAppClientDTO acDTO, AliexpressPopChoicePreProductQueryDTO reqDTO) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressPopChoiceProductEnu.POP_CHOICE_PRE_PRODUCT_QUERY.getApiName());
        request.addApiParameter("product_id", reqDTO.getProduct_id());
        request.addApiParameter("language", reqDTO.getLanguage());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    /*
    IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.pop.choice.pre.product.submit");
request.addApiParameter("pop_choice_product", "{\"product_sku_list\":[{\"package_width\":\"1.1\",\"package_height\":\"1.1\",\"sku_property_list\":[{\"sku_property_value\":\"\u7C73\u8272\",\"sku_image\":\"https://ae04.alicdn.com/kf/S5c57c6002a4545d5b0cfa9effb494b334.png\",\"sku_property_name\":\"\u989C\u8272\",\"sku_property_id_long\":\"14\",\"property_value_definition_name\":\"\u7C73\u8272test\",\"property_value_id_long\":\"771\",\"image_url_list\":[\"[]\",\"[]\"]},{\"sku_property_value\":\"\u7C73\u8272\",\"sku_image\":\"https://ae04.alicdn.com/kf/S5c57c6002a4545d5b0cfa9effb494b334.png\",\"sku_property_name\":\"\u989C\u8272\",\"sku_property_id_long\":\"14\",\"property_value_definition_name\":\"\u7C73\u8272test\",\"property_value_id_long\":\"771\",\"image_url_list\":[\"[]\",\"[]\"]}],\"package_length\":\"1.1\",\"pop_choice_product_sku_sc_item_info\":{\"sc_item_code\":\"123\",\"sc_item_bar_code\":\"123abc\",\"special_product_type_list\":[\"[       \\\"274452\\\",             \\\"274526\\\" ]\",\"[       \\\"274452\\\",             \\\"274526\\\" ]\"],\"original_box\":\"1\"},\"base_price\":\"1.1\",\"package_weight\":\"1.1\",\"sku_id\":\"1232412312\",\"pop_choice_sku_warehouse_stock_list\":[{\"warehouse_code\":\"test001-JIT\",\"sellable_quantity\":\"12\"},{\"warehouse_code\":\"test001-JIT\",\"sellable_quantity\":\"12\"}],\"sku_code\":\"123abc\"},{\"package_width\":\"1.1\",\"package_height\":\"1.1\",\"sku_property_list\":[{\"sku_property_value\":\"\u7C73\u8272\",\"sku_image\":\"https://ae04.alicdn.com/kf/S5c57c6002a4545d5b0cfa9effb494b334.png\",\"sku_property_name\":\"\u989C\u8272\",\"sku_property_id_long\":\"14\",\"property_value_definition_name\":\"\u7C73\u8272test\",\"property_value_id_long\":\"771\",\"image_url_list\":[\"[]\",\"[]\"]},{\"sku_property_value\":\"\u7C73\u8272\",\"sku_image\":\"https://ae04.alicdn.com/kf/S5c57c6002a4545d5b0cfa9effb494b334.png\",\"sku_property_name\":\"\u989C\u8272\",\"sku_property_id_long\":\"14\",\"property_value_definition_name\":\"\u7C73\u8272test\",\"property_value_id_long\":\"771\",\"image_url_list\":[\"[]\",\"[]\"]}],\"package_length\":\"1.1\",\"pop_choice_product_sku_sc_item_info\":{\"sc_item_code\":\"123\",\"sc_item_bar_code\":\"123abc\",\"special_product_type_list\":[\"[       \\\"274452\\\",             \\\"274526\\\" ]\",\"[       \\\"274452\\\",             \\\"274526\\\" ]\"],\"original_box\":\"1\"},\"base_price\":\"1.1\",\"package_weight\":\"1.1\",\"sku_id\":\"1232412312\",\"pop_choice_sku_warehouse_stock_list\":[{\"warehouse_code\":\"test001-JIT\",\"sellable_quantity\":\"12\"},{\"warehouse_code\":\"test001-JIT\",\"sellable_quantity\":\"12\"}],\"sku_code\":\"123abc\"}],\"category_id\":\"123\",\"product_id\":\"1234\",\"joined_country_list\":[\"[                 \\\"PL\\\",                 \\\"UK\\\",                 \\\"NL\\\",                 \\\"IT\\\",                 \\\"PT\\\",                 \\\"BE\\\",                 \\\"LT\\\",                 \\\"NO\\\",                 \\\"HU\\\",                 \\\"RO\\\"             ]\",\"[                 \\\"PL\\\",                 \\\"UK\\\",                 \\\"NL\\\",                 \\\"IT\\\",                 \\\"PT\\\",                 \\\"BE\\\",                 \\\"LT\\\",                 \\\"NO\\\",                 \\\"HU\\\",                 \\\"RO\\\"             ]\"],\"currency_code\":\"USD\"}");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */
    @Override
    public String productPopChoicePreProductSubmit(AeAppClientDTO acDTO, AliexpressPopChoicePreProductSubmitDTO reqDTO) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressPopChoiceProductEnu.POP_CHOICE_PRE_PRODUCT_SUBMIT.getApiName());
        request.addApiParameter("pop_choice_product", reqDTO.getPop_choice_product());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    /*
    IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.pop.choice.draft.query");
request.addApiParameter("product_id", "1005005906923241");
request.addApiParameter("language", "zh_CN");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */
    @Override
    public AePopChoiceProductDraftQueryRespVO productPopChoiceDraftQuery(AeAppClientDTO acDTO, AliexpressPopChoiceDraftQueryDTO reqDTO) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressPopChoiceProductEnu.POP_CHOICE_DRAFT_QUERY.getApiName());
        request.addApiParameter("product_id", reqDTO.getProduct_id());
        request.addApiParameter("language", reqDTO.getLanguage());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        // TODO json解析
        JSONObject respJson = JSONObject.parseObject(response.getGopResponseBody());
        JSONObject result = respJson.getJSONObject("result");
        AePopChoiceProductDraftQueryRespVO aePopChoiceInfoRespVO = new AePopChoiceProductDraftQueryRespVO();
        if (result != null) {
            aePopChoiceInfoRespVO.setErrorCode(result.getString("error_code"));
            aePopChoiceInfoRespVO.setErrorMessage(result.getString("error_message"));
            aePopChoiceInfoRespVO.setSuccess(result.getBoolean("success"));

            AePopChoiceProductDraftQueryVO aePopChoiceProductDraftQueryVO = new AePopChoiceProductDraftQueryVO();
            JSONObject popChoiceProduct = result.getJSONObject("pop_choice_product");
            aePopChoiceProductDraftQueryVO.setProductId(popChoiceProduct.getLong("product_id"));
            aePopChoiceProductDraftQueryVO.setCurrencyCode(popChoiceProduct.getString("currency_code"));
            aePopChoiceProductDraftQueryVO.setCategoryId(popChoiceProduct.getLong("category_id"));


            JSONArray popProductSkuArry = popChoiceProduct.getJSONArray("product_sku_list");
            if (CollectionUtils.isNotEmpty(popProductSkuArry)) {
                List<AePopChoiceProductDraftQuerySkuVO> productSkuList = new ArrayList<>();
                for (int i = 0; i < popProductSkuArry.size(); i++) {
                    JSONObject object = popProductSkuArry.getJSONObject(i);
                    AePopChoiceProductDraftQuerySkuVO aePopChoiceProductDraftQuerySkuVO = new AePopChoiceProductDraftQuerySkuVO();
                    aePopChoiceProductDraftQuerySkuVO.setSkuCode(object.getString("sku_code"));
                    aePopChoiceProductDraftQuerySkuVO.setSkuId(object.getString("sku_id"));

                    JSONArray skuPropertyList = object.getJSONArray("sku_property_list");
                    if (CollectionUtils.isNotEmpty(skuPropertyList)) {
                        List<AePopChoiceProductDraftQuerySkuProPertyVO> skuPropertyLists = new ArrayList<>();
                        for (int j = 0; j < skuPropertyList.size(); j++) {
                            JSONObject skuProperty = skuPropertyList.getJSONObject(j);
                            AePopChoiceProductDraftQuerySkuProPertyVO aePopChoiceProductDraftQuerySkuPropertyVO = new AePopChoiceProductDraftQuerySkuProPertyVO();

                            aePopChoiceProductDraftQuerySkuPropertyVO.setSku_image(skuProperty.getString("sku_image"));
                            aePopChoiceProductDraftQuerySkuPropertyVO.setSku_property_id_long(skuProperty.getLong("sku_property_id_long"));
                            aePopChoiceProductDraftQuerySkuPropertyVO.setSku_property_name(skuProperty.getString("sku_property_name"));
                            aePopChoiceProductDraftQuerySkuPropertyVO.setSku_property_value(skuProperty.getString("sku_property_value"));
                            aePopChoiceProductDraftQuerySkuPropertyVO.setProperty_value_id_long(skuProperty.getLong("property_value_id_long"));
                            aePopChoiceProductDraftQuerySkuPropertyVO.setProperty_value_definition_name(skuProperty.getString("property_value_definition_name"));
                            skuPropertyLists.add(aePopChoiceProductDraftQuerySkuPropertyVO);
                        }
                        aePopChoiceProductDraftQuerySkuVO.setSkuPropertyList(skuPropertyLists);
                    }
                    productSkuList.add(aePopChoiceProductDraftQuerySkuVO);
                }
                aePopChoiceProductDraftQueryVO.setProductSkuList(productSkuList);
            }
            aePopChoiceInfoRespVO.setPopChoiceProduct(aePopChoiceProductDraftQueryVO);
        }
        return aePopChoiceInfoRespVO;
    }


    /*
    IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.pop.choice.info.query");
request.setHttpMethod("GET");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */
    @Override
    public AePopChoiceInfoRespVO productPopChoiceInfoQuery(AeAppClientDTO acDTO) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setHttpMethod("GET");
        request.setApiName(AliexpressPopChoiceProductEnu.POP_CHOICE_INFO_QUERY.getApiName());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        AePopChoiceInfoRespVO aePopChoiceInfoRespVO = new AePopChoiceInfoRespVO();
        // TODO json解析
        JSONObject respJson = JSONObject.parseObject(response.getGopResponseBody());
        JSONObject result = respJson.getJSONObject("result");
        if (result != null) {
            aePopChoiceInfoRespVO.setErrorCode(result.getString("error_code"));
            aePopChoiceInfoRespVO.setErrorMessage(result.getString("error_message"));
            aePopChoiceInfoRespVO.setSuccess(result.getBoolean("success"));

            JSONArray popChoiceCountryArry = result.getJSONArray("pop_choice_country_list");

            if (CollectionUtils.isNotEmpty(popChoiceCountryArry)) {
                List<PopChoiceCountryVO> popChoiceCountryVOList = new ArrayList<>();
                for (int i = 0; i < popChoiceCountryArry.size(); i++) {
                    JSONObject object = popChoiceCountryArry.getJSONObject(i);
                    PopChoiceCountryVO popChoiceCountryVO = new PopChoiceCountryVO();
                    popChoiceCountryVO.setCountryCode(object.getString("country_code"));
                    popChoiceCountryVO.setCnName(object.getString("cn_name"));
                    popChoiceCountryVO.setEnName(object.getString("en_name"));
                    popChoiceCountryVOList.add(popChoiceCountryVO);
                }
                aePopChoiceInfoRespVO.setPopChoiceCountryList(popChoiceCountryVOList);
            }

            JSONArray popChoiceWarehouseArry = result.getJSONArray("pop_choice_warehouse_list");
            if (CollectionUtils.isNotEmpty(popChoiceWarehouseArry)) {
                List<AePopChoiceWarehouseRespVO> aePopChoiceWarehouseRespVOList = new ArrayList<>();
                for (int i = 0; i < popChoiceWarehouseArry.size(); i++) {
                    JSONObject object = popChoiceWarehouseArry.getJSONObject(i);
                    AePopChoiceWarehouseRespVO aePopChoiceWarehouseRespVO = new AePopChoiceWarehouseRespVO();
                    aePopChoiceWarehouseRespVO.setWarehouseCode(object.getString("warehouse_code"));
                    aePopChoiceWarehouseRespVO.setWarehouseName(object.getString("warehouse_name"));
                    aePopChoiceWarehouseRespVOList.add(aePopChoiceWarehouseRespVO);
                }
                aePopChoiceInfoRespVO.setPopChoiceWarehouseList(aePopChoiceWarehouseRespVOList);
            } else {
                aePopChoiceInfoRespVO.setPopChoiceWarehouseList(null);
            }
        }
        return aePopChoiceInfoRespVO;
    }

    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.pop.choice.collected.products.list");
request.setHttpMethod("GET");
request.addApiParameter("param", "{\"leaf_category\":\"579\",\"product_id\":\"10000000000\",\"current_page\":\"1\",\"page_size\":\"20\"}");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */
    @Override
    public String productPopChoiceCollectedProductsList(AeAppClientDTO acDTO, AliexpressPopChoiceCollectedProductsListDTO reqDTO) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setHttpMethod("GET");
        request.setApiName(AliexpressPopChoiceProductEnu.POP_CHOICE_COLLECTED_PRODUCTS_LIST.getApiName());
        request.addApiParameter("param", reqDTO.getParam());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.pop.choice.products.list");
request.setHttpMethod("GET");
request.addApiParameter("param", "{\"leaf_category\":\"579\",\"gmt_modified_end\":\"2012-01-01 12:13:14\",\"gmt_modified_start\":\"2012-01-01 12:13:14\",\"product_id\":\"10000000000\",\"joined_product_tab\":\"joined\",\"current_page\":\"1\",\"page_size\":\"20\"}");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */
    @Override
    public AePopProductRespVO productPopChoiceProductsList(AeAppClientDTO acDTO, AliexpressPopChoiceProductsListDTO reqDTO) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setHttpMethod("GET");
        request.setApiName(AliexpressPopChoiceProductEnu.POP_CHOICE_PRODUCTS_LIST.getApiName());
        request.addApiParameter("param", JSONUtil.toJsonStr(reqDTO));
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        String responseBody = response.getGopResponseBody();

        AePopProductRespVO respVO = new AePopProductRespVO();
        respVO.setRespBody(responseBody);

        JSONObject respJson = JSONObject.parseObject(responseBody);
        JSONObject result = respJson.getJSONObject("result");
        if (result != null) {
            respVO.setErrorCode(result.getString("error_code"));
            respVO.setErrorMessage(result.getString("error_message"));
            respVO.setSuccess(result.getBoolean("success"));
            JSONArray popChoiceProducts = result.getJSONArray("pop_choice_product_list");
            List<PopChoiceProductVO> list = new ArrayList<>();
            if (CollectionUtils.isNotEmpty(popChoiceProducts)) {
                for (int i = 0; i < popChoiceProducts.size(); i++) {
                    JSONObject popChoiceProductObj = popChoiceProducts.getJSONObject(i);
                    PopChoiceProductVO popChoiceProductVO = new PopChoiceProductVO();
                    popChoiceProductVO.setProductId(popChoiceProductObj.getLong("product_id"));
                    popChoiceProductVO.setProductStatus(popChoiceProductObj.getString("product_status"));
                    popChoiceProductVO.setProductImage(popChoiceProductObj.getString("product_image"));
                    popChoiceProductVO.setCreateTime(popChoiceProductObj.getString("create_time"));
                    popChoiceProductVO.setTitle(popChoiceProductObj.getString("title"));
                    popChoiceProductVO.setCurrencyCode(popChoiceProductObj.getString("currency_code"));
                    popChoiceProductVO.setMaxSkuPrice(popChoiceProductObj.getString("max_sku_price"));
                    popChoiceProductVO.setMinSkuPrice(popChoiceProductObj.getString("min_sku_price"));
                    popChoiceProductVO.setModifiedTime(popChoiceProductObj.getString("modified_time"));
                    popChoiceProductVO.setTotalStocks(popChoiceProductObj.getString("total_stocks"));
                    list.add(popChoiceProductVO);
                }
                respVO.setPopChoiceProducts(list);
            }
        }
        System.out.println(JSON.toJSONString(respVO));
        return respVO;
    }
}
