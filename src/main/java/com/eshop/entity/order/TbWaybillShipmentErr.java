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
 * 运单号获取异常
 * </p>
 *
 * @author order
 * @since 2025-03-07
 */
@Getter
@Setter
@ToString
@TableName("tb_waybill_shipment_err")
public class TbWaybillShipmentErr implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 物流单id(便于查询)
     */
    private Long waybillId;

    /**
     * 包裹号
     */
    private Long parcelNo;

    /**
     * 是否已被删除(1: 是, 2: 否)
     */
    private Byte isDelete;

    /**
     * 删除时间
     */
    private Date deleteTime;

    /**
     * 最后修改人id
     */
    private Long lastUpdateId;

    /**
     * 最后修改时间(排序)
     */
    private Date lastUpdateTime;
}
