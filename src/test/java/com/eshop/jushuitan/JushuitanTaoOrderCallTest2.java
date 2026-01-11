package com.eshop.jushuitan;

import com.alibaba.fastjson.JSON;
import com.eshop.util.platform.api.client.jushuitan.request.QimenCustomAppClientDTO;
import com.eshop.util.platform.api.service.order.jushuitan.JushuitanTaoOrderCall;
import com.eshop.util.platform.api.service.order.jushuitan.dto.JushuitanTaoOrderListReqDTO;
import com.eshop.util.platform.api.service.order.jushuitan.dto.JushuitanTaoReceiverInfoReqDTO;
import com.eshop.util.platform.api.service.order.jushuitan.dto.JushuitanTaoSaleOrderListReqDTO;
import com.eshop.util.platform.api.service.order.jushuitan.vo.JushuitanTaoOrderListRespVO;
import com.eshop.util.platform.api.service.order.jushuitan.vo.JushuitanTaoReceiverInfoRespVO;
import com.eshop.util.platform.api.service.order.jushuitan.vo.JushuitanTaoSaleOrderListRespVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class JushuitanTaoOrderCallTest2 {

    @Autowired
    private JushuitanTaoOrderCall jushuitanTaoOrderCall;


    /*
            淘系销售出库单(列表)查询【奇门自定义接口】
            奇门申请地址：https://open.taobao.com/docV3.htm?docId=118393&docType=1&source=search#ss13

            奇门系统参数的target_app_key  给 23060081

            奇门接口路由参数:

            接口需要额外带上customer_id,传不同的customer_id来路由不同的商家链接, 具体的值需要在进行授权的时候向聚水潭获取

            customer_id获取方法：文档中的上线流程  https://openweb.jushuitan.com/doc?docId=250

            奇门API调用示例：

            https://open.taobao.com/docV3.htm?spm=a219a.7386797.0.0.759a669a4Kh2yK&source=search&docId=112&docType=1

            奇门调用签名sign生成文档：https://open.taobao.com/doc.htm?docId=101617&docType=1

            请求参数中start_ts的说明：

            使用ts的查询条件是唯一可避免分页查询过程中因数据变动而导致的漏单问题，原因是该查询条件是数据库中的时间戳，sql server中的行版本号。只要当前这条数据在数据库中有变化任何字段变化ts的值都会自增，全表唯一的自增值，非业务上做的时间值更新。使用ts的查询模板

            第一次请求：{"start_ts":1."is_get_total":false,"page_index":1."page_size":100} //第一次请求ts从1开始

            第二次请求：{"start_ts":传第一次返回的最大ts值."is_get_total":false,"page_index":1."page_size":100} //一直请求到查不到比入参ts值本身更大的数据为止



            奇门自定义调用示例代码C#版本：请参考奇门自定义订单查询文档有完整示例代码“订单查询示例代码”，参考示例代码时请更换对应的method接口名

            其他语言如java，php请参考奇门官方示例代码请点击“奇门官方示例代码及SDK”
     */
    @Test
    void TaoOrderCallGetOrderList() throws Exception {
        //wms的 appKey
        String appKey = "35256860";
        //wms的 appSecret
        String appSecret = "811bc31681a6e83edaa16901666a4603";
        String sessionKey = "";
        //聚水潭的 targetAppKey
        String targetAppKey = "23060081";
        //聚水潭绑定wms生成的 customerId
        String customerId = "10969016";
        //奇门调用地址
        String apiUrl = "http://a1q40taq0j.api.taobao.com/router/qm";

        QimenCustomAppClientDTO appDTO = new QimenCustomAppClientDTO();
        appDTO.setAppKey(appKey);
        appDTO.setAppSecret(appSecret);
        appDTO.setSessionKey(sessionKey);
        appDTO.setTargetAppKey(targetAppKey);
        appDTO.setCustomerId(customerId);
        appDTO.setApiUrl(apiUrl);


        //page_index	int	是	1	页码
        Integer page_index = 1;
        //page_size	int	是	25	页数，最大100
        Integer page_size = 50;
        JushuitanTaoSaleOrderListReqDTO reqDTO = new JushuitanTaoSaleOrderListReqDTO();
        reqDTO.setPage_index(page_index);
        reqDTO.setPage_size(page_size);

        //start_time	string		2019-01-02 00:00:00	开始时间
        String start_time = "2026-01-08 00:00:00";
        //end_time	string		2019-01-02 00:00:00	结束时间
        String end_time = "2026-01-11 00:00:00";
        reqDTO.setStart_time(start_time);
        reqDTO.setEnd_time(end_time);
        //订单状态不必填 因为需要拉取多个状态 这里不做限制

        JushuitanTaoSaleOrderListRespVO respVO = jushuitanTaoOrderCall.getSaleOrderList(appDTO, reqDTO);
        System.out.println(respVO.getRespBody());
        System.out.println(JSON.toJSON(respVO));
    }

    @Test
    void getSaleOrderList() throws Exception {
        //wms的 appKey
        String appKey = "35256860";
        //wms的 appSecret
        String appSecret = "811bc31681a6e83edaa16901666a4603";
        String sessionKey = "";
        //聚水潭的 targetAppKey
        String targetAppKey = "23060081";
        //聚水潭绑定wms生成的 customerId
        String customerId = "10969016";
        //奇门调用地址
        String apiUrl = "http://a1q40taq0j.api.taobao.com/router/qm";

        QimenCustomAppClientDTO appDTO = new QimenCustomAppClientDTO();
        appDTO.setAppKey(appKey);
        appDTO.setAppSecret(appSecret);
        appDTO.setSessionKey(sessionKey);
        appDTO.setTargetAppKey(targetAppKey);
        appDTO.setCustomerId(customerId);
        appDTO.setApiUrl(apiUrl);


        //page_index	int	是	1	页码
        Integer page_index = 1;
        //page_size	int	是	25	页数，最大100
        Integer page_size = 50;
        JushuitanTaoSaleOrderListReqDTO reqDTO = new JushuitanTaoSaleOrderListReqDTO();
        reqDTO.setPage_index(page_index);
        reqDTO.setPage_size(page_size);
        String so_ids = "3168479786331150357,3168890472371444265";
        reqDTO.setSo_ids(so_ids);
        JushuitanTaoSaleOrderListRespVO respVO = jushuitanTaoOrderCall.getSaleOrderList(appDTO, reqDTO);
        System.out.println(respVO.getRespBody());
        System.out.println(JSON.toJSON(respVO));
    }


    @Test
    void queryReceiverInfo() throws Exception {

        /**
         * 可替换为您的应用的appKey
         * 聚水潭注释 奇门的appKey
         */
        String appKey = "23060081";
        /**
         * 可替换为您的应用的appSecret
         * 聚水潭注释 奇门的密钥
         */
        String appSecret = "";
        /**
         * 必须替换为授权得到的真实有效sessionKey
         * 聚水潭注释 非必填参数 可以不传
         */
        String sessionKey = "";
        /**
         * 用户需要透传的targetAppkey，主要用于安全验签，
         * 验签的目的是防止黑客恶意调用你的服务，确保服务发起来源来自奇门云网关。
         */
        String targetAppKey = "23060081";

        String customerId = "";
        /**
         * 奇门调用地址
         * 聚水潭注释 请求容器URL
         */
//        String apiUrl = "https://qimen.api.taobao.com/router/qimen/service";
        String apiUrl = "http://qimen.api.taobao.com/router/qimen/service";

        QimenCustomAppClientDTO appDTO = new QimenCustomAppClientDTO();
        appDTO.setAppKey(appKey);
        appDTO.setAppSecret(appSecret);
        appDTO.setSessionKey(sessionKey);
//        appDTO.setTargetAppKey(targetAppKey);
        appDTO.setCustomerId(customerId);
        appDTO.setApiUrl(apiUrl);

        //oaid	String	false	订单收件人 ID, string (50)	订单收件人 ID, string (50)
        String oaid  = "666";
        //deliveryOrderCode	String	true	出库单号, string (50) , 必填	出库单号, string (50) , 必填
        String deliveryOrderCode= "666";
        //ownerCode	String	false	货主ID, string (50)	货主ID
        String ownerCode= "666";
        //warehouseCode	String	false	WS1231，string (64)	仓库编码
        String warehouseCode= "666";
        //scene	String	false	使用场景, string(10)，必填	使用场景。1001，顺丰电子面单发货；1002，4通一达电子面单发货；1003，EMS电子面单发货；1004，其他电子面单发货；2001，客户售后服务
        String scene= "2001";

        JushuitanTaoReceiverInfoReqDTO reqDTO = new JushuitanTaoReceiverInfoReqDTO();
        reqDTO.setOaid(oaid);
        reqDTO.setDeliveryOrderCode(deliveryOrderCode);
        reqDTO.setOwnerCode(ownerCode);
        reqDTO.setWarehouseCode(warehouseCode);
        reqDTO.setScene(scene);

        JushuitanTaoReceiverInfoRespVO respVO = jushuitanTaoOrderCall.queryReceiverInfo(appDTO, reqDTO);
        System.out.println(respVO.getRespBody());
        System.out.println(JSON.toJSON(respVO));
    }

}