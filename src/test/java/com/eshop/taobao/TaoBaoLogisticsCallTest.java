package com.eshop.taobao;

import com.alibaba.fastjson.JSON;
import com.eshop.util.platform.api.client.taobao.request.TaoBaoAppClientDTO;
import com.eshop.util.platform.api.service.logistics.taobao.TaoBaoLogisticsCall;
import com.eshop.util.platform.api.service.logistics.taobao.dto.*;
import com.eshop.util.platform.api.service.logistics.taobao.vo.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @program: eshop-plat-api
 * @description:
 * @author: lindz
 * @create: 2026-01-08 11:15
 **/
@SpringBootTest
public class TaoBaoLogisticsCallTest {

    @Autowired
    private TaoBaoLogisticsCall taoBaoLogisticsCall;


    @Test
    void queryEcBillTemplates() throws Exception {
        String apiUrl = "https://gw.api.taobao.com/router/rest";
        String appKey = "34124006";
        String appSecret = "4a921fb19d69fca3db1becf7d96c00ca";
        String sessionKey = "6100506c11ee151a6f033ab9d649f6aa2e5ba207a1360ac2206890150985";
        TaoBaoAppClientDTO appDTO = new TaoBaoAppClientDTO();
        appDTO.setAppKey(appKey);
        appDTO.setAppSecret(appSecret);
        appDTO.setSessionKey(sessionKey);
//        appDTO.setTargetAppKey(targetAppKey);
        appDTO.setApiUrl(apiUrl);

        TaoBaoEbillTemplatesReqDTO reqDTO = new TaoBaoEbillTemplatesReqDTO();

        TaoBaoEbillTemplatesRespVO xiaohongshuTokenCreateVO = taoBaoLogisticsCall.queryEcBillTemplates(appDTO, reqDTO);
        System.out.println(xiaohongshuTokenCreateVO.getRespBody());
        System.out.println(JSON.toJSONString(xiaohongshuTokenCreateVO));

        //第一次


    }

