package com.eshop.entity.depot;

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
 * 加工sku素材信息排序
 * </p>
 *
 * @author depot
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("tb_process_sku_material_sort")
public class TbProcessSkuMaterialSort implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 加工sku素材表主键id
     */
    private Long processSkuMaterialId;

    /**
     * 图片id
     */
    private Long imgId;

    /**
     * 排序
     */
    private Long sort;

    /**
     * 创建时间
     */
    private Date createTime;
}
