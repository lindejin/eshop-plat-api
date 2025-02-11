package com.eshop.entity.order;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 订单_运单同步表
 * </p>
 *
 * @author order
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("tb_waybill_syn_record")
public class TbWaybillSynRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 平台id
     */
    private Integer platformId;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 运单号/货运单号
     */
    private String waybillNo;

    /**
     * 包裹号
     */
    private Long parcelNo;

    /**
     * 同步人
     */
    private Integer synId;

    /**
     * 同步日期
     */
    private LocalDateTime synTime;

    /**
     * 类型(1.常规同步，2.虚拟同步，3.修改同步)
     */
    private Byte synType;
}