    @Test
    void queryEcBillOrder() throws Exception {
        String apiUrl = "https://gw.api.taobao.com/router/rest";
        String appKey = "34124006";
        String appSecret = "4a921fb19d69fca3db1becf7d96c00ca";
        String sessionKey = "6100506c11ee151a6f033ab9d649f6aa2e5ba207a1360ac2206890150985";
        TaoBaoAppClientDTO appDTO = new TaoBaoAppClientDTO();
        appDTO.setAppKey(appKey);
        appDTO.setAppSecret(appSecret);
        appDTO.setSessionKey(sessionKey);
//        appDTO.setTargetAppKey(targetAppKey);
        appDTO.setApiUrl(apiUrl);


        String objectId = UUID.randomUUID().toString();
        //  cp_code	String	true	POSTB	快递公司code（如：POSTB=邮政）
        String cp_code = "YTO";
        //  object_id	String	true	1	请求id（用于幂等性控制）
        String object_id = objectId;
        //  waybill_code	String	true	9890000066001	电子面单号（运单号）
        String waybill_code = "YT7596382757695";
        TaoBaoEbillOrderWaybillDetailQueryByWaybillCodeRequest row = new TaoBaoEbillOrderWaybillDetailQueryByWaybillCodeRequest();
        row.setCp_code(cp_code);
        row.setObject_id(object_id);
        row.setWaybill_code(waybill_code);
        List<TaoBaoEbillOrderWaybillDetailQueryByWaybillCodeRequest> list = new ArrayList<>();
        list.add(row);
        TaoBaoEbillOrderReqDTO reqDTO = new TaoBaoEbillOrderReqDTO();
        reqDTO.setParam_list(list);


        TaoBaoEbillOrderRespVO xiaohongshuTokenCreateVO = taoBaoLogisticsCall.queryEcBillOrder(appDTO, reqDTO);
        System.out.println(xiaohongshuTokenCreateVO.getRespBody());
        System.out.println(JSON.toJSONString(xiaohongshuTokenCreateVO));
        //第一次
        //{"cainiao_waybill_ii_query_by_waybillcode_response":{"modules":{"waybill_cloud_print_with_result_desc_response":[{"object_id":"2e8f005d-7bb7-4b26-bd76-4273a203a8e5","success":true,"waybill_cloud_print_response":{"print_data":"{\"encryptedData\":\"AES:rU904rj6UH2oqfSUb43+Z199vDU2GZtH5\/LVIEq0ppUJuwjq7qZ58JRvDHOQ\/f2QhqdsWiYYFqp6z96+fPLupxENx4gZUSA\/zYJbbdwevCzeI+22t7hONi0e8k4pytGn0cs+O\/SQI1why\/dhaLeykWnnlGU0C0H6rLb9Myr8u1LJAYfQ7SsjVBRaWlssLiH1kWSfGOTZIOkh5WTnbdxPi08HJV+ZEEBVCoPXVHJDpcK1R5+aEFHTaaPA8hdfslZFbDRsR2HRygU1aH9gkxrtOJOgL2h8xN4FxaScOFAueeM02fE0M6R5OW3\/tG2db\/uSO1LeFpLhsvAAavywxPYKKAqAWH\/W\/1cfllrQ8zk3ZeOZj+EAnpCyMNgmN0mEaeYUT6ZPB62QmecrMlnnX9yrigewlb7NEw880iGKoy8xTrIDaMETvoNsS+cN9QYsmFOykkurZ0nHhfE35xXhA\/t2L3889OFflzf5KaoBVcTynldKwDBAwWIVRTBRNdzqf5rMyp2qt\/j2QRkNt0ufBJ+O8F21ji1F90qUuc2yV0A4gX8\/bYk4hVP0FnpKEF4tS\/+2aM8Ki55L0B4cM65hZHsqSWEQzJICbsIcnohyWH8DTp1Z6dcnfquU113K6dgd8tw43Vdc5h5+vva7NAh7ohJfEpzwAc0DukUHMl0gu0mecn6Q7g0s7GQ5u0hKjLG2RATMR5v0jcpuzU1dhPbGdHiUzn1NT7xSnb317qiXw9Hcp8V26OUT8DIfsUP4wFyXkcUit3QdepO3kc34G0BlkDyvd5pArU+HUoGoxN4Rs0XswY69SexkoDFLlvKtpvGcOBIoloiXtdpYAqzEBWGNdKLNjPL2v\/GYUsIo+2+LsV5fjYzNcj5NMweNe8rzaz4p\/z0OrIzBqHyurLlDLTJ6mkQMF7Zn5E\/y\/\/A+GaSCXay2DNVoC1w349AA7vPkHzA7FirVYYbm0lAxO0z\/Iw0b\/WA0OQ4KggaIBACcP47qOW8kynrpAUkiaHiAlfLLajDqoKkHVaYvanMKvJOpMnQOWYOd0ORmjtYBfQiivGadgq+zGld91EUn7ItRenTAm628cZIJ0GihcHLgJul\/DZJOXgRmI96bwP3V\/UChZXaoxiEPadvBuD2\/UMgwGoCatbk6DLhDWxR+wz+E9bCOxAbWvmmAGsVBo37Jz7b3zinok87yo9g8txTc\/gx4xEYKNdY0Xzx2eCs+gOzZLov\/pA5lL2kwVlsD4Lh6zv01IDu7erR3yJVot+k5oE1tNr0f5FBnd2OTAa\/utVcOrKm8nVO6SEDxZNYwL+Vu0JiKFn469HM2htzVLKMaAn7noHrda25Y+uJGckS94q\/nPqpE9NHSvg+VN6zlQ1jSReTT8WOu2U9IKqpaswdg8mUeUuQn8Va\/wIKY3pWflnjN8A0NctEYYZ8Tslqw40UTIzyNA9I7\/NFHV3u+DJVgeeJ0L8\/Sqbfk+taK8NZrXCwsXS6J+MA8DihtZaxrb1Bu68Mftf\/cJmRpvo5YOx+dFuy3ioZTNSaAd1qTFS04N+GOgF42\/PSqqjU+B99ERMVWmjMrbrBkpMKlHEKeH++pPEO6pYzTV9ob4t0Cavd3xEgMXhM3wh98OWeTMbs3KO3Oh3VT9IDIXlEwX693rWOjg1dz1DYTOk6XeaahRi7RuZRQPDEaHNfKVp91A01j2J9T3TJP+OYMlS0+U99cZMXgmmUV+597VyxwihbF93\/LOO3ASvvQuuZdFC5OgosrZObt2caWFemDrVGZ3UqqHv+PA22dO825ZvFdoWZ+Cwl9NUYpqa1CARXAcHW9k9FSAAbODxXu+lO\/CvZ87igCp3zTMRtvBQfPEIiyJj7Rh0lwaH0gAOPmOPNg7qalpFck1tKVCV8ZO1CLJf+3kcmbnCcqcoGY12yJigbHTU\/Hn9kORMJOEZOChNPOUGjVhs1dtacrjTh0DaWfE5L81ecLiOepR7RoHARK57iF1751uiKXmq73DYO\/Cz9f4sfsOa7o64JKo+guIR4OJopaNrW8r1Mxyym9rqNrZDXWRtBiAFts9L7Of8lawxNlMJhEBKTwC+6ciIeSiK4+B3OPF2x7nWQwo3LpspN\/CMLum4lrQ9oFCqNWf79UtQvKEKuIRRKlMwO7YH3oELo7xJuJBjivAOjz8OamEvVkHSSGSCr9BpU59uM1gMbybDYkTOvYJHefXrLWzJVYxKqHc6NLXaPTedTQnOLyNodpWCtBHDA\/mw5+co\/movnIkWzxjaTZQMpB9b\/KPo3wCaYWXw0fVqA9A4Ll8m4ofI7SlK2r\/iphfB\/keGNQx1SzioMJkw65WfmoCNyk5khtZzzPiB8ihChBYzveb2VHK04HKmM8oNePp9rvU7pYioYfPi2GgLf3+imrux4I6pw69ra6K1Jo9nYjWhAk0shTgMXNwInJRce4k04tcXk7EooEST4H57FaJw==\",\"signature\":\"MD:EksqcqnCVyCS\/rBtOQlzSQ==\",\"templateURL\":\"http:\/\/cloudprint.cainiao.com\/template\/standard\/290659\",\"ver\":\"waybill_print_secret_version_1\"}","waybill_code":"YT7596382757695"}}]},"request_id":"16ms4tudox3u6"}}
        //{"respBody":"{\"cainiao_waybill_ii_query_by_waybillcode_response\":{\"modules\":{\"waybill_cloud_print_with_result_desc_response\":[{\"object_id\":\"2e8f005d-7bb7-4b26-bd76-4273a203a8e5\",\"success\":true,\"waybill_cloud_print_response\":{\"print_data\":\"{\\\"encryptedData\\\":\\\"AES:rU904rj6UH2oqfSUb43+Z199vDU2GZtH5\\/LVIEq0ppUJuwjq7qZ58JRvDHOQ\\/f2QhqdsWiYYFqp6z96+fPLupxENx4gZUSA\\/zYJbbdwevCzeI+22t7hONi0e8k4pytGn0cs+O\\/SQI1why\\/dhaLeykWnnlGU0C0H6rLb9Myr8u1LJAYfQ7SsjVBRaWlssLiH1kWSfGOTZIOkh5WTnbdxPi08HJV+ZEEBVCoPXVHJDpcK1R5+aEFHTaaPA8hdfslZFbDRsR2HRygU1aH9gkxrtOJOgL2h8xN4FxaScOFAueeM02fE0M6R5OW3\\/tG2db\\/uSO1LeFpLhsvAAavywxPYKKAqAWH\\/W\\/1cfllrQ8zk3ZeOZj+EAnpCyMNgmN0mEaeYUT6ZPB62QmecrMlnnX9yrigewlb7NEw880iGKoy8xTrIDaMETvoNsS+cN9QYsmFOykkurZ0nHhfE35xXhA\\/t2L3889OFflzf5KaoBVcTynldKwDBAwWIVRTBRNdzqf5rMyp2qt\\/j2QRkNt0ufBJ+O8F21ji1F90qUuc2yV0A4gX8\\/bYk4hVP0FnpKEF4tS\\/+2aM8Ki55L0B4cM65hZHsqSWEQzJICbsIcnohyWH8DTp1Z6dcnfquU113K6dgd8tw43Vdc5h5+vva7NAh7ohJfEpzwAc0DukUHMl0gu0mecn6Q7g0s7GQ5u0hKjLG2RATMR5v0jcpuzU1dhPbGdHiUzn1NT7xSnb317qiXw9Hcp8V26OUT8DIfsUP4wFyXkcUit3QdepO3kc34G0BlkDyvd5pArU+HUoGoxN4Rs0XswY69SexkoDFLlvKtpvGcOBIoloiXtdpYAqzEBWGNdKLNjPL2v\\/GYUsIo+2+LsV5fjYzNcj5NMweNe8rzaz4p\\/z0OrIzBqHyurLlDLTJ6mkQMF7Zn5E\\/y\\/\\/A+GaSCXay2DNVoC1w349AA7vPkHzA7FirVYYbm0lAxO0z\\/Iw0b\\/WA0OQ4KggaIBACcP47qOW8kynrpAUkiaHiAlfLLajDqoKkHVaYvanMKvJOpMnQOWYOd0ORmjtYBfQiivGadgq+zGld91EUn7ItRenTAm628cZIJ0GihcHLgJul\\/DZJOXgRmI96bwP3V\\/UChZXaoxiEPadvBuD2\\/UMgwGoCatbk6DLhDWxR+wz+E9bCOxAbWvmmAGsVBo37Jz7b3zinok87yo9g8txTc\\/gx4xEYKNdY0Xzx2eCs+gOzZLov\\/pA5lL2kwVlsD4Lh6zv01IDu7erR3yJVot+k5oE1tNr0f5FBnd2OTAa\\/utVcOrKm8nVO6SEDxZNYwL+Vu0JiKFn469HM2htzVLKMaAn7noHrda25Y+uJGckS94q\\/nPqpE9NHSvg+VN6zlQ1jSReTT8WOu2U9IKqpaswdg8mUeUuQn8Va\\/wIKY3pWflnjN8A0NctEYYZ8Tslqw40UTIzyNA9I7\\/NFHV3u+DJVgeeJ0L8\\/Sqbfk+taK8NZrXCwsXS6J+MA8DihtZaxrb1Bu68Mftf\\/cJmRpvo5YOx+dFuy3ioZTNSaAd1qTFS04N+GOgF42\\/PSqqjU+B99ERMVWmjMrbrBkpMKlHEKeH++pPEO6pYzTV9ob4t0Cavd3xEgMXhM3wh98OWeTMbs3KO3Oh3VT9IDIXlEwX693rWOjg1dz1DYTOk6XeaahRi7RuZRQPDEaHNfKVp91A01j2J9T3TJP+OYMlS0+U99cZMXgmmUV+597VyxwihbF93\\/LOO3ASvvQuuZdFC5OgosrZObt2caWFemDrVGZ3UqqHv+PA22dO825ZvFdoWZ+Cwl9NUYpqa1CARXAcHW9k9FSAAbODxXu+lO\\/CvZ87igCp3zTMRtvBQfPEIiyJj7Rh0lwaH0gAOPmOPNg7qalpFck1tKVCV8ZO1CLJf+3kcmbnCcqcoGY12yJigbHTU\\/Hn9kORMJOEZOChNPOUGjVhs1dtacrjTh0DaWfE5L81ecLiOepR7RoHARK57iF1751uiKXmq73DYO\\/Cz9f4sfsOa7o64JKo+guIR4OJopaNrW8r1Mxyym9rqNrZDXWRtBiAFts9L7Of8lawxNlMJhEBKTwC+6ciIeSiK4+B3OPF2x7nWQwo3LpspN\\/CMLum4lrQ9oFCqNWf79UtQvKEKuIRRKlMwO7YH3oELo7xJuJBjivAOjz8OamEvVkHSSGSCr9BpU59uM1gMbybDYkTOvYJHefXrLWzJVYxKqHc6NLXaPTedTQnOLyNodpWCtBHDA\\/mw5+co\\/movnIkWzxjaTZQMpB9b\\/KPo3wCaYWXw0fVqA9A4Ll8m4ofI7SlK2r\\/iphfB\\/keGNQx1SzioMJkw65WfmoCNyk5khtZzzPiB8ihChBYzveb2VHK04HKmM8oNePp9rvU7pYioYfPi2GgLf3+imrux4I6pw69ra6K1Jo9nYjWhAk0shTgMXNwInJRce4k04tcXk7EooEST4H57FaJw==\\\",\\\"signature\\\":\\\"MD:EksqcqnCVyCS\\/rBtOQlzSQ==\\\",\\\"templateURL\\\":\\\"http:\\/\\/cloudprint.cainiao.com\\/template\\/standard\\/290659\\\",\\\"ver\\\":\\\"waybill_print_secret_version_1\\\"}\",\"waybill_code\":\"YT7596382757695\"}}]},\"request_id\":\"16ms4tudox3u6\"}}"}

        //结构化
    }


