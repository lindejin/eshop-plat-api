package com.eshop.entity.log;

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
 * 预报（订单号为单位）异常运行日志
 * </p>
 *
 * @author log
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("tb_shipment_log")
public class TbShipmentLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 业务编号
     */
    private String businessNo;

    /**
     * 平台id
     */
    private Long platId;

    /**
     * 店铺id
     */
    private Long shopId;

    /**
     * 运行属性/运行描述
     */
    private String operateProperty;

    /**
     * 描述
     */
    private String description;

    /**
     * 异常
     */
    private String exceptionLog;

    /**
     * (1:成功: 2:失败)
     */
    private Byte status;

    /**
     * 操作人
     */
    private String operator;

    /**
     * 运行时间
     */
    private Date operateTime;
}
