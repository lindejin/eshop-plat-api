package com.eshop.util.platform.api.service.product.aliexpress;

import com.eshop.util.platform.api.service.product.aliexpress.dto.*;
import com.eshop.util.platform.api.structure.aliexpress.dto.AeAppClientDTO;
import com.eshop.util.platform.api.structure.aliexpress.enumerate.AliexpressProductEnu;
import com.global.iop.api.IopClient;
import com.global.iop.api.IopClientImpl;
import com.global.iop.api.IopRequest;
import com.global.iop.api.IopResponse;
import com.global.iop.domain.Protocol;
import com.global.iop.util.ApiException;
import org.springframework.stereotype.Service;

/**
 * @author ldj
 * @date 2024/3/6 17:14
 * @Description: ...
 * @Version 1.0
 */
@Service
public class AliexpressProductCallImpl implements AliexpressProductCall {

    //批量产品价格更新
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.solution.batch.product.price.update");
request.addApiParameter("mutiple_product_update_list", "[{\"product_id\":\"1000005237852\",\"multi_country_price_configuration\":{\"price_type\":\"absolute\",\"country_price_list\":[{\"sku_price_by_country_list\":[{\"price\":\"15\",\"discount_price\":\"13.99\",\"sku_code\":\"abc123\"},{\"price\":\"15\",\"discount_price\":\"13.99\",\"sku_code\":\"abc123\"}],\"ship_to_country\":\"FR\"},{\"sku_price_by_country_list\":[{\"price\":\"15\",\"discount_price\":\"13.99\",\"sku_code\":\"abc123\"},{\"price\":\"15\",\"discount_price\":\"13.99\",\"sku_code\":\"abc123\"}],\"ship_to_country\":\"FR\"}]},\"multiple_sku_update_list\":[{\"discount_price\":\"14.99\",\"price\":\"19.99\",\"sku_code\":\"123abc\"},{\"discount_price\":\"14.99\",\"price\":\"19.99\",\"sku_code\":\"123abc\"}]}]");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 批量产品价格更新
     */

    @Override
    public String batchProductPriceUpdate(AeAppClientDTO acDTO, AeProductBatchProductPriceUpdateDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressProductEnu.BATCH_PRODUCT_PRICE_UPDATE.getApiName());
        request.addApiParameter("mutiple_product_update_list", reqDto.getMutiple_product_update_list());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    //用于编辑产品
    //用于编辑产品的API，为海外商家定制。此 API 的大多数输入字段与 aliexpress.solution.product.post 类似。对于编辑，只需填写您要编辑的字段，其他字段留空即可
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.solution.product.edit");
request.addApiParameter("edit_product_request", "{\"extra_params\":\"extra params\",\"inventory_deduction_strategy\":\"place_order_withhold or payment_success_deduct\",\"main_image_urls_list\":[\"[\\\"https://upload.wikimedia.org/wikipedia/commons/b/b5/Winnersh_Meadows_Trees.jpg\\\",\\\"https://ae01.alicdn.com/kf/UTB85xyVgnzIXKJkSafVq6yWgXXa0/Kingston-SDCS-16GB-MicroSD-Canvas-Select-16GB-velocidades-de-UHS-I-Clase-10-DE-hasta-80.jpg\\\"]\",\"[\\\"https://upload.wikimedia.org/wikipedia/commons/b/b5/Winnersh_Meadows_Trees.jpg\\\",\\\"https://ae01.alicdn.com/kf/UTB85xyVgnzIXKJkSafVq6yWgXXa0/Kingston-SDCS-16GB-MicroSD-Canvas-Select-16GB-velocidades-de-UHS-I-Clase-10-DE-hasta-80.jpg\\\"]\"],\"sku_info_list\":[{\"extra_params\":\"extra params\",\"price\":\"12.21\",\"discount_price\":\"9.92\",\"sku_attributes_list\":[{\"sku_attribute_value\":\"red\",\"sku_image\":\"https://upload.wikimedia.org/wikipedia/commons/b/b5/Winnersh_Meadows_Trees.jpg\",\"sku_attribute_name\":\"Color\",\"sku_attribute_name_id\":\"14\",\"sku_attribute_value_id\":\"10\"},{\"sku_attribute_value\":\"red\",\"sku_image\":\"https://upload.wikimedia.org/wikipedia/commons/b/b5/Winnersh_Meadows_Trees.jpg\",\"sku_attribute_name\":\"Color\",\"sku_attribute_name_id\":\"14\",\"sku_attribute_value_id\":\"10\"}],\"ean_code\":\"12345678\",\"inventory\":\"90\",\"sku_code\":\"123abc\"},{\"extra_params\":\"extra params\",\"price\":\"12.21\",\"discount_price\":\"9.92\",\"sku_attributes_list\":[{\"sku_attribute_value\":\"red\",\"sku_image\":\"https://upload.wikimedia.org/wikipedia/commons/b/b5/Winnersh_Meadows_Trees.jpg\",\"sku_attribute_name\":\"Color\",\"sku_attribute_name_id\":\"14\",\"sku_attribute_value_id\":\"10\"},{\"sku_attribute_value\":\"red\",\"sku_image\":\"https://upload.wikimedia.org/wikipedia/commons/b/b5/Winnersh_Meadows_Trees.jpg\",\"sku_attribute_name\":\"Color\",\"sku_attribute_name_id\":\"14\",\"sku_attribute_value_id\":\"10\"}],\"ean_code\":\"12345678\",\"inventory\":\"90\",\"sku_code\":\"123abc\"}],\"multi_language_description_list\":[{\"mobile_detail\":\"{\\\"moduleList\\\":[{\\\"texts\\\":{\\\"content\\\":\\\"test mobile description\\\",\\\"class\\\":\\\"body\\\"},\\\"type\\\":\\\"text\\\"}],\\\"version\\\":\\\"2.0.0\\\"}\",\"language\":\"es\",\"web_detail\":\"{\\\"moduleList\\\":[{\\\"html\\\":{\\\"content\\\":\\\"test web description\\\"},\\\"type\\\":\\\"html\\\"}],\\\"version\\\":\\\"2.0.0\\\"}\"},{\"mobile_detail\":\"{\\\"moduleList\\\":[{\\\"texts\\\":{\\\"content\\\":\\\"test mobile description\\\",\\\"class\\\":\\\"body\\\"},\\\"type\\\":\\\"text\\\"}],\\\"version\\\":\\\"2.0.0\\\"}\",\"language\":\"es\",\"web_detail\":\"{\\\"moduleList\\\":[{\\\"html\\\":{\\\"content\\\":\\\"test web description\\\"},\\\"type\\\":\\\"html\\\"}],\\\"version\\\":\\\"2.0.0\\\"}\"}],\"multi_language_subject_list\":[{\"subject\":\"Versi\u00F3n Global Xiaomi Redmi Note 5\",\"language\":\"es\"},{\"subject\":\"Versi\u00F3n Global Xiaomi Redmi Note 5\",\"language\":\"es\"}],\"weight\":\"3.2\",\"size_chart_id\":\"100\",\"brand_name\":\"Xiaomi\",\"package_width\":\"30\",\"package_height\":\"20\",\"category_id\":\"200105144\",\"attribute_list\":[{\"attribute_name\":\"Resolution\",\"attribute_value\":\"1920*1080\",\"aliexpress_attribute_value_id\":\"593\",\"aliexpress_attribute_name_id\":\"14\"},{\"attribute_name\":\"Resolution\",\"attribute_value\":\"1920*1080\",\"aliexpress_attribute_value_id\":\"593\",\"aliexpress_attribute_name_id\":\"14\"}],\"group_id\":\"262007001\",\"package_length\":\"10\",\"product_id\":\"1000005237852\",\"aliexpress_category_id\":\"200105144\",\"marketing_images\":[{\"image_url\":\"https://ae01.alicdn.com/kf/Hf5987123b00246699ac4f86795d59e636.jpg\",\"image_type\":\"1\"},{\"image_url\":\"https://ae01.alicdn.com/kf/Hf5987123b00246699ac4f86795d59e636.jpg\",\"image_type\":\"1\"}],\"service_policy_id\":\"0\",\"developer_features\":\"{\\\"source\\\":\\\"Lengow\\\"}\",\"shipping_lead_time\":\"3\",\"multi_country_price_configuration\":{\"price_type\":\"absolute\",\"country_price_list\":[{\"sku_price_by_country_list\":[{\"price\":\"15\",\"discount_price\":\"3.99\",\"value\":\"15\",\"sku_code\":\"123abc\"},{\"price\":\"15\",\"discount_price\":\"3.99\",\"value\":\"15\",\"sku_code\":\"123abc\"}],\"ship_to_country\":\"FR\"},{\"sku_price_by_country_list\":[{\"price\":\"15\",\"discount_price\":\"3.99\",\"value\":\"15\",\"sku_code\":\"123abc\"},{\"price\":\"15\",\"discount_price\":\"3.99\",\"value\":\"15\",\"sku_code\":\"123abc\"}],\"ship_to_country\":\"FR\"}]},\"freight_template_id\":\"703476858\"}");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 用于编辑产品
     */

    @Override
    public String productEdit(AeAppClientDTO acDTO, AeProductProductEditDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressProductEnu.PRODUCT_EDIT.getApiName());
        request.addApiParameter("edit_product_request", reqDto.getEdit_product_request());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    //获取单一产品信息
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.solution.product.info.get");
request.addApiParameter("product_id", "1307422965");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 获取单一产品信息
     */

