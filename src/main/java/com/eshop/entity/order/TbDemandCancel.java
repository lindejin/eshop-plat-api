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
 * sku取消需求记录
 * </p>
 *
 * @author order
 * @since 2025-03-07
 */
@Getter
@Setter
@ToString
@TableName("tb_demand_cancel")
public class TbDemandCancel implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 包裹号
     */
    private Long parcelNo;

    /**
     * 库存sku编号
     */
    private String skuCode;

    /**
     * 取消数量
     */
    private Long cancelAmount;

    /**
     * 取消原因
     */
    private String cancelCause;

    /**
     * 是否已处理(1: 是, 2: 否)
     */
    private Byte isDispose;

    /**
     * 创建人
     */
    private Long creatorId;

    /**
     * 创建时间
     */
    private Date createTime;
}
