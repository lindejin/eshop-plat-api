package com.eshop.service;

import com.alibaba.fastjson.JSON;
import com.eshop.util.platform.api.structure.dhgate.dto.DhAppClientDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class DhGateCategoryCallServiceImplTest {

    @Resource
    private DhGateCategoryCallServiceImpl dhGateCategoryCallService;

    /**
     * 获取所有菜单并保存为JSON文件
     */
    @Test
    void getAllCategoriesAndSaveToJson() throws Exception {
        DhAppClientDTO dcDTO = getDcDTO();
        List<DhCategoryListCatePubVO> allCategories = new ArrayList<>();
        
        // 获取根节点
        List<DhCategoryListCatePubVO> rootCategories = getRoot(dcDTO);
        if (rootCategories != null) {
            for (DhCategoryListCatePubVO category : rootCategories) {
                allCategories.add(category);
                // 递归获取子节点
                getAllChildCategories(dcDTO, category.getCatePubId(), allCategories);
            }
        }

        // 将结果保存为JSON文件
        String jsonResult = JSON.toJSONString(allCategories, true);
        try (FileWriter writer = new FileWriter("dhgate_categories.json")) {
            writer.write(jsonResult);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 递归获取所有子类目
     */
    private void getAllChildCategories(DhAppClientDTO dcDTO, String parentCategoryId, List<DhCategoryListCatePubVO> allCategories) throws Exception {
        List<DhCategoryListCatePubVO> childCategories = getPub(dcDTO, parentCategoryId);
        if (childCategories != null) {
            for (DhCategoryListCatePubVO category : childCategories) {
                allCategories.add(category);
                getAllChildCategories(dcDTO, category.getCatePubId(), allCategories);
            }
        }
    }

    /**
     * 指定店铺id 获取temu店铺物流商
     */
    @Test
    void getModeList() throws Exception {
        DhAppClientDTO dcDTO = getDcDTO();
        List<DhCategoryListCatePubVO> root = getRoot(dcDTO);
    }

    /**
     * 菜单根子节点
     */
    private List<DhCategoryListCatePubVO> getRoot(DhAppClientDTO dcDTO) throws Exception {
        DhCategoryListDTO reqDTO = new DhCategoryListDTO();
        reqDTO.setParentId(null);
        DhCategoryListVO respVO = dhGateCategoryCallService.getCategoryList(dcDTO, reqDTO);

        if (respVO == null) {
            return null;
        }
        return respVO.getCatePubList();
    }

    /**
     * 菜单子节点
     */
    private List<DhCategoryListCatePubVO> getPub(DhAppClientDTO dcDTO,String parentId) throws Exception {
        DhCategoryListDTO reqDTO = new DhCategoryListDTO();
        reqDTO.setParentId(parentId);
        DhCategoryListVO respVO = dhGateCategoryCallService.getCategoryList(dcDTO, reqDTO);

        if (respVO == null) {
            return null;
        }
        return respVO.getCatePubList();
    }

    private DhAppClientDTO getDcDTO() {
        //["appKey": "QrStYilYajlkjzTjd6Uy","appSecret": "Xj1ZCz51a38FrOl1WpuyVtPjtbHd9rNR"]
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
