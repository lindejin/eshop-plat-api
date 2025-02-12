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
 * 平台应用
 * </p>
 *
 * @author config
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("tb_platform_app")
public class TbPlatformApp implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 平台id
     */
    private Long platformId;

    /**
     * 平台编码
     */
    private String platformCode;

    /**
     * 应用秘钥参数
     */
    private String appParamJson;

    /**
     * 应用名称
     */
    private String appName;

    /**
     * 应用备注
     */
    private String appRemark;

    /**
     * 创建人id
     */
    private Long creatorId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 是否已被删除(1: 是, 2: 否)
     */
    private Byte isDelete;
}
