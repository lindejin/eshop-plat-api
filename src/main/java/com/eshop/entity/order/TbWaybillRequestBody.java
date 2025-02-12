package com.eshop.entity.order;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("tb_waybill_request_body")
public class TbWaybillRequestBody implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 包裹号
     */
    private Long parcelNo;

    /**
     * 请求类型
     */
    private Byte requestType;

    /**
     * 请求返回结果
     */
    private String responseDetail;

    /**
     * 请求日期
     */
    private Date requestTime;

    /**
     * 请求人
     */
    private Long requestId;
}
