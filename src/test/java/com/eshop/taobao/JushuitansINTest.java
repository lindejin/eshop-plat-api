package com.eshop.taobao;

import org.apache.commons.lang3.StringUtils;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: eshop-plat-api
 * @description:
 * @author: lindz
 * @create: 2026-01-18 18:09
 **/
public class JushuitansINTest {
    private static final String SIGN_METHOD_MD5 = "md5";
    private static final String SIGN_METHOD_HMAC = "hmac";
    private static final String CHARSET_UTF8 = "utf-8";
    private static final String CONTENT_ENCODING_GZIP = "gzip";
    private static final String str = "{\n" +
            "  \"orderLines\": {\n" +
            "    \"snCode\": \"货品sn编码\",\n" +
            "    \"itemCode\": \"I1234\",\n" +
            "    \"discountAmount\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"discount\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"purchasePrice\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"itemName\": \"淘公仔\",\n" +
            "    \"qrCode\": \"one;two\",\n" +
            "    \"orderSourceCode\": \"P1234\",\n" +
            "    \"deliveryOrderId\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"imeiList\": {\n" +
            "      \"extSnList\": {}\n" +
            "    },\n" +
            "    \"stockInQty\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"inventoryType\": \"ZP\",\n" +
            "    \"subSourceCode\": \"J1234\",\n" +
            "    \"productDate\": \"2016-09-09\",\n" +
            "    \"itemId\": \"WI1234\",\n" +
            "    \"batchs\": {\n" +
            "      \"produceCode\": \"PH1234\",\n" +
            "      \"inventoryType\": \"ZP\",\n" +
            "      \"quantity\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"snCode\": \"货品sn编码\",\n" +
            "      \"batchCode\": \"PC1234\",\n" +
            "      \"remark\": \"备注\",\n" +
            "      \"expireDate\": \"2017-09-09\",\n" +
            "      \"productDate\": \"2016-09-09\",\n" +
            "      \"actualQty\": 12\n" +
            "    },\n" +
            "    \"extCode\": \"PL1234\",\n" +
            "    \"size\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"sourceOrderCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"locationCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"status\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"planQty\": 12,\n" +
            "    \"color\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"actualPrice\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"ownerCode\": \"OW1234\",\n" +
            "    \"discountPrice\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"stockOutQty\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"remark\": \"备注\",\n" +
            "    \"supplierCode\": \"供应商编码\",\n" +
            "    \"actualQty\": 12,\n" +
            "    \"warehouseCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"skuProperty\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"payNo\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"produceCode\": \"P2345\",\n" +
            "    \"referencePrice\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"taobaoItemCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"expireDate\": \"2017-09-09\",\n" +
            "    \"supplierName\": \"供应商名称\",\n" +
            "    \"amount\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"orderLineNo\": \"1\",\n" +
            "    \"quantity\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"exceptionQty\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"batchCode\": \"P1234\",\n" +
            "    \"standardPrice\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"subDeliveryOrderId\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"subSourceOrderCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"moveOutLocation\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"standardAmount\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"productCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"outBizCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"moveInLocation\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"snList\": {},\n" +
            "    \"settlementAmount\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"retailPrice\": \"奇门仓储字段,说明,string(50),,\"\n" +
            "  },\n" +
            "  \"deliveryOrder\": {\n" +
            "    \"orderType\": \"JYCK\",\n" +
            "    \"buyerNick\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"operateTime\": \"2016-09-09 12:00:00\",\n" +
            "    \"discountAmount\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"shopNick\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"isCod\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"itemName\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"salesModel\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"invoices\": {\n" +
            "      \"number\": \"NUM123\",\n" +
            "      \"amount\": \"12.0\",\n" +
            "      \"code\": \"CODE123\",\n" +
            "      \"header\": \"XXX公司\",\n" +
            "      \"remark\": \"备注\",\n" +
            "      \"detail\": {\n" +
            "        \"items\": {\n" +
            "          \"orderType\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"reason\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"originAddress\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"discount\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"pricingCategory\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"itemName\": \"淘公仔\",\n" +
            "          \"packCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"price\": \"12.0\",\n" +
            "          \"brandCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"height\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"seasonCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"safetyStock\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"paperQty\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"productDate\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"stockUnit\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"itemId\": \"1234\",\n" +
            "          \"size\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"rejectLifecycle\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"shortName\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"planQty\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"ownerCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"supplierCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"defectiveQty\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"diffQuantity\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"tempRequirement\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"skuProperty\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"referencePrice\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"exCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"normalQty\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"seasonName\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"packageMaterial\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"expireDate\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"sn\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"shelfLife\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"orderLineNo\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"actualAmount\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"latestUpdateTime\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"costPrice\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"tagPrice\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"isSku\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"changeTime\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"productCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"width\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"goodsCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"retailPrice\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"tareWeight\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"priceAdjustment\": {\n" +
            "            \"endDate\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "            \"discount\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "            \"standardPrice\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "            \"remark\": \"备注\",\n" +
            "            \"type\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "            \"startDate\": \"奇门仓储字段,说明,string(50),,\"\n" +
            "          },\n" +
            "          \"snCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"itemCode\": \"1234\",\n" +
            "          \"lockQuantity\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"purchasePrice\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"lackQty\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"stockStatus\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"originCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"brandName\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"inventoryType\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"receiveQty\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"barCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"volume\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"batchs\": {\n" +
            "            \"produceCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "            \"inventoryType\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "            \"quantity\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "            \"batchCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "            \"expireDate\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "            \"remark\": \"备注\",\n" +
            "            \"productDate\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "            \"actualQty\": \"奇门仓储字段,说明,string(50),,\"\n" +
            "          },\n" +
            "          \"netWeight\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"unit\": \"个\",\n" +
            "          \"extCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"sourceOrderCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"isSNMgmt\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"lockupLifecycle\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"englishName\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"itemType\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"color\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"adventLifecycle\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"discountPrice\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"remark\": \"备注\",\n" +
            "          \"title\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"categoryName\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"actualQty\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"warehouseCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"produceCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"isShelfLifeMgmt\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"isAreaSale\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"isFragile\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"channelCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"supplierName\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"pcs\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"isHazardous\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"amount\": \"12.0\",\n" +
            "          \"quantity\": 12,\n" +
            "          \"batchCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"length\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"standardPrice\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"subSourceOrderCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"approvalNumber\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"grossWeight\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"isBatchMgmt\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"batchRemark\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"outBizCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"orderCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "          \"categoryId\": \"奇门仓储字段,说明,string(50),,\"\n" +
            "        }\n" +
            "      },\n" +
            "      \"type\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"content\": \"XXX公司报销XX元\"\n" +
            "    },\n" +
            "    \"personalOrderNote\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"packCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"price\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"expressCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"orderSourceCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"pickerInfo\": {\n" +
            "      \"area\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"zipCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"career\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"idType\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"town\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"gender\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"city\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"mobile\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"countryCodeCus\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"remark\": \"备注\",\n" +
            "      \"idNumber\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"birthDate\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"nick\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"province\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"carNo\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"countryCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"name\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"detailAddress\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"company\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"tel\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"id\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"fax\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"countryCodeCiq\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"email\": \"奇门仓储字段,说明,string(50),,\"\n" +
            "    },\n" +
            "    \"arAmount\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"totalOrderLines\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"personalPackageNote\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"orderConfirmTime\": \"2016-09-08 12:00:00\",\n" +
            "    \"packages\": {\n" +
            "      \"theoreticalWeight\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"length\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"logisticsCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"weight\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"remark\": \"备注\",\n" +
            "      \"logisticsName\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"volume\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"packageMaterialList\": {\n" +
            "        \"quantity\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "        \"remark\": \"备注\",\n" +
            "        \"type\": \"奇门仓储字段,说明,string(50),,\"\n" +
            "      },\n" +
            "      \"packageCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"expressCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"width\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"invoiceNo\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"items\": {\n" +
            "        \"planQty\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "        \"quantity\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "        \"itemCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "        \"batchCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "        \"logisticsCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "        \"remark\": \"备注\",\n" +
            "        \"actualQty\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "        \"productDate\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "        \"barCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "        \"itemId\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "        \"produceCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "        \"itemName\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "        \"extCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "        \"packItemPrice\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "        \"expireDate\": \"奇门仓储字段,说明,string(50),,\"\n" +
            "      },\n" +
            "      \"height\": \"奇门仓储字段,说明,string(50),,\"\n" +
            "    },\n" +
            "    \"logisticsName\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"relatedOrders\": {\n" +
            "      \"orderType\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"orderCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"remark\": \"备注\"\n" +
            "    },\n" +
            "    \"lineNumber\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"items\": {\n" +
            "      \"orderType\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"reason\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"originAddress\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"discount\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"pricingCategory\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"itemName\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"packCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"price\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"brandCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"height\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"seasonCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"safetyStock\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"paperQty\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"productDate\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"stockUnit\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"itemId\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"size\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"rejectLifecycle\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"shortName\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"planQty\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"ownerCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"supplierCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"defectiveQty\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"diffQuantity\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"tempRequirement\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"skuProperty\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"referencePrice\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"exCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"normalQty\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"seasonName\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"packageMaterial\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"expireDate\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"sn\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"shelfLife\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"orderLineNo\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"actualAmount\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"latestUpdateTime\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"costPrice\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"tagPrice\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"isSku\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"changeTime\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"productCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"width\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"goodsCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"retailPrice\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"tareWeight\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"priceAdjustment\": {\n" +
            "        \"endDate\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "        \"discount\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "        \"standardPrice\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "        \"remark\": \"备注\",\n" +
            "        \"type\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "        \"startDate\": \"奇门仓储字段,说明,string(50),,\"\n" +
            "      },\n" +
            "      \"snCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"itemCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"lockQuantity\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"purchasePrice\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"lackQty\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"stockStatus\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"originCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"brandName\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"inventoryType\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"receiveQty\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"barCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"volume\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"batchs\": {\n" +
            "        \"produceCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "        \"inventoryType\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "        \"quantity\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "        \"batchCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "        \"expireDate\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "        \"remark\": \"备注\",\n" +
            "        \"productDate\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "        \"actualQty\": \"奇门仓储字段,说明,string(50),,\"\n" +
            "      },\n" +
            "      \"netWeight\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"unit\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"extCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"sourceOrderCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"isSNMgmt\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"lockupLifecycle\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"englishName\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"itemType\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"color\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"adventLifecycle\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"discountPrice\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"remark\": \"备注\",\n" +
            "      \"title\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"categoryName\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"actualQty\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"warehouseCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"produceCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"isShelfLifeMgmt\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"isAreaSale\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"isFragile\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"channelCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"supplierName\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"pcs\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"isHazardous\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"amount\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"quantity\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"batchCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"length\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"standardPrice\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"subSourceOrderCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"approvalNumber\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"grossWeight\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"isBatchMgmt\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"batchRemark\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"outBizCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"orderCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"categoryId\": \"奇门仓储字段,说明,string(50),,\"\n" +
            "    },\n" +
            "    \"status\": \"NEW\",\n" +
            "    \"ownerCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"serviceCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"freight\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"supplierCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"deliveryOrderCode\": \"T1234\",\n" +
            "    \"operatorCode\": \"O23\",\n" +
            "    \"sourcePlatformName\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"operatorName\": \"老王\",\n" +
            "    \"orderLines\": {\n" +
            "      \"snCode\": \"货品sn编码\",\n" +
            "      \"itemCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"discountAmount\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"discount\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"purchasePrice\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"itemName\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"qrCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"orderSourceCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"deliveryOrderId\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"imeiList\": {\n" +
            "        \"extSnList\": {}\n" +
            "      },\n" +
            "      \"inventoryType\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"stockInQty\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"subSourceCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"productDate\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"itemId\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"batchs\": {\n" +
            "        \"produceCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "        \"inventoryType\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "        \"quantity\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "        \"snCode\": \"货品sn编码\",\n" +
            "        \"batchCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "        \"expireDate\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "        \"remark\": \"备注\",\n" +
            "        \"productDate\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "        \"actualQty\": \"奇门仓储字段,说明,string(50),,\"\n" +
            "      },\n" +
            "      \"extCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"size\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"sourceOrderCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"locationCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"status\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"planQty\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"color\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"actualPrice\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"ownerCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"discountPrice\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"stockOutQty\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"remark\": \"remark\",\n" +
            "      \"actualQty\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"warehouseCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"skuProperty\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"produceCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"payNo\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"referencePrice\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"taobaoItemCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"expireDate\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"orderLineNo\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"amount\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"quantity\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"exceptionQty\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"batchCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"standardPrice\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"subDeliveryOrderId\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"subSourceOrderCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"moveOutLocation\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"standardAmount\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"productCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"outBizCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"moveInLocation\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"snList\": {},\n" +
            "      \"settlementAmount\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"retailPrice\": \"奇门仓储字段,说明,string(50),,\"\n" +
            "    },\n" +
            "    \"itemAmount\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"sellerMessage\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"shelfLife\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"sellerNick\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"shopCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"uomCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"actualAmount\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"noStackTag\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"buyerName\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"minArrivalTime\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"buyerMessage\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"createTime\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"isValueDeclared\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"orderFlag\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"priorityCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"modifiedTime\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"storageFee\": \"12.0\",\n" +
            "    \"transpostSum\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"mergeOrderCodes\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"payTime\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"declaredAmount\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"itemCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"produceDate\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"sellerId\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"payMethod\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"gotAmount\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"presaleOrderType\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"confirmType\": 0,\n" +
            "    \"planArrivalTime\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"deliveryOrderId\": \"C1234\",\n" +
            "    \"serviceFee\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"invoiceFlag\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"deliveryNote\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"logisticsCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"planDeliveryDate\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"totalAmount\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"isUrgency\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"buyerPhone\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"sourcePlatformCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"logisticsAreaCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"sourceOrderCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"transportMode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"exceptionCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"receiveOrderTime\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"deliveryRequirements\": {\n" +
            "      \"scheduleType\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"scheduleDay\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"deliveryType\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"remark\": \"备注\",\n" +
            "      \"scheduleStartTime\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"scheduleEndTime\": \"奇门仓储字段,说明,string(50),,\"\n" +
            "    },\n" +
            "    \"collectedAmount\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"orderNote\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"receiverInfo\": {\n" +
            "      \"area\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"zipCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"career\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"idType\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"town\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"gender\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"city\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"mobile\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"countryCodeCus\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"remark\": \"备注\",\n" +
            "      \"idNumber\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"birthDate\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"nick\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"province\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"carNo\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"countryCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"name\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"detailAddress\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"company\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"tel\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"id\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"fax\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"countryCodeCiq\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"email\": \"奇门仓储字段,说明,string(50),,\"\n" +
            "    },\n" +
            "    \"orderStatus\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"remark\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"mergeOrderFlag\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"warehouseCode\": \"W1234\",\n" +
            "    \"placeOrderTime\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"payNo\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"maxArrivalTime\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"preDeliveryOrderId\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"scheduleDate\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"insuranceFlag\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"supplierName\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"quantity\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"batchCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"preDeliveryOrderCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"senderInfo\": {\n" +
            "      \"area\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"zipCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"career\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"idType\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"town\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"gender\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"city\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"mobile\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"countryCodeCus\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"remark\": \"备注\",\n" +
            "      \"idNumber\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"birthDate\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"nick\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"province\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"carNo\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"countryCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"name\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"detailAddress\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"company\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"tel\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"id\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"fax\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"countryCodeCiq\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"email\": \"奇门仓储字段,说明,string(50),,\"\n" +
            "    },\n" +
            "    \"fetchItemLocation\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"outBizCode\": \"WB1234\",\n" +
            "    \"businessMemo\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"identifyCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"warehouseAddressCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "    \"isPaymentCollected\": \"奇门仓储字段,说明,string(50),,\"\n" +
            "  },\n" +
            "  \"packages\": {\n" +
            "    \"theoreticalWeight\": \"12.0\",\n" +
            "    \"length\": \"12.0\",\n" +
            "    \"logisticsCode\": \"SF\",\n" +
            "    \"weight\": \"12.0\",\n" +
            "    \"remark\": \"备注\",\n" +
            "    \"logisticsName\": \"顺丰\",\n" +
            "    \"volume\": \"12.0\",\n" +
            "    \"packageMaterialList\": {\n" +
            "      \"quantity\": 12,\n" +
            "      \"remark\": \"备注\",\n" +
            "      \"type\": \"XLL\"\n" +
            "    },\n" +
            "    \"packageCode\": \"LG1234\",\n" +
            "    \"expressCode\": \"Y1234\",\n" +
            "    \"width\": \"12.0\",\n" +
            "    \"invoiceNo\": \"IN1234\",\n" +
            "    \"items\": {\n" +
            "      \"planQty\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"orderLineNo\": \"1\",\n" +
            "      \"quantity\": 11,\n" +
            "      \"batchCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"itemCode\": \"I1234\",\n" +
            "      \"logisticsCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"remark\": \"备注\",\n" +
            "      \"actualQty\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"productDate\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"barCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"produceCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"itemId\": \"WI1234\",\n" +
            "      \"itemName\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"extCode\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"packItemPrice\": \"奇门仓储字段,说明,string(50),,\",\n" +
            "      \"expireDate\": \"奇门仓储字段,说明,string(50),,\"\n" +
            "    },\n" +
            "    \"height\": \"12.0\"\n" +
            "  }\n" +
            "}";
    public static void main(String[] args) throws IOException {

        // 定义必要的参数变量
        String method = "taobao.qimen.deliveryorder.confirm";
        String appKey = "12129701";
        String sessionKey = null; // 根据实际情况设置
        String timestamp = "2026-01-18 18:19:43"; // 实际使用时应该用当前时间
        String format = "json";
        String version = "2.0";
        String signMethod = "md5";
        String targetAppKey = null; // 根据实际情况设置
        String customerId = null; // 根据实际情况设置
        String appSecret = "12129701"; // 替换为你的app secret

        Map<String, String> param = new HashMap<>();
        param.put("request", str);

        // 添加API系统参数
        param.put("method", method);
        param.put("app_key", appKey);
        param.put("session", sessionKey != null ? sessionKey : ""); // 非必填
        param.put("timestamp", timestamp);
        param.put("format", format);
        param.put("v", version);
        param.put("sign_method", signMethod);
        param.put("partner_id", "top-apitools"); // 添加示例中出现的partner_id参数

        // 申请奇门自定义场景的参数
        if (targetAppKey != null && !targetAppKey.trim().isEmpty()) {
            param.put("target_app_key", targetAppKey);
        }
        if (customerId != null && !customerId.trim().isEmpty()) {
            param.put("customer_id", customerId);
        }

        // 签名参数
        String s = signTopRequest(param, appSecret, SIGN_METHOD_MD5);
        System.out.println(s);
        param.put("sign", signTopRequest(param, appSecret, SIGN_METHOD_MD5));
    }

