package com.eshop.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.eshop.entity.product.DhCategory;
import com.eshop.service.product.IDhCategoryService;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@SpringBootTest
public class ReadDhGateCategoryTest {

    private static final String JSON_FILE_PATH = "dhgate_categories_async.json";

    @Test
    void readAndPrintCategories() {
        try {
            // 读取JSON文件内容
            String jsonContent = new String(Files.readAllBytes(Paths.get(JSON_FILE_PATH)));

            // 由于文件内容是多个JSON数组拼接而成，需要将其包装成一个完整的JSON数组
            jsonContent = "[" + jsonContent + "]";

            // 解析JSON为List对象
            List<List<DhCategoryListCatePubVO>> categoryLists = JSON.parseObject(
                    jsonContent,
                    new TypeReference<List<List<DhCategoryListCatePubVO>>>() {
                    }
            );

            // 打印类目信息
            System.out.println("=== 开始输出类目信息 ===");
            int totalCategories = 0;

            for (List<DhCategoryListCatePubVO> categoryList : categoryLists) {
                for (DhCategoryListCatePubVO category : categoryList) {

                    totalCategories++;

                    if ("019".equals(category.getPareCatePubId())) {
                        System.out.printf("类目ID: %s, 类目名称: %s, 是否叶子节点: %s%n",
                                category.getCatePubId(),
                                category.getPubNameCn(),
                                "0".equals(category.getLeaf()) ? "否" : "是"
                        );
                    }
                }
            }

            System.out.println("=== 类目信息输出完成 ===");
            System.out.println("总类目数量: " + totalCategories);

        } catch (IOException e) {
            System.err.println("读取JSON文件失败：" + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("解析JSON数据失败：" + e.getMessage());
            e.printStackTrace();
        }
    }

    @Autowired
    private IDhCategoryService iDhCategoryService;

    private List<DhCategory> getAllDhCategoryList() throws Exception {
        return iDhCategoryService.list();
    }


    @Test
    void compareCategoryDifferences() {
        try {
            // 获取服务中的类目数据
            List<DhCategory> serviceCategories = getAllDhCategoryList();

            // 读取JSON文件内容
            String jsonContent = new String(Files.readAllBytes(Paths.get(JSON_FILE_PATH)));
            jsonContent = "[" + jsonContent + "]";

            // 解析JSON为List对象
            List<List<DhCategoryListCatePubVO>> categoryLists = JSON.parseObject(
                    jsonContent,
                    new TypeReference<List<List<DhCategoryListCatePubVO>>>() {
                    }
            );

            // 创建两个Set来存储CatePubId，方便比较
            Set<String> serviceCatePubIds = serviceCategories.stream()
                    .map(DhCategory::getCatePubId)
                    .collect(Collectors.toSet());

            Set<String> jsonCatePubIds = new HashSet<>();
            for (List<DhCategoryListCatePubVO> categoryList : categoryLists) {
                for (DhCategoryListCatePubVO category : categoryList) {
                    jsonCatePubIds.add(category.getCatePubId());
                }
            }

            // 找出在JSON中存在但在服务数据中不存在的类目
            System.out.println("=== 开始输出新增类目信息 ===");
            int newCategories = 0;

            List<DhCategory> addList = new ArrayList<>();
            for (List<DhCategoryListCatePubVO> categoryList : categoryLists) {
                for (DhCategoryListCatePubVO category : categoryList) {
                    if (!serviceCatePubIds.contains(category.getCatePubId())) {
                        newCategories++;
                        System.out.printf("新增类目 - 类目ID: %s, 父类目ID: %s, 类目名称: %s, 是否叶子节点: %s%n",
                                category.getCatePubId(),
                                category.getPareCatePubId(),
                                category.getPubNameCn(),
                                "0".equals(category.getLeaf()) ? "否" : "是"
                        );

                        DhCategory add = new DhCategory();
                        add.setCatePubId(category.getCatePubId());
                        add.setPareCatePubId(category.getPareCatePubId());
                        add.setPubName(category.getPubName());
                        add.setPubNameCn(category.getPubNameCn());
                        add.setLeaf(category.getLeaf());
                        add.setValid("1");
                        add.setLevel(getLevel(category.getCatePubId()));
                        addList.add(add);
                    }
                }
            }
            if (CollectionUtils.isNotEmpty(addList)) {
                iDhCategoryService.saveBatch(addList);
            }

            System.out.println("=== 新增类目信息输出完成 ===");
            System.out.println("新增类目数量: " + newCategories);

        } catch (Exception e) {
            System.err.println("比较类目数据失败：" + e.getMessage());
            e.printStackTrace();
        }
    }

    private Byte getLevel(String catePubId) {
        //例子
        // 三位 210 一级
        // 六位 210210 二级
        // 六位 210210210 三级 

        if (catePubId == null) {
            return null;
        }

        int length = catePubId.length();

        // 根据类目ID的长度判断层级
        switch (length) {
            case 3:  // 一级类目
                return 1;
            case 6:  // 二级类目
                return 2;
            case 9:  // 三级类目
                return 3;
            case 12:  // 三级类目
                return 4;
            case 15:  // 四级类目
                return 5;
            case 18:  // 五级类目
                return 6;
            default:
                return null;
        }
    }
}