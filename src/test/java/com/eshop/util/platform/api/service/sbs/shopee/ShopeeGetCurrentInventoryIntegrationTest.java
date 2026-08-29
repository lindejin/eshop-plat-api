package com.eshop.util.platform.api.service.sbs.shopee;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.eshop.util.platform.api.client.shopee.ShopeeClientImpl;
import com.eshop.util.platform.api.client.shopee.ShopeeRequest;
import com.eshop.util.platform.api.client.shopee.ShopeeResponse;
import com.eshop.util.platform.api.structure.shopee.dto.ShopeeAppClientDTO;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Shopee Seller SBS current inventory live integration test.
 *
 * <p>This test is opt-in because it calls the real Shopee API. Configuration can
 * be supplied through JVM properties, environment variables, or the ignored
 * {@code src/test/resources/shopee-live.properties} file.</p>
 */
class ShopeeGetCurrentInventoryIntegrationTest {

    private static final String LOCAL_CONFIG_FILE = "shopee-live.properties";
    private static final Properties LOCAL_CONFIG = loadLocalConfig();

    private static final String API_PATH = "/api/v2/sbs/get_current_inventory";
    private static final String DEFAULT_API_URL = "https://openplatform.shopee.cn";

    private static final String WAREHOUSE_REGION = "PH";
    private static final String ITEM_ID = "29176519889";
    private static final String EXPECTED_SKU_ID = "29176519889_242661935896";

    // Reference data only. get_current_inventory does not return a barcode field.
    private static final String REFERENCE_BARCODE = "BM0102038SB001";

    @Test
    void shouldGetCurrentInventoryForBagsmartGlobalStorePh() {
        Assumptions.assumeTrue(
                Boolean.parseBoolean(config("shopee.live.enabled", "SHOPEE_RUN_LIVE_TEST", "false")),
                "Set shopee.live.enabled=true in shopee-live.properties to run the live Shopee integration test"
        );

        String apiUrl = config("shopee.api-url", "SHOPEE_API_URL", DEFAULT_API_URL);
        String partnerId = requiredConfig("shopee.partner-id", "SHOPEE_PARTNER_ID");
        String partnerKey = requiredConfig("shopee.partner-key", "SHOPEE_PARTNER_KEY");
        String shopId = requiredConfig("shopee.shop-id", "SHOPEE_SHOP_ID");
        String accessToken = requiredConfig("shopee.access-token", "SHOPEE_ACCESS_TOKEN");

        ShopeeAppClientDTO appClient = appClient(apiUrl, partnerId, partnerKey, shopId, accessToken);

        Map<String, Object> requestParams = new HashMap<>();
        requestParams.put("whs_region", WAREHOUSE_REGION);
        requestParams.put("search_type", 4); // Item ID
        requestParams.put("keyword", ITEM_ID);
        requestParams.put("page_no", 1);
        requestParams.put("page_size", 100);

        String warehouseIds = config("shopee.whs-ids", "SHOPEE_WHS_IDS", null);
        if (!isBlank(warehouseIds)) {
            requestParams.put("whs_ids", warehouseIds);
        }

        ShopeeRequest request = new ShopeeRequest();
        request.setApiName(API_PATH);
        request.setMediaType(1); // GET query parameters
        request.setSecretType(2); // Shop-level authentication
        request.setMapParams(requestParams);

        suppressSensitiveHttpDebugLogs();
        ShopeeClientImpl client = new ShopeeClientImpl();
        ReflectionTestUtils.setField(client, "restTemplate", new RestTemplate());

        ShopeeResponse response = client.execute(request, appClient);
        assertNotNull(response, "Shopee response must not be null");
        assertFalse(isBlank(response.getGopResponseBody()), "Shopee response body must not be blank");

        JSONObject responseBody = JSON.parseObject(response.getGopResponseBody());
        String error = responseBody.getString("error");
        assertTrue(isBlank(error), () -> "Shopee API returned an error: " + responseBody.toJSONString());

        Path outputFile = writeResponseBody(responseBody);

        JSONObject responseData = responseBody.getJSONObject("response");
        assertNotNull(responseData, () -> "Missing response data: " + responseBody.toJSONString());

        JSONArray itemList = responseData.getJSONArray("item_list");
        assertNotNull(itemList, () -> "Missing item_list: " + responseBody.toJSONString());

        JSONObject matchedSku = findSku(itemList, EXPECTED_SKU_ID);
        assertNotNull(
                matchedSku,
                () -> "SKU " + EXPECTED_SKU_ID + " was not found. Reference barcode: "
                        + REFERENCE_BARCODE + ". Response: " + responseBody.toJSONString()
        );

        JSONArray warehouseList = matchedSku.getJSONArray("whs_list");
        assertNotNull(warehouseList, () -> "Missing whs_list for SKU: " + matchedSku.toJSONString());
        assertFalse(warehouseList.isEmpty(), () -> "No warehouse inventory returned for SKU: "
                + matchedSku.toJSONString());

        System.out.println(JSON.toJSONString(matchedSku, true));
        System.out.println("Full Shopee response JSON saved to: " + outputFile);
    }

