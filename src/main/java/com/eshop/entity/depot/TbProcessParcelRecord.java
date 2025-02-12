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
 * 加工包裹操作记录
 * </p>
 *
 * @author depot
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("tb_process_parcel_record")
public class TbProcessParcelRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 包裹号
     */
    private Long parcelNo;

    /**
     * 配货人_id
     */
    private Long distributorById;

    /**
     * 配货时间
     */
    private Date distributorTime;

    /**
     * 复核人
     */
    private Long reviewedById;

    /**
     * 复核时间
     */
    private Date reviewedTime;

    /**
     * 出库人
     */
    private Long outboundById;

    /**
     * 出库时间
     */
    private Date outboundTime;

    /**
     * 取消人
     */
    private Long cancelById;

    /**
     * 取消时间
     */
    private Date cancelTime;

    /**
     * 揽收人
     */
    private Long collectionId;

    /**
     * 揽收时间
     */
    private Date collectionTime;

    /**
     * 复核员
     */
    private Long verifyById;

    /**
     * 复核时间点
     */
    private Date verifyTime;
}
