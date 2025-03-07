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
 * 客户基础信息
 * </p>
 *
 * @author order
 * @since 2025-03-07
 */
@Getter
@Setter
@ToString
@TableName("tb_customer_base")
public class TbCustomerBase implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 平台id
     */
    private Long platformId;

    /**
     * 客户分类(-1:刷单账号,1.金牌 2.银牌 3.铜牌)
     */
    private Byte customerType;

    /**
     * 客户标识(1差评 2.退款 3.黑名单)
     */
    private Byte customerMark;

    /**
     * 买家id
     */
    private String buyerId;

    /**
     * 买家账号
     */
    private String buyerUserId;

    /**
     * 买家姓名
     */
    private String buyerName;

    /**
     * 买家邮箱
     */
    private String email;

    /**
     * 邮编
     */
    private String postcode;

    /**
     * 手机号(包含国家区号)
     */
    private String mobile;

    /**
     * 座机(包含国家区号)
     */
    private String phone;

    /**
     * 国家
     */
    private String country;

    /**
     * 省/州
     */
    private String provinceOrState;

    /**
     * 城市
     */
    private String city;

    /**
     * 详细地址
     */
    private String detailedAddress;

    /**
     * 备用地址
     */
    private String reserveAddress;

    /**
     * 税号
     */
    private String dutyParagraph;

    /**
     * 备注内容
     */
    private String remark;

    /**
     * 买家别名(昵称)
     */
    private String buyerNickName;

    /**
     * 买家名
     */
    private String firstName;

    /**
     * 买家姓
     */
    private String lastName;

    /**
     * 创建人id
     */
    private Long createrId;

    /**
     * 创建时间
     */
    private Date createTime;
}