    @Override
    public String productInfoGet(AeAppClientDTO acDTO, AeProductProductInfoGetDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressProductEnu.PRODUCT_INFO_GET.getApiName());
        request.addApiParameter("product_id", reqDto.getProduct_id());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }
    //获取产品列表
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.solution.product.list.get");
request.addApiParameter("aeop_a_e_product_list_query", "{\"gmt_modified_start\":\"2012-01-01 12:13:14\",\"gmt_modified_end\":\"2012-01-01 12:13:14\",\"off_line_time\":\"7\",\"gmt_create_start\":\"2012-01-01 12:13:14\",\"subject\":\"knew odd\",\"have_national_quote\":\"n\",\"ws_display\":\"expire_offline\",\"product_status_type\":\"onSelling\",\"owner_member_id\":\"aliqatest01\",\"gmt_create_end\":\"2012-01-01 12:13:14\",\"group_id\":\"1234\",\"product_id\":\"123\",\"excepted_product_ids\":[\"[32962333569,32813963253]\",\"[32962333569,32813963253]\"],\"sku_code\":\"123ABC\",\"current_page\":\"2\",\"page_size\":\"30\"}");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 获取产品列表
     */

    @Override
    public String productListGet(AeAppClientDTO acDTO, AeProductProductListGetDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressProductEnu.PRODUCT_LIST_GET.getApiName());
        request.addApiParameter("aeop_a_e_product_list_query", reqDto.getAeop_a_e_product_list_query());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    //特定 Feed 失效
    //用于根据作业 ID 使特定 Feed 失效的 API。请使用 （aliexpress.solution.feed.list.get） 来确定需要发送哪些作业 ID 进行失效。
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.solution.feed.invalidate");
request.addApiParameter("job_id_list", "200000099310034475;200000099110014475;200000014009554475");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 特定 Feed 失效
     */

    @Override
    public String feedInvalidate(AeAppClientDTO acDTO, AeProductFeedInvalidateDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressProductEnu.FEED_INVALIDATE.getApiName());
        request.addApiParameter("job_id_list", reqDto.getJob_id_list());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    //产品发布 API
    //面向海外商家的产品发布API，简化了卖家和商家面临的整合复杂性。例如，这些卖家可以使用自己的类别和属性，而不是映射 AE 中的类别和属性。
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.solution.product.post");
request.addApiParameter("post_product_request", "{\"subject\":\"Huawei Mate 10\",\"multi_language_description_list\":[{\"mobile_detail\":\"{\\\"moduleList\\\":[{\\\"texts\\\":{\\\"content\\\":\\\"test mobile description\\\",\\\"class\\\":\\\"body\\\"},\\\"type\\\":\\\"text\\\"}],\\\"version\\\":\\\"2.0.0\\\"}\",\"language\":\"es\",\"web_detail\":\"{\\\"moduleList\\\":[{\\\"html\\\":{\\\"content\\\":\\\"test web description\\\"},\\\"type\\\":\\\"html\\\"}],\\\"version\\\":\\\"2.0.0\\\"}\"},{\"mobile_detail\":\"{\\\"moduleList\\\":[{\\\"texts\\\":{\\\"content\\\":\\\"test mobile description\\\",\\\"class\\\":\\\"body\\\"},\\\"type\\\":\\\"text\\\"}],\\\"version\\\":\\\"2.0.0\\\"}\",\"language\":\"es\",\"web_detail\":\"{\\\"moduleList\\\":[{\\\"html\\\":{\\\"content\\\":\\\"test web description\\\"},\\\"type\\\":\\\"html\\\"}],\\\"version\\\":\\\"2.0.0\\\"}\"}],\"description\":\"El Huawei Mate 10 Lite destaca principalmente por su pantalla FullView y sus cuatro c\u00E1maras. \\u003cimg alt\\u003d\\\"Huawei-Mate-10-Lite_02\\\" src\\u003d\\\"https://ae01.alicdn.com/kf/UTB8rju8uOaMiuJk43PTq6ySmXXa7.jpg\\\"\\u003e\",\"language\":\"es\",\"package_height\":\"20\",\"category_id\":\"200105144\",\"package_length\":\"10\",\"aliexpress_category_id\":\"200105144\",\"marketing_images\":[{\"image_url\":\"https://ae01.alicdn.com/kf/Hf5987123b00246699ac4f86795d59e636.jpg\",\"image_type\":\"1\"},{\"image_url\":\"https://ae01.alicdn.com/kf/Hf5987123b00246699ac4f86795d59e636.jpg\",\"image_type\":\"1\"}],\"multi_country_price_configuration\":{\"price_type\":\"absolute\",\"country_price_list\":[{\"sku_price_by_country_list\":[{\"price\":\"16\",\"discount_price\":\"3.99\",\"sku_code\":\"123abc\",\"value\":\"15\"},{\"price\":\"16\",\"discount_price\":\"3.99\",\"sku_code\":\"123abc\",\"value\":\"15\"}],\"ship_to_country\":\"FR\"},{\"sku_price_by_country_list\":[{\"price\":\"16\",\"discount_price\":\"3.99\",\"sku_code\":\"123abc\",\"value\":\"15\"},{\"price\":\"16\",\"discount_price\":\"3.99\",\"sku_code\":\"123abc\",\"value\":\"15\"}],\"ship_to_country\":\"FR\"}]},\"freight_template_id\":\"703476858\",\"extra_params\":\"extra params\",\"inventory_deduction_strategy\":\"payment_success_deduct\",\"main_image_urls_list\":[\"[\\\"https://upload.wikimedia.org/wikipedia/commons/b/b5/Winnersh_Meadows_Trees.jpg\\\",\\\"https://ae01.alicdn.com/kf/UTB85xyVgnzIXKJkSafVq6yWgXXa0/Kingston-SDCS-16GB-MicroSD-Canvas-Select-16GB-velocidades-de-UHS-I-Clase-10-DE-hasta-80.jpg\\\"]\",\"[\\\"https://upload.wikimedia.org/wikipedia/commons/b/b5/Winnersh_Meadows_Trees.jpg\\\",\\\"https://ae01.alicdn.com/kf/UTB85xyVgnzIXKJkSafVq6yWgXXa0/Kingston-SDCS-16GB-MicroSD-Canvas-Select-16GB-velocidades-de-UHS-I-Clase-10-DE-hasta-80.jpg\\\"]\"],\"sku_info_list\":[{\"extra_params\":\"extra params\",\"price\":\"12.21\",\"discount_price\":\"9.92\",\"bar_code\":\"2012331233258\",\"sku_attributes_list\":[{\"sku_attribute_value\":\"red\",\"sku_attribute_name\":\"Color\",\"sku_image_url\":\"https://upload.wikimedia.org/wikipedia/commons/b/b5/Winnersh_Meadows_Trees.jpg\",\"sku_attribute_name_id\":\"14\",\"sku_attribute_value_id\":\"10\"},{\"sku_attribute_value\":\"red\",\"sku_attribute_name\":\"Color\",\"sku_image_url\":\"https://upload.wikimedia.org/wikipedia/commons/b/b5/Winnersh_Meadows_Trees.jpg\",\"sku_attribute_name_id\":\"14\",\"sku_attribute_value_id\":\"10\"}],\"ean_code\":\"12345678\",\"inventory\":\"90\",\"sku_code\":\"123abc\"},{\"extra_params\":\"extra params\",\"price\":\"12.21\",\"discount_price\":\"9.92\",\"bar_code\":\"2012331233258\",\"sku_attributes_list\":[{\"sku_attribute_value\":\"red\",\"sku_attribute_name\":\"Color\",\"sku_image_url\":\"https://upload.wikimedia.org/wikipedia/commons/b/b5/Winnersh_Meadows_Trees.jpg\",\"sku_attribute_name_id\":\"14\",\"sku_attribute_value_id\":\"10\"},{\"sku_attribute_value\":\"red\",\"sku_attribute_name\":\"Color\",\"sku_image_url\":\"https://upload.wikimedia.org/wikipedia/commons/b/b5/Winnersh_Meadows_Trees.jpg\",\"sku_attribute_name_id\":\"14\",\"sku_attribute_value_id\":\"10\"}],\"ean_code\":\"12345678\",\"inventory\":\"90\",\"sku_code\":\"123abc\"}],\"multi_language_subject_list\":[{\"subject\":\"Versi\u00F3n Global Xiaomi Redmi Note 5\",\"language\":\"es\"},{\"subject\":\"Versi\u00F3n Global Xiaomi Redmi Note 5\",\"language\":\"es\"}],\"size_chart_id\":\"100\",\"weight\":\"3.2\",\"brand_name\":\"Xiaomi\",\"product_unit\":\"100000015\",\"package_width\":\"30\",\"attribute_list\":[{\"attribute_name\":\"Resolution\",\"attribute_value\":\"1920*1080\",\"aliexpress_attribute_value_id\":\"593\",\"aliexpress_attribute_name_id\":\"14\"},{\"attribute_name\":\"Resolution\",\"attribute_value\":\"1920*1080\",\"aliexpress_attribute_value_id\":\"593\",\"aliexpress_attribute_name_id\":\"14\"}],\"group_id\":\"262007001\",\"service_policy_id\":\"0\",\"developer_features\":\"{\\\"source\\\":\\\"Lengow\\\"}\",\"shipping_lead_time\":\"3\"}");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 产品发布
     */

    @Override
    public String productPost(AeAppClientDTO acDTO, AeProductProductPostDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressProductEnu.PRODUCT_POST.getApiName());
        request.addApiParameter("post_product_request", reqDto.getPost_product_request());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    //基于json schema实例上传产品
    //基于json schema实例上传产品。该接口的QPS（Invoke per s）每个appkey限制为100个，每个卖家限制为50个。
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.solution.schema.product.instance.post");
request.addApiParameter("product_instance_request", "{     \"category_id\": 348,     \"title_multi_language_list\":     [         {             \"locale\": \"es_ES\",             \"title\": \"atestproducttesttest001\"         }     ],     \"description_multi_language_list\":     [         {             \"locale\": \"es_ES\",             \"module_list\":             [                 {                     \"type\": \"html\",                     \"html\":                     {                         \"content\": \"unotesttestdescription002\"                     }                 }             ]         }     ],     \"locale\": \"es_ES\",     \"product_units_type\": \"100000015\",     \"image_url_list\":     [         \"https://upload.wikimedia.org/wikipedia/commons/b/ba/E-SENS_architecture.jpg\"     ],     \"category_attributes\":     {         \"Brand Name\":         {             \"value\": \"200010868\"         },         \"ShirtsType\":         {             \"value\": \"200001208\"         },         \"Material\":         {             \"value\":             [                 \"567\"             ]         },         \"SleeveLength(cm)\":         {             \"value\": \"200001500\"         }     },     \"sku_info_list\":     [         {             \"sku_code\": \"WEO19293829123\",             \"inventory\": 3,             \"price\": 9900,             \"discount_price\": 9800,             \"sku_attributes\":             {                 \"Size\":                 {                     \"alias\": \"Uni\",                     \"value\": \"200003528\"                 }             }         }     ],     \"inventory_deduction_strategy\": \"payment_success_deduct\",     \"package_weight\": 1.5,     \"package_length\": 10,     \"package_height\": 20,     \"package_width\": 30,     \"shipping_preparation_time\": 3,     \"shipping_template_id\": \"714844311\",     \"service_template_id\": \"0\" }");
request.addApiParameter("developer_features", "{\"source\":\"Lengow\"}");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 基于json schema实例上传产品
     */

    @Override
    public String schemaProductInstancePost(AeAppClientDTO acDTO, AeProductSchemaProductInstancePostDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressProductEnu.SCHEMA_PRODUCT_INSTANCE_POST.getApiName());
        request.addApiParameter("product_instance_request", reqDto.getProduct_instance_request());
        request.addApiParameter("developer_features", reqDto.getDeveloper_features());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    //查询草稿箱里的产品信息
    //描述：根据商品id查询单个商品的详细信息。
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.offer.draftproduct.get");
request.addApiParameter("product_id", "1307422965");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 查询草稿箱里的产品信息
     */

    @Override
    public String draftProductGet(AeAppClientDTO acDTO, AeProductDraftProductGetDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressProductEnu.DRAFT_PRODUCT_GET.getApiName());
        request.addApiParameter("product_id", reqDto.getProduct_id());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    //删除除草稿框外的在线产品
    //该接口用于删除除草稿框外的在线产品。请注意，没有相反的方法可以检索已删除的产品。谨慎使用此 API。
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.solution.batch.product.delete");
request.addApiParameter("product_ids", "4000403362451,4000403362452");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 删除除草稿框外的在线产品
     */

    @Override
    public String batchProductDelete(AeAppClientDTO acDTO, AeProductBatchProductDeleteDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressProductEnu.BATCH_PRODUCT_DELETE.getApiName());
        request.addApiParameter("product_ids", reqDto.getProduct_ids());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    //面向海外卖家的批量产品库存更新 API。卖家可以在一次通话中更新多个产品中的多个 SKU。最多可以同时更新 20 个产品，一个产品最多可以更新 200 个 SKU。
    //批量产品库存更新
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.solution.batch.product.inventory.update");
request.addApiParameter("mutiple_product_update_list", "[{\"product_id\":\"1000005237852\",\"multiple_sku_update_list\":[{\"inventory\":\"99\",\"sku_code\":\"123abc\"},{\"inventory\":\"99\",\"sku_code\":\"123abc\"}]}]");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 批量产品库存更新
     */

    @Override
    public String batchProductInventoryUpdate(AeAppClientDTO acDTO, AeProductBatchProductInventoryUpdateDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressProductEnu.BATCH_PRODUCT_INVENTORY_UPDATE.getApiName());
        request.addApiParameter("mutiple_product_update_list", reqDto.getMutiple_product_update_list());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    //查询属于卖家的 Feed 列表
    //描述：查询属于卖家的 Feed 列表的 API
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.solution.feed.list.get");
request.addApiParameter("current_page", "2");
request.addApiParameter("feed_type", "PRODUCT_CREATE");
request.addApiParameter("page_size", "50");
request.addApiParameter("status", "FINISH");
request.addApiParameter("submitted_time_end", "2020-11-12 06:00:00");
request.addApiParameter("submitted_time_start", "2020-11-01 02:00:00");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 查询属于卖家的 Feed 列表
     */

    @Override
    public String feedListGet(AeAppClientDTO acDTO, AeProductFeedListGetDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressProductEnu.FEED_LIST_GET.getApiName());
        request.addApiParameter("current_page", reqDto.getCurrent_page());
        request.addApiParameter("feed_type", reqDto.getFeed_type());
        request.addApiParameter("page_size", reqDto.getPage_size());
        request.addApiParameter("status", reqDto.getStatus());
        request.addApiParameter("submitted_time_end", reqDto.getSubmitted_time_end());
        request.addApiParameter("submitted_time_start", reqDto.getSubmitted_time_start());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    //查询Feed执行结果
    //用于查询Feed执行结果的API
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.solution.feed.query");
request.addApiParameter("job_id", "200000000060054475");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 查询Feed执行结果
     */

    @Override
    public String feedQuery(AeAppClientDTO acDTO, AeProductFeedQueryDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressProductEnu.FEED_QUERY.getApiName());
        request.addApiParameter("job_id", reqDto.getJob_id());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    //供商家提交 Feed 数据
    //供商家提交 Feed 数据的 API。请注意，对于每个卖家，每 24 小时为每operation_type提交的 Feed 建议数量应大于 150 条，否则处理 Feed 可能会遇到明显的延迟。
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.solution.feed.submit");
request.addApiParameter("operation_type", "PRODUCT_CREATE");
request.addApiParameter("item_list", "[{\"item_content_id\":\"A00000000Y1\",\"item_content\":\"{\\\"category_id\\\":200000346,\\\"title_multi_language_list\\\":[{\\\"locale\\\":\\\"es_ES\\\",\\\"title\\\":\\\"test\\\"}],\\\"description_multi_language_list\\\":[{\\\"locale\\\":\\\"es_ES\\\",\\\"module_list\\\":[{\\\"type\\\":\\\"html\\\",\\\"html\\\":{\\\"content\\\":\\\"test\\\"}}]}],\\\"locale\\\":\\\"es_ES\\\",\\\"product_units_type\\\":\\\"100000000\\\",\\\"image_url_list\\\":[\\\"https://ae01.alicdn.com/kf/HTB1TZJRVkvoK1RjSZFwq6AiCFXa0.jpg_350x350.jpg\\\"],\\\"category_attributes\\\":{\\\"Brand Name\\\":{\\\"value\\\":\\\"200010868\\\"},\\\"Material\\\":{\\\"value\\\":[\\\"47\\\",\\\"49\\\"]},\\\"Clothing Length\\\":{\\\"value\\\":\\\"1876\\\"}},\\\"sku_info_list\\\":[{\\\"sku_code\\\":\\\"234\\\",\\\"inventory\\\":234,\\\"price\\\":23,\\\"discount_price\\\":12,\\\"sku_attributes\\\":{\\\"Size\\\":{\\\"value\\\":\\\"200000989\\\"},\\\"Color\\\":{\\\"alias\\\":\\\"32\\\",\\\"sku_image_url\\\":\\\"https://ae01.alicdn.com/kf/HTB1TZJRVkvoK1RjSZFwq6AiCFXa0.jpg_350x350.jpg\\\",\\\"value\\\":\\\"771\\\"}}}],\\\"inventory_deduction_strategy\\\":\\\"place_order_withhold\\\",\\\"package_weight\\\":234,\\\"package_length\\\":234,\\\"package_height\\\":234,\\\"package_width\\\":234,\\\"shipping_preparation_time\\\":3,\\\"shipping_template_id\\\":\\\"1000\\\",\\\"service_template_id\\\":\\\"0\\\"}\"}]");
request.addApiParameter("developer_features", "{\"source\":\"Lengow\"}");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 供商家提交 Feed 数据
     */

    @Override
    public String feedSubmit(AeAppClientDTO acDTO, AeProductFeedSubmitDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressProductEnu.FEED_SUBMIT.getApiName());
        request.addApiParameter("operation_type", reqDto.getOperation_type());
        request.addApiParameter("item_list", reqDto.getItem_list());
        request.addApiParameter("developer_features", reqDto.getDeveloper_features());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    //物流ISV的API，用于根据产品类别获取hscode。
    //用于根据产品类别获取hscode
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.solution.hscode.query");
request.addApiParameter("country_code", "TR");
request.addApiParameter("category_id", "5090301");
IopResponse response = client.execute(request, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 用于根据产品类别获取hscode
     */

    @Override
    public String hsCodeQuery(AeAppClientDTO acDTO, AeProductHsCodeQueryDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressProductEnu.HS_CODE_QUERY.getApiName());
        request.addApiParameter("country_code", reqDto.getCountry_code());
        request.addApiParameter("category_id", reqDto.getCategory_id());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    //海外卖家获取正常信息
    //描述：API为海外卖家获取正常信息，如店铺ID、注册国家代码等。
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.solution.merchant.profile.get");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 海外卖家获取正常信息
     */
    @Override
    public String merchantProfileGet(AeAppClientDTO acDTO, AeProductMerchantProfileGetDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressProductEnu.MERCHANT_PROFILE_GET.getApiName());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    //产品全量更新
    //产品全量更新的架构接口。该接口的QPS（Invoke per s）每个appkey限制为100个，每个卖家限制为50个。
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.solution.schema.product.full.update");
request.addApiParameter("schema_full_update_request", "{\"category_id\":200000346,\"title_multi_language_list\":[{\"locale\":\"es_ES\",\"title\":\"test\"}],\"description_multi_language_list\":[{\"locale\":\"es_ES\",\"module_list\":[{\"type\":\"html\",\"html\":{\"content\":\"test\"}}]}],\"locale\":\"es_ES\",\"product_units_type\":\"100000000\",\"image_url_list\":[\"https://ae01.alicdn.com/kf/HTB1TZJRVkvoK1RjSZFwq6AiCFXa0.jpg_350x350.jpg\"],\"category_attributes\":{\"Brand Name\":{\"value\":\"200010868\"},\"Material\":{\"value\":[\"47\",\"49\"]},\"Clothing Length\":{\"value\":\"1876\"}},\"sku_info_list\":[{\"sku_code\":\"234\",\"inventory\":234,\"price\":23,\"discount_price\":12,\"sku_attributes\":{\"Size\":{\"value\":\"200000989\"},\"Color\":{\"alias\":\"32\",\"sku_image_url\":\"https://ae01.alicdn.com/kf/HTB1TZJRVkvoK1RjSZFwq6AiCFXa0.jpg_350x350.jpg\",\"value\":\"771\"}}}],\"inventory_deduction_strategy\":\"place_order_withhold\",\"package_weight\":234,\"package_length\":234,\"package_height\":234,\"package_width\":234,\"shipping_preparation_time\":3,\"shipping_template_id\":\"1000\",\"service_template_id\":\"0\",\"aliexpress_product_id\":32985684727}");
request.addApiParameter("developer_features", "{\"source\":\"Lengow\"}");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 产品全量更新
     */
    @Override
    public String schemaProductFullUpdate(AeAppClientDTO acDTO, AeProductSchemaProductFullUpdateDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressProductEnu.SCHEMA_PRODUCT_FULL_UPDATE.getApiName());
        request.addApiParameter("schema_full_update_request", reqDto.getSchema_full_update_request());
        request.addApiParameter("developer_features", reqDto.getDeveloper_features());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    //获取产品架构
    //提供一种新的模式方式来发布产品。使用一对 API，一个用于获取架构，一个用于发布实例
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.solution.product.schema.get");
request.addApiParameter("aliexpress_category_id", "200000346");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 获取产品架构
     */
    @Override
    public String productSchemaGet(AeAppClientDTO acDTO, AeProductProductSchemaGetDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressProductEnu.PRODUCT_SCHEMA_GET.getApiName());
        request.addApiParameter("aliexpress_category_id", reqDto.getAliexpress_category_id());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    //修改商品所引用的尺码模板
    //描述：修改商品所引用的尺码模板
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.postproduct.redefining.setsizechart");
request.addApiParameter("channel_seller_id", "2671514005");
request.addApiParameter("channel", "AE_GLOBAL");
request.addApiParameter("product_id", "1005005100110934");
request.addApiParameter("sizechart_id", "1000001533573010");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 修改商品所引用的尺码模板
     */
    @Override
    public String setSizeChart(AeAppClientDTO acDTO, AeProductSetSizeChartDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressProductEnu.SET_SIZE_CHART.getApiName());
        request.addApiParameter("channel_seller_id", reqDto.getChannel_seller_id());
        request.addApiParameter("channel", reqDto.getChannel());
        request.addApiParameter("product_id", reqDto.getProduct_id());
        request.addApiParameter("sizechart_id", reqDto.getSizechart_id());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    //修改编辑商品信息
    //描述：商品编辑接口（修改任何一个商品信息时，必须将其他所有信息进行填写全面后再提交，否则会出现报错或数据丢失问题）
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.postproduct.redefining.editaeproduct");
request.addApiParameter("ext_param", "{   \"custom_image\": {     \"image\": {       \"RU\": \"http://g01.a.alicdn.com/kf/HTB13GKLJXXXXXbYaXXXq6xXFXXXi.jpg;http://g02.a.alicdn.com/kf/HTB1DkaWJXXXXXb6XFXXq6xXFXXXp.jpg;http://g02.a.alicdn.com/kf/HTB1pMCQJXXXXXcvXVXXq6xXFXXXm.jpg;http://g03.a.alicdn.com/kf/HTB1QhORJXXXXXbiXVXXq6xXFXXXx.jpg;http://g02.a.alicdn.com/kf/HTB1q1aLJXXXXXcfaXXXq6xXFXXXv.jpg\",       \"BR\": \"http://g01.a.alicdn.com/kf/HTB13GKLJXXXXXbYaXXXq6xXFXXXi.jpg;http://g02.a.alicdn.com/kf/HTB1DkaWJXXXXXb6XFXXq6xXFXXXp.jpg;http://g02.a.alicdn.com/kf/HTB1pMCQJXXXXXcvXVXXq6xXFXXXm.jpg;http://g03.a.alicdn.com/kf/HTB1QhORJXXXXXbiXVXXq6xXFXXXx.jpg;http://g02.a.alicdn.com/kf/HTB1q1aLJXXXXXcfaXXXq6xXFXXXv.jpg\",       \"ES\": \"\"     },     \"process_customized_image\": true   },   \"vat_tags\": [{     \"sku_id\": \"200007763:201336100\",     \"is_sku_vat_tag\": true   }] }");
request.addApiParameter("aeop_a_e_product", "{\"lot_num\":\"1\",\"aeop_ae_product_propertys\":[{\"attr_name_id\":\"200000043\",\"attr_name\":\"size\",\"attr_value_id\":\"493\",\"attr_value_unit\":\"0\",\"attr_value\":\"2 - 5 kg\",\"attr_value_end\":\"0\",\"attr_value_start\":\"0\"},{\"attr_name_id\":\"200000043\",\"attr_name\":\"size\",\"attr_value_id\":\"493\",\"attr_value_unit\":\"0\",\"attr_value\":\"2 - 5 kg\",\"attr_value_end\":\"0\",\"attr_value_start\":\"0\"}],\"coupon_end_date\":\"2017-06-28 20:22:01\",\"mobile_detail\":\"mobile Detail html block\",\"mode_size_chart_list\":[{\"mode_size\":\"2\",\"hips\":\"2.1\",\"waist\":\"2\",\"bust\":\"2\",\"height\":\"2\"},{\"mode_size\":\"2\",\"hips\":\"2.1\",\"waist\":\"2\",\"bust\":\"2\",\"height\":\"2\"}],\"subject\":\"knew odd\",\"ws_display\":\"expire_offline\",\"ws_valid_num\":\"30\",\"product_price\":\"10.11\",\"product_status_type\":\"onSelling\",\"aeop_national_quote_configuration\":{\"configuration_data\":\"[{\\\"shiptoCountry\\\":\\\"US\\\",\\\"percentage\\\":\\\"5\\\"},{\\\"shiptoCountry\\\":\\\"RU\\\",\\\"percentage\\\":\\\"-2\\\"}]\",\"configuration_type\":\"percentage\"},\"delivery_time\":\"3\",\"package_type\":\"false\",\"owner_member_seq\":\"1006680305\",\"base_unit\":\"1\",\"currency_code\":\"USD\",\"is_pack_sell\":\"false\",\"add_weight\":\"30.11\",\"coupon_start_date\":\"2017-06-28 20:22:01\",\"package_height\":\"40\",\"aeop_ae_product_s_k_us\":[{\"sku_discount_price\":\"12.05\",\"sku_price\":\"200.07\",\"ipm_sku_stock\":\"1111\",\"sku_stock\":\"false\",\"aeop_s_k_u_national_discount_price\":[{\"discount_price\":\"10.01\",\"shipto_country\":\"RU\"},{\"discount_price\":\"10.01\",\"shipto_country\":\"RU\"}],\"id\":\"\\\"200000182:193;200007763:201336100\\\"\",\"ean_code\":\"12345678\",\"aeop_s_k_u_property\":[{\"sku_image\":\"http://ae01.alicdn.com/kf/HTB19KVYX6LuK1Rjy0Fhq6xpdFXac.jpg\",\"property_value_definition_name\":\"pink\",\"property_value_id\":\"366\",\"sku_property_id\":\"14\",\"image_url_list\":[\"http://ae01.alicdn.com/kf/HTB19KVYX6LuK1Rjy0Fhq6xpdFXac.jpg\",\"http://ae01.alicdn.com/kf/HTB19KVYX6LuK1Rjy0Fhq6xpdFXac.jpg\"]},{\"sku_image\":\"http://ae01.alicdn.com/kf/HTB19KVYX6LuK1Rjy0Fhq6xpdFXac.jpg\",\"property_value_definition_name\":\"pink\",\"property_value_id\":\"366\",\"sku_property_id\":\"14\",\"image_url_list\":[\"http://ae01.alicdn.com/kf/HTB19KVYX6LuK1Rjy0Fhq6xpdFXac.jpg\",\"http://ae01.alicdn.com/kf/HTB19KVYX6LuK1Rjy0Fhq6xpdFXac.jpg\"]}],\"sku_code\":\"cfas00978\",\"currency_code\":\"USD;RUB\"},{\"sku_discount_price\":\"12.05\",\"sku_price\":\"200.07\",\"ipm_sku_stock\":\"1111\",\"sku_stock\":\"false\",\"aeop_s_k_u_national_discount_price\":[{\"discount_price\":\"10.01\",\"shipto_country\":\"RU\"},{\"discount_price\":\"10.01\",\"shipto_country\":\"RU\"}],\"id\":\"\\\"200000182:193;200007763:201336100\\\"\",\"ean_code\":\"12345678\",\"aeop_s_k_u_property\":[{\"sku_image\":\"http://ae01.alicdn.com/kf/HTB19KVYX6LuK1Rjy0Fhq6xpdFXac.jpg\",\"property_value_definition_name\":\"pink\",\"property_value_id\":\"366\",\"sku_property_id\":\"14\",\"image_url_list\":[\"http://ae01.alicdn.com/kf/HTB19KVYX6LuK1Rjy0Fhq6xpdFXac.jpg\",\"http://ae01.alicdn.com/kf/HTB19KVYX6LuK1Rjy0Fhq6xpdFXac.jpg\"]},{\"sku_image\":\"http://ae01.alicdn.com/kf/HTB19KVYX6LuK1Rjy0Fhq6xpdFXac.jpg\",\"property_value_definition_name\":\"pink\",\"property_value_id\":\"366\",\"sku_property_id\":\"14\",\"image_url_list\":[\"http://ae01.alicdn.com/kf/HTB19KVYX6LuK1Rjy0Fhq6xpdFXac.jpg\",\"http://ae01.alicdn.com/kf/HTB19KVYX6LuK1Rjy0Fhq6xpdFXac.jpg\"]}],\"sku_code\":\"cfas00978\",\"currency_code\":\"USD;RUB\"}],\"category_id\":\"200002101\",\"image_u_r_ls\":\"http://g01.a.alicdn.com/kf/HTB13GKLJXXXXXbYaXXXq6xXFXXXi.jpg;http://g02.a.alicdn.com/kf/HTB1DkaWJXXXXXb6XFXXq6xXFXXXp.jpg;http://g02.a.alicdn.com/kf/HTB1pMCQJXXXXXcvXVXXq6xXFXXXm.jpg;http://g03.a.alicdn.com/kf/HTB1QhORJXXXXXbiXVXXq6xXFXXXx.jpg;http://g02.a.alicdn.com/kf/HTB1q1aLJXXXXXcfaXXXq6xXFXXXv.jpg\",\"package_length\":\"20\",\"product_id\":\"1239273\",\"product_more_keywords2\":\"0\",\"reduce_strategy\":\"place_order_withhold\",\"product_more_keywords1\":\"0\",\"gross_weight\":\"50\",\"keyword\":\"0\",\"freight_template_id\":\"1\",\"ws_offline_date\":\"2017-06-28 20:22:01\",\"promise_template_id\":\"100\",\"summary\":\"0\",\"sizechart_id\":\"123\",\"aeop_a_e_multimedia\":{\"aeop_a_e_videos\":[{\"media_status\":\"approved\",\"media_type\":\"video\",\"ali_member_id\":\"1006680305\",\"media_id\":\"12345678\",\"poster_url\":\"http://img01.taobaocdn.com/bao/uploaded/TB1rNdGIVXXXXbTXFXXXXXXXXXX.jpg\"},{\"media_status\":\"approved\",\"media_type\":\"video\",\"ali_member_id\":\"1006680305\",\"media_id\":\"12345678\",\"poster_url\":\"http://img01.taobaocdn.com/bao/uploaded/TB1rNdGIVXXXXbTXFXXXXXXXXXX.jpg\"}]},\"src\":\"isv\",\"bulk_order\":\"5\",\"owner_member_id\":\"aliqatest01\",\"product_unit\":\"100000000\",\"package_width\":\"30\",\"add_unit\":\"2\",\"group_id\":\"123\",\"bulk_discount\":\"90\",\"is_image_dynamic\":\"false\",\"detail\":\"detail html block\"}");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 修改编辑商品信息
     */
    @Override
    public String editAeProduct(AeAppClientDTO acDTO, AeProductEditAeProductDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressProductEnu.POST_PRODUCT_REDEFINING_EDIT_AE_PRODUCT.getApiName());
        request.addApiParameter("ext_param", reqDto.getExt_param());
        request.addApiParameter("aeop_a_e_product", reqDto.getAeop_a_e_product());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    //分页查询待优化商品列表
    //描述：分页查询待优化商品列表
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.product.diagnosis.pageQueryProblem");
request.addApiParameter("operate_status", "0");
request.addApiParameter("problem_type_list", "repeat_repost, lack_white_image");
request.addApiParameter("page_size", "10");
request.addApiParameter("current_page", "1");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 分页查询待优化商品列表
     */
    @Override
    public String productDiagnosisPageQueryProblem(AeAppClientDTO acDTO, AeProductProductDiagnosisPageQueryProblemDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressProductEnu.PRODUCT_DIAGNOSIS_PAGE_QUERY_PROBLEM.getApiName());
        request.addApiParameter("operate_status", reqDto.getOperate_status());
        request.addApiParameter("problem_type_list", reqDto.getProblem_type_list());
        request.addApiParameter("page_size", reqDto.getPage_size());
        request.addApiParameter("current_page", reqDto.getCurrent_page());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    //创建产品分组
    //描述：创建一个新的产品分组.一个用户的一级分组最多有10个，二级分组最多有10个。
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.postproduct.redefining.createproductgroup");
request.addApiParameter("name", "foo");
request.addApiParameter("parent_id", "100");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 创建产品分组
     */
    @Override
    public String createProductGroup(AeAppClientDTO acDTO, AeProductCreateProductGroupDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressProductEnu.POST_PRODUCT_REDEFINING_CREATE_PRODUCT_GROUP.getApiName());
        request.addApiParameter("name", reqDto.getName());
        request.addApiParameter("parent_id", reqDto.getParent_id());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    //发布产品信息
    //描述：post产品并且返回post成功后的产品的id
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.postproduct.redefining.postaeproduct");
request.addApiParameter("ext_param", "{   \"custom_image\": {     \"image\": {       \"RU\": \"http://g01.a.alicdn.com/kf/HTB13GKLJXXXXXbYaXXXq6xXFXXXi.jpg;http://g02.a.alicdn.com/kf/HTB1DkaWJXXXXXb6XFXXq6xXFXXXp.jpg;http://g02.a.alicdn.com/kf/HTB1pMCQJXXXXXcvXVXXq6xXFXXXm.jpg;http://g03.a.alicdn.com/kf/HTB1QhORJXXXXXbiXVXXq6xXFXXXx.jpg;http://g02.a.alicdn.com/kf/HTB1q1aLJXXXXXcfaXXXq6xXFXXXv.jpg\",       \"BR\": \"http://g01.a.alicdn.com/kf/HTB13GKLJXXXXXbYaXXXq6xXFXXXi.jpg;http://g02.a.alicdn.com/kf/HTB1DkaWJXXXXXb6XFXXq6xXFXXXp.jpg;http://g02.a.alicdn.com/kf/HTB1pMCQJXXXXXcvXVXXq6xXFXXXm.jpg;http://g03.a.alicdn.com/kf/HTB1QhORJXXXXXbiXVXXq6xXFXXXx.jpg;http://g02.a.alicdn.com/kf/HTB1q1aLJXXXXXcfaXXXq6xXFXXXv.jpg\",       \"ES\": \"\"     },     \"process_customized_image\": true   },   \"vat_tags\": [{     \"sku_id\": \"200007763:201336100\",     \"is_sku_vat_tag\": true   }] }");
request.addApiParameter("aeop_a_e_product", "{\"lot_num\":\"1\",\"aeop_ae_product_propertys\":[{\"attr_name_id\":\"0\",\"attr_name\":\"0\",\"attr_value_id\":\"0\",\"attr_value_unit\":\"0\",\"attr_value\":\"0\",\"attr_value_end\":\"0\",\"attr_value_start\":\"0\"},{\"attr_name_id\":\"0\",\"attr_name\":\"0\",\"attr_value_id\":\"0\",\"attr_value_unit\":\"0\",\"attr_value\":\"0\",\"attr_value_end\":\"0\",\"attr_value_start\":\"0\"}],\"coupon_end_date\":\"2017-06-28 20:22:01\",\"mobile_detail\":\"mobile Detail html block\",\"mode_size_chart_list\":[{\"mode_size\":\"R\",\"hips\":\"2.3\",\"waist\":\"2\",\"bust\":\"2\",\"height\":\"2\"},{\"mode_size\":\"R\",\"hips\":\"2.3\",\"waist\":\"2\",\"bust\":\"2\",\"height\":\"2\"}],\"subject\":\"knew odd of test\",\"ws_display\":\"0\",\"ws_valid_num\":\"30\",\"aeop_national_quote_configuration\":{\"configuration_data\":\"[{\\\"shiptoCountry\\\":\\\"US\\\",\\\"percentage\\\":\\\"5\\\"},{\\\"shiptoCountry\\\":\\\"RU\\\",\\\"percentage\\\":\\\"-2\\\"}]\",\"configuration_type\":\"percentage, relative\"},\"delivery_time\":\"7\",\"product_price\":\"11.00\",\"product_status_type\":\"0\",\"owner_member_seq\":\"0\",\"package_type\":\"false\",\"base_unit\":\"1\",\"currency_code\":\"USD;RUB\",\"is_pack_sell\":\"false\",\"coupon_start_date\":\"2017-06-28 20:22:01\",\"package_height\":\"40\",\"add_weight\":\"3.03\",\"category_id\":\"200002101\",\"aeop_ae_product_s_k_us\":[{\"sku_discount_price\":\"10.01\",\"sku_price\":\"0\",\"ipm_sku_stock\":\"0\",\"sku_stock\":\"true\",\"aeop_s_k_u_national_discount_price\":[{\"discount_price\":\"9.09\",\"shipto_country\":\"RU\"},{\"discount_price\":\"9.09\",\"shipto_country\":\"RU\"}],\"id\":\"0\",\"ean_code\":\"12345678\",\"aeop_s_k_u_property\":[{\"sku_image\":\"0\",\"property_value_definition_name\":\"0\",\"property_value_id\":\"0\",\"sku_property_id\":\"0\",\"image_url_list\":[\"http://dda/a.jpg\",\"http://dda/a.jpg\"]},{\"sku_image\":\"0\",\"property_value_definition_name\":\"0\",\"property_value_id\":\"0\",\"sku_property_id\":\"0\",\"image_url_list\":[\"http://dda/a.jpg\",\"http://dda/a.jpg\"]}],\"sku_code\":\"0\",\"currency_code\":\"USD;RUB\"},{\"sku_discount_price\":\"10.01\",\"sku_price\":\"0\",\"ipm_sku_stock\":\"0\",\"sku_stock\":\"true\",\"aeop_s_k_u_national_discount_price\":[{\"discount_price\":\"9.09\",\"shipto_country\":\"RU\"},{\"discount_price\":\"9.09\",\"shipto_country\":\"RU\"}],\"id\":\"0\",\"ean_code\":\"12345678\",\"aeop_s_k_u_property\":[{\"sku_image\":\"0\",\"property_value_definition_name\":\"0\",\"property_value_id\":\"0\",\"sku_property_id\":\"0\",\"image_url_list\":[\"http://dda/a.jpg\",\"http://dda/a.jpg\"]},{\"sku_image\":\"0\",\"property_value_definition_name\":\"0\",\"property_value_id\":\"0\",\"sku_property_id\":\"0\",\"image_url_list\":[\"http://dda/a.jpg\",\"http://dda/a.jpg\"]}],\"sku_code\":\"0\",\"currency_code\":\"USD;RUB\"}],\"image_u_r_ls\":\"http://g01.a.alicdn.com/kf/HTB13GKLJXXXXXbYaXXXq6xXFXXXi.jpg;http://g02.a.alicdn.com/kf/HTB1DkaWJXXXXXb6XFXXq6xXFXXXp.jpg;http://g02.a.alicdn.com/kf/HTB1pMCQJXXXXXcvXVXXq6xXFXXXm.jpg;http://g03.a.alicdn.com/kf/HTB1QhORJXXXXXbiXVXXq6xXFXXXx.jpg;http://g02.a.alicdn.com/kf/HTB1q1aLJXXXXXcfaXXXq6xXFXXXv.jpg\",\"package_length\":\"20\",\"product_id\":\"0\",\"product_more_keywords2\":\"0\",\"reduce_strategy\":\"place_order_withhold\u6216payment_success_deduct\",\"product_more_keywords1\":\"0\",\"gross_weight\":\"10.020\",\"keyword\":\"0\",\"freight_template_id\":\"1\",\"ws_offline_date\":\"2017-06-28 20:22:01\",\"promise_template_id\":\"100\",\"summary\":\"0\",\"sizechart_id\":\"100\",\"aeop_a_e_multimedia\":{\"aeop_a_e_videos\":[{\"media_status\":\"0\",\"media_type\":\"0\",\"ali_member_id\":\"0\",\"media_id\":\"0\",\"poster_url\":\"0\"},{\"media_status\":\"0\",\"media_type\":\"0\",\"ali_member_id\":\"0\",\"media_id\":\"0\",\"poster_url\":\"0\"}]},\"src\":\"0\",\"bulk_order\":\"5\",\"owner_member_id\":\"0\",\"product_unit\":\"100000000\",\"package_width\":\"30\",\"group_id\":\"124\",\"add_unit\":\"2\",\"bulk_discount\":\"90\",\"is_image_dynamic\":\"false\",\"detail\":\"detail stuff here\"}");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 发布产品信息
     */
    @Override
    public String postAeProduct(AeAppClientDTO acDTO, AeProductPostAeProductDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressProductEnu.POST_PRODUCT_REDEFINING_POST_AE_PRODUCT.getApiName());
        request.addApiParameter("ext_param", reqDto.getExt_param());
        request.addApiParameter("aeop_a_e_product", reqDto.getAeop_a_e_product());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    //发布多语言产品(试用)
    //描述：多语言原发接口。卖家可以通过这个接口发布一个多语言商品。一次只能发布一种多语言商品，例如：俄文。
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.postproduct.redefining.postmultilanguageaeproduct");
request.addApiParameter("ext_param", "{   \"custom_image\": {     \"image\": {       \"RU\": \"http://g01.a.alicdn.com/kf/HTB13GKLJXXXXXbYaXXXq6xXFXXXi.jpg;http://g02.a.alicdn.com/kf/HTB1DkaWJXXXXXb6XFXXq6xXFXXXp.jpg;http://g02.a.alicdn.com/kf/HTB1pMCQJXXXXXcvXVXXq6xXFXXXm.jpg;http://g03.a.alicdn.com/kf/HTB1QhORJXXXXXbiXVXXq6xXFXXXx.jpg;http://g02.a.alicdn.com/kf/HTB1q1aLJXXXXXcfaXXXq6xXFXXXv.jpg\",       \"BR\": \"http://g01.a.alicdn.com/kf/HTB13GKLJXXXXXbYaXXXq6xXFXXXi.jpg;http://g02.a.alicdn.com/kf/HTB1DkaWJXXXXXb6XFXXq6xXFXXXp.jpg;http://g02.a.alicdn.com/kf/HTB1pMCQJXXXXXcvXVXXq6xXFXXXm.jpg;http://g03.a.alicdn.com/kf/HTB1QhORJXXXXXbiXVXXq6xXFXXXx.jpg;http://g02.a.alicdn.com/kf/HTB1q1aLJXXXXXcfaXXXq6xXFXXXv.jpg\",       \"ES\": \"\"     },     \"process_customized_image\": true   },   \"vat_tags\": [{     \"sku_id\": \"200007763:201336100\",     \"is_sku_vat_tag\": true   }] }");
request.addApiParameter("product", "{\"lot_num\":\"10\",\"coupon_end_date\":\"2017-06-28 20:22:01\",\"mobile_detail\":\"0\",\"subject\":\"knew odd of test\",\"use_auto_trans\":\"true\",\"delivery_time\":\"7\",\"product_price\":\"11.00\",\"owner_member_seq\":\"1006680305\",\"package_type\":\"false\",\"base_unit\":\"1\",\"package_height\":\"40\",\"add_weight\":\"3.03\",\"image_u_r_ls\":\"http://g01.a.alicdn.com/kf/HTB13GKLJXXXXXbYaXXXq6xXFXXXi.jpg;http://g02.a.alicdn.com/kf/HTB1DkaWJXXXXXb6XFXXq6xXFXXXp.jpg;http://g02.a.alicdn.com/kf/HTB1pMCQJXXXXXcvXVXXq6xXFXXXm.jpg;http://g03.a.alicdn.com/kf/HTB1QhORJXXXXXbiXVXXq6xXFXXXx.jpg;http://g02.a.alicdn.com/kf/HTB1q1aLJXXXXXcfaXXXq6xXFXXXv.jpg\",\"product_id\":\"1234\",\"product_more_keywords2\":\"0\",\"product_more_keywords1\":\"0\",\"gross_weight\":\"10.020\",\"keyword\":\"0\",\"ws_offline_date\":\"2017-06-28 20:22:01\",\"promise_template_id\":\"100\",\"sizechart_id\":\"100\",\"aeop_a_e_multimedia\":{\"aeop_a_e_videos\":[{\"media_status\":\"approved\",\"media_type\":\"video\",\"ali_member_id\":\"1006680305\",\"media_id\":\"12345678\",\"poster_url\":\"http://img01.taobaocdn.com/bao/uploaded/TB1rNdGIVXXXXbTXFXXXXXXXXXX.jpg\"},{\"media_status\":\"approved\",\"media_type\":\"video\",\"ali_member_id\":\"1006680305\",\"media_id\":\"12345678\",\"poster_url\":\"http://img01.taobaocdn.com/bao/uploaded/TB1rNdGIVXXXXbTXFXXXXXXXXXX.jpg\"}]},\"multilanguage_detail\":\"\u041C\u043D\u043E\u0433\u043E\u044F\u0437\u044B\u0447\u043D\u044B\u0439 \u043F\u043E\u0434\u0440\u043E\u0431\u043D\u043E\u0435 \u043E\u043F\u0438\u0441\u0430\u043D\u0438\u0435\",\"product_unit\":\"100000000\",\"add_unit\":\"2\",\"detail\":\"\\u003cul\\u003e \\u003c/ul\\u003e\",\"aeop_ae_product_propertys\":[{\"attr_name_id\":\"0\",\"attr_name\":\"0\",\"attr_value_id\":\"0\",\"attr_value_unit\":\"0\",\"attr_value\":\"2 - 5 kg\",\"attr_value_end\":\"0\",\"attr_value_start\":\"0\"},{\"attr_name_id\":\"0\",\"attr_name\":\"0\",\"attr_value_id\":\"0\",\"attr_value_unit\":\"0\",\"attr_value\":\"2 - 5 kg\",\"attr_value_end\":\"0\",\"attr_value_start\":\"0\"}],\"ws_display\":\"expire_offline\",\"ws_valid_num\":\"30\",\"aeop_national_quote_configuration\":{\"configuration_data\":\"[{\\\"shiptoCountry\\\":\\\"US\\\",\\\"percentage\\\":\\\"5\\\"},{\\\"shiptoCountry\\\":\\\"RU\\\",\\\"percentage\\\":\\\"-2\\\"}]\",\"configuration_type\":\"percentage\"},\"product_status_type\":\"onSelling\",\"currency_code\":\"USD;RUB\",\"is_pack_sell\":\"false\",\"coupon_start_date\":\"2017-06-28 20:22:01\",\"category_id\":\"200002101\",\"aeop_ae_product_s_k_us\":[{\"sku_discount_price\":\"10.01\",\"sku_price\":\"11.11\",\"ipm_sku_stock\":\"1234\",\"sku_stock\":\"false\",\"aeop_s_k_u_national_discount_price\":[{\"discount_price\":\"9.05\",\"shipto_country\":\"RU\"},{\"discount_price\":\"9.05\",\"shipto_country\":\"RU\"}],\"id\":\"\\\"200000182:193;200007763:201336100\\\"\",\"aeop_s_k_u_property\":[{\"sku_image\":\"http://ae01.alicdn.com/kf/HTB19KVYX6LuK1Rjy0Fhq6xpdFXac.jpg\",\"property_value_definition_name\":\"pink\",\"sku_property_id\":\"14\",\"property_value_id\":\"366\"},{\"sku_image\":\"http://ae01.alicdn.com/kf/HTB19KVYX6LuK1Rjy0Fhq6xpdFXac.jpg\",\"property_value_definition_name\":\"pink\",\"sku_property_id\":\"14\",\"property_value_id\":\"366\"}],\"sku_code\":\"cfas00978\",\"barcode\":\"0\",\"currency_code\":\"USD\"},{\"sku_discount_price\":\"10.01\",\"sku_price\":\"11.11\",\"ipm_sku_stock\":\"1234\",\"sku_stock\":\"false\",\"aeop_s_k_u_national_discount_price\":[{\"discount_price\":\"9.05\",\"shipto_country\":\"RU\"},{\"discount_price\":\"9.05\",\"shipto_country\":\"RU\"}],\"id\":\"\\\"200000182:193;200007763:201336100\\\"\",\"aeop_s_k_u_property\":[{\"sku_image\":\"http://ae01.alicdn.com/kf/HTB19KVYX6LuK1Rjy0Fhq6xpdFXac.jpg\",\"property_value_definition_name\":\"pink\",\"sku_property_id\":\"14\",\"property_value_id\":\"366\"},{\"sku_image\":\"http://ae01.alicdn.com/kf/HTB19KVYX6LuK1Rjy0Fhq6xpdFXac.jpg\",\"property_value_definition_name\":\"pink\",\"sku_property_id\":\"14\",\"property_value_id\":\"366\"}],\"sku_code\":\"cfas00978\",\"barcode\":\"0\",\"currency_code\":\"USD\"}],\"locale_name\":\"ru_RU\",\"package_length\":\"20\",\"reduce_strategy\":\"place_order_withhold\u6216payment_success_deduct\",\"freight_template_id\":\"1\",\"summary\":\"0\",\"src\":\"isv\",\"bulk_order\":\"5\",\"owner_member_id\":\"aliqatest01\",\"multilanguage_subject\":\"\u041D\u0430\u0437\u0432\u0430\u043D\u0438\u0435 \u043D\u0435\u0441\u043A\u043E\u043B\u044C\u043A\u0438\u0445 \u044F\u0437\u044B\u043A\u043E\u0432\",\"package_width\":\"30\",\"group_id\":\"124\",\"bulk_discount\":\"90\",\"is_image_dynamic\":\"false\"}");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 发布多语言产品(试用)
     */
    @Override
    public String postMultiLanguageAeProduct(AeAppClientDTO acDTO, AeProductPostMultiLanguageAeProductDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressProductEnu.POST_PRODUCT_REDEFINING_POST_MULTI_LANGUAGE_AE_PRODUCT.getApiName());
        request.addApiParameter("ext_param", reqDto.getExt_param());
        request.addApiParameter("product", reqDto.getProduct());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    //商品上架
    //述：上架一个或者多个商品，待上架的产品ID通过参数productIds指定，产品ID之间使用英文分号（;)隔开, 最多一次只能上架50个商品
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.postproduct.redefining.onlineaeproduct");
request.addApiParameter("product_ids", "109827;109828");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 商品上架
     */
    @Override
    public String onlineAeProduct(AeAppClientDTO acDTO, AeProductOnlineAeProductDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressProductEnu.POST_PRODUCT_REDEFINING_ONLINE_AE_PRODUCT.getApiName());
        request.addApiParameter("product_ids", reqDto.getProduct_ids());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    //商品下架
    //描述：商品下架接口。需要下架的商品的通过productIds参数指定，多个商品之间用英文分号隔开。
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.postproduct.redefining.offlineaeproduct");
request.addApiParameter("edit_reason", "product_diagnosis");
request.addApiParameter("product_ids", "109827;109828");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 商品下架
     */
    @Override
    public String offlineAeProduct(AeAppClientDTO acDTO, AeProductOfflineAeProductDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressProductEnu.POST_PRODUCT_REDEFINING_OFFLINE_AE_PRODUCT.getApiName());
        request.addApiParameter("edit_reason", reqDto.getEdit_reason());
        request.addApiParameter("product_ids", reqDto.getProduct_ids());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    //商品分组设置
    //描述：设置单个产品的产品分组信息，最多设置三十个分组。
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.postproduct.redefining.setgroups");
request.addApiParameter("product_id", "1005005270241178");
request.addApiParameter("group_ids", "254562048");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 商品分组设置
     */
    @Override
    public String setGroups(AeAppClientDTO acDTO, AeProductSetGroupsDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressProductEnu.POST_PRODUCT_REDEFINING_SET_GROUPS.getApiName());
        request.addApiParameter("product_id", reqDto.getProduct_id());
        request.addApiParameter("group_ids", reqDto.getGroup_ids());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    //商品列表查询接口
    //描述：商品列表查询接口。主账号可查询所有商品，子账号只可查询自身所属商品。
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.postproduct.redefining.findproductinfolistquery");
request.addApiParameter("aeop_a_e_product_list_query", "{\"gmt_modified_start\":\"2012-01-01 12:13:14\",\"gmt_modified_end\":\"2012-01-01 12:13:14\",\"off_line_time\":\"7\",\"gmt_create_start\":\"2012-01-01 12:13:14\",\"subject\":\"knew odd\",\"have_national_quote\":\"n\",\"ws_display\":\"expire_offline\",\"product_status_type\":\"onSelling\",\"owner_member_id\":\"123\",\"gmt_create_end\":\"2012-01-01 12:13:14\",\"group_id\":\"1234\",\"product_id\":\"123\",\"excepted_product_ids\":[\"[32962333569,32813963253]\",\"[32962333569,32813963253]\"],\"current_page\":\"2\",\"page_size\":\"30\"}");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 商品列表查询接口
     */
    @Override
    public String findProductInfoListQuery(AeAppClientDTO acDTO, AeProductFindProductInfoListQueryDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressProductEnu.POST_PRODUCT_REDEFINING_FIND_PRODUCT_INFO_LIST_QUERY.getApiName());
        request.addApiParameter("aeop_a_e_product_list_query", reqDto.getAeop_a_e_product_list_query());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    //商品删除接口
    //描述：商品删除接口，注意：删除的商品不能恢复，请慎重删除
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.offer.product.delete");
request.addApiParameter("product_id", "1005004617892753");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 商品删除接口
     */
    @Override
    public String productDelete(AeAppClientDTO acDTO, AeProductProductDeleteDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressProductEnu.PRODUCT_DELETE.getApiName());
        request.addApiParameter("product_id", reqDto.getProduct_id());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }
    //商品发布新接口
    //描述：post产品并且返回post成功后的产品的id
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.offer.product.post");
request.addApiParameter("aeop_a_e_product", "{\"lot_num\":\"1\",\"aeop_ae_product_propertys\":[{\"attr_name_id\":\"14\",\"attr_name\":\"color\",\"attr_value_id\":\"12343444\",\"attr_value_unit\":\"0\",\"attr_value\":\"white\",\"attr_value_end\":\"2000561\",\"attr_value_start\":\"2000568\"},{\"attr_name_id\":\"14\",\"attr_name\":\"color\",\"attr_value_id\":\"12343444\",\"attr_value_unit\":\"0\",\"attr_value\":\"white\",\"attr_value_end\":\"2000561\",\"attr_value_start\":\"2000568\"}],\"mode_size_chart_list\":[{\"mode_size\":\"R\",\"hips\":\"2.1\",\"waist\":\"2\",\"bust\":\"2\",\"height\":\"2\"},{\"mode_size\":\"R\",\"hips\":\"2.1\",\"waist\":\"2\",\"bust\":\"2\",\"height\":\"2\"}],\"ws_valid_num\":\"30\",\"aeop_national_quote_configuration\":{\"configuration_data\":\"[{\\\"absoluteQuoteMap\\\":{\\\"\\\":1.0},\\\"shiptoCountry\\\":\\\"RU\\\"},{\\\"absoluteQuoteMap\\\":{\\\"\\\":2.0},\\\"shiptoCountry\\\":\\\"US\\\"}]\",\"configuration_type\":\"absolute\"},\"delivery_time\":\"3\",\"product_price\":\"11.00\",\"detail_source_list\":[{\"mobile_detail\":\"detail stuff here\",\"locale\":\"en_US\",\"web_detail\":\"detail stuff here\"},{\"mobile_detail\":\"detail stuff here\",\"locale\":\"en_US\",\"web_detail\":\"detail stuff here\"}],\"locale\":\"en_US\",\"package_type\":\"false\",\"base_unit\":\"1\",\"currency_code\":\"USD;RUB\",\"is_pack_sell\":\"false\",\"add_weight\":\"3.03\",\"package_height\":\"40\",\"aeop_ae_product_s_k_us\":[{\"sku_discount_price\":\"10.01\",\"ipm_sku_stock\":\"10\",\"aeop_s_k_u_national_discount_price\":[{\"discount_price\":\"9.09\",\"shipto_country\":\"RU\"},{\"discount_price\":\"9.09\",\"shipto_country\":\"RU\"}],\"ean_code\":\"12345678\",\"currency_code\":\"USD;RUB\",\"package_width\":\"3\",\"package_height\":\"2\",\"sku_price\":\"9.05\",\"package_length\":\"4\",\"aeop_s_k_u_property\":[{\"sku_image\":\"http://ae01.alicdn.com/kf/HTB19KVYX6LuK1Rjy0Fhq6xpdFXac.jpg\",\"property_value_definition_name\":\"\u6807\u51C6\u5957\u9910\",\"property_value_id\":\"23123444\",\"sku_property_id\":\"120001\",\"image_url_list\":[\"[http://ae01.alicdn.com/kf/HTB19KVYX6LuK1Rjy0Fhq6xpdFXac.jpg]\",\"[http://ae01.alicdn.com/kf/HTB19KVYX6LuK1Rjy0Fhq6xpdFXac.jpg]\"]},{\"sku_image\":\"http://ae01.alicdn.com/kf/HTB19KVYX6LuK1Rjy0Fhq6xpdFXac.jpg\",\"property_value_definition_name\":\"\u6807\u51C6\u5957\u9910\",\"property_value_id\":\"23123444\",\"sku_property_id\":\"120001\",\"image_url_list\":[\"[http://ae01.alicdn.com/kf/HTB19KVYX6LuK1Rjy0Fhq6xpdFXac.jpg]\",\"[http://ae01.alicdn.com/kf/HTB19KVYX6LuK1Rjy0Fhq6xpdFXac.jpg]\"]}],\"gross_weight\":\"1\",\"barcode\":\"AEfgsdg334\",\"sku_code\":\"AE235de2\"},{\"sku_discount_price\":\"10.01\",\"ipm_sku_stock\":\"10\",\"aeop_s_k_u_national_discount_price\":[{\"discount_price\":\"9.09\",\"shipto_country\":\"RU\"},{\"discount_price\":\"9.09\",\"shipto_country\":\"RU\"}],\"ean_code\":\"12345678\",\"currency_code\":\"USD;RUB\",\"package_width\":\"3\",\"package_height\":\"2\",\"sku_price\":\"9.05\",\"package_length\":\"4\",\"aeop_s_k_u_property\":[{\"sku_image\":\"http://ae01.alicdn.com/kf/HTB19KVYX6LuK1Rjy0Fhq6xpdFXac.jpg\",\"property_value_definition_name\":\"\u6807\u51C6\u5957\u9910\",\"property_value_id\":\"23123444\",\"sku_property_id\":\"120001\",\"image_url_list\":[\"[http://ae01.alicdn.com/kf/HTB19KVYX6LuK1Rjy0Fhq6xpdFXac.jpg]\",\"[http://ae01.alicdn.com/kf/HTB19KVYX6LuK1Rjy0Fhq6xpdFXac.jpg]\"]},{\"sku_image\":\"http://ae01.alicdn.com/kf/HTB19KVYX6LuK1Rjy0Fhq6xpdFXac.jpg\",\"property_value_definition_name\":\"\u6807\u51C6\u5957\u9910\",\"property_value_id\":\"23123444\",\"sku_property_id\":\"120001\",\"image_url_list\":[\"[http://ae01.alicdn.com/kf/HTB19KVYX6LuK1Rjy0Fhq6xpdFXac.jpg]\",\"[http://ae01.alicdn.com/kf/HTB19KVYX6LuK1Rjy0Fhq6xpdFXac.jpg]\"]}],\"gross_weight\":\"1\",\"barcode\":\"AEfgsdg334\",\"sku_code\":\"AE235de2\"}],\"category_id\":\"200002101\",\"subject_list\":[{\"locale\":\"en_US\",\"value\":\"title content here\"},{\"locale\":\"en_US\",\"value\":\"title content here\"}],\"image_u_r_ls\":\"http://g01.a.alicdn.com/kf/HTB13GKLJXXXXXbYaXXXq6xXFXXXi.jpg;http://g02.a.alicdn.com/kf/HTB1DkaWJXXXXXb6XFXXq6xXFXXXp.jpg;http://g02.a.alicdn.com/kf/HTB1pMCQJXXXXXcvXVXXq6xXFXXXm.jpg;http://g03.a.alicdn.com/kf/HTB1QhORJXXXXXbiXVXXq6xXFXXXx.jpg;http://g02.a.alicdn.com/kf/HTB1q1aLJXXXXXcfaXXXq6xXFXXXv.jpg\",\"package_length\":\"20\",\"reduce_strategy\":\"place_order_withhold\u6216payment_success_deduct\",\"gross_weight\":\"10.020\",\"freight_template_id\":\"1000\",\"promise_template_id\":\"100\",\"msr_eu_id\":\"12\",\"aeop_a_e_multimedia\":{\"aeop_a_e_videos\":[{\"media_type\":\"video\",\"media_id\":\"23423423\",\"poster_url\":\"http://img01.taobaocdn.com/bao/uploaded/TB1rNdGIVXXXXbTXFXXXXXXXXXX.jpg\"},{\"media_type\":\"video\",\"media_id\":\"23423423\",\"poster_url\":\"http://img01.taobaocdn.com/bao/uploaded/TB1rNdGIVXXXXbTXFXXXXXXXXXX.jpg\"}]},\"sizechart_id\":\"100\",\"aeop_qualification_struct_list\":[{\"type\":\"image\",\"value\":\"https://ae01.alicdn.com/kf/S23b9cb05c8e844648d48324f23f0c123T.jpeg\",\"key\":\"item_EU_CE_certificate\"},{\"type\":\"image\",\"value\":\"https://ae01.alicdn.com/kf/S23b9cb05c8e844648d48324f23f0c123T.jpeg\",\"key\":\"item_EU_CE_certificate\"}],\"bulk_order\":\"5\",\"product_unit\":\"100000000\",\"market_images\":[{\"url\":\"https://ae01.alicdn.com/kf/HTB1C72NbcvrXXX.jpg\",\"image_type\":\"1\"},{\"url\":\"https://ae01.alicdn.com/kf/HTB1C72NbcvrXXX.jpg\",\"image_type\":\"1\"}],\"package_width\":\"30\",\"add_unit\":\"2\",\"group_id\":\"124\",\"bulk_discount\":\"90\",\"ext_param\":\"{     \\\"category_forecast\\\":\\\"100000015;100000014;100000013;100000012;100000011;100000010\\\" }\"}");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 商品发布新接口
     */
    @Override
    public String productPostNew(AeAppClientDTO acDTO, AeProductProductPostNewDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressProductEnu.PRODUCT_POST_NEW.getApiName());
        request.addApiParameter("aeop_a_e_product", reqDto.getAeop_a_e_product());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    //商品新的编辑接口
    //描述：商品编辑接口（修改任何一个商品信息时，必须将其他所有信息进行填写全面后再提交，否则会出现报错情况出现。）营销图功能上线，增加字段
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.offer.product.edit");
request.addApiParameter("aeop_a_e_product", "{\"lot_num\":\"1\",\"aeop_ae_product_propertys\":[{\"attr_name_id\":\"200000043\",\"attr_name\":\"size\",\"attr_value_id\":\"493\",\"attr_value_unit\":\"0\",\"attr_value\":\"2 - 5 kg\",\"attr_value_end\":\"0\",\"attr_value_start\":\"0\"},{\"attr_name_id\":\"200000043\",\"attr_name\":\"size\",\"attr_value_id\":\"493\",\"attr_value_unit\":\"0\",\"attr_value\":\"2 - 5 kg\",\"attr_value_end\":\"0\",\"attr_value_start\":\"0\"}],\"mode_size_chart_list\":[{\"mode_size\":\"2\",\"hips\":\"2\",\"bust\":\"2\",\"waist\":\"2\",\"height\":\"2\"},{\"mode_size\":\"2\",\"hips\":\"2\",\"bust\":\"2\",\"waist\":\"2\",\"height\":\"2\"}],\"ws_valid_num\":\"30\",\"delivery_time\":\"3\",\"product_price\":\"10.11\",\"aeop_national_quote_configuration\":{\"configuration_data\":\"[{\\\"absoluteQuoteMap\\\":{\\\"\\\":1.0},\\\"shiptoCountry\\\":\\\"RU\\\"},{\\\"absoluteQuoteMap\\\":{\\\"\\\":2.0},\\\"shiptoCountry\\\":\\\"US\\\"}]\",\"configuration_type\":\"absolute\"},\"package_type\":\"false\",\"locale\":\"en_US\",\"detail_source_list\":[{\"mobile_detail\":\"{\\\\\\\"version\\\\\\\":\\\\\\\"2.0.0\\\\\\\",\\\\\\\"moduleList\\\\\\\":[{\\\\\\\"type\\\\\\\":\\\\\\\"text\\\\\\\",\\\\\\\"texts\\\\\\\":[{\\\\\\\"content\\\\\\\":\\\\\\\"Thisistitle\\\\\\\",\\\\\\\"class\\\\\\\":\\\\\\\"title\\\\\\\"},{\\\\\\\"content\\\\\\\":\\\\\\\"Thisisdescription\\\\\\\",\\\\\\\"class\\\\\\\":\\\\\\\"body\\\\\\\"}]}]}\",\"web_detail\":\"{\\\\\\\"version\\\\\\\":\\\\\\\"2.0.0\\\\\\\",\\\\\\\"moduleList\\\\\\\":[{\\\\\\\"type\\\\\\\":\\\\\\\"text\\\\\\\",\\\\\\\"texts\\\\\\\":[{\\\\\\\"content\\\\\\\":\\\\\\\"Thisistitle\\\\\\\",\\\\\\\"class\\\\\\\":\\\\\\\"title\\\\\\\"},{\\\\\\\"content\\\\\\\":\\\\\\\"Thisisdescription\\\\\\\",\\\\\\\"class\\\\\\\":\\\\\\\"body\\\\\\\"}]}]}\",\"locale\":\"en_US\"},{\"mobile_detail\":\"{\\\\\\\"version\\\\\\\":\\\\\\\"2.0.0\\\\\\\",\\\\\\\"moduleList\\\\\\\":[{\\\\\\\"type\\\\\\\":\\\\\\\"text\\\\\\\",\\\\\\\"texts\\\\\\\":[{\\\\\\\"content\\\\\\\":\\\\\\\"Thisistitle\\\\\\\",\\\\\\\"class\\\\\\\":\\\\\\\"title\\\\\\\"},{\\\\\\\"content\\\\\\\":\\\\\\\"Thisisdescription\\\\\\\",\\\\\\\"class\\\\\\\":\\\\\\\"body\\\\\\\"}]}]}\",\"web_detail\":\"{\\\\\\\"version\\\\\\\":\\\\\\\"2.0.0\\\\\\\",\\\\\\\"moduleList\\\\\\\":[{\\\\\\\"type\\\\\\\":\\\\\\\"text\\\\\\\",\\\\\\\"texts\\\\\\\":[{\\\\\\\"content\\\\\\\":\\\\\\\"Thisistitle\\\\\\\",\\\\\\\"class\\\\\\\":\\\\\\\"title\\\\\\\"},{\\\\\\\"content\\\\\\\":\\\\\\\"Thisisdescription\\\\\\\",\\\\\\\"class\\\\\\\":\\\\\\\"body\\\\\\\"}]}]}\",\"locale\":\"en_US\"}],\"currency_code\":\"USD;RUB\",\"base_unit\":\"1\",\"is_pack_sell\":\"false\",\"package_height\":\"40\",\"add_weight\":\"30.11\",\"aeop_ae_product_s_k_us\":[{\"sku_discount_price\":\"12.05\",\"ipm_sku_stock\":\"1111\",\"aeop_s_k_u_national_discount_price\":[{\"discount_price\":\"10.01\",\"shipto_country\":\"RU\"},{\"discount_price\":\"10.01\",\"shipto_country\":\"RU\"}],\"ean_code\":\"12345678\",\"currency_code\":\"USD;RUB\",\"package_width\":\"3\",\"package_height\":\"2\",\"sku_price\":\"200.07\",\"package_length\":\"4\",\"id\":\"\\\"200000182:193;200007763:201336100\\\"\",\"aeop_s_k_u_property\":[{\"sku_image\":\"http://ae01.alicdn.com/kf/HTB19KVYX6LuK1Rjy0Fhq6xpdFXac.jpg\",\"property_value_definition_name\":\"pink\",\"property_value_id\":\"366\",\"sku_property_id\":\"14\",\"image_url_list\":[\"[http://ae01.alicdn.com/kf/HTB19KVYX6LuK1Rjy0Fhq6xpdFXac.jpg]\",\"[http://ae01.alicdn.com/kf/HTB19KVYX6LuK1Rjy0Fhq6xpdFXac.jpg]\"]},{\"sku_image\":\"http://ae01.alicdn.com/kf/HTB19KVYX6LuK1Rjy0Fhq6xpdFXac.jpg\",\"property_value_definition_name\":\"pink\",\"property_value_id\":\"366\",\"sku_property_id\":\"14\",\"image_url_list\":[\"[http://ae01.alicdn.com/kf/HTB19KVYX6LuK1Rjy0Fhq6xpdFXac.jpg]\",\"[http://ae01.alicdn.com/kf/HTB19KVYX6LuK1Rjy0Fhq6xpdFXac.jpg]\"]}],\"gross_weight\":\"1\",\"sku_code\":\"cfas00978\"},{\"sku_discount_price\":\"12.05\",\"ipm_sku_stock\":\"1111\",\"aeop_s_k_u_national_discount_price\":[{\"discount_price\":\"10.01\",\"shipto_country\":\"RU\"},{\"discount_price\":\"10.01\",\"shipto_country\":\"RU\"}],\"ean_code\":\"12345678\",\"currency_code\":\"USD;RUB\",\"package_width\":\"3\",\"package_height\":\"2\",\"sku_price\":\"200.07\",\"package_length\":\"4\",\"id\":\"\\\"200000182:193;200007763:201336100\\\"\",\"aeop_s_k_u_property\":[{\"sku_image\":\"http://ae01.alicdn.com/kf/HTB19KVYX6LuK1Rjy0Fhq6xpdFXac.jpg\",\"property_value_definition_name\":\"pink\",\"property_value_id\":\"366\",\"sku_property_id\":\"14\",\"image_url_list\":[\"[http://ae01.alicdn.com/kf/HTB19KVYX6LuK1Rjy0Fhq6xpdFXac.jpg]\",\"[http://ae01.alicdn.com/kf/HTB19KVYX6LuK1Rjy0Fhq6xpdFXac.jpg]\"]},{\"sku_image\":\"http://ae01.alicdn.com/kf/HTB19KVYX6LuK1Rjy0Fhq6xpdFXac.jpg\",\"property_value_definition_name\":\"pink\",\"property_value_id\":\"366\",\"sku_property_id\":\"14\",\"image_url_list\":[\"[http://ae01.alicdn.com/kf/HTB19KVYX6LuK1Rjy0Fhq6xpdFXac.jpg]\",\"[http://ae01.alicdn.com/kf/HTB19KVYX6LuK1Rjy0Fhq6xpdFXac.jpg]\"]}],\"gross_weight\":\"1\",\"sku_code\":\"cfas00978\"}],\"category_id\":\"200002101\",\"subject_list\":[{\"locale\":\"en_US\",\"value\":\"product subject\"},{\"locale\":\"en_US\",\"value\":\"product subject\"}],\"image_u_r_ls\":\"http://g01.a.alicdn.com/kf/HTB13GKLJXXXXXbYaXXXq6xXFXXXi.jpg;http://g02.a.alicdn.com/kf/HTB1DkaWJXXXXXb6XFXXq6xXFXXXp.jpg;http://g02.a.alicdn.com/kf/HTB1pMCQJXXXXXcvXVXXq6xXFXXXm.jpg;http://g03.a.alicdn.com/kf/HTB1QhORJXXXXXbiXVXXq6xXFXXXx.jpg;http://g02.a.alicdn.com/kf/HTB1q1aLJXXXXXcfaXXXq6xXFXXXv.jpg\",\"package_length\":\"20\",\"product_id\":\"1239273\",\"reduce_strategy\":\"place_order_withhold\",\"gross_weight\":\"50\",\"freight_template_id\":\"1000\",\"promise_template_id\":\"100\",\"msr_eu_id\":\"12\",\"sizechart_id\":\"123\",\"aeop_a_e_multimedia\":{\"aeop_a_e_videos\":[{\"media_type\":\"video\",\"media_id\":\"12345678\",\"poster_url\":\"http://img01.taobaocdn.com/bao/uploaded/TB1rNdGIVXXXXbTXFXXXXXXXXXX.jpg\"},{\"media_type\":\"video\",\"media_id\":\"12345678\",\"poster_url\":\"http://img01.taobaocdn.com/bao/uploaded/TB1rNdGIVXXXXbTXFXXXXXXXXXX.jpg\"}]},\"aeop_qualification_struct_list\":[{\"type\":\"image\",\"value\":\"https://ae01.alicdn.com/kf/S23b9cb05c8e844648d48324f23f0c123T.jpeg\",\"key\":\"item_EU_CE_certificate\"},{\"type\":\"image\",\"value\":\"https://ae01.alicdn.com/kf/S23b9cb05c8e844648d48324f23f0c123T.jpeg\",\"key\":\"item_EU_CE_certificate\"}],\"bulk_order\":\"5\",\"product_unit\":\"100000000\",\"market_images\":[{\"url\":\"https://ae01.alicdn.com/kf/HTB1C72NbcvrXXX.jpg\",\"image_type\":\"1\"},{\"url\":\"https://ae01.alicdn.com/kf/HTB1C72NbcvrXXX.jpg\",\"image_type\":\"1\"}],\"package_width\":\"30\",\"add_unit\":\"2\",\"bulk_discount\":\"90\",\"ext_param\":\"{     \\\"deleteMarketImageFlag\\\":\\\"false\\\",     \\\"deleteQualificationFlag\\\":\\\"false\\\", \\\"edit_reason\\\":\\\"product_diagnosis\\\"}\"}");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 商品新的编辑接口
     */
    @Override
    public String productEditNew(AeAppClientDTO acDTO, AeProductProductEditNewDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressProductEnu.PRODUCT_EDIT_NEW.getApiName());
        request.addApiParameter("aeop_a_e_product", reqDto.getAeop_a_e_product());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    //商品查询新接口
    //描述：根据商品id查询单个商品的详细信息。
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.offer.product.query");
request.addApiParameter("product_id", "1005004616872521");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 商品查询新接口
     */
    @Override
    public String productDetailQueryNew(AeAppClientDTO acDTO, AeProductProductQueryNewDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressProductEnu.PRODUCT_QUERY_NEW.getApiName());
        request.addApiParameter("product_id", reqDto.getProduct_id());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    //商品橱窗设置
    //描述：商品橱窗设置
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.postproduct.redefining.setshopwindowproduct");
request.addApiParameter("product_id_list", "1351344486;1351344487");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 商品橱窗设置
     */
    @Override
    public String setShopWindowProduct(AeAppClientDTO acDTO, AeProductSetShopWindowProductDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressProductEnu.SET_SHOP_WINDOW_PRODUCT.getApiName());
        request.addApiParameter("product_id_list", reqDto.getProduct_id_list());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    //商品违禁词查询（暂停维护，返回空集合）
    //描述：“调用发布商品接口api.postaeproduct前，针对商品标题等信息做违禁词相关信息查询接口。 当前支持的违禁词查询范围包括：1.商品的标题，2.商品的关键字, 3.商品的类目属性, 4.商品的详细描述。用户提供以上四个参数以及商品的类目ID来查询标题、关键字、类目属性、详细描述中是否包含了当前类目的违禁词。 发布产品时平台提供的违禁词查询只供参考和引导的作用，同时由于是系统检测并不能判断实际词语应用的场景，所以还需请您不断仔细检查相关词语的应用情况，可点此进入知识产权的相关学习：http://seller.aliexpress.com/education/rules/ipr31.html?tracelog=ipr01zscqzq”
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.postproduct.redefining.findaeproductprohibitedwords");
request.addApiParameter("category_id", "322");
request.addApiParameter("title", "nike");
request.addApiParameter("keywords", "0");
request.addApiParameter("product_properties", "0");
request.addApiParameter("detail", "This is a test for the product.");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 商品违禁词查询
     */
    @Override
    public String findAeProductProhibitedWords(AeAppClientDTO acDTO, AeProductFindAeProductProhibitedWordsDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressProductEnu.FIND_AE_PRODUCT_PROHIBITED_WORDS.getApiName());
        request.addApiParameter("category_id", reqDto.getCategory_id());
        request.addApiParameter("title", reqDto.getTitle());
        request.addApiParameter("keywords", reqDto.getKeywords());
        request.addApiParameter("product_properties", reqDto.getProduct_properties());
        request.addApiParameter("detail", reqDto.getDetail());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    //将指定的尺码模版信息复制到具有相同的模型的目标叶子类目下面
    //描述：复制所有尺码模版的所有信息 尺码模版与目标叶子类目具有相同的模型
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.offer.redefining.copysizetemplate");
request.addApiParameter("size_template_id", "1");
request.addApiParameter("target_leaf_id", "364");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 将指定的尺码模版信息复制到具有相同的模型的目标叶子类目下面
     */
    @Override
    public String copySizeTemplate(AeAppClientDTO acDTO, AeProductCopySizeTemplateDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressProductEnu.COPY_SIZE_TEMPLATE.getApiName());
        request.addApiParameter("size_template_id", reqDto.getSize_template_id());
        request.addApiParameter("target_leaf_id", reqDto.getTarget_leaf_id());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    //延长商品有效期
    //描述：“卖家post商品时可选择商品有效期。 每次延长的有效期=post商品时卖家选择的商品有效期”
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.postproduct.redefining.renewexpire");
request.addApiParameter("product_id", "32960861801");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 延长商品有效期
     */
    @Override
    public String renewExpire(AeAppClientDTO acDTO, AeProductRenewExpireDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressProductEnu.RENEW_EXPIRE.getApiName());
        request.addApiParameter("product_id", reqDto.getProduct_id());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    //批量更新商品绑定车型信息
    //描述：批量更新商品绑定车型信息
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.carmodel.update.product.carInfo");
request.addApiParameter("param0", "{\"delete_af_ids\":[\"[\\\"US323221\\\"]\",\"[\\\"US323221\\\"]\"],\"product_id\":\"\\\"1005005113643414\\\"\",\"channel_seller_id\":\"2671514005\",\"channel\":\"AE_GLOBAL\",\"add_af_ids\":[\"[\\\"US122121\\\"]\",\"[\\\"US122121\\\"]\"]}");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 批量更新商品绑定车型信息
     */
    @Override
    public String carModelUpdateProductCarInfo(AeAppClientDTO acDTO, AeProductCarModelUpdateProductCarInfoDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressProductEnu.CAR_MODEL_UPDATE_PRODUCT_CAR_INFO.getApiName());
        request.addApiParameter("param0", reqDto.getParam0());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    //批量查询车型库数据
    //描述：根据条件批量查询车型库数据
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.carmodel.findByTecIds");
request.setHttpMethod("GET");
request.addApiParameter("param", "{\"link_target_id_list\":[\"[]\",\"[]\"],\"current\":\"1\",\"year_id\":\"1\",\"model_id\":\"1\",\"country_id\":\"1\",\"brand_id\":\"1\",\"page_size\":\"10\"}");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 批量查询车型库数据
     */
    @Override
    public String carModelFindByTecIds(AeAppClientDTO acDTO, AeProductCarModelFindByTecIdsDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressProductEnu.CAR_MODEL_FIND_BY_TEC_IDS.getApiName());
        request.setHttpMethod("GET");
        request.addApiParameter("param", reqDto.getParam());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    //新增商品主图短视频
    //描述：根据商品id和视频url完成商品头图视频的更新
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.ugc.product.video.upload");
request.addApiParameter("product_id", "123554348908");
request.addApiParameter("media_type", "video");
request.addApiParameter("video_file_url", "http://ae-cn.alicdn.com/kddd6bep.mp4");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 新增商品主图短视频
     */
    @Override
    public String ugcProductVideoUpload(AeAppClientDTO acDTO, AeProductUgcProductVideoUploadDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressProductEnu.UGC_PRODUCT_VIDEO_UPLOAD.getApiName());
        request.addApiParameter("product_id", reqDto.getProduct_id());
        request.addApiParameter("media_type", reqDto.getMedia_type());
        request.addApiParameter("video_file_url", reqDto.getVideo_file_url());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    //服务模板查询
    //描述：服务模板查询API
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.postproduct.redefining.querypromisetemplatebyid");
request.addApiParameter("template_id", "-1");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 服务模板查询
     */
    @Override
    public String queryPromiseTemplateById(AeAppClientDTO acDTO, AeProductQueryPromiseTemplateByIdDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressProductEnu.QUERY_PROMISE_TEMPLATE_BY_ID.getApiName());
        request.addApiParameter("template_id", reqDto.getTemplate_id());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    //查询主商品搭配列表
    //描述：查询商品搭配列表,这个接口是以主商品来作为查询的统计维度的？比如要查10条记录，其实是查10个主商品，这10个主商品的所有搭配记录都会查出来，所以实际上查出来的搭配数量实际上要比10大，由于每个主商品最多可以有三个搭配，所以如果查询10个主商品，一次最多可能会查询出30条搭配记录
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.offer.redefining.querybundle");
request.addApiParameter("param_aeop_offer_bundle_query_condition", "{\"item_subject\":\"test-product\",\"item_id\":\"32840310226\",\"current_page\":\"1\",\"page_size\":\"10\"}");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 查询主商品搭配列表
     */
    @Override
    public String queryBundle(AeAppClientDTO acDTO, AeProductQueryBundleDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressProductEnu.QUERY_BUNDLE.getApiName());
        request.addApiParameter("param_aeop_offer_bundle_query_condition", reqDto.getParam_aeop_offer_bundle_query_condition());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    //查询信息模板列表
    //描述：查询信息模板列表
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.postproduct.redefining.findaeproductdetailmodulelistbyqurey");
request.addApiParameter("module_status", "approved");
request.addApiParameter("type", "custom");
request.addApiParameter("page_index", "1");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 查询信息模板列表
     */
    @Override
    public String findAeProductDetailModuleListByQuery(AeAppClientDTO acDTO, AeProductFindAeProductDetailModuleListByQueryDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressProductEnu.FIND_AE_PRODUCT_DETAIL_MODULE_LIST_BY_QUREY.getApiName());
        request.addApiParameter("module_status", reqDto.getModule_status());
        request.addApiParameter("type", reqDto.getType());
        request.addApiParameter("page_index", reqDto.getPage_index());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    //查询单个信息模板详情
    //描述：“根据模块id查询模块，模块在detail详情中显示格式：<kse：widget data-widget-type=”“widget”“ id=”“1004”“ title=”“Specification ”“ type=”“relation”“></kse：widget> 标签属性id=“”1004“”对应返回值中的id，标签属性type=“”relation“”对应返回值中的type， 标签属性title=“”Specification “”对应返回值中的name.”
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.postproduct.redefining.findaeproductmodulebyid");
request.addApiParameter("module_id", "0");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 查询单个信息模板详情
     */
    @Override
    public String findAeProductModuleById(AeAppClientDTO acDTO, AeProductFindAeProductModuleByIdDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressProductEnu.FIND_AE_PRODUCT_MODULE_BY_ID.getApiName());
        request.addApiParameter("module_id", reqDto.getModule_id());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    //查询商品状态
    //描述：查询商品状态，商品供三种状态。审核通过：approved;审核中：auditing;审核不通过：refuse
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.postproduct.redefining.findaeproductstatusbyid");
request.addApiParameter("product_id", "32462942083");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 查询商品状态
     */
    @Override
    public String findAeProductStatusById(AeAppClientDTO acDTO, AeProductFindAeProductStatusByIdDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressProductEnu.FIND_AE_PRODUCT_STATUS_BY_ID.getApiName());
        request.addApiParameter("product_id", reqDto.getProduct_id());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    //查询商品绑定的车型信息
    //描述：查询商品绑定的车型库信息
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.carmodel.findListByProductId");
request.setHttpMethod("GET");
request.addApiParameter("param0", "{\"product_id\":\"\\\"1005004513947684\\\"\",\"channel\":\"AE_GLOBAL\",\"channel_seller_id\":\"2671514005\"}");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 查询商品绑定的车型信息
     */
    @Override
    public String carModelFindListByProductId(AeAppClientDTO acDTO, AeProductCarModelFindListByProductIdDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressProductEnu.CAR_MODEL_FIND_LIST_BY_PRODUCT_ID.getApiName());
        request.setHttpMethod("GET");
        request.addApiParameter("param0", reqDto.getParam0());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    //查询商家下已优化商品
    //描述：查询商家下已优化商品，包括优化时间和优化来源
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.product.diagnosis.result.list");
request.addApiParameter("current", "1");
request.addApiParameter("page_size", "10");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 查询商家下已优化商品
     */
    @Override
    public String productDiagnosisResultList(AeAppClientDTO acDTO, AeProductProductDiagnosisResultListDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressProductEnu.PRODUCT_DIAGNOSIS_RESULT_LIST.getApiName());
        request.addApiParameter("current", reqDto.getCurrent());
        request.addApiParameter("page_size", reqDto.getPage_size());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    //查询商家下待优化的商品问题类型列表
    //描述：查询商家下待优化的商品问题类型列表 包含问题类型和问题描述
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.product.diagnosis.queryProblem");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 查询商家下待优化的商品问题类型列表
     */
    @Override
    public String productDiagnosisQueryProblem(AeAppClientDTO acDTO, AeProductProductDiagnosisQueryProblemDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressProductEnu.PRODUCT_DIAGNOSIS_QUERY_PROBLEM.getApiName());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    //查询指定商品ID所在产品分组
    //描述：查询指定商品id所在产品分组
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.postproduct.redefining.queryproductgroupidbyproductid");
request.addApiParameter("product_id", "1629872654");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 查询指定商品ID所在产品分组
     */
    @Override
    public String queryProductGroupIdByProductId(AeAppClientDTO acDTO, AeProductQueryProductGroupIdByProductIdDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressProductEnu.QUERY_PRODUCT_GROUP_ID_BY_PRODUCT_ID.getApiName());
        request.addApiParameter("product_id", reqDto.getProduct_id());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }
    //查询草稿箱里的产品信息
    //描述：根据商品id查询单个商品的详细信息。
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.offer.draftproduct.get");
request.addApiParameter("product_id", "1307422965");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 查询草稿箱里的产品信息
     */
    @Override
    public String draftProductGetNew(AeAppClientDTO acDTO, AeProductDraftProductGetNewDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressProductEnu.DRAFT_PRODUCT_GET_NEW.getApiName());
        request.addApiParameter("product_id", reqDto.getProduct_id());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    //查询草稿箱里的商品列表
    //描述：草稿箱商品列表查询接口。主账号可查询所有商品，子账号只可查询自身所属商品。
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.offer.draftproducts.get");
request.addApiParameter("aeop_a_e_product_list_query", "{\"current_page\":\"2\",\"page_size\":\"30\"}");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 查询草稿箱里的商品列表
     */
    @Override
    public String draftProductsGet(AeAppClientDTO acDTO, AeProductDraftProductsGetDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressProductEnu.DRAFT_PRODUCTS_GET.getApiName());
        request.addApiParameter("aeop_a_e_product_list_query", reqDto.getAeop_a_e_product_list_query());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    //查询车型库支持的品牌
    //描述：查询车型库支持的品牌
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.carmodel.get.brand");
request.addApiParameter("param0", "{\"lang\":\"zh\"}");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 查询车型库支持的品牌
     */
    @Override
    public String carModelGetBrand(AeAppClientDTO acDTO, AeProductCarModelGetBrandDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressProductEnu.CAR_MODEL_GET_BRAND.getApiName());
        request.addApiParameter("param0", reqDto.getParam0());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    //查询车型库支持的国家
    //描述：查询车型库支持的所有国家列表
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.carmodel.get.country");
request.addApiParameter("param0", "{\"lang\":\"zh\"}");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 查询车型库支持的国家
     */
    @Override
    public String carModelGetCountry(AeAppClientDTO acDTO, AeProductCarModelGetCountryDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressProductEnu.CAR_MODEL_GET_COUNTRY.getApiName());
        request.addApiParameter("param0", reqDto.getParam0());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    //查询零配件关联的TEC车型ID
    //描述：查询零配件关联的车型信息
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.carmodel.get.linktarget");
request.addApiParameter("param0", "{\"article_id_list\":[\"[\\\"1222211\\\",\\\"221\\\"]\",\"[\\\"1222211\\\",\\\"221\\\"]\"],\"linking_target_type\":\"V\",\"lang\":\"zh\"}");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 查询零配件关联的TEC车型ID
     */
    @Override
    public String carModelGetLinkTarget(AeAppClientDTO acDTO, AeProductCarModelGetLinkTargetDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressProductEnu.CAR_MODEL_GET_LINK_TARGET.getApiName());
        request.addApiParameter("param0", reqDto.getParam0());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    //根据OE号查询零配件信息
    //描述：根据OE号等条件查询零配件信息
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.carmodel.get.article");
request.addApiParameter("param0", "{\"current\":\"1\",\"language\":\"zh\",\"search_query\":\"4233244\",\"search_type\":\"1\",\"page_size\":\"10\"}");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 根据OE号查询零配件信息
     */
    @Override
    public String carModelGetArticle(AeAppClientDTO acDTO, AeProductCarModelGetArticleDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressProductEnu.CAR_MODEL_GET_ARTICLE.getApiName());
        request.addApiParameter("param0", reqDto.getParam0());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    //根据tecId查询车型库数据
    //描述：根据TEC ID查询车型库数据
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.carmodel.findByTecId");
request.addApiParameter("tec_id", "22548");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 根据tecId查询车型库数据
     */
    @Override
    public String carModelFindByTecId(AeAppClientDTO acDTO, AeProductCarModelFindByTecIdDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressProductEnu.CAR_MODEL_FIND_BY_TEC_ID.getApiName());
        request.addApiParameter("tec_id", reqDto.getTec_id());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    //根据类目id获得适用的尺码表信息列表（不推荐使用）
    //描述：查询当前用户在指定类目下可用的尺码模版信息。不推荐使用，请使用aliexpress.offer.redefining.getsizetemplatesbycategoryid
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.postproduct.redefining.getsizechartinfobycategoryid");
request.addApiParameter("channel", "AE_GLOBAL");
request.addApiParameter("channel_seller_id", "2671514005");
request.addApiParameter("category_id", "348");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 根据类目id获得适用的尺码表信息列表（不推荐使用）
     */
    @Override
    public String getSizeChartInfoByCategoryId(AeAppClientDTO acDTO, AeProductGetSizeChartInfoByCategoryIdDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressProductEnu.GET_SIZE_CHART_INFO_BY_CATEGORY_ID.getApiName());
        request.addApiParameter("channel", reqDto.getChannel());
        request.addApiParameter("channel_seller_id", reqDto.getChannel_seller_id());
        request.addApiParameter("category_id", reqDto.getCategory_id());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    //类目预测，可以筛选卖家已经通过准入申请的类目
    //描述：类目预测，根据商品标题和图片预测商品的叶子类目，可以筛选已经通过准入申请的类目
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.postproduct.redefining.categoryforecast");
request.addApiParameter("image_url", "https://ae01.alicdn.com/kf/S1f7eae683d124854973b72563474e170V.jpg");
request.addApiParameter("subject", "elle+sport+sujetador+deportivo+gunn+rosa");
request.addApiParameter("locale", "es");
request.addApiParameter("is_filter_by_permission", "N");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 类目预测
     */
    @Override
    public String categoryForecast(AeAppClientDTO acDTO, AeProductCategoryForecastDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressProductEnu.CATEGORY_FORECAST.getApiName());
        request.addApiParameter("image_url", reqDto.getImage_url());
        request.addApiParameter("subject", reqDto.getSubject());
        request.addApiParameter("locale", reqDto.getLocale());
        request.addApiParameter("is_filter_by_permission", reqDto.getIs_filter_by_permission());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    //编辑单商品多sku价格
    //描述：编辑单商品多sku价格
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.offer.product.skuprices.edit");
request.addApiParameter("product_id", "32985788417");
request.addApiParameter("sku_id_price_map", "{ \"14:193\": \"0.6\",\"14:175\": \"0.9\"}");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 编辑单商品多sku价格
     */
    @Override
    public String editMultipleProductSkuPrices(AeAppClientDTO acDTO, AeProductProductSkuPricesEditDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressProductEnu.PRODUCT_SKU_PRICES_EDIT.getApiName());
        request.addApiParameter("product_id", reqDto.getProduct_id());
        request.addApiParameter("sku_id_price_map", reqDto.getSku_id_price_map());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }


    //编辑单商品多个SKU的库存
    //描述：编辑单个商品的一个或者多个SKU可售库存。将要修改的SKU的库存值保存在skuStocks参数中（Map类型数据），其中key为SKU ID（字符串）， value为对应的库存值（Longtype）。
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.postproduct.redefining.editmutilpleskustocks");
request.addApiParameter("product_id", "32297192242");
request.addApiParameter("sku_stocks", "{\"14:200003699;5:100014064\":240, \"14:200003699;5:361386\": 220}");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 编辑单商品多个SKU的库存
     */
    @Override
    public String editMultipleSkuStocks(AeAppClientDTO acDTO, AeProductEditMultipleSkuStocksDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressProductEnu.EDIT_MULTIPLE_SKU_STOCKS.getApiName());
        request.addApiParameter("product_id", reqDto.getProduct_id());
        request.addApiParameter("sku_stocks", reqDto.getSku_stocks());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }


    //编辑商品单个SKU价格
    //描述：编辑商品的单个SKU价格信息。
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.postproduct.redefining.editsingleskuprice");
request.addApiParameter("product_id", "123456789");
request.addApiParameter("sku_id", "14:771;5:100014066");
request.addApiParameter("sku_price", "999");
request.addApiParameter("sale_price", "999");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 编辑商品单个SKU价格
     */
    @Override
    public String editSingleSkuPrice(AeAppClientDTO acDTO, AeProductEditSingleSkuPriceDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressProductEnu.EDIT_SINGLE_SKU_PRICE.getApiName());
        request.addApiParameter("product_id", reqDto.getProduct_id());
        request.addApiParameter("sku_id", reqDto.getSku_id());
        request.addApiParameter("sku_price", reqDto.getSku_price());
        request.addApiParameter("sale_price", reqDto.getSale_price());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }


    //编辑商品单个SKU库存
    //描述：编辑商品单个SKU的库存信息.
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.postproduct.redefining.editsingleskustock");
request.addApiParameter("product_id", "32297192242");
request.addApiParameter("sku_id", "14:200003699;5:100014065");
request.addApiParameter("ipm_sku_stock", "299");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 编辑商品单个SKU库存
     */
    @Override
    public String editSingleSkuStock(AeAppClientDTO acDTO, AeProductEditSingleSkuStockDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressProductEnu.EDIT_SINGLE_SKU_STOCK.getApiName());
        request.addApiParameter("product_id", reqDto.getProduct_id());
        request.addApiParameter("sku_id", reqDto.getSku_id());
        request.addApiParameter("ipm_sku_stock", reqDto.getIpm_sku_stock());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }


    //编辑商品的单个字段
    //描述：编辑商品的单个字段（目前使用api.editSimpleProductFiled这个接口 暂不支持商品分组、商品属性、SKU、服务模板的修改。请注意！)
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.postproduct.redefining.editsimpleproductfiled");
request.addApiParameter("product_id", "1234");
request.addApiParameter("fied_name", "deliveryTime");
request.addApiParameter("fiedvalue", "{  \"mobileDetail\": [  {        \"type\": \"text\",        \"content\": \" POSTAGE<>:  We provide free express shipping via UPS / DHL / FEDEX / EMS / TNT / ARAMEX / for most of country when your orders around US$200 (please contact us if you have qustions). Delivery time around 4-7 days (business days).NOTE<>: We have only one store called 'TWOTWINSTYLE' on aliexpress. The products selling in other stores with same designs or photos are not from us. 'TWOTWINSTYLE' have their own separate production lines, all merchandise sold are exclusive and high quality.\"      } ],  \"version\": \"1.0\",  \"versionNum\": 1}");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 编辑商品的单个字段
     */
    @Override
    public String editSimpleProductFiled(AeAppClientDTO acDTO, AeProductEditSimpleProductFiledDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressProductEnu.EDIT_SIMPLE_PRODUCT_FILED.getApiName());
        request.addApiParameter("product_id", reqDto.getProduct_id());
        request.addApiParameter("fied_name", reqDto.getFied_name());
        request.addApiParameter("fiedvalue", reqDto.getFiedvalue());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    //编辑商品的多语言标题或详描
    //描述：原发编辑商品多语言标题或详描描述（英文版本除外）。试用
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.postproduct.redefining.editmultilanguageproduct");
request.addApiParameter("product_id", "32234411234");
request.addApiParameter("aeop_a_e_product_multilanguage_info", "{\"mobile_detail\":\"{    \\\"mobileDetail\\\": [        {            \\\"content\\\": \\\"context1\\\",            \\\"type\\\": \\\"text\\\"        },        {            \\\"col\\\": 1,            \\\"images\\\": [                {                    \\\"height\\\":500,                    \\\"imgUrl\\\": \\\"https://ae01.alicdn.com/kf/HTB1WQ.MKpXXXXXhXVXXq6xXFXXX6.jpg\\\",                    \\\"width\\\":500,                    \\\"targetUrl\\\":\\\"https://ae01.alicdn.com/kf/HTB1WQ.MKpXXXXXhXVXXq6xXFXXX6.jpg\\\"                },                {                    \\\"imgUrl\\\": \\\"https://ae01.alicdn.com/kf/HTB1WQ.MKpXXXXXhXVXXq6xXFXXX6.jpg\\\",                    \\\"targetUrl\\\":\\\"https://ae01.alicdn.com/kf/HTB1WQ.MKpXXXXXhXVXXq6xXFXXX6.jpg\\\"                }            ],            \\\"type\\\": \\\"image\\\"        },        {            \\\"content\\\": \\\"context3\\\",            \\\"type\\\": \\\"text\\\"        }    ],    \\\"version\\\": \\\"1.0\\\",    \\\"versionNum\\\": 1}\",\"subject\":\"foo\",\"detail\":\"bar\",\"locale\":\"ru_RU\"}");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 编辑商品的多语言标题或详描
     */
    @Override
    public String editMultiLanguageProduct(AeAppClientDTO acDTO, AeProductEditMultiLanguageProductDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressProductEnu.EDIT_MULTI_LANGUAGE_PRODUCT.getApiName());
        request.addApiParameter("product_id", reqDto.getProduct_id());
        request.addApiParameter("aeop_a_e_product_multilanguage_info", reqDto.getAeop_a_e_product_multilanguage_info());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }


    //编辑商品类目属性
    //描述：编辑商品的类目属性，用给定的类目属性覆盖原有的类目属性。(试用)
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.postproduct.redefining.editproductcategoryattributes");
request.addApiParameter("product_id", "1706468951");
request.addApiParameter("product_category_attributes", "[{\"attr_name_id\":\"0\",\"attr_name\":\"0\",\"attr_value_id\":\"0\",\"attr_value_unit\":\"0\",\"attr_value\":\"0\",\"attr_value_end\":\"0\",\"attr_value_start\":\"0\"}]");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 编辑商品类目属性
     */
    @Override
    public String editProductCategoryAttributes(AeAppClientDTO acDTO, AeProductEditProductCategoryAttributesDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressProductEnu.EDIT_PRODUCT_CATEGORY_ATTRIBUTES.getApiName());
        request.addApiParameter("product_id", reqDto.getProduct_id());
        request.addApiParameter("product_category_attributes", reqDto.getProduct_category_attributes());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }


    //获取单个产品信息
    //描述：根据商品id查询单个商品的详细信息。
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.postproduct.redefining.findaeproductbyid");
request.addApiParameter("product_id", "1307422965");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 获取单个产品信息
     */
    @Override
    public String findAeProductById(AeAppClientDTO acDTO, AeProductFindAeProductByIdDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressProductEnu.FIND_AE_PRODUCT_BY_ID.getApiName());
        request.addApiParameter("product_id", reqDto.getProduct_id());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }


    //获取叶子类目下尺码模版列表
    //描述：获取当前用户下入驻叶子类目尺码模版列表，分页，每页最多20条记录。
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.offer.redefining.getsizetemplatesbycategoryid");
request.addApiParameter("channel_seller_id", "2671514005");
request.addApiParameter("channel", "AE_GLOBAL");
request.addApiParameter("leaf_category_id", "348");
request.addApiParameter("current_page", "1");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 获取叶子类目下尺码模版列表
     */
    @Override
    public String getSizeTemplatesByCategoryId(AeAppClientDTO acDTO, AeProductGetSizeTemplatesByCategoryIdDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressProductEnu.GET_SIZE_TEMPLATES_BY_CATEGORY_ID.getApiName());
        request.addApiParameter("channel_seller_id", reqDto.getChannel_seller_id());
        request.addApiParameter("channel", reqDto.getChannel());
        request.addApiParameter("leaf_category_id", reqDto.getLeaf_category_id());
        request.addApiParameter("current_page", reqDto.getCurrent_page());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }


    //获取当前会员的产品分组（不推荐使用）
    //描述：获取当前会员的产品分组。该接口存在问题导致SDK无法使用，自己解析json的方式目前仍可以使用，但后期会下线掉。建议使用新API：aliexpress.product.productgroups.get，https：//developers.aliexpress.com/doc.htm#？docType=2&docId=35300。
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.postproduct.redefining.getproductgrouplist");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 获取当前会员的产品分组（不推荐使用）
     */
    @Override
    public String getProductGroupList(AeAppClientDTO acDTO, AeProductGetProductGroupListDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressProductEnu.GET_PRODUCT_GROUP_LIST.getApiName());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }


    //获取当前会员的产品分组（新）
    //描述：获取当前会员的产品分组
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.product.productgroups.get");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 获取当前会员的产品分组（新）
     */
    @Override
    public String productGroupsGet(AeAppClientDTO acDTO, AeProductProductGroupsGetDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressProductEnu.PRODUCT_GROUPS_GET.getApiName());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }


    //通过商品ID初始化商品搭配
    //描述：通过商品ID初始化商品搭配，这个接口初始化的搭配信息不回保存到数据库，只有调用了aliexpress.offer.redefining.createbundle接口后才会保存
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.offer.redefining.initialnewbundle");
request.addApiParameter("main_item_id", "32840310226");
request.addApiParameter("sub_item_list", "[32829102949]");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 通过商品ID初始化商品搭配
     */
    @Override
    public String initialNewBundle(AeAppClientDTO acDTO, AeProductInitialNewBundleDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressProductEnu.INITIAL_NEW_BUNDLE.getApiName());
        request.addApiParameter("main_item_id", reqDto.getMain_item_id());
        request.addApiParameter("sub_item_list", reqDto.getSub_item_list());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }
}