    private static Path writeResponseBody(JSONObject responseBody) {
        String configuredPath = config(
                "shopee.inventory-output-file",
                "SHOPEE_INVENTORY_OUTPUT_FILE",
                "target/shopee-current-inventory-response.json"
        );
        Path outputFile = Paths.get(configuredPath).toAbsolutePath().normalize();
        try {
            Path parent = outputFile.getParent();
            if (parent != null) {
                Files.createDirectories(parent);
            }
            Files.write(
                    outputFile,
                    JSON.toJSONString(responseBody, true).getBytes(StandardCharsets.UTF_8)
            );
            return outputFile;
        } catch (IOException e) {
            throw new IllegalStateException("Failed to write Shopee response JSON to " + outputFile, e);
        }
    }

    private static void suppressSensitiveHttpDebugLogs() {
        setLogLevel(RestTemplate.class.getName(), Level.INFO);
        setLogLevel("org.springframework.web.client.RestTemplate", Level.INFO);
        setLogLevel("org.springframework.web.HttpLogging", Level.INFO);
    }

    private static void setLogLevel(String loggerName, Level level) {
        org.slf4j.Logger logger = LoggerFactory.getLogger(loggerName);
        if (logger instanceof Logger) {
            ((Logger) logger).setLevel(level);
        }
    }

    private static ShopeeAppClientDTO appClient(String apiUrl,
                                                 String partnerId,
                                                 String partnerKey,
                                                 String shopId,
                                                 String accessToken) {
        ShopeeAppClientDTO appClient = new ShopeeAppClientDTO() {
            @Override
            public String getUrl() {
                return apiUrl;
            }
        };
        appClient.setPartnerId(partnerId);
        appClient.setPartnerKey(partnerKey);
        appClient.setPlatformShopId(shopId);
        appClient.setAccessToken(accessToken);
        return appClient;
    }

    private static JSONObject findSku(JSONArray itemList, String expectedSkuId) {
        for (int itemIndex = 0; itemIndex < itemList.size(); itemIndex++) {
            JSONObject item = itemList.getJSONObject(itemIndex);
            JSONArray skuList = item.getJSONArray("sku_list");
            if (skuList == null) {
                continue;
            }

            for (int skuIndex = 0; skuIndex < skuList.size(); skuIndex++) {
                JSONObject sku = skuList.getJSONObject(skuIndex);
                if (expectedSkuId.equals(sku.getString("mtsku_id"))) {
                    return sku;
                }

                JSONArray shopSkuList = sku.getJSONArray("shop_sku_list");
                if (containsShopSku(shopSkuList, expectedSkuId)) {
                    return sku;
                }
            }
        }
        return null;
    }

    private static boolean containsShopSku(JSONArray shopSkuList, String expectedSkuId) {
        if (shopSkuList == null) {
            return false;
        }
        for (int index = 0; index < shopSkuList.size(); index++) {
            if (expectedSkuId.equals(shopSkuList.getJSONObject(index).getString("shop_sku_id"))) {
                return true;
            }
        }
        return false;
    }

    private static String requiredConfig(String propertyName, String environmentName) {
        String value = config(propertyName, environmentName, null);
        assertFalse(isBlank(value),
                () -> "Missing configuration: set " + environmentName + " or -D" + propertyName);
        return value;
    }

    private static String config(String propertyName, String environmentName, String defaultValue) {
        String value = System.getProperty(propertyName);
        if (isBlank(value)) {
            value = System.getenv(environmentName);
        }
        if (isBlank(value)) {
            value = LOCAL_CONFIG.getProperty(propertyName);
        }
        return isBlank(value) ? defaultValue : value.trim();
    }

    private static Properties loadLocalConfig() {
        Properties properties = new Properties();
        ClassLoader classLoader = ShopeeGetCurrentInventoryIntegrationTest.class.getClassLoader();
        try (InputStream inputStream = classLoader.getResourceAsStream(LOCAL_CONFIG_FILE)) {
            if (inputStream != null) {
                properties.load(inputStream);
            }
            return properties;
        } catch (IOException e) {
            throw new IllegalStateException("Failed to load " + LOCAL_CONFIG_FILE, e);
        }
    }

    private static boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }
}
