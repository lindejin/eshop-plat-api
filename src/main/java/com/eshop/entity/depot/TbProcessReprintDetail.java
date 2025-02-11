package com.eshop.entity.depot;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 成品补打明细
 * </p>
 *
 * @author depot
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("tb_process_reprint_detail")
public class TbProcessReprintDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 补打成品_id
     */
    private Integer reprintId;

    /**
     * 素材_id
     */
    private Integer materialId;

    /**
     * 素材sku编码
     */
    private String materialSkuCode;

    /**
     * 素材条形编码
     */
    private Long materialBarCode;

    /**
     * 素材序号
     */
    private String materialIndex;

    /**
     * 定位名称
     */
    private String locationName;
}
