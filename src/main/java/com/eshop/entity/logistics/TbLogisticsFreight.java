package com.eshop.entity.logistics;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 物流资费
 * </p>
 *
 * @author logistics
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("tb_logistics_freight")
public class TbLogisticsFreight implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 物流方式id(一对多)
     */
    private Integer modeId;

    /**
     * 国家代码
     */
    private String countryCode;

    /**
     * 国家中文名称
     */
    private String countryChineseName;

    /**
     * 国家英文名称
     */
    private String countryEnglishName;

    /**
     * 最小重量(KG)
     */
    private Double minimumWeight;

    /**
     * 最大重量(KG)
     */
    private Double maximumWeight;

    /**
     * 首重(KG)
     */
    private Double ykg;

    /**
     * 物流折扣比例(1 = 100%)
     */
    private Double logisticsDiscount;

    /**
     * 运费
     */
    private BigDecimal freight;

    /**
     * 操作费
     */
    private BigDecimal operatingCost;

    /**
     * 其他费用
     */
    private BigDecimal otherFees;

    /**
     * 创建人id
     */
    private Integer createrId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 最后修改人id
     */
    private Integer lastUpdateId;

    /**
     * 最后修改时间
     */
    private LocalDateTime lastUpdateTime;
}
