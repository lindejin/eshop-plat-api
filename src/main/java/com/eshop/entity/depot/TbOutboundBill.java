package com.eshop.entity.depot;

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
 * 出库单
 * </p>
 *
 * @author depot
 * @since 2025-03-07
 */
@Getter
@Setter
@ToString
@TableName("tb_outbound_bill")
public class TbOutboundBill implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 出库单号
     */
    private Long outboundNo;

    /**
     * 包裹号
     */
    private Long parcelNo;

    /**
     * 仓库id
     */
    private Long depotId;

    /**
     * 备注
     */
    private String remark;

    /**
     * 出库类型(1:常规出库,2:非常规出库)
     */
    private Byte outboundType;

    /**
     * 出库人_id
     */
    private Long outboundPersonId;

    /**
     * 出库时间
     */
    private Date outboundTime;
}
