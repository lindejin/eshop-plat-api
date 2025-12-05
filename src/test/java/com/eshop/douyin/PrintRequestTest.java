package com.eshop.douyin;


import com.alibaba.fastjson.JSON;
import com.eshop.douyin.print.*;
import com.eshop.util.platform.api.client.douyin.DouyinSignUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.JsonContent;

import java.io.IOException;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
public class PrintRequestTest {

    @Autowired
    private JacksonTester<PrintRequest> json;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testSerialize() throws IOException {
        // 创建测试对象
        PrintRequest request = new PrintRequest();
        request.setCmd("print");
        request.setRequestID("123458976");
        request.setVersion("1.0");

        Task task = new Task();
        task.setTaskID("7293666");
        task.setPrinter("打印机");
        task.setPreview(false);
//        task.setConfig("打印配置 面单：wms_waybill,拣选单：wms_，");

        Document document = new Document();
        document.setDocNo("单号");
        document.setDocumentID("0123456789");
        document.setCopy(2);

        Content content1 = new Content();
        content1.setParams("access_token=值&app_key=值&method=logistics.getShopKey&param_json={}&timestamp=时间&v=2&sign=值&sign_method=hmac-sha256，此处只用关心入参，不用关心出参，这个是打印组件调用的，各参数值的生成详见电商开放平台https://op.jinritemai.com/docs/guide-docs/148/814，其中的method=logistics.getShopKey，param_json={}");
        content1.setSignature("数据的签名，电商开放平台/logistics/waybillApply接口返回的waybill_infos.sign");
        content1.setEncryptedData("电商开放平台/logistics/waybillApply接口返回的waybill_infos.print_data");
        content1.setTemplateURL("电商开放平台/logistics/templateList接口返回的标准模板template_data.template_infos.template_url或者其他模板");

        AddData addData = new AddData();
        SenderInfo senderInfo = new SenderInfo();
        Address address = new Address();
        address.setCityName("南京市");
        address.setCountryCode("CHN");
        address.setDetailAddress("软件大道10号华为南研所E区");
        address.setDistrictName("雨花台区");
        address.setProvinceName("江苏省");
        address.setStreetName("街道");
        Contact contact = new Contact();
        contact.setMobile("13282160693");
        contact.setName("字节跳动");
        senderInfo.setAddress(address);
        senderInfo.setContact(contact);
        addData.setSenderInfo(senderInfo);
        content1.setAddData(addData);

        Config config = new Config();
        config.setPackageNumber("1/3");
        content1.setConfig(config);

        Content content2 = new Content();
        Map<String, String> customData = new HashMap<>();
        customData.put("key1", "自定义值1");
        customData.put("key2", "自定义值2");
        content2.setData(customData);
        content2.setTemplateURL("自定义模板的url需要ISV存储，也可以是通过/logistics/getCustomTemplateList接口返回的模板");

        document.setContents(Arrays.asList(content1, content2));
        task.setDocuments(Collections.singletonList(document));
        request.setTask(task);

        // 验证序列化
        JsonContent<PrintRequest> jsonContent = json.write(request);
        assertThat(jsonContent).extractingJsonPathStringValue("$.cmd").isEqualTo("print");
        assertThat(jsonContent).extractingJsonPathStringValue("$.requestID").isEqualTo("123458976");
        assertThat(jsonContent).extractingJsonPathStringValue("$.version").isEqualTo("1.0");
        assertThat(jsonContent).extractingJsonPathStringValue("$.task.taskID").isEqualTo("7293666");
        assertThat(jsonContent).extractingJsonPathStringValue("$.task.printer").isEqualTo("打印机");
        assertThat(jsonContent).extractingJsonPathBooleanValue("$.task.preview").isEqualTo(false);
        assertThat(jsonContent).extractingJsonPathStringValue("$.task.documents[0].docNo").isEqualTo("单号");
        assertThat(jsonContent).extractingJsonPathStringValue("$.task.documents[0].documentID").isEqualTo("0123456789");
        assertThat(jsonContent).extractingJsonPathNumberValue("$.task.documents[0].copy").isEqualTo(2);
        assertThat(jsonContent).extractingJsonPathStringValue("$.task.documents[0].contents[0].params").isEqualTo("access_token=值&app_key=值&method=logistics.getShopKey&param_json={}&timestamp=时间&v=2&sign=值&sign_method=hmac-sha256，此处只用关心入参，不用关心出参，这个是打印组件调用的，各参数值的生成详见电商开放平台https://op.jinritemai.com/docs/guide-docs/148/814，其中的method=logistics.getShopKey，param_json={}");
        assertThat(jsonContent).extractingJsonPathStringValue("$.task.documents[0].contents[1].templateURL").isEqualTo("自定义模板的url需要ISV存储，也可以是通过/logistics/getCustomTemplateList接口返回的模板");

        System.out.println(JSON.toJSONString(request));
    }

