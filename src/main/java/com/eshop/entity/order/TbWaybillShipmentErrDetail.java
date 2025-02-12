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
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("tb_waybill_shipment_err_detail")
public class TbWaybillShipmentErrDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 货运异常id
     */
    private Long waybillShipmentErrId;

    /**
     * 物流方式
     */
    private Long modeId;

    /**
     * 错误原因
     */
    private String errCause;

    /**
     * 错误操作人
     */
    private Long errId;

    /**
     * 错误时间
     */
    private Date errTime;

    /**
     * 是否旧错误1: 是, 2: 否  用来区分是否展示)
     */
    private Byte isOld;
}
