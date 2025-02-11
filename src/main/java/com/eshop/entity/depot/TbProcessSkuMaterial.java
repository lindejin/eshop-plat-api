package com.eshop.entity.depot;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 加工sku素材信息
 * </p>
 *
 * @author depot
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("tb_process_sku_material")
public class TbProcessSkuMaterial implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 加工sku_id
     */
    private Integer processSkuId;

    /**
     * 素材_id
     */
    private Integer materialId;

    /**
     * 素材sku编码
     */
    private String materialSkuCode;

    /**
     * 素材条形编码
     */
    private Long materialBarCode;

    /**
     * 素材条形编码(新)
     */
    private Long materialBarCodeNew;

    /**
     * 素材序号
     */
    private String materialIndex;

    /**
     * 定位名称
     */
    private String locationName;

    /**
     * 是否扫描完成(1.是 2.否)
     */
    private Byte isScan;

    /**
     * 是否有库存(1.是 2.否)
     */
    private Byte isInStock;
}
