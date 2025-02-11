package com.eshop.util.platform.api.service.product.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author rch
 * @date 2024/3/2 16:51
 * @Description: 详描原数据
 * @Version 1.0
 */
@Getter
@Setter
public class AeDetailInfoDTO {
    private String version;
    private List<AeDetailModuleDTO> moduleList;
}
