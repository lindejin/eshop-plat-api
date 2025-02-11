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
 * 加工任务
 * </p>
 *
 * @author depot
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("tb_process_task")
public class TbProcessTask implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 商户_id
     */
    private Integer merchantId;

    /**
     * 仓库id
     */
    private Integer depotId;

    /**
     * 批次号
     */
    private Long batchNo;

    /**
     * 篮子编号
     */
    private Long bigBasketCode;

    /**
     * 预输入包裹数量
     */
    private Integer parcelQuantity;

    /**
     * 任务状态(1: 执行中, 2: 正常结束, 3: 异常结束, 4: 挂起执行)
     */
    private Byte taskStatus;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建人
     */
    private Integer createId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 是否打印素材图片(1.是 2.否)
     */
    private Byte isPrintMaterialImage;

    /**
     * 是否打印素材item(1.是 2.否)
     */
    private Byte isPrintMaterialItem;

    /**
     * 是否打印运单号(1.是 2.否)
     */
    private Byte isPrintWaybill;
}
