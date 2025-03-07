package com.eshop.entity.supply;

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
 * 备货单 运单信息
 * </p>
 *
 * @author supply
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("tb_prepare_waybill")
public class TbPrepareWaybill implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 备货单号
     */
    private Long prepareNo;

    /**
     * 物流方式名称
     */
    private String waybillName;

    /**
     * 运单号
     */
    private String waybillNo;

    /**
     * 发货时间
     */
    private Date deliverTime;

    /**
     * 收货时间
     */
    private Date receivingTime;

    /**
     * 付款方式(1:预付,2:到付,3:月结)
     */
    private Byte paymentType;

    /**
     * 物流编号
     */
    private String logisticsId;

    /**
     * 运费
     */
    private BigDecimal freight;
}
