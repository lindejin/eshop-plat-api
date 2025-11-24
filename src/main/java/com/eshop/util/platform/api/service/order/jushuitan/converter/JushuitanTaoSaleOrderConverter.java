package com.eshop.util.platform.api.service.order.jushuitan.converter;

import cn.hutool.core.collection.CollectionUtil;
import com.eshop.util.platform.api.service.order.jushuitan.converter.vo.*;
import com.eshop.util.platform.api.service.order.jushuitan.vo.*;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public class JushuitanTaoSaleOrderConverter implements JushuitanErpOrderConverter<JushuitanTaoSaleOrderListRespVO> {

    @Override
    public List<JushuitanErpOrderVO> convert(JushuitanTaoSaleOrderListRespVO source) {
        List<JushuitanTaoSaleOrderVO> orders = Optional.ofNullable(source)
                .map(JushuitanTaoSaleOrderListRespVO::getResponse)
                .map(JushuitanTaoSaleOrderListVO::getDatas)
                .orElse(new ArrayList<>());

        return getErpOrderVOS(orders);
    }

    private List<JushuitanErpOrderVO> getErpOrderVOS(List<JushuitanTaoSaleOrderVO> orders) {
        if (CollectionUtil.isEmpty(orders)) {
            return Collections.emptyList();
        }

        List<JushuitanErpOrderVO> jushuitanErpOrderVOS = new ArrayList<>();
        for (JushuitanTaoSaleOrderVO order : orders) {
            JushuitanErpOrderVO erpOrder = new JushuitanErpOrderVO();
            erpOrder.setOrderInfo(getOrderInfoVO(order));
            erpOrder.setSenderInfo(getSenderInfo(order));
            erpOrder.setReceiverInfo(getReceiverInfo(order));
            erpOrder.setOrderLines(getOrderLines(order));

            jushuitanErpOrderVOS.add(erpOrder);
        }
        return jushuitanErpOrderVOS;
    }

    /**
     * 转化订单信息
     */
    private JushuitanErpOrderInfoVO getOrderInfoVO(JushuitanTaoSaleOrderVO order) {
        JushuitanErpOrderInfoVO deliveryOrder = new JushuitanErpOrderInfoVO();

        //shopNick 店铺名称 销售出库单-店铺名称
        //shop_name	string	川梣铺子	店铺名称
        deliveryOrder.setShopNick(order.getShop_name());
        //shop_id	integer	店铺编号
        deliveryOrder.setShopId(order.getShop_id());

        //status	string	Question	聚水潭订单状态
        deliveryOrder.setStatus(order.getStatus());

        //invoice_title	string		发票抬头
        deliveryOrder.setInvoiceTitle(order.getInvoice_title());

        //buyer_message	string		买家留言
        deliveryOrder.setBuyerMessage(order.getBuyer_message());

        //buyer_tax_no string 发票税号  先存在后台表
        //非淘系 - 无
        deliveryOrder.setBuyerTaxNo(order.getBuyer_tax_no());

        //deliveryOrderCode OMS订单号 是 销售出库单-出仓单号
        String deliveryOrderCode = order.getIo_id() == null ? "" : order.getIo_id().toString();
        deliveryOrder.setDeliveryOrderCode(deliveryOrderCode);

        //oaidOrderSourceCode oaid对应线上单号 否 - 淘系oaid对应的线上单号，唯一
        //so_id	线上订单号，线上同步过来的订单号，最长不超过20;唯一 /对应销售单号
        deliveryOrder.setOaidOrderSourceCode(order.getSo_id());

        //orderType 单据类型是默认”JYCK“，若唯品会JITX补寄订单，则推送”BFCK“；  如果是聚水潭补发、换货类型订单，可以开通功能推送”BFCK“、”HHCK“类型，详情介绍见该页：5.2 订单多类型
        //奇门订单类型除了JYCK，也枚举了其他类型HHCK=换货出库单、BFCK=补发出库单，默认是不做推送的，标准业务里，WMS不需要感知订单类型，做发货即可。
        deliveryOrder.setOrderType(order.getOrder_type());

        //type	string	普通订单	订单类型，普通订单；补发订单；分销Plus；供销Plus；换货订单
        deliveryOrder.setType(order.getOrder_type());

        //warehouseCode 外部仓库编码是奇门配置-仓库代码WMS提供
        //warehouse_oid	string		外部单据号
        String warehouseCode = order.getWms_co_id() == null ? "" : order.getWms_co_id().toString();
        deliveryOrder.setWarehouseCode(warehouseCode);

        //latestDeliveryTime 最晚发货时间 否 订单-计划发货日期
        //plan_delivery_date	string		计划发货时间
        String latestDeliveryTime = "";
        deliveryOrder.setLatestDeliveryTime(latestDeliveryTime);

        //createTime 单据创建时间 是 订单审核时间
        // String createTime;
        deliveryOrder.setCreateTime(order.getCreated());

        //payNo 支付平台交易号 否 订单-支付单号
        //outer_pay_id	string	20210928	外部支付单号
        String payNo = "";
        deliveryOrder.setPayNo(payNo);

        //buyerNick 买家昵称 是 订单-买家账号 代发业务会使用该字段传店铺ID一类信息，详情可见菜单【关于收件人加密】
        //buyer_id	string		买家ID（系统根据shop_buy_id生成的）
        deliveryOrder.setBuyerNick(order.getShop_buyer_id());

        //totalAmount 订单总金额 (元) 是 商品总金额+运费-折扣金额 受奇门配置-金额隐藏影响，开启则推0
        //需要单独计算 ......
        deliveryOrder.setTotalAmount(getTotalAmount(order));

        //itemAmount 商品总金额 (元) 是 订单项(实际成交金额*应发数量)总和
        String itemAmount = order.getPay_amount() == null ? "" : order.getPay_amount().toString();
        deliveryOrder.setItemAmount(itemAmount);

        //discountAmount 订单折扣金额 (元) 是 订单表里的折扣金额
        //free_amount	number	0.0	优惠金额
        String discountAmount = order.getFree_amount() == null ? "" : order.getFree_amount().toString();
        deliveryOrder.setDiscountAmount(discountAmount);

        //freight 快递费用 (元  ) 是 订单表里的运费金额
        //freight 4.0	买家支付运费，保留两位小数，单位（元）
        String freight = order.getFreight() == null ? "" : order.getFreight().toString();
        deliveryOrder.setFreight(freight);

        //gotAmount 已收金额 (元) 是 不是货到付款状态:订单表中的实付金额 是货到付款： 0 --- 实付金额
        //paid_amount		实际支付金额
        String gotAmount = order.getPaid_amount() == null ? "" : order.getPaid_amount().toString();
        deliveryOrder.setGotAmount(gotAmount);

        //logisticsCode 快递公司编码 是 销售出库单-快递公司
        //lc_id		物流公司编码
        deliveryOrder.setLogisticsCode(order.getLc_id());

        //expressCode 物流单号 否 销售出库单-物流单号 订单有运单号且开启奇门配置-推送物流信息才会推送该字段；否则为空
        //l_id		快递单号
        deliveryOrder.setExpressCode(order.getL_id());

        //insuranceFlag 是否需要保价, Y/N 是  推送前提：
        //1、开启奇门配置保价推送
        //2、物流设置保价规则，且对应订单需要获取面单号并命中该规则，有保价金额则为“Y”
        //非淘系 无
//        deliveryOrder.setInsuranceFlag();

        return deliveryOrder;
    }

    /**
     * 转化订单发件人信息
     */
    private JushuitanErpOrderSenderInfoVO getSenderInfo(JushuitanTaoSaleOrderVO order) {
        JushuitanErpOrderSenderInfoVO senderInfo = new JushuitanErpOrderSenderInfoVO();
        //name 姓名 是 按奇门配置读取仓库或者店铺联系人信息 仓库名称、店铺简称、仓库联系人
        // String name;
        senderInfo.setName("");
        //mobile 移动电话 是 同上 店铺、云仓配置、仓库手机号
        // String mobile;
        senderInfo.setMobile("");
        //province 省 是 同上 店铺或仓库
        // String province;
        senderInfo.setProvince("");
        //city 市 是 同上 店铺或仓库
        // String city;
        senderInfo.setCity("");
        //area 区 是 同上 店铺或仓库
        // String area;
        senderInfo.setArea("");
        //detailAddress 详细地址 是 同上 店铺或仓库
        // String detailAddress;
        senderInfo.setDetailAddress("");
        return senderInfo;
    }

    /**
     * 转发订单收件人信息
     */
    private JushuitanErpOrderReceiverInfo getReceiverInfo(JushuitanTaoSaleOrderVO order) {
        JushuitanErpOrderReceiverInfo receiverInfo = new JushuitanErpOrderReceiverInfo();

        //name 收件人 是 销售出库单-收货人
        // String name;
        receiverInfo.setName(order.getShop_buyer_id());
        //mobile 移动电话 是 销售出库单-手机
        String mobile = "";
        receiverInfo.setMobile(mobile);
        //province 省 是 销售出库单- 详细地址- 省
        // String province;
        receiverInfo.setProvince(order.getReceiver_state());
        //city 市 是 销售出库单- 详细地址- 市
        // String city;
        receiverInfo.setCity(order.getReceiver_city());
        //area 区 是 销售出库单- 详细地址- 区
        receiverInfo.setArea(order.getReceiver_district());
        //town 镇 否 销售出库单- 详细地址- 镇
        String town =  "";
        receiverInfo.setTown(town);
        //detailAddress 详细地址 是 销售出库单- 详细地址- 详细地址
        String detailAddress  = "";
        receiverInfo.setDetailAddress(detailAddress);
        //oaid oaid 否 - 淘系密文订单必传； 小红书密文订单必传； 1688平台传值中间带 -  ，为caid
        // open_id	string		平台买家唯一值，仅支持天猫，抖音，快手
        receiverInfo.setOaid(order.getOpen_id());

        //receiver_country		国家代码
        receiverInfo.setCountry(order.getReceiver_country());

        return receiverInfo;
    }

    /**
     * 转换订单商品行信息
     *
     * @param order
     * @return
     */
    private List<JushuitanErpOrderLineInfo> getOrderLines(JushuitanTaoSaleOrderVO order) {
        List<JushuitanTaoSaleOrderItemVO> items = order.getItems();
        if (CollectionUtil.isEmpty(items)) {
            return Collections.emptyList();
        }

        List<JushuitanErpOrderLineInfo> erpOrderLines = new ArrayList<>();
        for (JushuitanTaoSaleOrderItemVO saleOrderItemVO : items) {
            JushuitanErpOrderLineInfo erpOrderLineInfo = new JushuitanErpOrderLineInfo();
            //orderLineNo  行号  是
            String orderLineNo = "";
            erpOrderLineInfo.setOrderLineNo(orderLineNo);
            //ownerCode  货主编码  是  奇门配置-货主  WMS提供
            String ownerCode = "";
            erpOrderLineInfo.setOwnerCode(ownerCode);
            //itemCode  sku商品编码  是  订单-商品编码
            String itemCode = saleOrderItemVO.getSku_id();
            erpOrderLineInfo.setItemCode(itemCode);
            //inventoryType  库存类型  是    固定为“ZP”，销售订单只能出库正品
            String inventoryType = "ZP";
            erpOrderLineInfo.setInventoryType(inventoryType);
            //planQty  计划出库数量  是
            Integer planQty = saleOrderItemVO.getQty();
            erpOrderLineInfo.setPlanQty(planQty);
            //retailPrice  零售价  否  单价  开启奇门推送营收小计开关后推送；  很可能有  除不尽情况，建议使用明细行的商品总金额
            String retailPrice = saleOrderItemVO.getSale_amount() == null ? "" : saleOrderItemVO.getSale_amount().toString();
            erpOrderLineInfo.setRetailPrice(retailPrice);
            //actualPrice  零售价  否  单价
            String actualPrice = saleOrderItemVO.getSale_price() == null ? "" : saleOrderItemVO.getSale_price().toString();
            erpOrderLineInfo.setActualPrice(actualPrice);


            //isGift  是否赠品标识  是  1-赠品；  0-非赠品
            Boolean isGift = saleOrderItemVO.getIs_gift();
            if (isGift != null) {
                if (isGift) {
                    erpOrderLineInfo.setIsGift(1);
                } else {
                    erpOrderLineInfo.setIsGift(0);
                }
            }
            //combine_sku_id  组合装编码  否
            //  String combine_sku_id;
            erpOrderLineInfo.setCombine_sku_id(saleOrderItemVO.getCombine_sku_id());
            //combine_sku_quantity  组合装数量  否
            erpOrderLineInfo.setCombine_sku_quantity(saleOrderItemVO.getQty());
            //buyer_paidamount  买家实付金额（明细）  否  订单详情-营收小计-买家实付  按金额占比分摊明细
            String buyer_paidamount = saleOrderItemVO.getBuyer_paid_amount() == null ? "" : saleOrderItemVO.getBuyer_paid_amount().toString();
            erpOrderLineInfo.setBuyer_paidamount(buyer_paidamount);
            //sellerIncome_amount  商家实收  否  订单详情-营收小计-商家实收  按金额占比分摊明细
            String sellerIncome_amount = saleOrderItemVO.getSeller_income_amount() == null ? "" : saleOrderItemVO.getSeller_income_amount().toString();
            erpOrderLineInfo.setSellerIncome_amount(sellerIncome_amount);
            //platform_freeamount  平台优惠总金额  否  营收小计-平台补贴  开启奇门推送营收小计开关后推送；  按金额占比分摊明细
            String platform_freeamount = "";
            erpOrderLineInfo.setPlatform_freeamount(platform_freeamount);
            //venderFee  邮费  否  订单邮费  开启奇门推送营收小计开关后推送；  按金额占比分摊明细
            String venderFee = "";
            erpOrderLineInfo.setVenderFee(venderFee);
            erpOrderLines.add(erpOrderLineInfo);

        }
        return erpOrderLines;
    }

    /**
     * totalAmount 订单总金额 (元) 是 商品总金额+运费-折扣金额 受奇门配置-金额隐藏影响，开启则推0
     */
    private String getTotalAmount(JushuitanTaoSaleOrderVO order) {
        BigDecimal freight = order.getFreight() == null ? BigDecimal.ZERO : new BigDecimal(order.getFreight());
        BigDecimal freeAmount = order.getFree_amount() == null ? BigDecimal.ZERO : new BigDecimal(order.getFree_amount());

        BigDecimal productAmount = BigDecimal.ZERO;
        List<JushuitanTaoSaleOrderItemVO> items = order.getItems();
        if (CollectionUtil.isNotEmpty(items)) {
            for (JushuitanTaoSaleOrderItemVO saleOrderItemVO : items) {
                //itemCode  sku商品编码  是  订单-商品编码
                BigDecimal sale_amount = saleOrderItemVO.getSale_amount() == null ? BigDecimal.ZERO : new BigDecimal(saleOrderItemVO.getSale_amount());
                productAmount = productAmount.add(sale_amount);

            }
        }


        return productAmount.add(freight).subtract(freeAmount).toString();
    }
}
