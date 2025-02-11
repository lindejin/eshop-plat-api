package com.eshop.entity.sds;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 样机生成款式sd参数
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("tb_prototype_sd_param")
public class TbPrototypeSdParam implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 样机_id
     */
    private Integer prototypeId;

    /**
     * sd_背景_id
     */
    private Integer sdParamId;

    /**
     * 主商品_id(款式)
     */
    private Integer styleProductId;
}
