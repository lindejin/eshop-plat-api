package com.eshop.entity.config;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 店铺商户配置表
 * </p>
 *
 * @author config
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("tb_shop_merchant_config")
public class TbShopMerchantConfig implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 店铺商户_id
     */
    private Integer shopMerchantId;

    /**
     * ioss税号（欧盟税号）
     */
    private String iossNo;

    /**
     * vat税号
     */
    private String vatNum;

    /**
     * 每天最大刊登量
     */
    private Integer dayMaxPublishNumber;

    /**
     * 语言
     */
    private String language;

    /**
     * 发货仓库
     */
    private Integer depotId;

    /**
     * 是否自动审核订单(1: 是, 2: 否)
     */
    private Byte isAutomaticHandle;
}
