package com.eshop.taobao;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.eshop.util.platform.api.client.jushuitan.QimenCustomApiClient;
import com.eshop.util.platform.api.client.jushuitan.QimenTaoApiClient;
import com.eshop.util.platform.api.client.jushuitan.request.QimenCustomAppClientDTO;
import com.eshop.util.platform.api.client.jushuitan.request.QimenCustomRequest;
import com.eshop.util.platform.api.client.jushuitan.response.QimenCustomResponse;
import com.eshop.util.platform.api.client.taobao.request.TaoBaoAppClientDTO;
import com.eshop.util.platform.api.service.logistics.taobao.TaoBaoLogisticsCall;
import com.eshop.util.platform.api.service.logistics.taobao.dto.*;
import com.eshop.util.platform.api.service.logistics.taobao.vo.*;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.*;

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
        String waybill_code = "YT7600066683612";
        TaoBaoEbillOrderWaybillDetailQueryByWaybillCodeRequest row = new TaoBaoEbillOrderWaybillDetailQueryByWaybillCodeRequest();
        row.setCp_code(cp_code);
        row.setObject_id(object_id);
        row.setWaybill_code(waybill_code);
        List<TaoBaoEbillOrderWaybillDetailQueryByWaybillCodeRequest> list = new ArrayList<>();
        list.add(row);
        TaoBaoEbillOrderReqDTO reqDTO = new TaoBaoEbillOrderReqDTO();
        reqDTO.setParam_list(list);


        TaoBaoEbillOrderRespVO respVO = taoBaoLogisticsCall.queryEcBillOrder(appDTO, reqDTO);
        System.out.println(respVO.getRespBody());
        System.out.println(JSON.toJSONString(respVO));
        //第一次
        //{"cainiao_waybill_ii_query_by_waybillcode_response":{"modules":{"waybill_cloud_print_with_result_desc_response":[{"object_id":"2e8f005d-7bb7-4b26-bd76-4273a203a8e5","success":true,"waybill_cloud_print_response":{"print_data":"{\"encryptedData\":\"AES:rU904rj6UH2oqfSUb43+Z199vDU2GZtH5\/LVIEq0ppUJuwjq7qZ58JRvDHOQ\/f2QhqdsWiYYFqp6z96+fPLupxENx4gZUSA\/zYJbbdwevCzeI+22t7hONi0e8k4pytGn0cs+O\/SQI1why\/dhaLeykWnnlGU0C0H6rLb9Myr8u1LJAYfQ7SsjVBRaWlssLiH1kWSfGOTZIOkh5WTnbdxPi08HJV+ZEEBVCoPXVHJDpcK1R5+aEFHTaaPA8hdfslZFbDRsR2HRygU1aH9gkxrtOJOgL2h8xN4FxaScOFAueeM02fE0M6R5OW3\/tG2db\/uSO1LeFpLhsvAAavywxPYKKAqAWH\/W\/1cfllrQ8zk3ZeOZj+EAnpCyMNgmN0mEaeYUT6ZPB62QmecrMlnnX9yrigewlb7NEw880iGKoy8xTrIDaMETvoNsS+cN9QYsmFOykkurZ0nHhfE35xXhA\/t2L3889OFflzf5KaoBVcTynldKwDBAwWIVRTBRNdzqf5rMyp2qt\/j2QRkNt0ufBJ+O8F21ji1F90qUuc2yV0A4gX8\/bYk4hVP0FnpKEF4tS\/+2aM8Ki55L0B4cM65hZHsqSWEQzJICbsIcnohyWH8DTp1Z6dcnfquU113K6dgd8tw43Vdc5h5+vva7NAh7ohJfEpzwAc0DukUHMl0gu0mecn6Q7g0s7GQ5u0hKjLG2RATMR5v0jcpuzU1dhPbGdHiUzn1NT7xSnb317qiXw9Hcp8V26OUT8DIfsUP4wFyXkcUit3QdepO3kc34G0BlkDyvd5pArU+HUoGoxN4Rs0XswY69SexkoDFLlvKtpvGcOBIoloiXtdpYAqzEBWGNdKLNjPL2v\/GYUsIo+2+LsV5fjYzNcj5NMweNe8rzaz4p\/z0OrIzBqHyurLlDLTJ6mkQMF7Zn5E\/y\/\/A+GaSCXay2DNVoC1w349AA7vPkHzA7FirVYYbm0lAxO0z\/Iw0b\/WA0OQ4KggaIBACcP47qOW8kynrpAUkiaHiAlfLLajDqoKkHVaYvanMKvJOpMnQOWYOd0ORmjtYBfQiivGadgq+zGld91EUn7ItRenTAm628cZIJ0GihcHLgJul\/DZJOXgRmI96bwP3V\/UChZXaoxiEPadvBuD2\/UMgwGoCatbk6DLhDWxR+wz+E9bCOxAbWvmmAGsVBo37Jz7b3zinok87yo9g8txTc\/gx4xEYKNdY0Xzx2eCs+gOzZLov\/pA5lL2kwVlsD4Lh6zv01IDu7erR3yJVot+k5oE1tNr0f5FBnd2OTAa\/utVcOrKm8nVO6SEDxZNYwL+Vu0JiKFn469HM2htzVLKMaAn7noHrda25Y+uJGckS94q\/nPqpE9NHSvg+VN6zlQ1jSReTT8WOu2U9IKqpaswdg8mUeUuQn8Va\/wIKY3pWflnjN8A0NctEYYZ8Tslqw40UTIzyNA9I7\/NFHV3u+DJVgeeJ0L8\/Sqbfk+taK8NZrXCwsXS6J+MA8DihtZaxrb1Bu68Mftf\/cJmRpvo5YOx+dFuy3ioZTNSaAd1qTFS04N+GOgF42\/PSqqjU+B99ERMVWmjMrbrBkpMKlHEKeH++pPEO6pYzTV9ob4t0Cavd3xEgMXhM3wh98OWeTMbs3KO3Oh3VT9IDIXlEwX693rWOjg1dz1DYTOk6XeaahRi7RuZRQPDEaHNfKVp91A01j2J9T3TJP+OYMlS0+U99cZMXgmmUV+597VyxwihbF93\/LOO3ASvvQuuZdFC5OgosrZObt2caWFemDrVGZ3UqqHv+PA22dO825ZvFdoWZ+Cwl9NUYpqa1CARXAcHW9k9FSAAbODxXu+lO\/CvZ87igCp3zTMRtvBQfPEIiyJj7Rh0lwaH0gAOPmOPNg7qalpFck1tKVCV8ZO1CLJf+3kcmbnCcqcoGY12yJigbHTU\/Hn9kORMJOEZOChNPOUGjVhs1dtacrjTh0DaWfE5L81ecLiOepR7RoHARK57iF1751uiKXmq73DYO\/Cz9f4sfsOa7o64JKo+guIR4OJopaNrW8r1Mxyym9rqNrZDXWRtBiAFts9L7Of8lawxNlMJhEBKTwC+6ciIeSiK4+B3OPF2x7nWQwo3LpspN\/CMLum4lrQ9oFCqNWf79UtQvKEKuIRRKlMwO7YH3oELo7xJuJBjivAOjz8OamEvVkHSSGSCr9BpU59uM1gMbybDYkTOvYJHefXrLWzJVYxKqHc6NLXaPTedTQnOLyNodpWCtBHDA\/mw5+co\/movnIkWzxjaTZQMpB9b\/KPo3wCaYWXw0fVqA9A4Ll8m4ofI7SlK2r\/iphfB\/keGNQx1SzioMJkw65WfmoCNyk5khtZzzPiB8ihChBYzveb2VHK04HKmM8oNePp9rvU7pYioYfPi2GgLf3+imrux4I6pw69ra6K1Jo9nYjWhAk0shTgMXNwInJRce4k04tcXk7EooEST4H57FaJw==\",\"signature\":\"MD:EksqcqnCVyCS\/rBtOQlzSQ==\",\"templateURL\":\"http:\/\/cloudprint.cainiao.com\/template\/standard\/290659\",\"ver\":\"waybill_print_secret_version_1\"}","waybill_code":"YT7596382757695"}}]},"request_id":"16ms4tudox3u6"}}
        //{"respBody":"{\"cainiao_waybill_ii_query_by_waybillcode_response\":{\"modules\":{\"waybill_cloud_print_with_result_desc_response\":[{\"object_id\":\"2e8f005d-7bb7-4b26-bd76-4273a203a8e5\",\"success\":true,\"waybill_cloud_print_response\":{\"print_data\":\"{\\\"encryptedData\\\":\\\"AES:rU904rj6UH2oqfSUb43+Z199vDU2GZtH5\\/LVIEq0ppUJuwjq7qZ58JRvDHOQ\\/f2QhqdsWiYYFqp6z96+fPLupxENx4gZUSA\\/zYJbbdwevCzeI+22t7hONi0e8k4pytGn0cs+O\\/SQI1why\\/dhaLeykWnnlGU0C0H6rLb9Myr8u1LJAYfQ7SsjVBRaWlssLiH1kWSfGOTZIOkh5WTnbdxPi08HJV+ZEEBVCoPXVHJDpcK1R5+aEFHTaaPA8hdfslZFbDRsR2HRygU1aH9gkxrtOJOgL2h8xN4FxaScOFAueeM02fE0M6R5OW3\\/tG2db\\/uSO1LeFpLhsvAAavywxPYKKAqAWH\\/W\\/1cfllrQ8zk3ZeOZj+EAnpCyMNgmN0mEaeYUT6ZPB62QmecrMlnnX9yrigewlb7NEw880iGKoy8xTrIDaMETvoNsS+cN9QYsmFOykkurZ0nHhfE35xXhA\\/t2L3889OFflzf5KaoBVcTynldKwDBAwWIVRTBRNdzqf5rMyp2qt\\/j2QRkNt0ufBJ+O8F21ji1F90qUuc2yV0A4gX8\\/bYk4hVP0FnpKEF4tS\\/+2aM8Ki55L0B4cM65hZHsqSWEQzJICbsIcnohyWH8DTp1Z6dcnfquU113K6dgd8tw43Vdc5h5+vva7NAh7ohJfEpzwAc0DukUHMl0gu0mecn6Q7g0s7GQ5u0hKjLG2RATMR5v0jcpuzU1dhPbGdHiUzn1NT7xSnb317qiXw9Hcp8V26OUT8DIfsUP4wFyXkcUit3QdepO3kc34G0BlkDyvd5pArU+HUoGoxN4Rs0XswY69SexkoDFLlvKtpvGcOBIoloiXtdpYAqzEBWGNdKLNjPL2v\\/GYUsIo+2+LsV5fjYzNcj5NMweNe8rzaz4p\\/z0OrIzBqHyurLlDLTJ6mkQMF7Zn5E\\/y\\/\\/A+GaSCXay2DNVoC1w349AA7vPkHzA7FirVYYbm0lAxO0z\\/Iw0b\\/WA0OQ4KggaIBACcP47qOW8kynrpAUkiaHiAlfLLajDqoKkHVaYvanMKvJOpMnQOWYOd0ORmjtYBfQiivGadgq+zGld91EUn7ItRenTAm628cZIJ0GihcHLgJul\\/DZJOXgRmI96bwP3V\\/UChZXaoxiEPadvBuD2\\/UMgwGoCatbk6DLhDWxR+wz+E9bCOxAbWvmmAGsVBo37Jz7b3zinok87yo9g8txTc\\/gx4xEYKNdY0Xzx2eCs+gOzZLov\\/pA5lL2kwVlsD4Lh6zv01IDu7erR3yJVot+k5oE1tNr0f5FBnd2OTAa\\/utVcOrKm8nVO6SEDxZNYwL+Vu0JiKFn469HM2htzVLKMaAn7noHrda25Y+uJGckS94q\\/nPqpE9NHSvg+VN6zlQ1jSReTT8WOu2U9IKqpaswdg8mUeUuQn8Va\\/wIKY3pWflnjN8A0NctEYYZ8Tslqw40UTIzyNA9I7\\/NFHV3u+DJVgeeJ0L8\\/Sqbfk+taK8NZrXCwsXS6J+MA8DihtZaxrb1Bu68Mftf\\/cJmRpvo5YOx+dFuy3ioZTNSaAd1qTFS04N+GOgF42\\/PSqqjU+B99ERMVWmjMrbrBkpMKlHEKeH++pPEO6pYzTV9ob4t0Cavd3xEgMXhM3wh98OWeTMbs3KO3Oh3VT9IDIXlEwX693rWOjg1dz1DYTOk6XeaahRi7RuZRQPDEaHNfKVp91A01j2J9T3TJP+OYMlS0+U99cZMXgmmUV+597VyxwihbF93\\/LOO3ASvvQuuZdFC5OgosrZObt2caWFemDrVGZ3UqqHv+PA22dO825ZvFdoWZ+Cwl9NUYpqa1CARXAcHW9k9FSAAbODxXu+lO\\/CvZ87igCp3zTMRtvBQfPEIiyJj7Rh0lwaH0gAOPmOPNg7qalpFck1tKVCV8ZO1CLJf+3kcmbnCcqcoGY12yJigbHTU\\/Hn9kORMJOEZOChNPOUGjVhs1dtacrjTh0DaWfE5L81ecLiOepR7RoHARK57iF1751uiKXmq73DYO\\/Cz9f4sfsOa7o64JKo+guIR4OJopaNrW8r1Mxyym9rqNrZDXWRtBiAFts9L7Of8lawxNlMJhEBKTwC+6ciIeSiK4+B3OPF2x7nWQwo3LpspN\\/CMLum4lrQ9oFCqNWf79UtQvKEKuIRRKlMwO7YH3oELo7xJuJBjivAOjz8OamEvVkHSSGSCr9BpU59uM1gMbybDYkTOvYJHefXrLWzJVYxKqHc6NLXaPTedTQnOLyNodpWCtBHDA\\/mw5+co\\/movnIkWzxjaTZQMpB9b\\/KPo3wCaYWXw0fVqA9A4Ll8m4ofI7SlK2r\\/iphfB\\/keGNQx1SzioMJkw65WfmoCNyk5khtZzzPiB8ihChBYzveb2VHK04HKmM8oNePp9rvU7pYioYfPi2GgLf3+imrux4I6pw69ra6K1Jo9nYjWhAk0shTgMXNwInJRce4k04tcXk7EooEST4H57FaJw==\\\",\\\"signature\\\":\\\"MD:EksqcqnCVyCS\\/rBtOQlzSQ==\\\",\\\"templateURL\\\":\\\"http:\\/\\/cloudprint.cainiao.com\\/template\\/standard\\/290659\\\",\\\"ver\\\":\\\"waybill_print_secret_version_1\\\"}\",\"waybill_code\":\"YT7596382757695\"}}]},\"request_id\":\"16ms4tudox3u6\"}}"}

        //结构化
        CainiaoWaybillIiQueryByWaybillcodeWaybillCloudPrintResponse waybill_cloud_print_response = Optional.ofNullable(respVO)
                .map(TaoBaoEbillOrderRespVO::getCainiao_waybill_ii_query_by_waybillcode_response)
                .map(CainiaoWaybillIiQueryByWaybillcodeResponse::getModules)
                .map(CainiaoWaybillIiQueryByWaybillcodeWaybillCloudPrintWithResultDescResponse::getWaybill_cloud_print_with_result_desc_response)
                .filter(CollectionUtils::isNotEmpty)
                .map(p -> p.get(0))
                .map(CainiaoWaybillIiQueryByWaybillcodeWaybillCloudPrintWithResultDescStdResponse::getWaybill_cloud_print_response)
                .orElse(null);
        System.out.println(JSON.toJSONString(waybill_cloud_print_response));


        String print_data = Optional.ofNullable(respVO)
                .map(TaoBaoEbillOrderRespVO::getCainiao_waybill_ii_query_by_waybillcode_response)
                .map(CainiaoWaybillIiQueryByWaybillcodeResponse::getModules)
                .map(CainiaoWaybillIiQueryByWaybillcodeWaybillCloudPrintWithResultDescResponse::getWaybill_cloud_print_with_result_desc_response)
                .filter(CollectionUtils::isNotEmpty)
                .map(p -> p.get(0))
                .map(CainiaoWaybillIiQueryByWaybillcodeWaybillCloudPrintWithResultDescStdResponse::getWaybill_cloud_print_response)
                .map(CainiaoWaybillIiQueryByWaybillcodeWaybillCloudPrintResponse::getPrint_data)
                .orElse(null);
        System.out.println(JSON.parseObject(print_data));
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

    private static final String str = "{\n" +
            "  \"orderLines\": {\n" +
            "    \"snCode\": \"货品sn编码\",\n" +
            "    \"itemCode\": \"I1234\",\n" +
            "    \"discountAmount\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"discount\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"purchasePrice\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"itemName\": \"淘公仔\",\n" +
            "    \"qrCode\": \"one;two\",\n" +
            "    \"orderSourceCode\": \"P1234\",\n" +
            "    \"deliveryOrderId\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"imeiList\": {\n" +
            "      \"extSnList\": {}\n" +
            "    },\n" +
            "    \"stockInQty\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"inventoryType\": \"ZP\",\n" +
            "    \"subSourceCode\": \"J1234\",\n" +
            "    \"productDate\": \"2016-09-09\",\n" +
            "    \"itemId\": \"WI1234\",\n" +
            "    \"batchs\": {\n" +
            "      \"produceCode\": \"PH1234\",\n" +
            "      \"inventoryType\": \"ZP\",\n" +
            "      \"quantity\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"snCode\": \"货品sn编码\",\n" +
            "      \"batchCode\": \"PC1234\",\n" +
            "      \"remark\": \"备注\",\n" +
            "      \"expireDate\": \"2017-09-09\",\n" +
            "      \"productDate\": \"2016-09-09\",\n" +
            "      \"actualQty\": 12\n" +
            "    },\n" +
            "    \"extCode\": \"PL1234\",\n" +
            "    \"size\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"sourceOrderCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"locationCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"status\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"planQty\": 12,\n" +
            "    \"color\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"actualPrice\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"ownerCode\": \"OW1234\",\n" +
            "    \"discountPrice\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"stockOutQty\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"remark\": \"备注\",\n" +
            "    \"supplierCode\": \"供应商编码\",\n" +
            "    \"actualQty\": 12,\n" +
            "    \"warehouseCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"skuProperty\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"payNo\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"produceCode\": \"P2345\",\n" +
            "    \"referencePrice\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"taobaoItemCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"expireDate\": \"2017-09-09\",\n" +
            "    \"supplierName\": \"供应商名称\",\n" +
            "    \"amount\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"orderLineNo\": \"1\",\n" +
            "    \"quantity\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"exceptionQty\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"batchCode\": \"P1234\",\n" +
            "    \"standardPrice\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"subDeliveryOrderId\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"subSourceOrderCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"moveOutLocation\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"standardAmount\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"productCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"outBizCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"moveInLocation\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"snList\": {},\n" +
            "    \"settlementAmount\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"retailPrice\": \"奇门仓储字段,说明,string(50),,\"\n" +
            "  },\n" +
            "  \"deliveryOrder\": {\n" +
            "    \"orderType\": \"JYCK\",\n" +
            "    \"buyerNick\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"operateTime\": \"2016-09-09 12:00:00\",\n" +
            "    \"discountAmount\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"shopNick\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"isCod\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"itemName\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"salesModel\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"invoices\": {\n" +
            "      \"number\": \"NUM123\",\n" +
            "      \"amount\": \"12.0\",\n" +
            "      \"code\": \"CODE123\",\n" +
            "      \"header\": \"XXX公司\",\n" +
            "      \"remark\": \"备注\",\n" +
            "      \"detail\": {\n" +
            "        \"items\": {\n" +
            "          \"orderType\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"reason\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"originAddress\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"discount\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"pricingCategory\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"itemName\": \"淘公仔\",\n" +
            "          \"packCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"price\": \"12.0\",\n" +
            "          \"brandCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"height\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"seasonCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"safetyStock\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"paperQty\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"productDate\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"stockUnit\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"itemId\": \"1234\",\n" +
            "          \"size\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"rejectLifecycle\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"shortName\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"planQty\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"ownerCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"supplierCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"defectiveQty\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"diffQuantity\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"tempRequirement\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"skuProperty\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"referencePrice\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"exCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"normalQty\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"seasonName\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"packageMaterial\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"expireDate\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"sn\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"shelfLife\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"orderLineNo\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"actualAmount\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"latestUpdateTime\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"costPrice\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"tagPrice\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"isSku\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"changeTime\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"productCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"width\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"goodsCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"retailPrice\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"tareWeight\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"priceAdjustment\": {\n" +
            "            \"endDate\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "            \"discount\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "            \"standardPrice\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "            \"remark\": \"备注\",\n" +
            "            \"type\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "            \"startDate\": \"奇门仓储字段,说明,string(50),,\"\n" +
            "          },\n" +
            "          \"snCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"itemCode\": \"1234\",\n" +
            "          \"lockQuantity\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"purchasePrice\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"lackQty\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"stockStatus\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"originCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"brandName\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"inventoryType\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"receiveQty\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"barCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"volume\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"batchs\": {\n" +
            "            \"produceCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "            \"inventoryType\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "            \"quantity\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "            \"batchCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "            \"expireDate\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "            \"remark\": \"备注\",\n" +
            "            \"productDate\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "            \"actualQty\": \"奇门仓储字段,说明,string(50),,\"\n" +
            "          },\n" +
            "          \"netWeight\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"unit\": \"个\",\n" +
            "          \"extCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"sourceOrderCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"isSNMgmt\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"lockupLifecycle\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"englishName\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"itemType\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"color\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"adventLifecycle\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"discountPrice\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"remark\": \"备注\",\n" +
            "          \"title\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"categoryName\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"actualQty\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"warehouseCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"produceCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"isShelfLifeMgmt\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"isAreaSale\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"isFragile\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"channelCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"supplierName\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"pcs\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"isHazardous\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"amount\": \"12.0\",\n" +
            "          \"quantity\": 12,\n" +
            "          \"batchCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"length\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"standardPrice\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"subSourceOrderCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"approvalNumber\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"grossWeight\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"isBatchMgmt\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"batchRemark\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"outBizCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"orderCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"categoryId\": \"奇门仓储字段,说明,string(50),,\"\n" +
            "        }\n" +
            "      },\n" +
            "      \"type\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"content\": \"XXX公司报销XX元\"\n" +
            "    },\n" +
            "    \"personalOrderNote\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"packCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"price\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"expressCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"orderSourceCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"pickerInfo\": {\n" +
            "      \"area\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"zipCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"career\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"idType\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"town\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"gender\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"city\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"mobile\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"countryCodeCus\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"remark\": \"备注\",\n" +
            "      \"idNumber\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"birthDate\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"nick\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"province\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"carNo\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"countryCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"name\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"detailAddress\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"company\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"tel\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"id\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"fax\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"countryCodeCiq\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"email\": \"奇门仓储字段,说明,string(50),,\"\n" +
            "    },\n" +
            "    \"arAmount\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"totalOrderLines\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"personalPackageNote\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"orderConfirmTime\": \"2016-09-08 12:00:00\",\n" +
            "    \"packages\": {\n" +
            "      \"theoreticalWeight\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"length\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"logisticsCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"weight\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"remark\": \"备注\",\n" +
            "      \"logisticsName\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"volume\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"packageMaterialList\": {\n" +
            "        \"quantity\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "        \"remark\": \"备注\",\n" +
            "        \"type\": \"奇门仓储字段,说明,string(50),,\"\n" +
            "      },\n" +
            "      \"packageCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"expressCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"width\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"invoiceNo\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"items\": {\n" +
            "        \"planQty\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "        \"quantity\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "        \"itemCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "        \"batchCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "        \"logisticsCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "        \"remark\": \"备注\",\n" +
            "        \"actualQty\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "        \"productDate\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "        \"barCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "        \"itemId\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "        \"produceCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "        \"itemName\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "        \"extCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "        \"packItemPrice\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "        \"expireDate\": \"奇门仓储字段,说明,string(50),,\"\n" +
            "      },\n" +
            "      \"height\": \"奇门仓储字段,说明,string(50),,\"\n" +
            "    },\n" +
            "    \"logisticsName\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"relatedOrders\": {\n" +
            "      \"orderType\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"orderCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"remark\": \"备注\"\n" +
            "    },\n" +
            "    \"lineNumber\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"items\": {\n" +
            "      \"orderType\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"reason\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"originAddress\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"discount\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"pricingCategory\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"itemName\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"packCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"price\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"brandCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"height\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"seasonCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"safetyStock\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"paperQty\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"productDate\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"stockUnit\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"itemId\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"size\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"rejectLifecycle\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"shortName\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"planQty\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"ownerCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"supplierCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"defectiveQty\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"diffQuantity\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"tempRequirement\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"skuProperty\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"referencePrice\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"exCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"normalQty\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"seasonName\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"packageMaterial\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"expireDate\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"sn\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"shelfLife\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"orderLineNo\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"actualAmount\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"latestUpdateTime\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"costPrice\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"tagPrice\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"isSku\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"changeTime\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"productCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"width\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"goodsCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"retailPrice\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"tareWeight\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"priceAdjustment\": {\n" +
            "        \"endDate\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "        \"discount\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "        \"standardPrice\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "        \"remark\": \"备注\",\n" +
            "        \"type\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "        \"startDate\": \"奇门仓储字段,说明,string(50),,\"\n" +
            "      },\n" +
            "      \"snCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"itemCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"lockQuantity\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"purchasePrice\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"lackQty\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"stockStatus\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"originCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"brandName\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"inventoryType\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"receiveQty\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"barCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"volume\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"batchs\": {\n" +
            "        \"produceCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "        \"inventoryType\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "        \"quantity\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "        \"batchCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "        \"expireDate\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "        \"remark\": \"备注\",\n" +
            "        \"productDate\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "        \"actualQty\": \"奇门仓储字段,说明,string(50),,\"\n" +
            "      },\n" +
            "      \"netWeight\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"unit\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"extCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"sourceOrderCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"isSNMgmt\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"lockupLifecycle\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"englishName\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"itemType\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"color\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"adventLifecycle\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"discountPrice\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"remark\": \"备注\",\n" +
            "      \"title\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"categoryName\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"actualQty\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"warehouseCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"produceCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"isShelfLifeMgmt\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"isAreaSale\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"isFragile\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"channelCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"supplierName\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"pcs\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"isHazardous\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"amount\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"quantity\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"batchCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"length\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"standardPrice\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"subSourceOrderCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"approvalNumber\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"grossWeight\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"isBatchMgmt\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"batchRemark\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"outBizCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"orderCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"categoryId\": \"奇门仓储字段,说明,string(50),,\"\n" +
            "    },\n" +
            "    \"status\": \"NEW\",\n" +
            "    \"ownerCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"serviceCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"freight\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"supplierCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"deliveryOrderCode\": \"T1234\",\n" +
            "    \"operatorCode\": \"O23\",\n" +
            "    \"sourcePlatformName\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"operatorName\": \"老王\",\n" +
            "    \"orderLines\": {\n" +
            "      \"snCode\": \"货品sn编码\",\n" +
            "      \"itemCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"discountAmount\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"discount\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"purchasePrice\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"itemName\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"qrCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"orderSourceCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"deliveryOrderId\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"imeiList\": {\n" +
            "        \"extSnList\": {}\n" +
            "      },\n" +
            "      \"inventoryType\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"stockInQty\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"subSourceCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"productDate\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"itemId\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"batchs\": {\n" +
            "        \"produceCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "        \"inventoryType\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "        \"quantity\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "        \"snCode\": \"货品sn编码\",\n" +
            "        \"batchCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "        \"expireDate\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "        \"remark\": \"备注\",\n" +
            "        \"productDate\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "        \"actualQty\": \"奇门仓储字段,说明,string(50),,\"\n" +
            "      },\n" +
            "      \"extCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"size\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"sourceOrderCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"locationCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"status\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"planQty\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"color\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"actualPrice\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"ownerCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"discountPrice\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"stockOutQty\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"remark\": \"remark\",\n" +
            "      \"actualQty\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"warehouseCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"skuProperty\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"produceCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"payNo\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"referencePrice\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"taobaoItemCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"expireDate\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"orderLineNo\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"amount\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"quantity\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"exceptionQty\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"batchCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"standardPrice\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"subDeliveryOrderId\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"subSourceOrderCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"moveOutLocation\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"standardAmount\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"productCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"outBizCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"moveInLocation\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"snList\": {},\n" +
            "      \"settlementAmount\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"retailPrice\": \"奇门仓储字段,说明,string(50),,\"\n" +
            "    },\n" +
            "    \"itemAmount\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"sellerMessage\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"shelfLife\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"sellerNick\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"shopCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"uomCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"actualAmount\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"noStackTag\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"buyerName\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"minArrivalTime\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"buyerMessage\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"createTime\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"isValueDeclared\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"orderFlag\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"priorityCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"modifiedTime\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"storageFee\": \"12.0\",\n" +
            "    \"transpostSum\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"mergeOrderCodes\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"payTime\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"declaredAmount\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"itemCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"produceDate\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"sellerId\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"payMethod\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"gotAmount\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"presaleOrderType\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"confirmType\": 0,\n" +
            "    \"planArrivalTime\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"deliveryOrderId\": \"C1234\",\n" +
            "    \"serviceFee\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"invoiceFlag\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"deliveryNote\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"logisticsCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"planDeliveryDate\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"totalAmount\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"isUrgency\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"buyerPhone\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"sourcePlatformCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"logisticsAreaCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"sourceOrderCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"transportMode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"exceptionCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"receiveOrderTime\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"deliveryRequirements\": {\n" +
            "      \"scheduleType\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"scheduleDay\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"deliveryType\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"remark\": \"备注\",\n" +
            "      \"scheduleStartTime\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"scheduleEndTime\": \"奇门仓储字段,说明,string(50),,\"\n" +
            "    },\n" +
            "    \"collectedAmount\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"orderNote\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"receiverInfo\": {\n" +
            "      \"area\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"zipCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"career\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"idType\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"town\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"gender\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"city\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"mobile\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"countryCodeCus\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"remark\": \"备注\",\n" +
            "      \"idNumber\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"birthDate\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"nick\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"province\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"carNo\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"countryCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"name\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"detailAddress\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"company\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"tel\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"id\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"fax\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"countryCodeCiq\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"email\": \"奇门仓储字段,说明,string(50),,\"\n" +
            "    },\n" +
            "    \"orderStatus\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"remark\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"mergeOrderFlag\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"warehouseCode\": \"W1234\",\n" +
            "    \"placeOrderTime\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"payNo\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"maxArrivalTime\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"preDeliveryOrderId\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"scheduleDate\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"insuranceFlag\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"supplierName\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"quantity\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"batchCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"preDeliveryOrderCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"senderInfo\": {\n" +
            "      \"area\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"zipCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"career\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"idType\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"town\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"gender\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"city\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"mobile\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"countryCodeCus\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"remark\": \"备注\",\n" +
            "      \"idNumber\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"birthDate\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"nick\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"province\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"carNo\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"countryCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"name\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"detailAddress\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"company\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"tel\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"id\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"fax\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"countryCodeCiq\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"email\": \"奇门仓储字段,说明,string(50),,\"\n" +
            "    },\n" +
            "    \"fetchItemLocation\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"outBizCode\": \"WB1234\",\n" +
            "    \"businessMemo\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"identifyCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"warehouseAddressCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"isPaymentCollected\": \"奇门仓储字段,说明,string(50),,\"\n" +
            "  },\n" +
            "  \"packages\": {\n" +
            "    \"theoreticalWeight\": \"12.0\",\n" +
            "    \"length\": \"12.0\",\n" +
            "    \"logisticsCode\": \"SF\",\n" +
            "    \"weight\": \"12.0\",\n" +
            "    \"remark\": \"备注\",\n" +
            "    \"logisticsName\": \"顺丰\",\n" +
            "    \"volume\": \"12.0\",\n" +
            "    \"packageMaterialList\": {\n" +
            "      \"quantity\": 12,\n" +
            "      \"remark\": \"备注\",\n" +
            "      \"type\": \"XLL\"\n" +
            "    },\n" +
            "    \"packageCode\": \"LG1234\",\n" +
            "    \"expressCode\": \"Y1234\",\n" +
            "    \"width\": \"12.0\",\n" +
            "    \"invoiceNo\": \"IN1234\",\n" +
            "    \"items\": {\n" +
            "      \"planQty\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"orderLineNo\": \"1\",\n" +
            "      \"quantity\": 11,\n" +
            "      \"batchCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"itemCode\": \"I1234\",\n" +
            "      \"logisticsCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"remark\": \"备注\",\n" +
            "      \"actualQty\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"productDate\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"barCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"produceCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"itemId\": \"WI1234\",\n" +
            "      \"itemName\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"extCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"packItemPrice\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"expireDate\": \"奇门仓储字段,说明,string(50),,\"\n" +
            "    },\n" +
            "    \"height\": \"12.0\"\n" +
            "  }\n" +
            "}";

    @Resource
    private QimenCustomApiClient qimenCustomApiClient;

    @Resource
    private QimenTaoApiClient qimenTaoApiClient;

    /**
     * 返回内容响应格式。不传默认为xml格式，可选值：xml，json。
     */
    private static final String FORMAT = "json";

    /**
     * API协议版本，可选值：2.0
     */
    private static final String VERSION = "2.0";

    /**
     * 签名的摘要算法，可选值为：hmac，md5，hmac-sha256。
     */
    private static final String SIGN_METHOD = "md5";
    @Test
    void tes00() throws Exception {
        String method = "taobao.qimen.deliveryorder.confirm";
        String appKey = "12129701";
        String sessionKey = null; // 根据实际情况设置
        String timestamp = "2026-01-18 18:19:43"; // 实际使用时应该用当前时间
        String format = "json";
        String version = "2.0";
        String signMethod = "md5";
        String targetAppKey = null; // 根据实际情况设置
        String customerId = null; // 根据实际情况设置
        String appSecret = "12129701"; // 替换为你的app secret
        // 公钥私钥

        QimenCustomAppClientDTO appDTO = new QimenCustomAppClientDTO();
        appDTO.setAppKey(appKey);
        appDTO.setAppSecret(appSecret);
        appDTO.setSessionKey(sessionKey);
        appDTO.setTargetAppKey(targetAppKey);
        appDTO.setCustomerId(customerId);
        appDTO.setApiUrl("33");

        // 构建请求
        QimenCustomRequest request = new QimenCustomRequest();
        request.setMethod(method);
        request.setFormat(FORMAT);
        request.setVersion(VERSION);
        request.setSignMethod(SIGN_METHOD);

        JSONObject jsonObject = JSON.parseObject(str);
        String requestJson = jsonObject.getString("request");
        Map<String, String> params = new HashMap<>();
        params.put("request", requestJson);
        params.put("partner_id", "top-apitools");
        request.setParams(params);


        // 执行请求
        QimenCustomResponse response = null;
        response = qimenTaoApiClient.executeTaoBao(request, appDTO);

        String respBody = response.getGopResponseBody();
    }



}
