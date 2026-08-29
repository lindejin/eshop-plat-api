package com.eshop.util.platform.api.service.auth.shopee;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.eshop.util.platform.api.client.shopee.ShopeeClientImpl;
import com.eshop.util.platform.api.service.auth.shopee.dto.ShopeeTokenRefreshDTO;
import com.eshop.util.platform.api.structure.shopee.dto.ShopeeAppClientDTO;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.AtomicMoveNotSupportedException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Refreshes a Shopee shop token and writes the rotated tokens back to the
 * ignored local live-test configuration file.
 */
class ShopeeRefreshTokenIntegrationTest {

    private static final String LOCAL_CONFIG_FILE = "shopee-live.properties";
    private static final Path LOCAL_CONFIG_PATH = Paths.get(
            "src", "test", "resources", LOCAL_CONFIG_FILE
    ).toAbsolutePath().normalize();
    private static final Properties LOCAL_CONFIG = loadLocalConfig();
    private static final String DEFAULT_API_URL = "https://openplatform.shopee.cn";

    @Test
    void shouldRefreshShopTokenAndUpdateLocalConfig() throws Exception {
        Assumptions.assumeTrue(
                Boolean.parseBoolean(config("shopee.refresh.enabled", "SHOPEE_RUN_TOKEN_REFRESH", "false")),
                "Set shopee.refresh.enabled=true in shopee-live.properties to refresh the token"
        );

        String apiUrl = config("shopee.api-url", "SHOPEE_API_URL", DEFAULT_API_URL);
        String partnerId = requiredConfig("shopee.partner-id", "SHOPEE_PARTNER_ID");
        String partnerKey = requiredConfig("shopee.partner-key", "SHOPEE_PARTNER_KEY");
        String shopId = requiredConfig("shopee.shop-id", "SHOPEE_SHOP_ID");
        String refreshToken = requiredConfig("shopee.refresh-token", "SHOPEE_REFRESH_TOKEN");

        suppressSensitiveHttpDebugLogs();

        ShopeeClientImpl client = new ShopeeClientImpl();
        ReflectionTestUtils.setField(client, "restTemplate", new RestTemplate());

        ShopeeAuthCallServiceImpl authService = new ShopeeAuthCallServiceImpl();
        ReflectionTestUtils.setField(authService, "shopeeClient", client);

        ShopeeTokenRefreshDTO request = new ShopeeTokenRefreshDTO();
        request.setRefreshToken(refreshToken);
        request.setShopId(shopId);

        String responseText = authService.tokenRefresh(
                appClient(apiUrl, partnerId, partnerKey), request
        );
        JSONObject response = JSON.parseObject(responseText);
        String error = response.getString("error");
        assertTrue(isBlank(error), () -> tokenErrorMessage(response));

        String newAccessToken = response.getString("access_token");
        String newRefreshToken = response.getString("refresh_token");
        assertFalse(isBlank(newAccessToken), "Shopee response is missing access_token");
        assertFalse(isBlank(newRefreshToken), "Shopee response is missing refresh_token");

        updateLocalConfig(shopId, newAccessToken, newRefreshToken);

        System.out.println("Shopee token refresh succeeded for shop_id=" + shopId
                + "; the rotated tokens were saved to " + LOCAL_CONFIG_PATH
                + "; shopee.refresh.enabled was reset to false.");
    }

    private static ShopeeAppClientDTO appClient(String apiUrl, String partnerId, String partnerKey) {
        ShopeeAppClientDTO appClient = new ShopeeAppClientDTO() {
            @Override
            public String getUrl() {
                return apiUrl;
            }
        };
        appClient.setPartnerId(partnerId);
        appClient.setPartnerKey(partnerKey);
        return appClient;
    }

    private static void updateLocalConfig(String shopId,
                                          String accessToken,
                                          String refreshToken) throws IOException {
        assertTrue(Files.isRegularFile(LOCAL_CONFIG_PATH),
                () -> "Local configuration file not found: " + LOCAL_CONFIG_PATH);

        Properties properties = new Properties();
        try (InputStream inputStream = Files.newInputStream(LOCAL_CONFIG_PATH)) {
            properties.load(inputStream);
        }
        properties.setProperty("shopee.shop-id", shopId);
        properties.setProperty("shopee.access-token", accessToken);
        properties.setProperty("shopee.refresh-token", refreshToken);
        properties.setProperty("shopee.refresh.enabled", "false");

        Path temporaryFile = Files.createTempFile(
                LOCAL_CONFIG_PATH.getParent(), "shopee-live-", ".properties.tmp"
        );
        try {
            try (OutputStream outputStream = Files.newOutputStream(temporaryFile)) {
                properties.store(outputStream, "Local Shopee live-test credentials; do not commit");
            }
            replaceConfigFile(temporaryFile);
        } finally {
            Files.deleteIfExists(temporaryFile);
        }
    }

    private static void replaceConfigFile(Path temporaryFile) throws IOException {
        try {
            Files.move(
                    temporaryFile,
                    LOCAL_CONFIG_PATH,
                    StandardCopyOption.ATOMIC_MOVE,
                    StandardCopyOption.REPLACE_EXISTING
            );
        } catch (AtomicMoveNotSupportedException ignored) {
            Files.move(temporaryFile, LOCAL_CONFIG_PATH, StandardCopyOption.REPLACE_EXISTING);
        }
    }

    private static String tokenErrorMessage(JSONObject response) {
        return "Shopee token refresh failed: error=" + response.getString("error")
                + ", message=" + response.getString("message")
                + ", request_id=" + response.getString("request_id");
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

    private static String requiredConfig(String propertyName, String environmentName) {
        String value = config(propertyName, environmentName, null);
        assertFalse(isBlank(value),
                () -> "Missing configuration: set " + environmentName + " or " + propertyName);
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
        ClassLoader classLoader = ShopeeRefreshTokenIntegrationTest.class.getClassLoader();
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
