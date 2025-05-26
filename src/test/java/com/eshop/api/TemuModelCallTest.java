package com.eshop.api;

import com.eshop.config.limit.TemuRateLimit;
import com.eshop.entity.config.TbShop;
import com.eshop.service.config.ITbShopService;
import com.eshop.util.platform.api.client.temu.TemuApiInvoker;
import com.eshop.util.platform.api.service.product.temu.TemuModelCall;
import com.eshop.util.platform.api.service.product.temu.dto.TemuModelInfoGetReqDTO;
import com.eshop.util.platform.api.service.product.temu.vo.TemuModelInfoGetRespVO;
import com.eshop.util.platform.api.structure.temu.dto.TemuAppClientDTO;
import com.eshop.util.shop.PlatformAppClientUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@SpringBootTest
public class TemuModelCallTest {

    @Resource
    private PlatformAppClientUtils platformAppClientUtils;

    @Resource
    private ITbShopService shopService;

    @Resource
    private TemuModelCall temuModelCall;

    @Resource
    private TemuApiInvoker temuApiInvoker;

    @Test
    void modelInfoGet1() throws Exception {
        Long shopId = 2325L;
        TbShop shopDO = shopService.getById(shopId);
        String shopLocation = "CN";
        TemuAppClientDTO clientDTO = platformAppClientUtils.getTemuAppClientDTO(shopDO, shopLocation);

        TemuModelInfoGetReqDTO reqDTO = new TemuModelInfoGetReqDTO();
        reqDTO.setModelName(null);
        reqDTO.setPageNo(1);
        reqDTO.setPageSize(200);
        reqDTO.setId(2409210004037L);
        reqDTO.setModelType(0);
        TemuModelInfoGetRespVO respVO = temuModelCall.modelInfoGet(clientDTO, reqDTO);
        System.out.println(respVO.getRespBody());

        System.out.println("GG");

        // 使用示例
        String type = "bg.modelinfo.get";
        TemuModelInfoGetRespVO resp02VO = temuApiInvoker.execute(
                clientDTO,
                type,
                TemuModelInfoGetRespVO.class,
                reqDTO
        );
        System.out.println(resp02VO.getRespBody());
    }
//
//    @Resource
//    private DualRateLimitService dualRateLimitService;

    // 注入默认限流器
    @Autowired
    @Qualifier("defaultRateLimiter50")
    private TemuRateLimit defaultRateLimiter50;

    @Test
    public void executeWithSmartRetry() throws Exception {
        Long shopId = 2325L;
        TbShop shopDO = shopService.getById(shopId);
        String shopLocation = "CN";
        TemuAppClientDTO clientDTO = platformAppClientUtils.getTemuAppClientDTO(shopDO, shopLocation);

        TemuModelInfoGetReqDTO reqDTO = new TemuModelInfoGetReqDTO();
        reqDTO.setModelName(null);
        reqDTO.setPageNo(1);
        reqDTO.setPageSize(200);
        reqDTO.setId(2409210004037L);
        reqDTO.setModelType(0);
        TemuModelInfoGetRespVO respVO = temuModelCall.modelInfoGet(clientDTO, reqDTO);
        System.out.println(respVO.getRespBody());

        System.out.println("GG");

        // 使用示例
        String type = "bg.modelinfo.get";


        // 示例调用（自动处理500并发）
        List<CompletableFuture<TemuModelInfoGetRespVO>> futures = new ArrayList<>();
        for (int i = 0; i < 5000; i++) {
            futures.add(CompletableFuture.supplyAsync(() -> {
                try {
//                    return temuApiInvoker.execute(
//                            clientDTO,
//                            type,
//                            TemuModelInfoGetRespVO.class,
//                            reqDTO
//                    );

                    // 使用限流服务执行请求
                    return defaultRateLimiter50.executeWithRetry(() ->
                            {

                                TemuModelInfoGetRespVO execute = temuApiInvoker.execute(
                                        clientDTO,
                                        type,
                                        TemuModelInfoGetRespVO.class,
                                        reqDTO
                                );
                                if (Objects.nonNull(execute) && !execute.getSuccess()) {
                                    throw new RuntimeException(execute.getErrorMsg());
                                }
                                return execute;

                            }
                    );
                } catch (Exception e) {
                    return null;
                }
            }));
        }


        //阻塞等待执行完成
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).get();

        // 3. 收集结果到 List（处理可能的 null）
        List<TemuModelInfoGetRespVO> results = futures.stream()
                .map(future -> {
                    try {
                        return future.get(); // 获取每个 Future 的结果
                    } catch (InterruptedException | ExecutionException e) {
                        // 处理异常（例如记录日志）
                        System.err.println("获取结果时发生异常: " + e.getMessage());
                        return null; // 或者抛出运行时异常
                    }
                })
                .filter(Objects::nonNull) // 可选：过滤掉 null 值
                .collect(Collectors.toList());
        // 统计结果
        long successCount = 0;
        for (TemuModelInfoGetRespVO result : results) {
            System.out.println(result.getRespBody());
            successCount = result.getSuccess() == true ? successCount + 1 : successCount;
        }
        System.out.println("成功处理请求：" + successCount);
    }
}
