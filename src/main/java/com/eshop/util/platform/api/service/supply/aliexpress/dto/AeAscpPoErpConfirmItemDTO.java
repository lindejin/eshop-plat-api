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
public class AeAscpPoErpConfirmItemDTO {
//    sc_item_id	Number	否	货品id。 all_quantity_confirm == false时，必填。
    private Number sc_item_id;
//    confirm_quantity	Number	否	对应货品供应商确认数量。 all_quantity_confirm == false时，必填。
    private Number confirm_quantity;
}
