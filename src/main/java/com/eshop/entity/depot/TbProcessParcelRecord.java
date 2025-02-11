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
 * 加工包裹操作记录
 * </p>
 *
 * @author depot
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("tb_process_parcel_record")
public class TbProcessParcelRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 包裹号
     */
    private Long parcelNo;

    /**
     * 配货人_id
     */
    private Integer distributorById;

    /**
     * 配货时间
     */
    private LocalDateTime distributorTime;

    /**
     * 复核人
     */
    private Integer reviewedById;

    /**
     * 复核时间
     */
    private LocalDateTime reviewedTime;

    /**
     * 出库人
     */
    private Integer outboundById;

    /**
     * 出库时间
     */
    private LocalDateTime outboundTime;

    /**
     * 取消人
     */
    private Integer cancelById;

    /**
     * 取消时间
     */
    private LocalDateTime cancelTime;

    /**
     * 揽收人
     */
    private Integer collectionId;

    /**
     * 揽收时间
     */
    private LocalDateTime collectionTime;

    /**
     * 复核员
     */
    private Integer verifyById;

    /**
     * 复核时间点
     */
    private LocalDateTime verifyTime;
}
