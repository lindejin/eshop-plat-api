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
 * diy商品待合成列表
 * </p>
 *
 * @author depot
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("tb_diy_wait_compose_style")
public class TbDiyWaitComposeStyle implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 包裹号
     */
    private Long parcelNo;

    /**
     * sku_编码
     */
    private String skuCode;

    /**
     * 款式sku编码
     */
    private String styleSkuCode;

    /**
     * 仓库_id
     */
    private Long depotId;

    /**
     * 是否已完成(1:是, 2:否)
     */
    private Byte isDone;

    /**
     * 最新一次缺货时间
     */
    private Date stockoutTime;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 批次号
     */
    private Long batchNo;
}