    @Test
    public void testDeserialize() throws IOException {
        String jsonStr = "{\n" +
                "  \"cmd\": \"print\",\n" +
                "  \"requestID\": \"123458976\",\n" +
                "  \"version\": \"1.0\",\n" +
                "  \"task\": {\n" +
                "    \"taskID\": \"7293666\",\n" +
                "    \"printer\": \"打印机\",\n" +
                "    \"preview\": false,\n" +
                "    \"config\": \"打印配置 面单：wms_waybill,拣选单：wms_，\",\n" +
                "    \"documents\": [{\n" +
                "      \"docNo\": \"单号\",\n" +
                "      \"documentID\": \"0123456789\",\n" +
                "      \"copy\": 2,\n" +
                "      \"contents\": [{\n" +
                "        \"params\":\"access_token=值&app_key=值&method=logistics.getShopKey&param_json={}&timestamp=时间&v=2&sign=值&sign_method=hmac-sha256，此处只用关心入参，不用关心出参，这个是打印组件调用的，各参数值的生成详见电商开放平台https://op.jinritemai.com/docs/guide-docs/148/814，其中的method=logistics.getShopKey，param_json={}\",\n" +
                "        \"signature\":\"数据的签名，电商开放平台/logistics/waybillApply接口返回的waybill_infos.sign\",\n" +
                "        \"encryptedData\":\"电商开放平台/logistics/waybillApply接口返回的waybill_infos.print_data\",\n" +
                "        \"templateURL\":\"电商开放平台/logistics/templateList接口返回的标准模板template_data.template_infos.template_url或者其他模板\",\n" +
                "        \"addData\":{\n" +
                "          \"senderInfo\":{\n" +
                "            \"address\":{\n" +
                "              \"cityName\":\"南京市\",\n" +
                "              \"countryCode\":\"CHN\",\n" +
                "              \"detailAddress\":\"软件大道10号华为南研所E区\",\n" +
                "              \"districtName\":\"雨花台区\",\n" +
                "              \"provinceName\":\"江苏省\",\n" +
                "              \"streetName\":\"街道\"\n" +
                "            },\n" +
                "            \"contact\":{\n" +
                "              \"mobile\":\"13282160693\",\n" +
                "              \"name\":\"字节跳动\"\n" +
                "            }\n" +
                "          }\n" +
                "        },\n" +
                "        \"config\":{\n" +
                "            \"packageNumber\": \"1/3\"\n" +
                "        }\n" +
                "    },{\n" +
                "        \"data\": {\n" +
                "          \"key1\": \"自定义值1\",\n" +
                "          \"key2\": \"自定义值2\"\n" +
                "        },\n" +
                "        \"templateURL\": \"自定义模板的url需要ISV存储，也可以是通过/logistics/getCustomTemplateList接口返回的模板\"\n" +
                "      }]\n" +
                "    }]\n" +
                "  }\n" +
                "}";

        PrintRequest request = json.parseObject(jsonStr);

        // 验证反序列化
        assertThat(request.getCmd()).isEqualTo("print");
        assertThat(request.getRequestID()).isEqualTo("123458976");
        assertThat(request.getVersion()).isEqualTo("1.0");
        assertThat(request.getTask().getTaskID()).isEqualTo("7293666");
        assertThat(request.getTask().getPrinter()).isEqualTo("打印机");
        assertThat(request.getTask().isPreview()).isFalse();
        assertThat(request.getTask().getConfig()).isEqualTo("打印配置 面单：wms_waybill,拣选单：wms_，");
        assertThat(request.getTask().getDocuments()).hasSize(1);
        Document document = request.getTask().getDocuments().get(0);
        assertThat(document.getDocNo()).isEqualTo("单号");
        assertThat(document.getDocumentID()).isEqualTo("0123456789");
        assertThat(document.getCopy()).isEqualTo(2);
        assertThat(document.getContents()).hasSize(2);
        Content content1 = document.getContents().get(0);
        assertThat(content1.getParams()).isEqualTo("access_token=值&app_key=值&method=logistics.getShopKey&param_json={}&timestamp=时间&v=2&sign=值&sign_method=hmac-sha256，此处只用关心入参，不用关心出参，这个是打印组件调用的，各参数值的生成详见电商开放平台https://op.jinritemai.com/docs/guide-docs/148/814，其中的method=logistics.getShopKey，param_json={}");
        assertThat(content1.getSignature()).isEqualTo("数据的签名，电商开放平台/logistics/waybillApply接口返回的waybill_infos.sign");
        Content content2 = document.getContents().get(1);
        assertThat(content2.getTemplateURL()).isEqualTo("自定义模板的url需要ISV存储，也可以是通过/logistics/getCustomTemplateList接口返回的模板");
        assertThat(content2.getData()).containsEntry("key1", "自定义值1");
    }