    @Test
    void cainiaoCloudprintIsvResourcesGet() throws Exception {
        String apiUrl = "https://eco.taobao.com/router/rest";
        String appKey = "34124006";
        String appSecret = "4a921fb19d69fca3db1becf7d96c00ca";
        String sessionKey = "6100506c11ee151a6f033ab9d649f6aa2e5ba207a1360ac2206890150985";
        TaoBaoAppClientDTO appDTO = new TaoBaoAppClientDTO();
        appDTO.setAppKey(appKey);
        appDTO.setAppSecret(appSecret);
        appDTO.setSessionKey(sessionKey);
//        appDTO.setTargetAppKey(targetAppKey);
        appDTO.setApiUrl(apiUrl);

        CainiaoCloudprintIsvResourcesGetReqDTO reqDTO = new CainiaoCloudprintIsvResourcesGetReqDTO();
        reqDTO.setIsv_resource_type("TEMPLATE");
        CainiaoCloudprintIsvResourcesGetRespVO xiaohongshuTokenCreateVO = taoBaoLogisticsCall.cainiaoCloudprintIsvResourcesGet(appDTO, reqDTO);
        System.out.println(xiaohongshuTokenCreateVO.getRespBody());
        System.out.println(JSON.toJSONString(xiaohongshuTokenCreateVO));

        //第一次
        //{"cainiao_cloudprint_isv_resources_get_response":{"result":{"error_code":"0","resource_list":{},"success":true},"request_id":"16kye9rmz0dl3"}}
        //{"respBody":"{\"cainiao_cloudprint_isv_resources_get_response\":{\"result\":{\"error_code\":\"0\",\"resource_list\":{},\"success\":true},\"request_id\":\"16kye9rmz0dl3\"}}"}

        //结构化
        //{"cainiao_cloudprint_isv_resources_get_response":{"result":{"error_code":"0","resource_list":{},"success":true},"request_id":"16l86lm45rd1h"}}
        //{"cainiao_cloudprint_isv_resources_get_response":{"result":{"error_code":"0","resource_list":[{}],"success":true}},"respBody":"{\"cainiao_cloudprint_isv_resources_get_response\":{\"result\":{\"error_code\":\"0\",\"resource_list\":{},\"success\":true},\"request_id\":\"16l86lm45rd1h\"}}"}

    }

