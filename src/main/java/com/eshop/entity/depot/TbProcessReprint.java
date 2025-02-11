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
 * 成品补打列表
 * </p>
 *
 * @author depot
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("tb_process_reprint")
public class TbProcessReprint implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 加工成品主键id
     */
    private Integer processSkuId;

    /**
     * 仓库_id
     */
    private Integer depotId;

    /**
     * 批次号
     */
    private Long batchNo;

    /**
     * 包裹号
     */
    private Long parcelNo;

    /**
     * 运单号/货运单号
     */
    private String waybillNo;

    /**
     * 成品sku编码
     */
    private String mainSkuCode;

    /**
     * 补打类型（1.批次补打 2.运单号补打）
     */
    private Byte reprintType;

    /**
     * 是否已补打(1: 是, 2: 否)
     */
    private Byte isRetyped;

    /**
     * 创建人_id
     */
    private Integer createrId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 补打操作人_id
     */
    private Integer reprintOperatorId;

    /**
     * 补打时间
     */
    private LocalDateTime reprintTime;

    /**
     * 是否删除(1: 是, 2: 否)
     */
    private Byte isDelete;

    /**
     * 删除时间
     */
    private LocalDateTime deleteTime;
}