    @Test
    public void testDefaultValues() throws JsonProcessingException {
        // 测试默认值
        Document document = new Document();
        document.setDocNo("测试单号");
        document.setContents(Collections.emptyList());

        String jsonStr = objectMapper.writeValueAsString(document);
        assertThat(jsonStr).contains("\"copy\":1");
    }


    @Test
    public void testSerialize22() throws IOException {
        String appKey = "7564242597683381811";
        String appSecret = "00c66ba7-ea59-42ad-9b34-b105483151b3";
        String method = "logistics.getShopKey";
        String accessToken = "hfd86q0wc81lgwk7oxkf6er00001ri95-11";


        //时间戳，格式为UNIX时间（秒） ，长度10位，当前时间-300秒<=入参时间<=当前时间+300秒
        long timestamp = System.currentTimeMillis() / 1000;
        String paramJson = "{}";

        String signsss = DouyinSignUtil.sign(appKey, appSecret, method, timestamp+"", paramJson, "2");

        String params = "access_token="+accessToken+"&app_key="+appKey+"&method=logistics.getShopKey&param_json={}&timestamp="+timestamp+"&v=2&sign="+signsss+"&sign_method=md5";


        String order_id = "6948626828631938627|1055635778";
        String track_no = "SF3262690419302";
        String print_data = "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";
        String sign = "RxgNWCCowiosV5WoCvx3Es/xedgQM3wtcP3SRdk5DLUbFbDneIwi02kecv/Rvgq3SSpb60gJ6hXDh3eGX/FRkbNO/KhfJ9bA0wUCt63SmnFP5xwA/P85ojMeagk2d4udKBBmrqTMz/nEpOnAUzmL1xovNk5RqhXapT2Nrzf7SkS+y9wizvYAs42dAs+7nGnPCH8Gs8ksC0EY0B++z+5xxP4Es+gv1T0RXxmdyXJuGlXdkcd5nGlNK6wz/OXB1orgzkaFMN7rha4W39XilOsq893f1OITWoq70XAdFQKhu94T0q7IDPZmtcNt32ZtxvsPt/QsZYR51Mni1TWN/YQvIw==";

        // 创建测试对象
        PrintRequest request = new PrintRequest();
        request.setCmd("print");
        request.setRequestID("123458976");
        request.setVersion("1.0");

        Task task = new Task();
        task.setTaskID("7293666");
        task.setPrinter("得物打印机");
        task.setPreview(false);
//        task.setConfig("打印配置 面单：wms_waybill,拣选单：wms_，");

        Document document = new Document();
        document.setDocNo("SF3262690419302");
        document.setDocumentID("0123456789");
        document.setCopy(2);

        Content content1 = new Content();
        content1.setParams("access_token=值&app_key=值&method=logistics.getShopKey&param_json={}&timestamp=时间&v=2&sign=值&sign_method=hmac-sha256，此处只用关心入参，不用关心出参，这个是打印组件调用的，各参数值的生成详见电商开放平台https://op.jinritemai.com/docs/guide-docs/148/814，其中的method=logistics.getShopKey，param_json={}");
        content1.setSignature("数据的签名，电商开放平台/logistics/waybillApply接口返回的waybill_infos.sign");
        content1.setEncryptedData("电商开放平台/logistics/waybillApply接口返回的waybill_infos.print_data");
        content1.setTemplateURL("电商开放平台/logistics/templateList接口返回的标准模板template_data.template_infos.template_url或者其他模板");

        content1.setParams(params);


        content1.setSignature(sign);
        content1.setEncryptedData(print_data);
        content1.setTemplateURL("https://lf3-cm.ecombdstatic.com/obj/logistics-davinci/template/v2/shunfeng_76_130.xml");

//        AddData addData = new AddData();
//        SenderInfo senderInfo = new SenderInfo();
//        Address address = new Address();
//        address.setCityName("南京市");
//        address.setCountryCode("CHN");
//        address.setDetailAddress("软件大道10号华为南研所E区");
//        address.setDistrictName("雨花台区");
//        address.setProvinceName("江苏省");
//        address.setStreetName("街道");
//        Contact contact = new Contact();
//        contact.setMobile("13282160693");
//        contact.setName("字节跳动");
//        senderInfo.setAddress(address);
//        senderInfo.setContact(contact);
//        addData.setSenderInfo(senderInfo);
//        content1.setAddData(addData);

        Config config = new Config();
        config.setPackageNumber("1/3");
        content1.setConfig(config);

//        Content content2 = new Content();
//        Map<String, String> customData = new HashMap<>();
//        customData.put("key1", "自定义值1");
//        customData.put("key2", "自定义值2");
//        content2.setData(customData);
//        content2.setTemplateURL("自定义模板的url需要ISV存储，也可以是通过/logistics/getCustomTemplateList接口返回的模板");

//        document.setContents(Arrays.asList(content1, content2));

        document.setContents(Collections.singletonList(content1));
        task.setDocuments(Collections.singletonList(document));
        request.setTask(task);

        System.out.println(JSON.toJSONString(request));
    }
}