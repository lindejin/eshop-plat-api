package com.eshop.dewu;

import com.alibaba.fastjson.JSON;
import com.eshop.util.platform.api.client.dewu.request.DewuAppClientDTO;
import com.eshop.util.platform.api.service.auth.dewu.DewuAuthCall;
import com.eshop.util.platform.api.service.auth.dewu.dto.DewuTokenCreateDTO;
import com.eshop.util.platform.api.service.auth.dewu.dto.DewuTokenRefreshDTO;
import com.eshop.util.platform.api.service.auth.dewu.vo.DewuTokenCreateVO;
import com.eshop.util.platform.api.service.auth.dewu.vo.DewuTokenRefreshVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class TestDewuAuthCall {

    @Autowired
    private DewuAuthCall dewuAuthCall;


    //https://open-dev-boss-api.worthfind.com/auth/authorize/tiktok/authcallback?code=lFhwaLJcZRF2&state=random_string_1764751192239

    @Test
    public void tokenCreate() throws Exception {
        String apiUrl = "https://openapi.dewu.com";
        String appKey = "75881da49c8b41caa2448c3fef771595";
        String appSecret = "5f44031fef3f41119f2324ac3fbeb9aaaf6a9d9fb4024455809bdaee3e30804c";
        DewuAppClientDTO appDTO = new DewuAppClientDTO();
        appDTO.setAppKey(appKey);
        appDTO.setAppSecret(appSecret);
        appDTO.setApiUrl(apiUrl);

        String code = "lFhwaLJcZRF2";
        DewuTokenCreateDTO reqDTO = new DewuTokenCreateDTO();
        reqDTO.setCode(code);
        DewuTokenCreateVO respVO = dewuAuthCall.tokenCreate(appDTO, reqDTO);
        System.out.println(respVO.getRespBody());
        System.out.println(JSON.toJSONString(respVO));

        //{"domain":"dop-core","code":500,"msg":"无效的authorization_code:5lvo8Yim0MT2","data":null,"errors":null,"status":500}
        //{"respBody":"{\"domain\":\"dop-core\",\"code\":500,\"msg\":\"无效的authorization_code:5lvo8Yim0MT2\",\"data\":null,\"errors\":null,\"status\":500}"}

        //{"code":200,"msg":"success","data":{"scope":["all"],"open_id":"efMZOTOhxi72Twy8","access_token":"8xlxEJkjgf1WAaO39Cpy3c8MfqTpxKJeYm01Q5847U03Gk992oIsT3eYAZGWApTZ","access_token_expires_in":86400,"refresh_token":"LNTdLO8JaNgBxv6RAdpXX7L3e41M1KDXNfxKipw6uCTQj0rVyZEq4W6J79IdiJCr","refresh_token_expires_in":15552000},"trace_id":"0aee13a7692ff7af9fa45eecd2d27f6b","status":200}
        //{"respBody":"{\"code\":200,\"msg\":\"success\",\"data\":{\"scope\":[\"all\"],\"open_id\":\"efMZOTOhxi72Twy8\",\"access_token\":\"8xlxEJkjgf1WAaO39Cpy3c8MfqTpxKJeYm01Q5847U03Gk992oIsT3eYAZGWApTZ\",\"access_token_expires_in\":86400,\"refresh_token\":\"LNTdLO8JaNgBxv6RAdpXX7L3e41M1KDXNfxKipw6uCTQj0rVyZEq4W6J79IdiJCr\",\"refresh_token_expires_in\":15552000},\"trace_id\":\"0aee13a7692ff7af9fa45eecd2d27f6b\",\"status\":200}"}

    }


    @Test
    public void tokenRefresh() throws Exception {
        String apiUrl = "https://openapi.dewu.com";
        String appKey = "75881da49c8b41caa2448c3fef771595";
        String appSecret = "5f44031fef3f41119f2324ac3fbeb9aaaf6a9d9fb4024455809bdaee3e30804c";
        DewuAppClientDTO appDTO = new DewuAppClientDTO();
        appDTO.setAppKey(appKey);
        appDTO.setAppSecret(appSecret);
        appDTO.setApiUrl(apiUrl);

        String refreshToken = "LNTdLO8JaNgBxv6RAdpXX7L3e41M1KDXNfxKipw6uCTQj0rVyZEq4W6J79IdiJCr";
        DewuTokenRefreshDTO reqDTO = new DewuTokenRefreshDTO();
        reqDTO.setRefreshToken(refreshToken);
        DewuTokenRefreshVO respVO = dewuAuthCall.tokenRefresh(appDTO, reqDTO);
        System.out.println(respVO.getRespBody());
        System.out.println(JSON.toJSONString(respVO));


        //{"code":200,"msg":"success","data":{"scope":["all"],"open_id":"efMZOTOhxi72Twy8","access_token":"FlS3wbNrBT3OyjOB63QH5h0wtoslcd8JjXMRx1AYC8CR3desbxZrQdzABrw9ofuw","access_token_expires_in":86400,"refresh_token":"LNTdLO8JaNgBxv6RAdpXX7L3e41M1KDXNfxKipw6uCTQj0rVyZEq4W6J79IdiJCr","refresh_token_expires_in":15548026},"trace_id":"0aee5b606930073522b8502facc64ce4","status":200}
        //{"code":200,"data":{"access_token":"FlS3wbNrBT3OyjOB63QH5h0wtoslcd8JjXMRx1AYC8CR3desbxZrQdzABrw9ofuw","access_token_expires_in":"86400","open_id":"efMZOTOhxi72Twy8","refresh_token":"LNTdLO8JaNgBxv6RAdpXX7L3e41M1KDXNfxKipw6uCTQj0rVyZEq4W6J79IdiJCr","refresh_token_expires_in":"15548026","scope":["all"]},"msg":"success","respBody":"{\"code\":200,\"msg\":\"success\",\"data\":{\"scope\":[\"all\"],\"open_id\":\"efMZOTOhxi72Twy8\",\"access_token\":\"FlS3wbNrBT3OyjOB63QH5h0wtoslcd8JjXMRx1AYC8CR3desbxZrQdzABrw9ofuw\",\"access_token_expires_in\":86400,\"refresh_token\":\"LNTdLO8JaNgBxv6RAdpXX7L3e41M1KDXNfxKipw6uCTQj0rVyZEq4W6J79IdiJCr\",\"refresh_token_expires_in\":15548026},\"trace_id\":\"0aee5b606930073522b8502facc64ce4\",\"status\":200}","trace_id":"0aee5b606930073522b8502facc64ce4"}
    }

}
