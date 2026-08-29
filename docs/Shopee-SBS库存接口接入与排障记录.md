# Shopee SBS 库存接口接入与排障记录

## 1. 最终目标

调用 Shopee Open Platform 的 Seller SBS 当前库存接口：

```text
GET /api/v2/sbs/get_current_inventory
```

本次验证使用的数据：

- 店铺：`BAGSMART Global Store`，站点 `PH`
- `shop_id`：`1274006847`
- 目标 MTSKU：`29176519889_242661935896`
- 参考条码：`BM0102038SB001`
- 官方文档：<https://open.shopee.com/documents/v2/v2.sbs.get_current_inventory?module=124&type=1>

最终结果：接口调用成功，能够在 IDEA 中直接运行测试、输出目标 SKU，并将完整响应保存为 JSON 文件。

## 2. 最终代码和文件

### 2.1 当前库存测试

文件：

```text
src/test/java/com/eshop/util/platform/api/service/sbs/shopee/
ShopeeGetCurrentInventoryIntegrationTest.java
```

功能：

1. 从本地配置读取 Shopee 应用和店铺授权信息。
2. 使用店铺级签名调用 `get_current_inventory`。
3. 按 Item ID `29176519889` 查询。
4. 根据 `mtsku_id` 或 `shop_sku_id` 查找目标 SKU。
5. 校验返回结果包含仓库库存列表。
6. 在控制台打印目标 SKU JSON。
7. 将完整接口响应写入：

```text
target/shopee-current-inventory-response.json
```

### 2.2 Token 刷新测试

文件：

```text
src/test/java/com/eshop/util/platform/api/service/auth/shopee/
ShopeeRefreshTokenIntegrationTest.java
```

功能：

1. 使用 `refresh_token` 调用 Shopee Token 刷新接口。
2. 刷新成功后，将新的 `access_token` 和 `refresh_token` 自动写回本地配置。
3. 自动把 `shopee.refresh.enabled` 恢复为 `false`，避免运行全部测试时重复刷新。
4. 不在控制台打印 Token 内容。

### 2.3 本地配置

文件：

```text
src/test/resources/shopee-live.properties
```

该文件已经加入 `.gitignore`，不会被提交。配置项包括：

```properties
shopee.live.enabled=true
shopee.refresh.enabled=false
shopee.partner-id=应用Partner ID
shopee.partner-key=应用Partner Key
shopee.shop-id=店铺ID
shopee.access-token=当前Access Token
shopee.refresh-token=当前Refresh Token
shopee.api-url=https://openplatform.shopee.cn
shopee.whs-ids=店铺绑定的仓库ID列表
```

## 3. IDEA 使用方法

### 3.1 查询当前库存

直接运行：

```text
ShopeeGetCurrentInventoryIntegrationTest
  -> shouldGetCurrentInventoryForBagsmartGlobalStorePh()
```

运行成功后：

- 控制台打印目标 SKU。
- 完整响应写入 `target/shopee-current-inventory-response.json`。
- 每次运行都会覆盖上一次的 JSON 文件。

如需修改输出位置，可在本地配置中添加：

```properties
shopee.inventory-output-file=自定义JSON文件路径
```

### 3.2 刷新 Token

把本地配置中的开关改为：

```properties
shopee.refresh.enabled=true
```

然后运行：

```text
ShopeeRefreshTokenIntegrationTest
  -> shouldRefreshShopTokenAndUpdateLocalConfig()
```

成功后，测试会自动保存 Shopee 返回的新 Token，并把刷新开关改回 `false`。

切换店铺时，需要同时更换：

- 新店铺对应的 `shop_id`
- 新店铺对应的 `refresh_token`

`access_token` 可以通过刷新测试生成，不需要手工维护。

## 4. 排障过程

### 4.1 测试被跳过：`TestAbortedException`

错误：

```text
Assumption failed: Set SHOPEE_RUN_LIVE_TEST=true to run the live Shopee integration test
```

原因：最初为了防止测试误调用真实接口，测试要求通过环境变量显式开启。命令行中临时设置的环境变量不会自动进入 IDEA 的运行配置，因此 IDEA 执行时测试被跳过。

解决：

- 新增本地 `shopee-live.properties`。
- 测试支持从 JVM 参数、环境变量、本地配置文件依次读取配置。
- 本地文件中设置 `shopee.live.enabled=true` 后，可直接从 IDEA 运行。
- 将本地配置加入 `.gitignore`，防止提交凭证。

### 4.2 请求被 IP 白名单拦截

错误：

```text
source_ip_undeclared
```

Shopee 返回的未声明公网 IP 为：

```text
27.154.199.18
```

原因：应用启用了来源 IP 校验，而当前调用机器的公网 IP 未加入 Shopee Open Platform 应用白名单。

解决：用户在 Shopee Open Platform 的应用 IP Address Whitelist 中添加该 IP。再次请求后，`source_ip_undeclared` 消失，证明白名单生效。

### 4.3 Access Token 无效

错误：

```text
invalid_acceess_token
Invalid access_token, please have a check.
```

原因：旧 `access_token` 已失效，或者不再匹配当前应用与店铺授权。

期间还出现过一次“已经修改 Token，但运行后仍然无效”的情况。检查发现：

- Maven 实际读取的是 `src/test/resources/shopee-live.properties`。
- `target/test-classes/shopee-live.properties` 只是构建生成的副本。
- 如果只修改 `target` 下的副本，下次构建会被源配置重新覆盖。

解决：

1. 始终修改 `src/test/resources/shopee-live.properties`。
2. 新增 Token 刷新测试。
3. 使用用户提供的 `refresh_token` 和 `shop_id` 刷新授权。
4. 刷新成功后，自动写回新 `access_token` 和新 `refresh_token`。

