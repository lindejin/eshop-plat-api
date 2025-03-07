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
 * 包裹操作记录
 * </p>
 *
 * @author depot
 * @since 2025-03-07
 */
@Getter
@Setter
@ToString
@TableName("tb_parcel_record")
public class TbParcelRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 包裹号
     */
    private Long parcelNo;

    /**
     * 配货人
     */
    private Long allocationId;

    /**
     * 配货时间
     */
    private Date allocationTime;

    /**
     * 复核人
     */
    private Long reviewId;

    /**
     * 复核时间
     */
    private Date reviewTime;

    /**
     * 打包称重人
     */
    private Long packId;

    /**
     * 打包称重时间
     */
    private Date packTime;

    /**
     * 出库人
     */
    private Long outboundId;

    /**
     * 出库时间
     */
    private Date outboundTime;

    /**
     * 包裹类型(1:单品,2:多品)
     */
    private Byte parcelType;
}