    @Test
    void cainiaoCloudprintIsvtemplatesGet() throws Exception {
        String apiUrl = "https://eco.taobao.com/router/rest";
        String appKey = "34124006";
        String appSecret = "4a921fb19d69fca3db1becf7d96c00ca";
        String sessionKey = "6100506c11ee151a6f033ab9d649f6aa2e5ba207a1360ac2206890150985";
        TaoBaoAppClientDTO appDTO = new TaoBaoAppClientDTO();
        appDTO.setAppKey(appKey);
        appDTO.setAppSecret(appSecret);
        appDTO.setSessionKey(sessionKey);
//        appDTO.setTargetAppKey(targetAppKey);
        appDTO.setApiUrl(apiUrl);

        CainiaoCloudprintIsvtemplatesGetReqDTO reqDTO = new CainiaoCloudprintIsvtemplatesGetReqDTO();
        CainiaoCloudprintIsvtemplatesGetRespVO xiaohongshuTokenCreateVO = taoBaoLogisticsCall.cainiaoCloudprintIsvtemplatesGet(appDTO, reqDTO);
        System.out.println(xiaohongshuTokenCreateVO.getRespBody());
        System.out.println(JSON.toJSONString(xiaohongshuTokenCreateVO));

        //第一次
        //{"cainiao_cloudprint_isvtemplates_get_response":{"result":{"datas":{},"error_code":"0","success":true},"request_id":"16moo2xa6lal9"}}
        //{"cainiao_cloudprint_isvtemplates_get_response":{"result":{"datas":[{}],"error_code":"0","success":true}},"respBody":"{\"cainiao_cloudprint_isvtemplates_get_response\":{\"result\":{\"datas\":{},\"error_code\":\"0\",\"success\":true},\"request_id\":\"16moo2xa6lal9\"}}"}

        //结构化
        //{"cainiao_cloudprint_isvtemplates_get_response":{"result":{"datas":{},"error_code":"0","success":true},"request_id":"16moo2xa6lal9"}}
        //{"cainiao_cloudprint_isvtemplates_get_response":{"result":{"datas":[{}],"error_code":"0","success":true}},"respBody":"{\"cainiao_cloudprint_isvtemplates_get_response\":{\"result\":{\"datas\":{},\"error_code\":\"0\",\"success\":true},\"request_id\":\"16moo2xa6lal9\"}}"}


    }


