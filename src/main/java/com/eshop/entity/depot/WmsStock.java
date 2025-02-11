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
 * 
 * </p>
 *
 * @author depot
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("wms_stock")
public class WmsStock implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * sku_编码
     */
    private String skuCode;

    /**
     * 区域编码
     */
    private String areaCode;

    /**
     * 货架编码
     */
    private String shelfCode;

    /**
     * 仓位编码
     */
    private String positionCode;
}
