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
 * 加工sku操作记录
 * </p>
 *
 * @author depot
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("tb_process_sku_record")
public class TbProcessSkuRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 加工sku_id
     */
    private Long processSkuId;

    /**
     * 材料配货人_id
     */
    private Long materialDistributorId;

    /**
     * 配货时间
     */
    private Date distributionTime;

    /**
     * 印花打印人_id
     */
    private Long printedById;

    /**
     * 打印时间
     */
    private Date printTime;

    /**
     * 分拣人
     */
    private Long sorterId;

    /**
     * 分拣时间
     */
    private Date sorterTime;

    /**
     * 印花入库人
     */
    private Long printingDepositorId;

    /**
     * 印花入库时间
     */
    private Date depositorTime;
}
