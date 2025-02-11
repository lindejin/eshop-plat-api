package com.eshop.util.platform.api.service.product.aliexpress.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 全托管类目查询
 *
 * @author rch
 * @create 2023-01-14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AeCategoryQueryDto {

    private Long shopId;

    private String categoryId;
}
