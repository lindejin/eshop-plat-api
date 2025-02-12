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
 * 关键词分类
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("tb_keyword_classify")
public class TbKeywordClassify implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 父分类id
     */
    private Long parentId;

    /**
     * 分类名称
     */
    private String classifyName;

    /**
     * 分类名称
     */
    private String classifyVal;

    /**
     * 层级(从1开始, 1.最顶级 2.平台 3.类目 4.key类型)
     */
    private Byte level;

    /**
     * 分类类型(1: 私有, 2: 公有)
     */
    private Byte copyrightType;

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