### 4.4 库存接口返回 `invalid cid`

错误：

```text
500 Internal Server Error
block by gateway due to invalid cid
```

这一步最容易被误判为“没有 SBS 接口权限”。最终通过对照实验确认，它不是权限问题，而是 HTTP 请求方法错误。

诊断顺序：

1. 使用同一 Token 调用基础店铺信息接口，成功返回：
   - 店铺：`BAGSMART Global Store`
   - 地区：`PH`
   - 状态：`NORMAL`
2. 调用 SBS 的 `get_bound_whs_info`，成功返回该店铺绑定的 PH 仓库列表。
3. 因此可以排除以下问题：
   - Token 无效
   - `shop_id` 错误
   - 签名算法错误
   - 整个 SBS 模块没有权限
4. `get_current_inventory` 使用 POST 时始终返回 `invalid cid`。
5. 增加有效 `whs_ids` 后继续使用 POST，仍然返回相同错误，排除了缺少仓库参数。
6. 保持相同 Token、签名、店铺和业务参数，仅把请求方式改成 GET，接口立即成功并返回 1 条库存记录。

最终修改：

```java
request.setMediaType(1); // GET
request.setSecretType(2); // 店铺级认证
request.setMapParams(requestParams);
```

不再使用：

```java
request.setMediaType(2); // POST JSON
request.setJsonParams(requestBody);
```

`invalid cid` 是 POST 请求进入错误网关路由后产生的提示，不是需要用户额外提供一个名为 `cid` 的参数。

### 4.5 仓库参数

通过以下接口获取该店铺绑定的仓库：

```text
GET /api/v2/sbs/get_bound_whs_info
```

本次返回的 PH 仓库 ID 被写入本地配置的 `shopee.whs-ids`。库存查询通过查询参数携带该列表。

### 4.6 SKU 匹配

用户提供的仓库 SKU ID：

```text
29176519889_242661935896
```

实际响应中它位于：

```json
{
  "mtsku_id": "29176519889_242661935896"
}
```

响应中的 `shop_sku_id` 是另一个店铺维度的 ID。因此测试同时检查：

- `sku.mtsku_id`
- `sku.shop_sku_list[*].shop_sku_id`

只要其中一个匹配目标值，就认为找到了目标 SKU。

用户提供的条码 `BM0102038SB001` 仅作为人工核对信息。该接口响应没有条码字段，不能直接通过响应条码断言。

### 4.7 响应写入 JSON

最初测试只在控制台打印匹配到的 SKU。根据用户要求，后来增加完整 `responseBody` 文件输出：

```text
target/shopee-current-inventory-response.json
```

写文件前会先将响应解析为 JSON 并格式化，便于在 IDEA 中查看。`target` 已被 Git 忽略，因此接口数据不会进入版本库。

## 5. 最终实测结果

目标 MTSKU：

```text
29176519889_242661935896
```

其中 `PHBUL4` 仓库在本次验证时返回：

| 字段 | 值 |
| --- | ---: |
| `sellable_qty` | 38 |
| `reserved_qty` | 10 |
| `in_transit_pending_putaway_qty` | 60 |

库存会随业务变化，上述数字只用于证明当时接口调用和字段解析成功，不能作为固定测试期望值。

## 6. 本次问题由谁解决

这是一次协作完成的接入，不是单独一方完成。

### 用户提供和完成的内容

- 明确了需要调用的 Shopee 官方接口和业务目标。
- 提供店铺名称、站点、仓库 SKU ID 和参考条码。
- 提供应用授权数据、店铺 Token 和 API 域名。
- 根据 Shopee 返回信息，将公网 IP 加入应用白名单。
- 提供有效的 `refresh_token` 和 `shop_id`。
- 再次提供官方接口文档链接，推动重新核对调用方式。
- 提出 IDEA 直接运行、本地配置、自动刷新 Token、响应写入 JSON 等实际使用要求。

### 助手研究和完成的内容

- 检查项目已有 Shopee Client、签名逻辑、认证类型和 Token 刷新实现。
- 编写当前库存真实集成测试。
- 编写 Token 刷新测试，并实现新 Token 安全回写和一次性刷新开关。
- 设计本地配置优先级，并将凭证文件加入 `.gitignore`。
- 关闭可能输出 Token 的 Spring HTTP 调试日志。
- 对每个 Shopee 错误进行真实请求验证，而不是只根据错误名称猜测。
- 通过店铺信息、绑定仓库、POST 库存、GET 库存四组对照请求，最终定位 HTTP 方法错误。
- 将库存测试从 POST JSON 改为 GET 查询参数。
- 获取并配置店铺绑定的 PH 仓库列表。
- 验证目标 MTSKU、仓库库存字段和完整响应。
- 实现完整响应 JSON 文件输出。

### 最关键结论的来源

`invalid cid` 的最终解决方案不是用户直接给出的答案，也不是仅靠文档页面得出的结论。用户提供了官方文档入口；助手在自动读取该页面受限的情况下，通过真实接口对照实验确认：POST 失败、GET 成功，最终定位并修复请求方法。

## 7. 安全注意事项

1. 不要提交 `src/test/resources/shopee-live.properties`。
2. 不要提交 `target/shopee-current-inventory-response.json`。
3. 不要在测试日志中打印 `partner_key`、`access_token` 或 `refresh_token`。
4. `refresh_token` 刷新成功后会轮换，应始终保存接口最新返回的值。
5. Token 曾经出现在会话或控制台时，建议完成验证后再次刷新或重新授权。
6. 公网 IP 发生变化后，需要同步更新 Shopee 应用的 IP 白名单。
