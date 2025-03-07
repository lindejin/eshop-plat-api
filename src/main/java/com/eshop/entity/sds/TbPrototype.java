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
 * 样机
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("tb_prototype")
public class TbPrototype implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * spu编码
     */
    private String spuCode;

    /**
     * 供应链商品id
     */
    private Long scmProductId;

    /**
     * 样机名称
     */
    private String prototypeName;

    /**
     * 类目_id
     */
    private Long categoryId;

    /**
     * 模特状态(1: 未上线, 2: 已上线)
     */
    private Byte prototypeStatus;

    /**
     * 样机类型(1: 精品模特, 2: 铺货模特, 3: sds模特)
     */
    private Byte prototypeType;

    /**
     * 文本描述
     */
    private String textDescribe;

    /**
     * 外部产品id
     */
    private Long rawId;

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
     * 修改人
     */
    private Long updateId;

    /**
     * 修改时间
     */
    private Date updateTime;
}
