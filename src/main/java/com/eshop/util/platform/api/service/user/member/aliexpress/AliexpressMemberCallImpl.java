package com.eshop.util.platform.api.service.user.member.aliexpress;

import com.eshop.util.platform.api.service.user.member.aliexpress.dto.AeMemberDsOrderDataSaveDTO;
import com.eshop.util.platform.api.service.user.member.aliexpress.dto.AeMemberOauthAuthorizeDTO;
import com.eshop.util.platform.api.service.user.member.aliexpress.dto.AeMemberQueryAccountLevelDTO;
import com.eshop.util.platform.api.service.user.member.aliexpress.dto.AeMemberUicQueryTbNickDTO;
import com.eshop.util.platform.api.structure.aliexpress.dto.AeAppClientDTO;
import com.eshop.util.platform.api.structure.aliexpress.enumerate.AliexpressMemberEnu;
import com.global.iop.api.IopClient;
import com.global.iop.api.IopClientImpl;
import com.global.iop.api.IopRequest;
import com.global.iop.api.IopResponse;
import com.global.iop.domain.Protocol;
import com.global.iop.util.ApiException;
import org.springframework.stereotype.Service;

/**
 * @author ldj
 * @date 2024/3/7 9:42
 * @Description: ...
 * @Version 1.0
 */
@Service
public class AliexpressMemberCallImpl implements AliexpressMemberCall {


    //查询淘宝的nickName
    //描述：通过AE的loginId查询淘宝的nickName
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.member.redefining.uicquerytbnick");
request.addApiParameter("login_id", "cn1519431219gong");
IopResponse response = client.execute(request, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 查询淘宝的nickName
     */
    @Override
    public String uicQueryTbNick(AeAppClientDTO acDTO, AeMemberUicQueryTbNickDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressMemberEnu.UIC_QUERY_TB_NICK.getApiName());
        request.addApiParameter("login_id", reqDto.getLogin_id());
        IopResponse response = client.execute(request, Protocol.TOP);
        return response.getGopResponseBody();
    }

    //收集下单的用户和订单金额等信息
    //描述：收集dropshipper导购站点下单的用户和订单金额等信息
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.member.ds.orderdata.save");
request.addApiParameter("dser_collect_data", "{\"ae_product_id\":\"1334345\",\"ae_sku_info\":\"200000182:193;200007763:201336100\",\"product_url\":\"https://www.yousite.com/item/32862631421.html\",\"order_amount\":\"35.33\",\"paytime\":\"20191122:150606\",\"ae_orderid\":\"1334345\",\"product_amount\":\"35.33\"}");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 收集下单的用户和订单金额等信息
     */
    @Override
    public String dsOrderDataSave(AeAppClientDTO acDTO, AeMemberDsOrderDataSaveDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressMemberEnu.DS_ORDER_DATA_SAVE.getApiName());
        request.addApiParameter("dser_collect_data", reqDto.getDser_collect_data());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    //oauth授权
    //描述：该开放接口使用OK的authCode 映射到AE账号上进行Top平台的授权操作
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.member.oauth.authorize");
request.addApiParameter("response_type", "code");
request.addApiParameter("sns_authorization_code", "afjaodfjaojdfoajdfioa");
request.addApiParameter("sns_type", "ok");
request.addApiParameter("auto_register", "true");
IopResponse response = client.execute(request, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * oauth授权
     */
    @Override
    public String oauthAuthorize(AeAppClientDTO acDTO, AeMemberOauthAuthorizeDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressMemberEnu.OAUTH_AUTHORIZE.getApiName());
        request.addApiParameter("response_type", reqDto.getResponse_type());
        request.addApiParameter("sns_authorization_code", reqDto.getSns_authorization_code());
        request.addApiParameter("sns_type", reqDto.getSns_type());
        request.addApiParameter("auto_register", reqDto.getAuto_register());
        IopResponse response = client.execute(request, Protocol.TOP);
        return response.getGopResponseBody();
    }
    //查询会员账户等级
    //描述：根据买家登录ID查询会员等级。平台对买家层级的标识，以A0-A4五个等级进行标注，数字越高，等级越高，买家越活跃，购买力越强,卖家朋友可根据买家分层更好的服务于买家。
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.member.redefining.queryaccountlevel");
request.addApiParameter("login_id", "jordenmail");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 查询会员账户等级
     */
    @Override
    public String queryAccountLevel(AeAppClientDTO acDTO, AeMemberQueryAccountLevelDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressMemberEnu.QUERY_ACCOUNT_LEVEL.getApiName());
        request.addApiParameter("login_id", reqDto.getLogin_id());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }
}
