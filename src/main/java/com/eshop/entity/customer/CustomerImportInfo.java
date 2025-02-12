package com.eshop.entity.customer;

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
 * 导入的客户信息表
 * </p>
 *
 * @author customer
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("customer_import_info")
public class CustomerImportInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 平台_id
     */
    private Long platformId;

    /**
     * 买家
     */
    private String buyerName;

    /**
     * 状态 1.正常，2.封禁，3.停用
     */
    private Byte buyerStatus;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建者
     */
    private Long createId;

    /**
     * 更新者
     */
    private Long updateId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}
