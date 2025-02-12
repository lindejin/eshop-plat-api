package com.eshop.entity.file;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 文件分组/分类
 * </p>
 *
 * @author file
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("file_grouping")
public class FileGrouping implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 是否为固定分组(1:是, 2:否)
     */
    private Byte isFixed;

    /**
     * 分组名称
     */
    private String groupingName;

    /**
     * 父分组id(值为0的话说明是最顶层分组)
     */
    private Long parentId;

    /**
     * 备注
     */
    private String remark;
}
