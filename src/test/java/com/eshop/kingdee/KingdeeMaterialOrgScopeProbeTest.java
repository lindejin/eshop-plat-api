package com.eshop.kingdee;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.kingdee.bos.webapi.entity.IdentifyInfo;
import com.kingdee.bos.webapi.sdk.K3CloudApi;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;

import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * Stage 金蝶物料组织范围只读探针。
 *
 * <p>不启动 Spring/Web/Task，不调用 Save/Allocate；仅使用 JDBC SELECT、
 * ExecuteBillQuery 和 QueryBusinessInfo。</p>
 *
 * <p>运行前将 {@code kingdee-probe.properties.example} 复制为
 * {@code kingdee-probe.properties} 并填写本地凭据，然后执行：</p>
 *
 * <pre>
 * mvn -Dtest=KingdeeMaterialOrgScopeProbeTest -Dkingdee.probe.enabled=true test
 * </pre>
 */
@EnabledIfSystemProperty(named = "kingdee.probe.enabled", matches = "true")
public class KingdeeMaterialOrgScopeProbeTest {

    private static final String DEFAULT_PRODUCT_ID = "100000306";
    private static final String CONTROL_POLICY_FORM_ID = "ORG_BASEDATACONTROLPOLICY";
    private static final String DEFAULT_CONFIG_PATH = "src/test/resources/kingdee-probe.properties";

    public static void main(String[] args) throws Exception {
        try {
            new KingdeeMaterialOrgScopeProbeTest().probeStageMaterialAndControlPolicy();
        } finally {
            com.mysql.cj.jdbc.AbandonedConnectionCleanupThread.checkedShutdown();
        }
    }

