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
 * 店铺配置表
 * </p>
 *
 * @author config
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("tb_shop_config")
public class TbShopConfig implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 店铺_id
     */
    private Long shopId;

    /**
     * ioss税号（欧盟税号）
     */
    private String iossNo;

    /**
     * vat税号
     */
    private String vatNum;

    /**
     * 语言
     */
    private String language;

    /**
     * 发货仓库
     */
    private Long depotId;

    /**
     * 是否自动审核订单(1: 是, 2: 否)
     */
    private Byte isAutomaticHandle;
}
