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
 * 运单轨迹
 * </p>
 *
 * @author order
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("tb_waybill_track")
public class TbWaybillTrack implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 运单号/货运单号
     */
    private String waybillNo;

    /**
     * 语言
     */
    private String language;

    /**
     * 发生时间
     */
    private Date occurDate;

    /**
     * 物流方式
     */
    private String shippingType;

    /**
     * 发生事件
     */
    private String info;

    /**
     * 发生地点
     */
    private String place;
}