    @Test
    public void probeStageMaterialAndControlPolicy() throws Exception {
        Properties config = loadProbeProperties();
        String jdbcUrl = required(config, "spring.datasource.dashboard.url");
        String jdbcUser = required(config, "spring.datasource.dashboard.username");
        String jdbcPassword = required(config, "spring.datasource.dashboard.password");

        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword)) {
            ProductRow product = findProbeProduct(connection);
            System.out.println("PROBE_PRODUCT productId=" + product.id
                    + ", sku=" + product.sku + ", orgId=" + product.orgId);

            Map<String, String> targetOrgMapping = loadBossTargetOrgs(connection, product.orgId);
            Set<String> bossTargetOrgCodes = new LinkedHashSet<>();
            Set<String> bossTargetOrgIds = new LinkedHashSet<>();
            bossTargetOrgCodes.add("008000");
            for (Map.Entry<String, String> entry : targetOrgMapping.entrySet()) {
                System.out.println("BOSS_TARGET companyCode=" + entry.getKey()
                        + ", k3Org=" + entry.getValue());
                bossTargetOrgCodes.add(entry.getKey());
                if (notBlank(entry.getValue())) {
                    bossTargetOrgIds.add(entry.getValue());
                }
            }

            K3CloudApi api = createK3CloudApi(config);
            List<List<Object>> materialRows = queryMaterialRows(api, product.sku);
            MaterialOrgScope materialOrgScope = printMaterialRows(materialRows);
            Set<String> kingdeeActualOrgCodes = materialOrgScope.orgCodes;
            Set<String> kingdeeActualOrgIds = materialOrgScope.orgIds;

            Set<String> expectedButMissing = new LinkedHashSet<>(bossTargetOrgCodes);
            expectedButMissing.removeAll(kingdeeActualOrgCodes);
            Set<String> actualButUnexpected = new LinkedHashSet<>(kingdeeActualOrgCodes);
            actualButUnexpected.removeAll(bossTargetOrgCodes);
            System.out.println("COMPARE bossTargetOrgCodes=" + bossTargetOrgCodes);
            System.out.println("COMPARE kingdeeActualOrgCodes=" + kingdeeActualOrgCodes);
            System.out.println("COMPARE bossExpectedButKingdeeMissing=" + expectedButMissing);
            System.out.println("COMPARE kingdeeActualButBossNotSelected=" + actualButUnexpected);

            Set<String> expectedIdsButMissing = new LinkedHashSet<>(bossTargetOrgIds);
            expectedIdsButMissing.removeAll(kingdeeActualOrgIds);
            System.out.println("COMPARE bossTargetOrgIds=" + bossTargetOrgIds);
            System.out.println("COMPARE kingdeeActualOrgIds=" + kingdeeActualOrgIds);
            System.out.println("COMPARE bossExpectedIdsButKingdeeMissing=" + expectedIdsButMissing);

            JSONObject policyRequest = new JSONObject();
            policyRequest.put("FormId", CONTROL_POLICY_FORM_ID);
            String policyMetadata = api.queryBusinessInfo(policyRequest.toJSONString());
            System.out.println("POLICY_METADATA formId=" + CONTROL_POLICY_FORM_ID
                    + ", length=" + (policyMetadata == null ? 0 : policyMetadata.length()));
            System.out.println("POLICY_METADATA_PREVIEW " + abbreviate(policyMetadata, 1000));

            List<List<Object>> policyRows = queryMaterialControlPolicyRows(api);
            printControlPolicyRows(policyRows, bossTargetOrgIds);
        }
    }

    private ProductRow findProbeProduct(Connection connection) throws Exception {
        String skuOverride = System.getProperty("probe.sku");
        if (notBlank(skuOverride)) {
            ProductRow row = queryOneProduct(connection,
                    "select id, sku, org_id from dashboard.products "
                            + "where disabled_at = 0 and sku = ? order by id desc limit 1",
                    skuOverride.trim());
            if (row == null) {
                throw new IllegalStateException("Stage 不存在指定 SKU: " + skuOverride);
            }
            return row;
        }

        String productId = System.getProperty("probe.productId", DEFAULT_PRODUCT_ID);
        ProductRow row = queryOneProduct(connection,
                "select id, sku, org_id from dashboard.products where disabled_at = 0 and id = ?",
                productId);
        if (row != null) {
            return row;
        }

        System.out.println("PROBE_NOTICE productId=" + productId
                + " 不存在，改取 Stage 最近一条已同步金蝶的物料");
        row = queryOneProduct(connection,
                "select id, sku, org_id from dashboard.products "
                        + "where disabled_at = 0 and kingdee_sku_id is not null "
                        + "order by id desc limit 1");
        if (row == null) {
            throw new IllegalStateException("Stage 未找到可用的已同步金蝶物料");
        }
        return row;
    }

    private ProductRow queryOneProduct(Connection connection, String sql, Object... params) throws Exception {
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            for (int i = 0; i < params.length; i++) {
                statement.setObject(i + 1, params[i]);
            }
            try (ResultSet result = statement.executeQuery()) {
                if (!result.next()) {
                    return null;
                }
                return new ProductRow(result.getInt("id"), result.getString("sku"), result.getInt("org_id"));
            }
        }
    }

    /** 完全复刻 KingdeeDockingServiceImpl 当前的全主体取值和 contains 映射规则。 */
    private Map<String, String> loadBossTargetOrgs(Connection connection, Integer orgId) throws Exception {
        List<String> companyCodes = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(
                "select company_code from erp.purchaser "
                        + "where organization_id = ? and disabled_by = 0 order by created_at desc")) {
            statement.setInt(1, orgId);
            try (ResultSet result = statement.executeQuery()) {
                while (result.next()) {
                    String code = result.getString("company_code");
                    if (notBlank(code) && !"008000".equals(code)) {
                        companyCodes.add(code);
                    }
                }
            }
        }

        List<DictRow> dictRows = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(
                "select dict_label, dict_value from erp.sys_dict_data "
                        + "where status = '0' and dict_type = 'k3_org' order by dict_sort asc")) {
            try (ResultSet result = statement.executeQuery()) {
                while (result.next()) {
                    dictRows.add(new DictRow(result.getString("dict_label"), result.getString("dict_value")));
                }
            }
        }

        Map<String, String> mapping = new LinkedHashMap<>();
        for (String companyCode : companyCodes) {
            String matched = null;
            for (DictRow dict : dictRows) {
                if (notBlank(dict.label) && dict.label.contains(companyCode)) {
                    matched = dict.value;
                    break;
                }
            }
            mapping.put(companyCode, matched);
        }
        return mapping;
    }

    private List<List<Object>> queryMaterialRows(K3CloudApi api, String materialCode) throws Exception {
        JSONObject body = new JSONObject();
        body.put("FormId", "BD_MATERIAL");
        body.put("FieldKeys", "FMaterialId,FMasterId,FNumber,FName,FSpecification,"
                + "FUseOrgId,FUseOrgId.FNumber,FUseOrgId.FName,FDocumentStatus,FForbidStatus");
        body.put("FilterString", "FNumber='" + materialCode.replace("'", "''") + "'");
        body.put("TopRowCount", 500);
        List<List<Object>> rows = api.executeBillQuery(JSON.toJSONString(body));
        return rows == null ? Collections.emptyList() : rows;
    }

    private List<List<Object>> queryMaterialControlPolicyRows(K3CloudApi api) throws Exception {
        JSONObject body = new JSONObject();
        body.put("FormId", CONTROL_POLICY_FORM_ID);
        body.put("FieldKeys", "FPolicyID,FBillNo,FBaseDataTypeId,FBaseDataTypeId.FNumber,"
                + "FBaseDataTypeId.FName,FCreateOrgId,FCreateOrgId.FNumber,FCreateOrgId.FName,"
                + "FTargetOrgId,FTargetOrgId.FNumber,FTargetOrgId.FName,FIsForbidden,FDontSyncAllocate");
        body.put("FilterString", "FBaseDataTypeId.FNumber='BD_MATERIAL'");
        body.put("TopRowCount", 500);
        List<List<Object>> rows = api.executeBillQuery(JSON.toJSONString(body));
        return rows == null ? Collections.emptyList() : rows;
    }

    private void printControlPolicyRows(List<List<Object>> rows, Set<String> bossTargetOrgIds) {
        Set<String> policyTargetOrgIds = new LinkedHashSet<>();
        System.out.println("POLICY_MATERIAL rowCount=" + rows.size());
        for (List<Object> row : rows) {
            if (row.size() < 13) {
                System.out.println("POLICY_MATERIAL malformedRow=" + row);
                continue;
            }
            String targetOrgId = String.valueOf(row.get(8));
            policyTargetOrgIds.add(targetOrgId);
            System.out.println("POLICY_MATERIAL policyId=" + row.get(0)
                    + ", billNo=" + row.get(1)
                    + ", baseData=" + row.get(3)
                    + ", createOrg=" + row.get(6)
                    + ", targetOrgId=" + targetOrgId
                    + ", targetOrg=" + row.get(9)
                    + ", syncDisabled=" + row.get(11)
                    + ", doNotSync=" + row.get(12));
        }
        Set<String> bossOutsidePolicy = new LinkedHashSet<>(bossTargetOrgIds);
        bossOutsidePolicy.removeAll(policyTargetOrgIds);
        System.out.println("COMPARE policyTargetOrgIds=" + policyTargetOrgIds);
        System.out.println("COMPARE bossTargetIdsOutsidePolicy=" + bossOutsidePolicy);
    }

    private MaterialOrgScope printMaterialRows(List<List<Object>> rows) {
        Set<String> orgIds = new LinkedHashSet<>();
        Set<String> orgCodes = new LinkedHashSet<>();
        for (List<Object> row : rows) {
            if (row.size() < 10) {
                System.out.println("KINGDEE_MATERIAL malformedRow=" + row);
                continue;
            }
            String orgId = String.valueOf(row.get(5));
            String orgCode = String.valueOf(row.get(6));
            orgIds.add(orgId);
            orgCodes.add(orgCode);
            System.out.println("KINGDEE_MATERIAL materialId=" + row.get(0)
                    + ", masterId=" + row.get(1)
                    + ", number=" + row.get(2)
                    + ", useOrgId=" + orgId
                    + ", useOrg=" + orgCode
                    + ", useOrgName=" + row.get(7)
                    + ", documentStatus=" + row.get(8)
                    + ", forbidStatus=" + row.get(9));
        }
        return new MaterialOrgScope(orgIds, orgCodes);
    }

    private K3CloudApi createK3CloudApi(Properties config) {
        IdentifyInfo identifyInfo = new IdentifyInfo()
                .setdCID(required(config, "X-KDApi-AcctID"))
                .setAppId(required(config, "X-KDApi-AppID"))
                .setAppSecret(required(config, "X-KDApi-AppSec"))
                .setUserName(required(config, "X-KDApi-UserName"))
                .setlCID(Integer.parseInt(required(config, "X-KDApi-LCID")))
                .setServerUrl(required(config, "X-KDApi-ServerUrl"));
        return new K3CloudApi(identifyInfo);
    }

    private Properties loadProbeProperties() throws Exception {
        Path file = Paths.get(System.getProperty("kingdee.probe.config", DEFAULT_CONFIG_PATH))
                .toAbsolutePath().normalize();
        if (!Files.exists(file)) {
            throw new IllegalStateException("找不到探针配置: " + file
                    + "；请复制 kingdee-probe.properties.example 后填写本地凭据");
        }
        Properties properties = new Properties();
        try (Reader reader = Files.newBufferedReader(file, StandardCharsets.UTF_8)) {
            properties.load(reader);
        }
        return properties;
    }

    private String required(Properties properties, String key) {
        String value = properties.getProperty(key);
        if (!notBlank(value)) {
            throw new IllegalStateException("探针配置缺失: " + key);
        }
        return value.trim();
    }

    private boolean notBlank(String value) {
        return value != null && !value.trim().isEmpty();
    }

    private String abbreviate(String value, int maxLength) {
        if (value == null || value.length() <= maxLength) {
            return value;
        }
        return value.substring(0, maxLength) + "...<truncated>";
    }

    private static class ProductRow {
        private final Integer id;
        private final String sku;
        private final Integer orgId;

        private ProductRow(Integer id, String sku, Integer orgId) {
            this.id = id;
            this.sku = sku;
            this.orgId = orgId;
        }
    }

    private static class DictRow {
        private final String label;
        private final String value;

        private DictRow(String label, String value) {
            this.label = label;
            this.value = value;
        }
    }

    private static class MaterialOrgScope {
        private final Set<String> orgIds;
        private final Set<String> orgCodes;

        private MaterialOrgScope(Set<String> orgIds, Set<String> orgCodes) {
            this.orgIds = orgIds;
            this.orgCodes = orgCodes;
        }
    }
}
