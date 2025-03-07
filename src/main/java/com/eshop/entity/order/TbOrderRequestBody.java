package com.eshop.entity.order;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 订单请求数据存储
 * </p>
 *
 * @author order
 * @since 2025-03-07
 */
@Getter
@Setter
@ToString
@TableName("tb_order_request_body")
public class TbOrderRequestBody implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 请求类型
     */
    private Byte requestType;

    /**
     * 订单相关信息
     */
    private String orderDetail;

    /**
     * 同步日期
     */
    private Date synTime;
}
