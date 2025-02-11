package com.eshop.util.platform.api.service.product.aliexpress.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author rch
 * @date 2024/4/2 16:28
 * @Description: ...
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AeopAeProductPostReqDTO {
    private AeopAeProductPostDTO aeop_a_e_product;

    private Long shopId;
}
