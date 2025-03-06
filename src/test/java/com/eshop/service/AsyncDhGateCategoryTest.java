package com.eshop.service;

import com.alibaba.fastjson.JSON;
import com.eshop.util.platform.api.structure.dhgate.dto.DhAppClientDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.*;

@SpringBootTest
public class AsyncDhGateCategoryTest {

    @Resource
    private DhGateCategoryCallServiceImpl dhGateCategoryCallService;

    private final ExecutorService executorService = Executors.newFixedThreadPool(10);
    private static final String JSON_FILE_PATH = "dhgate_categories_async.json";
    private final BlockingQueue<String> categoryQueue = new LinkedBlockingQueue<>();
    private volatile boolean isProducerFinished = false;
    private final Object fileLock = new Object();

    /**
     * 使用生产者-消费者模式异步获取所有菜单并保存为JSON文件
     */
    @Test
    void getAllCategoriesAsyncAndSaveToJsonAppend() throws Exception {
        // 清空文件内容
        clearJsonFile();

        DhAppClientDTO dcDTO = getDcDTO();

        // 获取根节点并保存
        List<DhCategoryListCatePubVO> rootCategories = getRoot(dcDTO);
        if (rootCategories != null) {
            appendCategoriesToJsonFile(rootCategories);

            // 启动消费者线程
            int numConsumers = 5;
            CountDownLatch consumerLatch = new CountDownLatch(numConsumers);
            for (int i = 0; i < numConsumers; i++) {
                executorService.submit(new CategoryConsumer(dcDTO, consumerLatch));
            }

            // 生产者：将非叶子类目ID加入队列
            rootCategories.stream()
                    .filter(category -> "0".equals(category.getLeaf()))
                    .forEach(category -> {
                        try {
                            categoryQueue.put(category.getCatePubId());
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    });

            // 标记生产者完成
            isProducerFinished = true;

            // 等待所有消费者完成
            consumerLatch.await();
            executorService.shutdown();
        }

        Thread.sleep(100000);
    }

    /**
     * 消费者线程类
     */
    private class CategoryConsumer implements Runnable {
        private final DhAppClientDTO dcDTO;
        private final CountDownLatch latch;

        public CategoryConsumer(DhAppClientDTO dcDTO, CountDownLatch latch) {
            this.dcDTO = dcDTO;
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                while (!isProducerFinished || !categoryQueue.isEmpty()) {
                    String categoryId = categoryQueue.poll(100, TimeUnit.MILLISECONDS);
                    if (categoryId != null) {
                        processCategory(categoryId);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                latch.countDown();
            }
        }

        private void processCategory(String categoryId) throws Exception {
            List<DhCategoryListCatePubVO> childCategories = getPub(dcDTO, categoryId);
            if (childCategories != null) {
                // 同步写入文件
                synchronized (fileLock) {
                    appendCategoriesToJsonFile(childCategories);
                }

                // 将所有子类目ID加入队列，不论是否为叶子节点
                childCategories.forEach(category -> {
                    try {
                        if ("0".equals(category.getLeaf())) {
                            categoryQueue.put(category.getCatePubId());
                        }
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                });
            }
        }
    }

    private void clearJsonFile() {
        try (FileWriter writer = new FileWriter(JSON_FILE_PATH)) {
            writer.write("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void appendCategoriesToJsonFile(List<DhCategoryListCatePubVO> categories) {
        if (categories == null || categories.isEmpty()) {
            return;
        }

        String jsonResult = JSON.toJSONString(categories, true);
        try (FileWriter writer = new FileWriter(JSON_FILE_PATH, true)) {
            File file = new File(JSON_FILE_PATH);
            if (file.length() > 0) {
                writer.write(",\n");
            }
            writer.write(jsonResult);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<DhCategoryListCatePubVO> getRoot(DhAppClientDTO dcDTO) throws Exception {
        DhCategoryListDTO reqDTO = new DhCategoryListDTO();
        reqDTO.setParentId(null);
        DhCategoryListVO respVO = dhGateCategoryCallService.getCategoryList(dcDTO, reqDTO);

        if (respVO == null) {
            return null;
        }
        return respVO.getCatePubList();
    }

    private List<DhCategoryListCatePubVO> getPub(DhAppClientDTO dcDTO, String parentId) throws Exception {
        DhCategoryListDTO reqDTO = new DhCategoryListDTO();
        reqDTO.setParentId(parentId);
        DhCategoryListVO respVO = dhGateCategoryCallService.getCategoryList(dcDTO, reqDTO);

        if (respVO == null) {
            return null;
        }
        return respVO.getCatePubList();
    }

    private DhAppClientDTO getDcDTO() {
        String appKey = "QrStYilYajlkjzTjd6Uy";
        String appSecret = "Xj1ZCz51a38FrOl1WpuyVtPjtbHd9rNR";
        String accessToken = "3bHAyDUe2jyuJRwbmGbBhf7hKvWySuEe05OOPYuR";

        DhAppClientDTO reqDTO = new DhAppClientDTO();
        reqDTO.setAppKey(appKey);
        reqDTO.setAppSecret(appSecret);
        reqDTO.setAccessToken(accessToken);
        return reqDTO;
    }
}