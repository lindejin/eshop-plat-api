package com.eshop.entity.sds;

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
 * 供应链商品
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("scm_product")
public class ScmProduct implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * spu编码
     */
    private String spuCode;

    /**
     * 类目id
     */
    private Long categoryId;

    /**
     * 商品状态(1: 未审核, 2: 已审核, 3: 审核未通过, -1: 作废)
     */
    private Byte productStatus;

    /**
     * 可支持平台ids[1,2,3]
     */
    private String supportPlatformIds;

    /**
     * 可支持国家ids[1,2,3]
     */
    private String supportCountryIds;

    /**
     * 是否柔性定制商品(1:是, 2: 否)
     */
    private Byte isDiy;

    /**
     * 是否已被删除(1: 是, 2: 否)
     */
    private Byte isDelete;

    /**
     * 创建人
     */
    private Long createId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改人
     */
    private Long updateId;

    /**
     * 修改时间
     */
    private Date updateTime;
}
