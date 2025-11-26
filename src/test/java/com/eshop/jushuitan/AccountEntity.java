//package com.eshop.jushuitan;
//
//
//import com.alibaba.excel.annotation.ExcelProperty;
//import com.bizark.boss.api.cons.BizConstant;
//import com.bizark.boss.api.entity.dashboard.amazon.AmazonMarketPlaceEntity;
//import com.bizark.boss.api.event.AccountAddressEvent;
//import com.bizark.boss.api.event.AccountShipmentEvent;
//import com.bizark.common.annotation.MetaData;
//import com.bizark.common.contract.AuthUserDetails;
//import com.bizark.common.contract.JsonViews;
//import com.bizark.common.enm.ModelActiveEnum;
//import com.bizark.common.entity.BizBaseNativeEntity;
//import com.bizark.common.event.EventBus;
//import com.bizark.common.util.JacksonUtils;
//import com.fasterxml.jackson.annotation.JsonFormat;
//import com.fasterxml.jackson.annotation.JsonInclude;
//import com.fasterxml.jackson.annotation.JsonView;
//import com.fasterxml.jackson.databind.annotation.JsonSerialize;
//import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
//import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
//import lombok.Getter;
//import lombok.Setter;
//import lombok.experimental.Accessors;
//import org.hibernate.annotations.DynamicInsert;
//import org.hibernate.annotations.DynamicUpdate;
//import org.hibernate.annotations.Where;
//
//import javax.persistence.*;
//import javax.validation.constraints.NotNull;
//import java.math.BigDecimal;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.util.Date;
//import java.util.List;
//import java.util.Map;
//
//@Getter
//@Setter
//@Accessors(chain = true)
//@Access(AccessType.FIELD)
//@JsonInclude(JsonInclude.Include.USE_DEFAULTS)
//@Entity
//@DynamicInsert
//@DynamicUpdate
//@Table(name = "accounts", schema = "dashboard")
//@MetaData(value = "渠道账号")
//@AttributeOverrides({
//        @AttributeOverride(name = "createdAt", column = @Column(name = "created", nullable = false)),
//        @AttributeOverride(name = "updatedAt", column = @Column(name = "updated", nullable = false))
//})
////@Where(clause = " active = 'Y'")
//@Where(clause = " is_delete is null")
//public class AccountEntity<AD_OAUTH_CODE> extends BizBaseNativeEntity {
//
//    @JsonView(JsonViews.Detail.class)
//    @Column(name = "parent_account_flag", length = 60)
//    private String parentAccountFlag;
//
//    @Column(name = "is_authorization")
//    private Integer isAuthorization = 0;
//
//    @Column(name = "seller_id")
//    private String sellerId;
//
//    @NotNull
//    @JsonView(JsonViews.Api.class)
//    @Column(name = "org_id", nullable = false)
//    private int orgId;
//
//    @JsonView(JsonViews.Detail.class)
//    @Column(name = "account_init", nullable = false, length = 120)
//    @ExcelProperty("店铺名称")
//    private String accountInit;
//
//    @NotNull
//    @JsonView(JsonViews.Api.class)
//    @Column(name = "flag", nullable = false)
//    @ExcelProperty("店铺标志")
//    private String flag;
//
//    @NotNull
//    @JsonView(JsonViews.Api.class)
//    @Column(name = "title", nullable = false)
//    @ExcelProperty("店铺标题")
//    private String title;
//
//    @JsonView(JsonViews.Api.class)
//    @Column(name = "type", nullable = false, length = 50)
//    @ExcelProperty("店铺类型/销售渠道")
//    private String type;
//
//    @JsonView(JsonViews.Detail.class)
//    @Column(name = "site", nullable = false, length = 50)
//    private String site;
//
//    @Column(name = "site_name")
//    @ExcelProperty("站点名称")
//    private String siteName;
//
//    @Column(name = "sale_channel")
//    private String saleChannel;
//
//    @NotNull
//    @JsonView(JsonViews.Detail.class)
//    @Column(name = "default_order_type", nullable = false, length = 3, columnDefinition = "TINYINT(3) DEFAULT 0")
//    private int defaultOrderType;
//
//    @JsonView(JsonViews.Api.class)
//    @Column(name = "currency", nullable = false, length = 5)
//    @ExcelProperty("币种")
//    private String currency;
//
//    @JsonView(JsonViews.Detail.class)
//    @Column(name = "username", nullable = false)
//    private String username;
//
//    @JsonView(JsonViews.Detail.class)
//    @Column(name = "password", nullable = false)
//    private String password;
//
//    @JsonView(JsonViews.Detail.class)
//    @Column(name = "fba_subinventory", nullable = false, length = 50)
//    private String fbaSubInventory;
//
//    @JsonView(JsonViews.Detail.class)
//    @Column(name = "fba_subinventory1", nullable = false, length = 50)
//    private String fbaSubInventory1;
//
//    @JsonView(JsonViews.Detail.class)
//    @Column(name = "fba_subinventory_new", nullable = false)
//    private int fbaSubInventoryNew;
//
//    @JsonView(JsonViews.Api.class)
//    @Column(name = "remark", nullable = false, length = 1024)
//    @ExcelProperty("备注")
//    private String remark;
//
//    @JsonView(JsonViews.Detail.class)
//    @Column(name = "begin_sales_date", nullable = false)
//    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "UTC")
//    @JsonSerialize(using = LocalDateSerializer.class)
//    @ExcelProperty("开始运营时间")
//    private LocalDate beginSalesDate;
//
//    @JsonView(JsonViews.Detail.class)
//    @Column(name = "begin_order_date")
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
//    @JsonSerialize(using = LocalDateTimeSerializer.class)
//    private LocalDateTime beginOrderDate;
//
//    @JsonView(JsonViews.Detail.class)
//    @Column(name = "erp_order_source_id", nullable = false)
//    private int erpOrderSourceId;
//
//    @JsonView(JsonViews.Detail.class)
//    @Column(name = "manage_user_email", nullable = false)
//    private String manageUserEmail;
//
//    @JsonView(JsonViews.Api.class)
//    @Column(name = "created", nullable = false, insertable = false, updatable = false)
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
//    @JsonSerialize(using = LocalDateTimeSerializer.class)
//    @ExcelProperty("创建时间")
//    private LocalDateTime created;
//
//    @JsonView(JsonViews.Api.class)
//    @Column(name = "updated", nullable = false, insertable = false, updatable = false)
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
//    @JsonSerialize(using = LocalDateTimeSerializer.class)
//    private LocalDateTime updated;
//
//    @JsonView(JsonViews.Api.class)
//    @Column(name = "active", nullable = false, columnDefinition = "enum('Y','N')")
//    @ExcelProperty("是否启用")
//    private String active;
//
//    @JsonView(JsonViews.Detail.class)
//    @Column(name = "unactive_time", nullable = false)
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
//    @JsonSerialize(using = LocalDateTimeSerializer.class)
//    private LocalDateTime unActiveTime;
//
//    @JsonView(JsonViews.Detail.class)
//    @Column(name = "model_type", nullable = false, length = 50)
//    private String modelType;
//
//    @JsonView(JsonViews.Detail.class)
//    @Column(name = "ftp_user", nullable = false, length = 100)
//    private String ftpUser;
//
//    @JsonView(JsonViews.Detail.class)
//    @Column(name = "ftp_password", nullable = false, length = 100)
//    private String ftpPassword;
//
//    @JsonView(JsonViews.Detail.class)
//    @Column(name = "ftp_url", nullable = false, length = 2048)
//    private String ftpUrl;
//
//    @JsonView(JsonViews.Detail.class)
//    @Column(name = "connect_str", nullable = false, length = 2047)
//    @ExcelProperty("接口信息")
//    private String connectStr;
//
//    @JsonView(JsonViews.Api.class)
//    @Column(name = "country_code", nullable = false, length = 2)
//    @ExcelProperty("国家编码")
//    private String countryCode;
//
//    @JsonView(JsonViews.Detail.class)
//    @Column(name = "area_code", nullable = false, length = 20)
//    @ExcelProperty("区域编码")
//    private String areaCode;
//
//    @JsonView(JsonViews.Detail.class)
//    @Column(name = "sale_type", length = 50)
//    @ExcelProperty("销售类型")
//    private String saleType;
//
//    @JsonView(JsonViews.Detail.class)
//    @Column(name = "order_only_show", nullable = false, columnDefinition = "enum('Y','N')")
//    private String orderOnlyShow;
//
//    @JsonView(JsonViews.Detail.class)
//    @ExcelProperty("发货允许最大天数")
//    @Column(name = "timeout_days", nullable = false)
//    private Integer timeoutDays;
//
//
////    @JsonView(JsonViews.Detail.class)
////    @Column(name = "advance_return")
////    private Integer advanceReturn;  //是否提前回传   0:否  1:是
////
////    @JsonView(JsonViews.Detail.class)
////    @Column(name = "outbound_mode")
////    private Integer outboundMode;  //出库方式   0:直接出库  1:集货出库
//
//
//    @JsonView(JsonViews.Api.class)
//    @Column(name = "status", length = 50)
//    @ExcelProperty("接口状态")
//    private String status;
//
//    @JsonView(JsonViews.Detail.class)
//    @Column(name = "inactive_time", nullable = false)
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
//    @JsonSerialize(using = LocalDateTimeSerializer.class)
//    private LocalDateTime inactiveTime;
//
//    @JsonView(JsonViews.Detail.class)
//    @Column(name = "status_comments")
//    private String statusComments;
//
//    @JsonView(JsonViews.Api.class)
//    @Column(name = "channel_category_id", nullable = false)
//    private Integer channelCategoryId;
//
//    @JsonView(JsonViews.Detail.class)
//    @Column(name = "is_return", nullable = false, columnDefinition = "enum('Y','N')")
//    private String isReturn;
//
//    @JsonView(JsonViews.Detail.class)
//    @Column(name = "return_begin", nullable = false)
//    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "UTC")
//    @JsonSerialize(using = LocalDateSerializer.class)
//    private LocalDate returnBegin;
//
//    @JsonView(JsonViews.Detail.class)
//    @Column(name = "is_linerelate", nullable = false, columnDefinition = "enum('Y','N')")
//    @ExcelProperty("未关联项目的订单是否默认为展示单")
//    private String isLineRelate;
//
//    @JsonView(JsonViews.Detail.class)
//    @Column(name = "linerelate_id", nullable = false)
//    @ExcelProperty(" 线路关联ID")
//    private Integer lineRelateId;
//
//    @JsonView(JsonViews.Detail.class)
//    @Column(name = "vat_rate", nullable = false, precision = 3)
//    @ExcelProperty(" 增值税率")
//    private BigDecimal vatRate;
//
//    @Column(name = "time_zone")
//    @ExcelProperty("时区")
//    private String timeZone;
//
//    @Column(name = "is_adv_auth", nullable = false)
//    private Integer isAdvAuth = 0;
//
//    @JsonView(JsonViews.Detail.class)
//    @Column(name = "advertisement", nullable = false)
//    private String advertisement;
//
//    @JsonView(JsonViews.Detail.class)
//    @Column(name = "advertisement_flag", nullable = false)
//    private Integer advertisementFlag;
//
//    @Column(name = "default_man_made_shipment", nullable = false)
//    private Integer defaultManMadeShipment;
//
//    @Column(name = "issue_account_pay", nullable = false)
//    private Integer issueAccountPay;
//
//    @Column(name = "is_account_pay", nullable = false)
//    @ExcelProperty("是否店铺支付运费:1是，0否")
//    private Integer isAccountPay;
//
//    @Column(name = "is_open_sfp", nullable = false)
//    @ExcelProperty("是否开放SFP")
//    private Integer isOpenSFP;
//
//    @Column(name = "boss_shipping_method_codes")
//    @ExcelProperty("哪些carrier需要上传附件")
//    private String bossShippingMethodCodes;
//
//    @Column(name = "manage_user_tels")
//    @ExcelProperty("账号负责人电话")
//    private String manageUserTels;
//
//    @Column(name = "authorization_at")
//    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "UTC")
//    @JsonSerialize(using = LocalDateSerializer.class)
//    private LocalDate authorizationAt;
//
//    @Column(name = "authorization_expire")
//    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "UTC")
//    @JsonSerialize(using = LocalDateSerializer.class)
//    private LocalDate authorizationExpire;
//
//
//    @Column(name = "cn_authorization_expire")
//    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "UTC")
//    @JsonSerialize(using = LocalDateSerializer.class)
//    private LocalDate cnAuthorizationExpire;
//
//    @Column(name = "store_name")
//    @ExcelProperty("浏览器店铺名称")
//    private String storeName;
//
//    @Transient
//    private List<String> bossShippingMethodCode;
//
//    @Transient
//    private List<AccountEntity> list;
//
//    @Transient
//    private Integer isMain;
//
//    @Transient
//    private Integer allowUpdate;
//
//    @Transient
//    private Integer isFk;
//
//    @Transient
//    private AmazonMarketPlaceEntity marketPlace;
//
//    @Column(name = "place_id")
//    private Long placeId;
//
//    @Column(name = "ad_auth_status")
//    private String adAuthStatus;
//
//    @Column(name = "ad_oauth_code")
//    private String adOauthCode;
//
//    @Column(name = "ad_access_token")
//    private String adAccessToken;
//
//    @Column(name = "ad_refresh_token")
//    private String adRefreshToken;
//
//    @Column(name = "ad_token_type")
//    private String adTokenType;
//
//    @Column(name = "ad_expires_in")
//    private Integer adExpiresIn;
//
//    @Column(name = "operation_id")
//    private Long operationId;
//
////    public void updateAccountShipment(AuthUserDetails user) {
////        EventBus.post(new AccountShipmentEvent(this, user));
////    }
////
//////    public void updateBaseTemplateEvent(AuthUserDetails user) {
//////        EventBus.post(new AccountBaseTemplateEvent(this, user));
//////    }
////
////    public void updateAccountAddress(AuthUserDetails user) {
////        EventBus.post(new AccountAddressEvent(this, user));
////    }
//
//    public static final String AD_OAUTH_CODE = "NEW";
//
//
//    /*** --------------------以下为新增字段----------------------  */
//
//    /**
//     * VC-USPO代码/vC-DI代码
//     */
//    @Column(name = "vendor_code")
//    @ExcelProperty("店铺类型代码")
//    private String vendorCode;
//
//
//    /**
//     * 账号类型
//     */
//    @Column(name = "account_type")
//    @ExcelProperty("账号类型")
//    private String accountType;
//
//
//    /**
//     * 店铺注册信息ID
//     */
//    @Column(name = "address_id")
//    private Integer addressId;
//
//    /**
//     * 金蝶编码
//     */
//    @Column(name = "jd_code")
//    @ExcelProperty("金蝶编码")
//    private String jdCode;
//
//
//    @Column(name = "is_labeled")
//    private String IsLabeled;
//
//
//    @Column(name = "amazon_application_id")
//    private String amazonApplicationId;
//
//    /**
//     * 是否包含佣金
//     */
//    @Column(name = "platform_com_flag")
//    @ExcelProperty("是否包含佣金")
//    private String platformComFlag;
//
//
//    @Column(name = "manage_user")
//    @ExcelProperty("负责人名称")
//    private String manageUser;
//
//
//    @Column(name = "manage_user_id")
//    private Integer manageUserId;
//
//
//    @Column(name = "ad_manage_user_id")
//    private Integer adManageUserId;
//
//    @Column(name = "delay_push")
//    private Integer delayPush = 0;
//
//    @Column(name = "update_auth_at")
//    @JsonView(JsonViews.Detail.class)
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
//    @JsonSerialize(using = LocalDateTimeSerializer.class)
//    private LocalDate updateAuthAt;
//
//
//    @Column(name = "purchaser_id")
//    private Integer purchaserId;
//    @Column(name = "purchaser_name")
//    private String purchaserName;
//    @Column(name = "purchaser_code")
//    private String purchaserCode;
//
//
//    @Column(name = "is_delete")
//    private Integer isDelete;
//
//
//    /**
//     * 用于查询开始运营时间的区间
//     */
//    @JsonView(JsonViews.Detail.class)
//    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "UTC")
//    @Transient  //字段忽略
//    @Column(updatable = false, insertable = false)  // 修改和插入排除
//    private Date endQueryTime;
//
//    @JsonView(JsonViews.Detail.class)
//    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "UTC")
//    @Transient  //字段忽略
//    @Column(updatable = false, insertable = false)  // 修改和插入排除
//    private Date beginQueryTime;
//
//
////    /**
////     * 店铺地址信息
////     */
////    @Transient
////    private AmzShopAddressEntity amzShopAddress;
////
////    /**
////     * 店铺退货仓库信息
////     */
////    @Transient
////    private List<AccountReturnWarehouseInfoEntity> accountReturnWarehouseList;
//
//
//    @Column(name = "investment")
//    private String investment;
//    @Column(name = "investment_code")
//    private String investmentCode;
//
//    @Column(name = "vendor_info")
//    private String vendorInfo;
//
//    @Column(name = "service_provider")
//    private String serviceProvider;
//
//    /**
//     * 发货地址ID
//     */
//    @Column(name = "sender_address_id")
//    private String senderAddressId;
//
//    /**
//     * 退货地址ID
//     */
//    @Column(name = "return_address_id")
//    private String returnAddressId;
//
//
//
//    //    @Column(name = "distribution_flag")
//    @Transient
//    private String distributionFlag;
//    //    @Column(name = "distribution_org_id")
//    @Transient
//    private Integer distributionOrgId;
//
////    @Transient
////    private List<AccountDistributionRelationEntity> distributionRelations;
//
//    @Transient
//    private Boolean hasActiveAddress = Boolean.FALSE;
//
//
//    /**
//     * 临时标识字段
//     */
//    @Transient
//    private boolean processed;
//
//    public boolean isWayfairLabel(String carrierService) {
//        String connectStr = this.connectStr;
//        Map<String, Object> connectStrMap = JacksonUtils.jsonToMap(connectStr);
//        if (connectStrMap.containsKey("new_flag")) {
//            Map<String, Object> newFlagMap = (Map<String, Object>) connectStrMap.get("new_flag");
//            if (newFlagMap.containsKey("SPlabel")) {
//                //勾选SP label的，则发货单上非LTL承运商的发货方式，和多渠道请求面单
//                if (newFlagMap.get("SPlabel").toString().equalsIgnoreCase(ModelActiveEnum.ACTIVE.value()) &&
//                        !carrierService.equalsIgnoreCase(BizConstant.LTL_CARRIER_SERVICE))
//                    return true;
//            }
//            if (newFlagMap.containsKey("LTLlabel")) {
//                //勾选了LTL label的，则发货单上LTL承运商的发货方式，和多渠道请求面单
//                if (newFlagMap.get("LTLlabel").toString().equalsIgnoreCase(ModelActiveEnum.ACTIVE.value()) &&
//                        carrierService.equalsIgnoreCase(BizConstant.LTL_CARRIER_SERVICE))
//                    return true;
//            }
//        }
//        return false;
//    }
//
//}
//