    /**
     * 对TOP请求进行签名。
     */
    private static String signTopRequest(Map<String, String> params, String secret, String signMethod) throws IOException {
        // 第一步：检查参数是否已经排序
        String[] keys = params.keySet().toArray(new String[0]);
        Arrays.sort(keys);

        // 第二步：把所有参数名和参数值串在一起
        StringBuilder query = new StringBuilder();
        if (SIGN_METHOD_MD5.equals(signMethod)) {
            query.append(secret);
        }
        for (String key : keys) {
            String value = params.get(key);
            if (StringUtils.isNotEmpty(key) && StringUtils.isNotEmpty(value)) {
                query.append(key).append(value);
            }
        }

        // 第三步：使用MD5/HMAC加密
        byte[] bytes;
        if (SIGN_METHOD_HMAC.equals(signMethod)) {
            bytes = encryptHMAC(query.toString(), secret);
        } else {
            query.append(secret);
            bytes = encryptMD5(query.toString());
        }

        // 第四步：把二进制转化为大写的十六进制
        return byte2hex(bytes);
    }

    /**
     * 对字节流进行HMAC_MD5摘要。
     */
    private static byte[] encryptHMAC(String data, String secret) throws IOException {
        byte[] bytes = null;
        try {
            SecretKey secretKey = new SecretKeySpec(secret.getBytes(CHARSET_UTF8), "HmacMD5");
            Mac mac = Mac.getInstance(secretKey.getAlgorithm());
            mac.init(secretKey);
            bytes = mac.doFinal(data.getBytes(CHARSET_UTF8));
        } catch (GeneralSecurityException gse) {
            throw new IOException(gse.toString());
        }
        return bytes;
    }

    /**
     * 对字符串采用UTF-8编码后，用MD5进行摘要。
     */
    private static byte[] encryptMD5(String data) throws IOException {
        return encryptMD5(data.getBytes(CHARSET_UTF8));
    }

    /**
     * 对字节流进行MD5摘要。
     */
    private static byte[] encryptMD5(byte[] data) throws IOException {
        byte[] bytes = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            bytes = md.digest(data);
        } catch (GeneralSecurityException gse) {
            throw new IOException(gse.toString());
        }
        return bytes;
    }

    /**
     * 把字节流转换为十六进制表示方式。
     */
    private static String byte2hex(byte[] bytes) {
        StringBuilder sign = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(bytes[i] & 0xFF);
            if (hex.length() == 1) {
                sign.append("0");
            }
            sign.append(hex.toUpperCase());
        }
        return sign.toString();
    }
}
