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
 * 店铺表
 * </p>
 *
 * @author config
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("tb_shop")
public class TbShop implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 商户_id
     */
    private Long merchantId;

    /**
     * 平台编码
     */
    private String platformCode;

    /**
     * 平台店铺id
     */
    private String platformShopId;

    /**
     * 店铺商户ID
     */
    private Long shopMerchantId;

    /**
     * 店铺类型(1: 跨境店, 2: 本土店3.跨境子店铺)
     */
    private Byte shopType;

    /**
     * 平台应用_id
     */
    private Long appId;

    /**
     * 店铺类型(1.普通/半托管 2.全托管)
     */
    private Byte platformShopType;

    /**
     * 店铺所属国家(本土店国家必选)
     */
    private Long countryId;

    /**
     * 店铺名称
     */
    private String name;

    /**
     * 状态: 1:开启,2,停用
     */
    private Byte status;

    /**
     * 授权状态,1:成功 2失败,0:未授权
     */
    private Byte tokenFlag;

    /**
     * 用户账号
     */
    private String userName;

    /**
     * 密码(AES加密  CBC模式)
     */
    private String password;

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
     * 货币类型
     */
    private String currencyType;
}