    @Test
    void cainiaoCloudprintMystdtemplatesGet() throws Exception {
        String apiUrl = "https://eco.taobao.com/router/rest";
        String appKey = "34124006";
        String appSecret = "4a921fb19d69fca3db1becf7d96c00ca";
        String sessionKey = "6100506c11ee151a6f033ab9d649f6aa2e5ba207a1360ac2206890150985";
        TaoBaoAppClientDTO appDTO = new TaoBaoAppClientDTO();
        appDTO.setAppKey(appKey);
        appDTO.setAppSecret(appSecret);
        appDTO.setSessionKey(sessionKey);
//        appDTO.setTargetAppKey(targetAppKey);
        appDTO.setApiUrl(apiUrl);

        CainiaoCloudprintMystdtemplatesGetReqDTO reqDTO = new CainiaoCloudprintMystdtemplatesGetReqDTO();
        CainiaoCloudprintMystdtemplatesGetRespVO xiaohongshuTokenCreateVO = taoBaoLogisticsCall.cainiaoCloudprintMystdtemplatesGet(appDTO, reqDTO);
        System.out.println(xiaohongshuTokenCreateVO.getRespBody());
        System.out.println(JSON.toJSONString(xiaohongshuTokenCreateVO));

        //第一次
        //{"cainiao_cloudprint_mystdtemplates_get_response":{"result":{"datas":{},"error_code":"0","success":true},"request_id":"15r7aixbed0wq"}}
        //{"cainiao_cloudprint_mystdtemplates_get_response":{"result":{"datas":[{}],"error_code":"0","success":true}},"respBody":"{\"cainiao_cloudprint_mystdtemplates_get_response\":{\"result\":{\"datas\":{},\"error_code\":\"0\",\"success\":true},\"request_id\":\"15r7aixbed0wq\"}}"}

        //结构化
        //{"cainiao_cloudprint_mystdtemplates_get_response":{"result":{"datas":{},"error_code":"0","success":true},"request_id":"15r7aixbed0wq"}}
        //{"cainiao_cloudprint_mystdtemplates_get_response":{"result":{"datas":[{}],"error_code":"0","success":true}},"respBody":"{\"cainiao_cloudprint_mystdtemplates_get_response\":{\"result\":{\"datas\":{},\"error_code\":\"0\",\"success\":true},\"request_id\":\"15r7aixbed0wq\"}}"}

        //{"cainiao_cloudprint_mystdtemplates_get_response":{"result":{"datas":{"user_template_result":[{"cp_code":"FEDEX","user_std_templates":{"user_template_do":[{"brand_code":"default","keys":{},"user_std_template_id":66260731,"user_std_template_name":"1","user_std_template_url":"https:\/\/cloudprint.cainiao.com\/template\/standard\/261503\/4"}]}}]},"error_code":"0","success":true},"request_id":"15qsnmdwe09vb"}}
        //{"cainiao_cloudprint_mystdtemplates_get_response":{"result":{"datas":[{}],"error_code":"0","success":true}},"respBody":"{\"cainiao_cloudprint_mystdtemplates_get_response\":{\"result\":{\"datas\":{\"user_template_result\":[{\"cp_code\":\"FEDEX\",\"user_std_templates\":{\"user_template_do\":[{\"brand_code\":\"default\",\"keys\":{},\"user_std_template_id\":66260731,\"user_std_template_name\":\"1\",\"user_std_template_url\":\"https:\\/\\/cloudprint.cainiao.com\\/template\\/standard\\/261503\\/4\"}]}}]},\"error_code\":\"0\",\"success\":true},\"request_id\":\"15qsnmdwe09vb\"}}"}

        //{"cainiao_cloudprint_mystdtemplates_get_response":{"result":{"datas":{"user_template_result":[{"cp_code":"FEDEX","user_std_templates":{"user_template_do":[{"brand_code":"default","keys":{},"user_std_template_id":66260731,"user_std_template_name":"1","user_std_template_url":"https:\/\/cloudprint.cainiao.com\/template\/standard\/261503\/4"}]}},{"cp_code":"YTO","user_std_templates":{"user_template_do":[{"brand_code":"default","keys":{},"user_std_template_id":66262319,"user_std_template_name":"圆通自定义","user_std_template_url":"https:\/\/cloudprint.cainiao.com\/template\/standard\/101\/642"}]}}]},"error_code":"0","success":true},"request_id":"15quh3kjxozlm"}}
        //{"cainiao_cloudprint_mystdtemplates_get_response":{"result":{"datas":[{}],"error_code":"0","success":true}},"respBody":"{\"cainiao_cloudprint_mystdtemplates_get_response\":{\"result\":{\"datas\":{\"user_template_result\":[{\"cp_code\":\"FEDEX\",\"user_std_templates\":{\"user_template_do\":[{\"brand_code\":\"default\",\"keys\":{},\"user_std_template_id\":66260731,\"user_std_template_name\":\"1\",\"user_std_template_url\":\"https:\\/\\/cloudprint.cainiao.com\\/template\\/standard\\/261503\\/4\"}]}},{\"cp_code\":\"YTO\",\"user_std_templates\":{\"user_template_do\":[{\"brand_code\":\"default\",\"keys\":{},\"user_std_template_id\":66262319,\"user_std_template_name\":\"圆通自定义\",\"user_std_template_url\":\"https:\\/\\/cloudprint.cainiao.com\\/template\\/standard\\/101\\/642\"}]}}]},\"error_code\":\"0\",\"success\":true},\"request_id\":\"15quh3kjxozlm\"}}"}

    }


