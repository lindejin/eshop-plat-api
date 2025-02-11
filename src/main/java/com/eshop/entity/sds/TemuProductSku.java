package com.eshop.entity.sds;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * Temu产品sku信息
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("temu_product_sku")
public class TemuProductSku implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 商品Id
     */
    private Integer productId;

    /**
     * skc_Id
     */
    private Integer temuProductSkcId;

    /**
     * 产品编码
     */
    private String spuCode;

    /**
     * 产品sku编码
     */
    private String skuCode;

    /**
     * sku货号，没有的场景传空字符串 
     */
    private String extCode;

    /**
     * 供货价  （单位：人民币-元/美元-美元）
     */
    private BigDecimal supplierPrice;

    /**
     * 站点申报价格  （单位：人民币-分/美元-美分）前期美国就一个占时放这里
     */
    private BigDecimal siteSupplierPrice;

    /**
     * sku分类   件数，单品默认是1
     */
    private Integer numberOfPieces;

    /**
     * 净含量单位，1：液体盎司，2：毫升，3：加仑，4：升，5：克，6：千克，7：常衡盎司，8：磅
     */
    private Integer netContentUnitCode;

    /**
     * 净含量数值
     */
    private Integer netContentNumber;

    /**
     * sku分类，1：单品，2：组合装，3：混合套装
     */
    private Integer skuClassification;

    /**
     * 单件单位，1：件，2：双，3：包
     */
    private Integer pieceUnitCode;

    /**
     * 建议价格币种（USD:美元,CNY:人民币,JPY:日元,CAD:加拿大元,GBP:英镑,AUD:澳大利亚元,NZD:新西兰元,EUR:欧元,MXN:墨西哥比索,PLN:波兰兹罗提,SEK:瑞典克朗,CHF:瑞士法郎,KRW:韩元,SAR:沙特里亚尔,SGD:新加坡元,AED:阿联酋迪拉姆,KWD:科威特第纳尔,NOK:挪威克朗,CLP:智利比索,MYR:马来西亚林吉特,PHP:菲律宾比索,TWD:新台湾元,THB:泰铢,QAR:卡塔尔里亚尔,JOD:约旦第纳尔,BRL:巴西雷亚尔,OMR:阿曼里亚尔,BHD:巴林第纳尔,ILS:以色列新锡克尔,ZAR:南非兰特,CZK:捷克克朗,HUF:匈牙利福林,DKK:丹麦克朗,RON:罗马尼亚列伊,BGN:保加利亚列瓦,HKD:港元,COP:哥伦比亚比索,GEL:格鲁吉亚拉里）
     */
    private String suggestedPriceCurrencyType;

    /**
     * 建议价格
     */
    private BigDecimal suggestedPrice;

    /**
     * 同款URl
     */
    private String sameReferPriceUrl;

    /**
     * 是否敏感属性，0：非敏感，1：敏感
     */
    private Integer isSensitive;

    /**
     * 商品标准编码
     */
    private String productBarCode;

    /**
     * 条码类型 (1: EAN, 2: UPC, 3: ISBN)
     */
    private Byte productBarCodeType;

    /**
     * 币种 (CNY: 人民币, USD: 美元) (默认人民币) 
     */
    private String currencyType;

    /**
     * sku重量  单位KG
     */
    private Double weight;

    /**
     * 长度，单位CM
     */
    private Double len;

    /**
     * 宽度，单位CM
     */
    private Double width;

    /**
     * 高度，单位CM
     */
    private Double height;

    /**
     * 预览图(非服装类目需要)
     */
    private Integer thumbId;

    /**
     * 平台产品skuId
     */
    private String platformSkuId;
}
