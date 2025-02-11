package com.eshop.util.platform.api.client.shopee;

import com.eshop.util.platform.api.structure.shopee.dto.ShopeeAppClientDTO;
import org.springframework.http.ResponseEntity;

/**
 * @author ldj
 * @date 2024/3/12 13:41
 * @Description: ...
 * @Version 1.0
 */
public interface ShopeeClient {

    ShopeeResponse execute(ShopeeRequest shopeeRequest, ShopeeAppClientDTO publicDTO) throws Exception;

    ResponseEntity<byte[]> downloadFile(ShopeeRequest shopeeRequest, ShopeeAppClientDTO publicDTO);


    ShopeeResponse tokenCreateAndRefresh(ShopeeRequest shopeeRequest, ShopeeAppClientDTO publicDTO) throws Exception;
}
