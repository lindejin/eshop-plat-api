package com.eshop.service;

import com.alibaba.fastjson.JSON;
import com.eshop.util.platform.api.structure.dhgate.dto.DhAppClientDTO;
import com.eshop.util.shop.PlatformAppClientUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class DhGateCategoryCallServiceImplTest2 {

    @Resource
    private DhGateCategoryCallServiceImpl dhGateCategoryCallService;

    @Resource
    private PlatformAppClientUtils platformAppClientUtils;
    /**
     * 获取所有菜单并保存为JSON文件
     */
    @Test
    void getAllCategoriesAndSaveToJson() throws Exception {
        DhAppClientDTO dcDTO = getDcDTO();
        List<DhCategoryListCatePubVO> allCategories = new ArrayList<>();

        // 获取根节点
        List<DhCategoryListCatePubVO> rootCategories = getRoot(dcDTO);
    }

    private DhAppClientDTO getDcDTO() {
        Long shopId = 183L;
        String platformCode = "Dhgate";
        DhAppClientDTO dcDTO = platformAppClientUtils.getDhAppClientDTO(shopId, platformCode);
        return dcDTO;
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
}
