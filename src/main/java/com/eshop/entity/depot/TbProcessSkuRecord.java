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
 * 加工sku操作记录
 * </p>
 *
 * @author depot
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("tb_process_sku_record")
public class TbProcessSkuRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 加工sku_id
     */
    private Integer processSkuId;

    /**
     * 材料配货人_id
     */
    private Integer materialDistributorId;

    /**
     * 配货时间
     */
    private LocalDateTime distributionTime;

    /**
     * 印花打印人_id
     */
    private Integer printedById;

    /**
     * 打印时间
     */
    private LocalDateTime printTime;

    /**
     * 分拣人
     */
    private Integer sorterId;

    /**
     * 分拣时间
     */
    private LocalDateTime sorterTime;

    /**
     * 印花入库人
     */
    private Integer printingDepositorId;

    /**
     * 印花入库时间
     */
    private LocalDateTime depositorTime;
}
