package com.eshop.util.platform.api.service.supply.aliexpress.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



/**
 * @author xxs
 * @date 2024/9/19
 * @Description: AE仓发备货单-分页查询单据 DTO
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AeAscpPoErpCreatePackageDTO {
    //    box_sequence	String	是	箱号。范围 [1,99]，必须连续且从1开始。
    private String box_sequence;
    //    box_qty	Number	是	装箱货量，即每箱多少件
    private Number box_qty;
}
