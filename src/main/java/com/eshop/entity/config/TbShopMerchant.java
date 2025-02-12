package com.eshop.entity.config;

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
 * 平台商户信息表
 * </p>
 *
 * @author config
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("tb_shop_merchant")
public class TbShopMerchant implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 商户Id
     */
    private Long merchantId;

    /**
     * 主账号Id
     */
    private Long mainAccountId;

    /**
     * 平台编码
     */
    private String platformCode;

    /**
     * 商户名称
     */
    private String name;

    /**
     * 授权状态,1:成功 2失败,-1:未授权
     */
    private Byte tokenFlag;

    /**
     * 过期时间
     */
    private Date expiresTime;

    /**
     * 调用参数_静态_空值
     */
    private String paramStaticJson;

    /**
     * 调用参数_动态_空值
     */
    private String paramDynamicJson;

    /**
     * 创建人
     */
    private Long createOperId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改人
     */
    private Long updateOperId;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 逻辑删除字段(1: 删除, 2: 未删除)
     */
    private Byte isDelete;

    /**
     * 删除人
     */
    private Long deleteUserId;

    /**
     * 删除时间
     */
    private Date deleteTime;

    /**
     * 平台商户Id
     */
    private String platformShopMerchantId;

    /**
     * 平台应用_id
     */
    private Long appId;
}
