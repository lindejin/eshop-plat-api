package com.eshop.entity.depot;

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
 * ams_lbx_shipment的记录表，用于记录签收时间、配送时间和完成时间
 * </p>
 *
 * @author depot
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("ams_lbx_shipment_record")
public class AmsLbxShipmentRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 关联的lbx信息表ID
     */
    private Long amsLbxId;

    /**
     * 签收时间
     */
    private LocalDateTime signInTime;

    /**
     * 签收操作人
     */
    private Long signInOperator;

    /**
     * 配送时间
     */
    private LocalDateTime deliveryTime;

    /**
     * 配送操作人
     */
    private Long deliveryOperator;

    /**
     * 完成时间
     */
    private LocalDateTime completionTime;

    /**
     * 完成操作人
     */
    private Long completionOperator;
}
