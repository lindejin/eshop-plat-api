package com.eshop.util.platform.api.service.order.jushuitan.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JushuitanConfirmDeliverySaleOrderItemBatchReqDTO {

    //batch_id	string	是		生产批次号
    private String batch_id;
    //produced_date	string	是		生产日期
    private String produced_date;
    //expiration_date	string	是		有效期至
    private String expiration_date;
    //qty	number	是		数量
    private Integer qty;
    //ioi_id	number	是		出库单明细编号
    private Long ioi_id;
}
