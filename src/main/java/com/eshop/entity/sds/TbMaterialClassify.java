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
 * 素材分类
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("tb_material_classify")
public class TbMaterialClassify implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 商户_id
     */
    private Long merchantId;

    /**
     * 父分类id
     */
    private Long parentId;

    /**
     * 父分类名称
     */
    private String classifyName;

    /**
     * 分类类型(1: 私有, 2: 公有)
     */
    private Byte copyrightType;

    /**
     * 外部id
     */
    private Long thirdPartyId;

    /**
     * 外部父id
     */
    private Long thirdPartyParentId;

    /**
     * 创建人id
     */
    private Long createId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 是否已被删除(1: 是, 2: 否)
     */
    private Byte isDelete;

    /**
     * 删除时间
     */
    private Date updateTime;
}
