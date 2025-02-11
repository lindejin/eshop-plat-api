package com.eshop.util.platform.api.service.auth.aliexpress;

import com.eshop.util.platform.api.service.auth.aliexpress.dto.AeCodeUrlCreateDTO;
import com.eshop.util.platform.api.service.auth.aliexpress.dto.AeTokenCreateDTO;
import com.eshop.util.platform.api.service.auth.aliexpress.dto.AeTokenRefreshDTO;
import com.eshop.util.platform.api.structure.aliexpress.dto.AeAppClientDTO;
import com.eshop.util.platform.api.structure.aliexpress.enumerate.AliexpressTokenEnu;
import com.global.iop.api.IopClient;
import com.global.iop.api.IopClientImpl;
import com.global.iop.api.IopRequest;
import com.global.iop.api.IopResponse;
import com.global.iop.domain.Protocol;
import org.springframework.stereotype.Service;

/**
 * @author ldj
 * @date 2024/2/26 16:47
 * @Description: ...
 * @Version 1.0
 */
@Service("AliExpressAuthCallServiceImpl")
public class AliExpressAuthCallServiceImpl implements AliExpressAuthCallService {

    @Override
    public String codeUrlCreate(AeAppClientDTO acDTO, AeCodeUrlCreateDTO reqDto) throws Exception {
        String authorizeUrl = acDTO.getUrl();
        String redirect = reqDto.getRedirectUrl();
        String path = "/oauth/authorize";
        String appKey = acDTO.getAppKey();
        Long shopId = reqDto.getShopId();
        Long opId = reqDto.getOpId();
        String redirect_url = redirect + "/" + shopId + "/" + opId + "/";
        String urlNet = authorizeUrl + path + "?response_type=code&force_auth=true&redirect_uri=" + redirect_url + "&client_id=" + appKey;
        return urlNet;
    }

    //生成调用api的access_token
    //生成调用api的access_token
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("/auth/token/create");
request.addApiParameter("code", "0_2DL4DV3jcU1UOT7WGI1A4rY91");
request.addApiParameter("uuid", "uuid");
IopResponse response = client.execute(request, Protocol.GOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 生成access_token
     */
    @Override
    public String tokenCreate(AeAppClientDTO acDTO, AeTokenCreateDTO reqDto) throws Exception {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressTokenEnu.TOKEN_CREATE.getApiName());
        request.addApiParameter("code", reqDto.getCode());
        request.addApiParameter("uuid", reqDto.getUuid());
        IopResponse response = client.execute(request, Protocol.TOP);
        return response.getGopResponseBody();
    }

    //刷新access_token
    //刷新access_token，端点 https://api-sg.aliexpress.com/rest
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("/auth/token/refresh");
request.addApiParameter("refresh_token", "50001600212wcwiOabwyjtEH11acc19aBOvQr9ZYkYDlr987D8BB88LIB8bj");
IopResponse response = client.execute(request, Protocol.GOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 刷新access_token
     */
    @Override
    public String tokenRefresh(AeAppClientDTO acDTO, AeTokenRefreshDTO reqDto) throws Exception {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressTokenEnu.TOKEN_REFRESH.getApiName());
        request.addApiParameter("refresh_token", reqDto.getRefresh_token());
        IopResponse response = client.execute(request, Protocol.TOP);
        return response.getGopResponseBody();
    }
}
