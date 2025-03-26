package com.eshop.code.vo.po3;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class TemuFullOrderGoodsLabelV2VO {

    /**
     * 说明:result
     * 是否必填:false
     * 类型标识:6，类型:object
     */
    private TemuFullOrderGoodsLabelV2Result result;

    /**
     * 说明:status
     * 是否必填:false
     * 类型标识:5，类型:boolean
     */
    private Boolean success;

    /**
     * 说明:error code
     * 是否必填:false
     * 类型标识:1，类型:long
     */
    private Long errorCode;

    /**
     * 说明:error message
     * 是否必填:false
     * 类型标识:4，类型:string
     */
    private String errorMsg;


    @Getter
    @Setter
    public static class TemuFullOrderGoodsLabelV2Result {
        /**
         * 说明:标签分页查询结果
         * 是否必填:false
         * 类型标识:6，类型:object
         */
        private TemuFullOrderGoodsLabelV2ResultLabelCodePageResult labelCodePageResult;

    }

    @Getter
    @Setter
    public static class TemuFullOrderGoodsLabelV2ResultLabelCodePageResult {
        /**
         * 说明:结果列表
         * 是否必填:false
         * 类型标识:8，类型:list
         */
        private List<DataItem> data;

        /**
         * 说明:总数
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long totalCount;

    }

    @Getter
    @Setter
    public static class DataItem {
        /**
         * 说明:sku规格多语言信息
         * 是否必填:false
         * 类型标识:7，类型:map
         */
        private Map productSkuSpecI18nMap;

        /**
         * 说明:sku信息
         * 是否必填:false
         * 类型标识:6，类型:object
         */
        private TemuFullOrderGoodsLabelV2ProductSkuDTO productSkuDTO;

        /**
         * 说明:旧版货品标签条码基础信息
         * 是否必填:false
         * 类型标识:6，类型:object
         */
        private TemuFullOrderGoodsLabelV2ProductLabelCodeDTO productLabelCodeDTO;

        /**
         * 说明:skc图片信息
         * 是否必填:false
         * 类型标识:8，类型:list
         */
        private List<ProductSkcImageListItem> productSkcImageList;

        /**
         * 说明:skc信息
         * 是否必填:false
         * 类型标识:6，类型:object
         */
        private TemuFullOrderGoodsLabelV2ProductSkcDTO productSkcDTO;

        /**
         * 说明:货品产地信息
         * 是否必填:false
         * 类型标识:6，类型:object
         */
        private TemuFullOrderGoodsLabelV2ProductOrigin productOrigin;

        /**
         * 说明:spu信息
         * 是否必填:false
         * 类型标识:6，类型:object
         */
        private TemuFullOrderGoodsLabelV2ProductDTO productDTO;

        /**
         * 说明:新版货品标签条码基础信息
         * 是否必填:false
         * 类型标识:6，类型:object
         */
        private TemuFullOrderGoodsLabelV2ProductSkuLabelCodeDTO productSkuLabelCodeDTO;

        /**
         * 说明:skc规格多语言信息
         * 是否必填:false
         * 类型标识:7，类型:map
         */
        private Map productSkcSpecI18nMap;

    }

    @Getter
    @Setter
    public static class TemuFullOrderGoodsLabelV2ProductSkuDTO {
        /**
         * 说明:货品skuId
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long productSkuId;

        /**
         * 说明:供应商id
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long supplierId;

        /**
         * 说明:货品id
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long productId;

        /**
         * 说明:sku销售规格Map
         * 是否必填:false
         * 类型标识:7，类型:map
         */
        private Map productSkuSpecMap;

        /**
         * 说明:sku规格信息
         * 是否必填:false
         * 类型标识:6，类型:object
         */
        private TemuFullOrderGoodsLabelV2ProductSkuDTOProductSkuSpec productSkuSpec;

        /**
         * 说明:sku预览图(多语言)
         * 是否必填:false
         * 类型标识:7，类型:map
         */
        private Map thumbUrlI18n;

        /**
         * 说明:sku货品版本号
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long version;

        /**
         * 说明:sku货号
         * 是否必填:false
         * 类型标识:4，类型:string
         */
        private String extCode;

        /**
         * 说明:是否贵重品
         * 是否必填:false
         * 类型标识:5，类型:boolean
         */
        private Boolean valuableCargo;

        /**
         * 说明:sku预览图(多语言)
         * 是否必填:false
         * 类型标识:7，类型:map
         */
        private Map thumbUrlI18nMap;

        /**
         * 说明:货品skcId
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long productSkcId;

        /**
         * 说明:缩略图
         * 是否必填:false
         * 类型标识:4，类型:string
         */
        private String thumbUrl;

    }

    @Getter
    @Setter
    public static class TemuFullOrderGoodsLabelV2ProductSkuDTOProductSkuSpec {
        /**
         * 说明:货品sku id
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long productSkuId;

        /**
         * 说明:供应商id
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long supplierId;

        /**
         * 说明:货品id
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long productId;

        /**
         * 说明:规格信息
         * 是否必填:false
         * 类型标识:8，类型:list
         */
        private List<SpecListItem> specList;

        /**
         * 说明:货品skcId
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long productSkcId;

    }

    @Getter
    @Setter
    public static class TemuFullOrderGoodsLabelV2ProductLabelCodeDTO {
        /**
         * 说明:null
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long productSkuId;

        /**
         * 说明:null
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long supplierId;

        /**
         * 说明:null
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long createTime;

        /**
         * 说明:null
         * 是否必填:false
         * 类型标识:4，类型:string
         */
        private String purchaseOrderSn;

        /**
         * 说明:null
         * 是否必填:false
         * 类型标识:4，类型:string
         */
        private String subPurchaseOrderSn;

        /**
         * 说明:null
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long productSkcId;

        /**
         * 说明:sku下单件数 (仅旧版分页查询接口返回)
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long productSkuPurchaseQuantity;

        /**
         * 说明:null
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long labelCode;

    }

    @Getter
    @Setter
    public static class ProductSkcImageListItem {
        /**
         * 说明:图片URL
         * 是否必填:false
         * 类型标识:4，类型:string
         */
        private String imageUrl;

        /**
         * 说明:语言
         * 是否必填:false
         * 类型标识:4，类型:string
         */
        private String language;

        /**
         * 说明:图片类型
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long imageType;

    }

    @Getter
    @Setter
    public static class TemuFullOrderGoodsLabelV2ProductSkcDTO {
        /**
         * 说明:主销售属性id列表
         * 是否必填:false
         * 类型标识:8，类型:list
         */
        private List<Long> specIdList;

        /**
         * 说明:供应商id
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long supplierId;

        /**
         * 说明:skc货号
         * 是否必填:false
         * 类型标识:4，类型:string
         */
        private String extCode;

        /**
         * 说明:货品Id
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long productId;

        /**
         * 说明:主销售属性详情
         * 是否必填:false
         * 类型标识:6，类型:object
         */
        private TemuFullOrderGoodsLabelV2ProductSkcDTOProductSkcSpec productSkcSpec;

        /**
         * 说明:skc主销售规格Map
         * 是否必填:false
         * 类型标识:7，类型:map
         */
        private Map productSkcSpecMap;

        /**
         * 说明:货品skcId
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long productSkcId;

        /**
         * 说明:skc货品版本号
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long version;

    }

    @Getter
    @Setter
    public static class TemuFullOrderGoodsLabelV2ProductSkcDTOProductSkcSpec {
        /**
         * 说明:供应商id
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long supplierId;

        /**
         * 说明:货品id
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long productId;

        /**
         * 说明:规格信息
         * 是否必填:false
         * 类型标识:8，类型:list
         */
        private List<SpecListItem> specList;

        /**
         * 说明:货品skcId
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long productSkcId;

    }

    @Getter
    @Setter
    public static class SpecListItem {
        /**
         * 说明:规格id
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long specId;

        /**
         * 说明:父规格名称
         * 是否必填:false
         * 类型标识:4，类型:string
         */
        private String parentSpecName;

        /**
         * 说明:父规格id
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long parentSpecId;

        /**
         * 说明:规格名称
         * 是否必填:false
         * 类型标识:4，类型:string
         */
        private String specName;

    }

    @Getter
    @Setter
    public static class TemuFullOrderGoodsLabelV2ProductOrigin {
        /**
         * 说明:国家简称 (二字简码)
         * 是否必填:false
         * 类型标识:4，类型:string
         */
        private String countryShortName;

        /**
         * 说明:国家名称 (英文)
         * 是否必填:false
         * 类型标识:4，类型:string
         */
        private String countryName;

    }

    @Getter
    @Setter
    public static class TemuFullOrderGoodsLabelV2ProductDTO {
        /**
         * 说明:供应商名称
         * 是否必填:false
         * 类型标识:4，类型:string
         */
        private String supplierName;

        /**
         * 说明:图片多语言列表
         * 是否必填:false
         * 类型标识:8，类型:list
         */
        private List<String> imageLanguageList;

        /**
         * 说明:叶子类目标记 (使用前请与接口提供者确认是否会返回该字段)
         * 是否必填:false
         * 类型标识:6，类型:object
         */
        private TemuFullOrderGoodsLabelV2ProductDTOLeafCatLabel leafCatLabel;

        /**
         * 说明:供应商ID
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long supplierId;

        /**
         * 说明:货品ID
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long productId;

        /**
         * 说明:货品多语言信息
         * 是否必填:false
         * 类型标识:8，类型:list
         */
        private List<ProductI18nListItem> productI18nList;

        /**
         * 说明:货品名称
         * 是否必填:false
         * 类型标识:4，类型:string
         */
        private String productName;

        /**
         * 说明:来源
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long sourceType;

        /**
         * 说明:叶子类目属性 (使用前请与接口提供者确认是否会返回该字段)
         * 是否必填:false
         * 类型标识:6，类型:object
         */
        private TemuFullOrderGoodsLabelV2ProductDTOCategoryPropDTO categoryPropDTO;

        /**
         * 说明:类目
         * 是否必填:false
         * 类型标识:6，类型:object
         */
        private TemuFullOrderGoodsLabelV2ProductDTOCategories categories;

        /**
         * 说明:货品类型
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long productType;

        /**
         * 说明:创建时间，毫秒时间戳
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long createdAtTs;

    }

    @Getter
    @Setter
    public static class TemuFullOrderGoodsLabelV2ProductDTOLeafCatLabel {
        /**
         * 说明:类目id
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long catId;

        /**
         * 说明:抛货标记类型
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long bulkyCargoMarkType;

    }

    @Getter
    @Setter
    public static class ProductI18nListItem {
        /**
         * 说明:供应商ID
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long supplierId;

        /**
         * 说明:货品ID
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long productId;

        /**
         * 说明:语言编码
         * 是否必填:false
         * 类型标识:4，类型:string
         */
        private String language;

        /**
         * 说明:更新时间
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long updateTime;

        /**
         * 说明:货品名称
         * 是否必填:false
         * 类型标识:4，类型:string
         */
        private String productName;

    }

    @Getter
    @Setter
    public static class TemuFullOrderGoodsLabelV2ProductDTOCategoryPropDTO {
        /**
         * 说明:类目id
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long catId;

        /**
         * 说明:不可折叠
         * 是否必填:false
         * 类型标识:5，类型:boolean
         */
        private Boolean forbidFold;

    }

    @Getter
    @Setter
    public static class TemuFullOrderGoodsLabelV2ProductDTOCategories {
        /**
         * 说明:四级类目
         * 是否必填:false
         * 类型标识:6，类型:object
         */
        private TemuFullOrderGoodsLabelV2CategoriesCat4 cat4;

        /**
         * 说明:五级类目
         * 是否必填:false
         * 类型标识:6，类型:object
         */
        private TemuFullOrderGoodsLabelV2CategoriesCat5 cat5;

        /**
         * 说明:二级类目
         * 是否必填:false
         * 类型标识:6，类型:object
         */
        private TemuFullOrderGoodsLabelV2CategoriesCat2 cat2;

        /**
         * 说明:三级类目
         * 是否必填:false
         * 类型标识:6，类型:object
         */
        private TemuFullOrderGoodsLabelV2CategoriesCat3 cat3;

        /**
         * 说明:一级类目
         * 是否必填:false
         * 类型标识:6，类型:object
         */
        private TemuFullOrderGoodsLabelV2CategoriesCat1 cat1;

        /**
         * 说明:十级类目
         * 是否必填:false
         * 类型标识:6，类型:object
         */
        private TemuFullOrderGoodsLabelV2CategoriesCat10 cat10;

        /**
         * 说明:叶子类目
         * 是否必填:false
         * 类型标识:6，类型:object
         */
        private TemuFullOrderGoodsLabelV2CategoriesLeafCat leafCat;

        /**
         * 说明:八级类目
         * 是否必填:false
         * 类型标识:6，类型:object
         */
        private TemuFullOrderGoodsLabelV2CategoriesCat8 cat8;

        /**
         * 说明:九级类目
         * 是否必填:false
         * 类型标识:6，类型:object
         */
        private TemuFullOrderGoodsLabelV2CategoriesCat9 cat9;

        /**
         * 说明:六级类目
         * 是否必填:false
         * 类型标识:6，类型:object
         */
        private TemuFullOrderGoodsLabelV2CategoriesCat6 cat6;

        /**
         * 说明:七级类目
         * 是否必填:false
         * 类型标识:6，类型:object
         */
        private TemuFullOrderGoodsLabelV2CategoriesCat7 cat7;

    }

    @Getter
    @Setter
    public static class TemuFullOrderGoodsLabelV2CategoriesCat4 {
        /**
         * 说明:类目ID
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long catId;

        /**
         * 说明:类目名称
         * 是否必填:false
         * 类型标识:4，类型:string
         */
        private String catName;

    }

    @Getter
    @Setter
    public static class TemuFullOrderGoodsLabelV2CategoriesCat5 {
        /**
         * 说明:类目ID
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long catId;

        /**
         * 说明:类目名称
         * 是否必填:false
         * 类型标识:4，类型:string
         */
        private String catName;

    }

    @Getter
    @Setter
    public static class TemuFullOrderGoodsLabelV2CategoriesCat2 {
        /**
         * 说明:类目ID
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long catId;

        /**
         * 说明:类目名称
         * 是否必填:false
         * 类型标识:4，类型:string
         */
        private String catName;

    }

    @Getter
    @Setter
    public static class TemuFullOrderGoodsLabelV2CategoriesCat3 {
        /**
         * 说明:类目ID
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long catId;

        /**
         * 说明:类目名称
         * 是否必填:false
         * 类型标识:4，类型:string
         */
        private String catName;

    }

    @Getter
    @Setter
    public static class TemuFullOrderGoodsLabelV2CategoriesCat1 {
        /**
         * 说明:类目ID
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long catId;

        /**
         * 说明:类目名称
         * 是否必填:false
         * 类型标识:4，类型:string
         */
        private String catName;

    }

    @Getter
    @Setter
    public static class TemuFullOrderGoodsLabelV2CategoriesCat10 {
        /**
         * 说明:类目ID
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long catId;

        /**
         * 说明:类目名称
         * 是否必填:false
         * 类型标识:4，类型:string
         */
        private String catName;

    }

    @Getter
    @Setter
    public static class TemuFullOrderGoodsLabelV2CategoriesLeafCat {
        /**
         * 说明:类目ID
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long catId;

        /**
         * 说明:类目名称
         * 是否必填:false
         * 类型标识:4，类型:string
         */
        private String catName;

    }

    @Getter
    @Setter
    public static class TemuFullOrderGoodsLabelV2CategoriesCat8 {
        /**
         * 说明:类目ID
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long catId;

        /**
         * 说明:类目名称
         * 是否必填:false
         * 类型标识:4，类型:string
         */
        private String catName;

    }

    @Getter
    @Setter
    public static class TemuFullOrderGoodsLabelV2CategoriesCat9 {
        /**
         * 说明:类目ID
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long catId;

        /**
         * 说明:类目名称
         * 是否必填:false
         * 类型标识:4，类型:string
         */
        private String catName;

    }

    @Getter
    @Setter
    public static class TemuFullOrderGoodsLabelV2CategoriesCat6 {
        /**
         * 说明:类目ID
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long catId;

        /**
         * 说明:类目名称
         * 是否必填:false
         * 类型标识:4，类型:string
         */
        private String catName;

    }

    @Getter
    @Setter
    public static class TemuFullOrderGoodsLabelV2CategoriesCat7 {
        /**
         * 说明:类目ID
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long catId;

        /**
         * 说明:类目名称
         * 是否必填:false
         * 类型标识:4，类型:string
         */
        private String catName;

    }

    @Getter
    @Setter
    public static class TemuFullOrderGoodsLabelV2ProductSkuLabelCodeDTO {
        /**
         * 说明:货品sku id
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long productSkuId;

        /**
         * 说明:供应商id
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long supplierId;

        /**
         * 说明:货品id
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long productId;

        /**
         * 说明:货品skc id
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long productSkcId;

        /**
         * 说明:标签条码
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long labelCode;

    }

}