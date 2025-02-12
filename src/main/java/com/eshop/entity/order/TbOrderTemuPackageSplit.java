package com.eshop.entity.order;

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
 * temu备货单 拆包信息
 * </p>
 *
 * @author order
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("tb_order_temu_package_split")
public class TbOrderTemuPackageSplit implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 平台sku_id
     */
    private Long platformSkuId;

    /**
     * 拆分数量
     */
    private Long splitNum;

    /**
     * 订单商品Id
     */
    private Long orderProductsId;

    /**
     * 创建人id
     */
    private Long creatorId;

    /**
     * 创建时间
     */
    private Date createTime;
}
