package com.eshop.entity.order;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 物流费用
 * </p>
 *
 * @author order
 * @since 2025-03-07
 */
@Getter
@Setter
@ToString
@TableName("tb_waybill_freight")
public class TbWaybillFreight implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 包裹号
     */
    private Long parcelNo;

    /**
     * 运单号
     */
    private String waybillNo;

    /**
     * 计费重量(kg)
     */
    private BigDecimal billableWeight;

    /**
     * 运费
     */
    private BigDecimal freight;

    /**
     * 创建人id
     */
    private Long creatorId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 物流方式/物流渠道
     */
    private Long logisticsModeId;
}
