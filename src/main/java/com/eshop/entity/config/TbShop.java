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
 * @since 2025-03-07
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
     * 平台编码
     */
    private String platformCode;

    /**
     * 平台店铺id
     */
    private String platformShopId;

    /**
     * 商户_id
     */
    private Long merchantId;

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
     * ioss税号（欧盟税号）
     */
    private String iossNo;

    /**
     * vat税号
     */
    private String vatNum;

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
     * 店铺所属国家(TikTok店铺必须指定)
     */
    private Long countryId;
}