    @Test
    void cainiaoCloudprintCustomaresGet() throws Exception {
        String apiUrl = "https://eco.taobao.com/router/rest";
        String appKey = "34124006";
        String appSecret = "4a921fb19d69fca3db1becf7d96c00ca";
        String sessionKey = "6100506c11ee151a6f033ab9d649f6aa2e5ba207a1360ac2206890150985";
        TaoBaoAppClientDTO appDTO = new TaoBaoAppClientDTO();
        appDTO.setAppKey(appKey);
        appDTO.setAppSecret(appSecret);
        appDTO.setSessionKey(sessionKey);
//        appDTO.setTargetAppKey(targetAppKey);
        appDTO.setApiUrl(apiUrl);

        Long template_id = Long.valueOf("66260731");
        //66262319
        template_id = Long.valueOf("66263123");
        CainiaoCloudprintCustomaresGetReqDTO reqDTO = new CainiaoCloudprintCustomaresGetReqDTO();
        reqDTO.setTemplate_id(template_id);
        CainiaoCloudprintCustomaresGetGetRespVO xiaohongshuTokenCreateVO = taoBaoLogisticsCall.cainiaoCloudprintCustomaresGet(appDTO, reqDTO);
        System.out.println(xiaohongshuTokenCreateVO.getRespBody());
        System.out.println(JSON.toJSONString(xiaohongshuTokenCreateVO));

        //第一次
        //{"error_response":{"code":15,"msg":"Remote service error","sub_code":"2401","sub_msg":"资源不存在","request_id":"16kksr4el1bs0"}}
        //{"error_response":{"code":15,"msg":"Remote service error","request_id":"16kksr4el1bs0","sub_code":"2401","sub_msg":"资源不存在"},"respBody":"{\"error_response\":{\"code\":15,\"msg\":\"Remote service error\",\"sub_code\":\"2401\",\"sub_msg\":\"资源不存在\",\"request_id\":\"16kksr4el1bs0\"}}"}


        //结构化
        //{"cainiao_cloudprint_customares_get_response":{"result":{"datas":{"custom_area_result":[{"custom_area_id":69787940,"custom_area_url":"https:\/\/cloudprint.cainiao.com\/template\/customArea\/69787940\/1","keys":{}}]},"error_code":"0","success":true},"request_id":"16mevs6y2xyto"}}
        //{"cainiao_cloudprint_customares_get_response":{"result":{"datas":[{}],"error_code":"0","success":true}},"respBody":"{\"cainiao_cloudprint_customares_get_response\":{\"result\":{\"datas\":{\"custom_area_result\":[{\"custom_area_id\":69787940,\"custom_area_url\":\"https:\\/\\/cloudprint.cainiao.com\\/template\\/customArea\\/69787940\\/1\",\"keys\":{}}]},\"error_code\":\"0\",\"success\":true},\"request_id\":\"16mevs6y2xyto\"}}"}


        //{"cainiao_cloudprint_customares_get_response":{"result":{"datas":{"custom_area_result":[{"custom_area_id":69789725,"custom_area_url":"https:\/\/cloudprint.cainiao.com\/template\/customArea\/69789725\/1","keys":{}}]},"error_code":"0","success":true},"request_id":"15r1u4ih81sse"}}
        //{"cainiao_cloudprint_customares_get_response":{"result":{"datas":[{}],"error_code":"0","success":true}},"respBody":"{\"cainiao_cloudprint_customares_get_response\":{\"result\":{\"datas\":{\"custom_area_result\":[{\"custom_area_id\":69789725,\"custom_area_url\":\"https:\\/\\/cloudprint.cainiao.com\\/template\\/customArea\\/69789725\\/1\",\"keys\":{}}]},\"error_code\":\"0\",\"success\":true},\"request_id\":\"15r1u4ih81sse\"}}"}

    }


}
