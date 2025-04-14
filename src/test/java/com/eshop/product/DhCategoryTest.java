package com.eshop.product;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.eshop.entity.product.DhCategory;
import com.eshop.entity.product.TbCategory;
import com.eshop.entity.product.TbCategoryAdditionalAttr;
import com.eshop.entity.product.TbCategoryPlatform;
import com.eshop.service.product.IDhCategoryService;
import com.eshop.service.product.ITbCategoryAdditionalAttrService;
import com.eshop.service.product.ITbCategoryPlatformService;
import com.eshop.service.product.ITbCategoryService;
import com.eshop.util.platform.api.service.order.shopee.ShopeeOrderCall;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SpringBootTest
public class DhCategoryTest {

    @Resource
    private IDhCategoryService iDhCategoryService;

    @Resource
    private ITbCategoryPlatformService iTbCategoryPlatformService;

    @Resource
    private ITbCategoryService iTbCategoryService;

    @Resource
    private ITbCategoryAdditionalAttrService iTbCategoryAdditionalAttrService;

    @Test
    void contextLoads() throws Exception {
//        List<DhCategory> dhCategories = queryCategoryTree();
//        System.out.println(dhCategories.size());
//
//        List<String> pareCatePubIds = dhCategories.stream().map(DhCategory::getCatePubId).collect(Collectors.toList());
//        Map<String, List<DhCategory>> stringListMap = queryPareCategoryTree(pareCatePubIds);
//
//        List<DhCategory> tempCateList = new ArrayList<>();
//        for (DhCategory dhCategory : dhCategories) {
//            List<DhCategory> tempList = stringListMap.get(dhCategory.getCatePubId());
//            if (CollectionUtils.isEmpty(tempList)){
//                tempCateList.add(dhCategory);
//            }
//        }
//
//        System.out.println(tempCateList.size());
//        List<Long> ids = tempCateList.stream().map(DhCategory::getId).collect(Collectors.toList());
//
//        Map<String, TbCategoryPlatform> stringTbCategoryPlatformMap = queryCategoryTree3(ids);
//
//        List<DhCategory> addList = new ArrayList<>();
//        for (DhCategory dhCategory : tempCateList) {
//            if (stringTbCategoryPlatformMap.get(dhCategory.getId()) == null){
//                System.out.println(dhCategory.getPubNameCn());
//                addList.add(dhCategory);
//            }
//        }
//        System.out.println(addList.size());

    }

    // 2. Service 层查询逻辑
    public List<DhCategory> queryCategoryTree() {
        QueryWrapper<DhCategory> wrapper = new QueryWrapper<>();

        // 组合 WHERE 条件（根据截图实际筛选逻辑优化）
        wrapper.and(wq -> wq
                .likeRight("pare_cate_pub_id", "210")   // pare_cate_pub_id LIKE '210%'
                .or()
                .eq("cate_pub_id", "210")               // cate_pub_id = '210'
        );

        // 添加排序（根据截图中的 cate_pub_id 升序）
        wrapper.orderByAsc("cate_pub_id");

        return iDhCategoryService.list(wrapper);
    }


    // 2. Service 层查询逻辑
    public Map<String,List<DhCategory>> queryPareCategoryTree(List<String> pareCatePubIds) {
        if (CollectionUtils.isEmpty(pareCatePubIds)) {
            return Collections.emptyMap();
        }

        QueryWrapper<DhCategory> wrapper = new QueryWrapper<>();

        // 组合 WHERE 条件（根据截图实际筛选逻辑优化）
        wrapper.and(wq -> wq
                .in("pare_cate_pub_id", pareCatePubIds)
        );

        // 添加排序（根据截图中的 cate_pub_id 升序）
        wrapper.orderByAsc("cate_pub_id");

        List<DhCategory> list = iDhCategoryService.list(wrapper);
        if (CollectionUtils.isEmpty(list)) {
            return Collections.emptyMap();
        }
        return list.stream().collect(Collectors.groupingBy(DhCategory::getPareCatePubId));

    }

    // 2. Service 层查询逻辑
    public Map<String,TbCategoryPlatform> queryCategoryTree3(List<String> catePubIds) {
        QueryWrapper<TbCategoryPlatform> wrapper = new QueryWrapper<>();

        // 组合 WHERE 条件（根据截图实际筛选逻辑优化）
        wrapper.eq("platform_code", "Dhgate");
        wrapper.in("platform_category_id", catePubIds);

        // 添加排序（根据截图中的 id 升序）
        wrapper.orderByAsc("id");

        List<TbCategoryPlatform> list = iTbCategoryPlatformService.list(wrapper);

        return list.stream().collect(Collectors.toMap(TbCategoryPlatform::getPlatformCategoryId, p -> p, (k1, k2) -> k1));

    }

    @Test
    void contextLoads21() throws Exception {
        List<DhCategory> dhCategories = queryCategoryTree();
        List<DhCategory> addList1 =  dhCategories.stream().filter(p->p.getLevel() == 1).collect(Collectors.toList());
//        List<DhCategory> addList2 =  dhCategories.stream().filter(p->p.getLevel() == 2).collect(Collectors.toList());
//
//        List<DhCategory> addList3 = dhCategories.stream().filter(p->p.getLevel() == 3).collect(Collectors.toList());
//
//        List<DhCategory> addList4 =dhCategories.stream().filter(p->p.getLevel() == 4).collect(Collectors.toList());

        for (DhCategory dhCategory : addList1) {
            String catePubId = dhCategory.getCatePubId();
            String pubNameCn = dhCategory.getPubNameCn();
            String pubName = dhCategory.getPubName();
            Byte level = dhCategory.getLevel();
            String leaf = dhCategory.getLeaf();

            Byte isLeaf = "1".equals(leaf) ? new Byte("1") :new Byte("2");
            QueryWrapper<TbCategory> wrapper = new QueryWrapper<>();

            // 组合 WHERE 条件（根据截图实际筛选逻辑优化）
            wrapper.eq("category_name", pubNameCn);
            wrapper.eq("remark", catePubId);

            List<TbCategory> list = iTbCategoryService.list(wrapper);
            if (CollectionUtils.isEmpty(list)) {
                TbCategory category = new TbCategory();
                category.setParentId(0L);
                category.setCategoryName(pubNameCn);
                category.setCategoryNameEn(pubName);
                category.setRemark(catePubId);
                category.setLevel(level);
                category.setIsLeaf(isLeaf);
                category.setIsDelete(new Byte("2"));
                iTbCategoryService.save(category);
            }

        }


    }

    @Test
    void contextLoads22() throws Exception {
        List<DhCategory> dhCategories = queryCategoryTree();
        List<DhCategory> addList2 =  dhCategories.stream().filter(p->p.getLevel() == 2).collect(Collectors.toList());
//
//        List<DhCategory> addList3 = dhCategories.stream().filter(p->p.getLevel() == 3).collect(Collectors.toList());
//
//        List<DhCategory> addList4 =dhCategories.stream().filter(p->p.getLevel() == 4).collect(Collectors.toList());

        for (DhCategory dhCategory : addList2) {
            String catePubId = dhCategory.getCatePubId();
            String pareCatePubId = dhCategory.getPareCatePubId();
            String pubNameCn = dhCategory.getPubNameCn();
            String pubName = dhCategory.getPubName();
            Byte level = dhCategory.getLevel();
            String leaf = dhCategory.getLeaf();

            Byte isLeaf = "1".equals(leaf) ? new Byte("1") :new Byte("2");

            QueryWrapper<TbCategory> wrapper = new QueryWrapper<>();
            // 组合 WHERE 条件（根据截图实际筛选逻辑优化）
            wrapper.eq("remark", pareCatePubId);

            List<TbCategory> list = iTbCategoryService.list(wrapper);
            if (CollectionUtils.isNotEmpty(list)) {
                TbCategory temp = list.get(0);

                TbCategory category = new TbCategory();
                category.setParentId(temp.getId());
                category.setCategoryName(pubNameCn);
                category.setCategoryNameEn(pubName);
                category.setRemark(catePubId);
                category.setLevel(level);
                category.setIsLeaf(isLeaf);
                category.setIsDelete(new Byte("2"));
                iTbCategoryService.save(category);
            }

        }


    }


    @Test
    void contextLoads23() throws Exception {
        List<DhCategory> dhCategories = queryCategoryTree();
//
        List<DhCategory> addList3 = dhCategories.stream().filter(p->p.getLevel() == 3).collect(Collectors.toList());
//
//        List<DhCategory> addList4 =dhCategories.stream().filter(p->p.getLevel() == 4).collect(Collectors.toList());

        for (DhCategory dhCategory : addList3) {
            String catePubId = dhCategory.getCatePubId();
            String pareCatePubId = dhCategory.getPareCatePubId();
            String pubNameCn = dhCategory.getPubNameCn();
            String pubName = dhCategory.getPubName();
            Byte level = dhCategory.getLevel();
            String leaf = dhCategory.getLeaf();

            Byte isLeaf = "1".equals(leaf) ? new Byte("1") :new Byte("2");

            QueryWrapper<TbCategory> wrapper = new QueryWrapper<>();
            // 组合 WHERE 条件（根据截图实际筛选逻辑优化）
            wrapper.eq("remark", pareCatePubId);

            List<TbCategory> list = iTbCategoryService.list(wrapper);
            if (CollectionUtils.isNotEmpty(list)) {
                TbCategory temp = list.get(0);

                TbCategory category = new TbCategory();
                category.setParentId(temp.getId());
                category.setCategoryName(pubNameCn);
                category.setCategoryNameEn(pubName);
                category.setRemark(catePubId);
                category.setLevel(level);
                category.setIsLeaf(isLeaf);
                category.setIsDelete(new Byte("2"));
                iTbCategoryService.save(category);
            }

        }


    }


    @Test
    void contextLoads24() throws Exception {
        List<DhCategory> dhCategories = queryCategoryTree();
//
//
        List<DhCategory> addList4 =dhCategories.stream().filter(p->p.getLevel() == 4).collect(Collectors.toList());

        for (DhCategory dhCategory : addList4) {
            String catePubId = dhCategory.getCatePubId();
            String pareCatePubId = dhCategory.getPareCatePubId();
            String pubNameCn = dhCategory.getPubNameCn();
            String pubName = dhCategory.getPubName();
            Byte level = dhCategory.getLevel();
            String leaf = dhCategory.getLeaf();

            Byte isLeaf = "1".equals(leaf) ? new Byte("1") :new Byte("2");

            QueryWrapper<TbCategory> wrapper = new QueryWrapper<>();
            // 组合 WHERE 条件（根据截图实际筛选逻辑优化）
            wrapper.eq("remark", pareCatePubId);

            List<TbCategory> list = iTbCategoryService.list(wrapper);
            if (CollectionUtils.isNotEmpty(list)) {
                TbCategory temp = list.get(0);

                TbCategory category = new TbCategory();
                category.setParentId(temp.getId());
                category.setCategoryName(pubNameCn);
                category.setCategoryNameEn(pubName);
                category.setRemark(catePubId);
                category.setLevel(level);
                category.setIsLeaf(isLeaf);
                category.setIsDelete(new Byte("2"));
                iTbCategoryService.save(category);
            }

        }


    }



    @Test
    void bind() throws Exception {
        List<DhCategory> dhCategories = queryCategoryTree();
        System.out.println(dhCategories.size());

        List<String> pareCatePubIds = dhCategories.stream().map(DhCategory::getCatePubId).collect(Collectors.toList());
        Map<String, List<DhCategory>> stringListMap = queryPareCategoryTree(pareCatePubIds);

        List<DhCategory> tempCateList = new ArrayList<>();
        for (DhCategory dhCategory : dhCategories) {
            List<DhCategory> tempList = stringListMap.get(dhCategory.getCatePubId());
            if (CollectionUtils.isEmpty(tempList)){
                tempCateList.add(dhCategory);
            }
        }

        System.out.println(tempCateList.size());
        List<String> catePubIds = tempCateList.stream().map(DhCategory::getCatePubId).collect(Collectors.toList());

        Map<String, TbCategoryPlatform> stringTbCategoryPlatformMap = queryCategoryTree3(catePubIds);

        List<DhCategory> addList = new ArrayList<>();
        for (DhCategory dhCategory : tempCateList) {
            if (stringTbCategoryPlatformMap.get(dhCategory.getCatePubId()) == null){
                System.out.println(dhCategory.getPubNameCn());
                addList.add(dhCategory);
            }
        }

        List<TbCategoryPlatform> tempPlatformList = new ArrayList<>();
        for (DhCategory dhCategory : addList) {
            String catePubId = dhCategory.getCatePubId();
            QueryWrapper<TbCategory> wrapper = new QueryWrapper<>();
            // 组合 WHERE 条件（根据截图实际筛选逻辑优化）
            wrapper.eq("remark", catePubId);

            List<TbCategory> list = iTbCategoryService.list(wrapper);
            if (CollectionUtils.isNotEmpty(list)) {
                TbCategory temp = list.get(0);


                QueryWrapper<TbCategoryPlatform> wrapperGTT = new QueryWrapper<>();

                // 组合 WHERE 条件（根据截图实际筛选逻辑优化）
                wrapperGTT.eq("platform_code", "Dhgate");
                wrapperGTT.in("category_id", temp.getId());
                wrapperGTT.in("platform_category_id", dhCategory.getCatePubId());

                List<TbCategoryPlatform> TEMP = iTbCategoryPlatformService.list(wrapperGTT);

                if (CollectionUtils.isEmpty(TEMP)) {
                    TbCategoryPlatform tempCategory = new TbCategoryPlatform();
                    tempCategory.setPlatformCode("Dhgate");
                    tempCategory.setCategoryId(dhCategory.getId());
                    tempCategory.setPlatformCategoryId(dhCategory.getCatePubId());
                    tempPlatformList.add(tempCategory);
                }
            }
        }

        iTbCategoryPlatformService.saveBatch(tempPlatformList,500);


    }

    @Test
    void bind2() throws Exception {
        List<DhCategory> dhCategories = queryCategoryTree();
        List<String> catePubIds = dhCategories.stream().map(DhCategory::getCatePubId).collect(Collectors.toList());

        QueryWrapper<TbCategory> wrapper = new QueryWrapper<>();
        // 组合 WHERE 条件（根据截图实际筛选逻辑优化）
        wrapper.in("remark", catePubIds);

        List<TbCategory> list = iTbCategoryService.list(wrapper);
        List<Long> ids = list.stream().map(TbCategory::getId).collect(Collectors.toList());

        Map<Long, TbCategoryAdditionalAttr> attrMap = queryAttrMap(ids);


        List<TbCategoryAdditionalAttr> tempList = new ArrayList<>();
        for (TbCategory category : list) {
            if (attrMap.get(category.getId()) == null){
                TbCategoryAdditionalAttr addAttr = new TbCategoryAdditionalAttr();
                addAttr.setCategoryId(category.getId());
                addAttr.setCustomsName("4201000090");
                addAttr.setDeclareName(category.getCategoryName());
                addAttr.setDeclareNameEn(category.getCategoryNameEn());
                addAttr.setDeclarePrice(new BigDecimal("5.0"));
                addAttr.setDeclareWeight(300.0);
                addAttr.setIsSizeTable(new Byte("2"));
                addAttr.setPackingId(6L);
                tempList.add(addAttr);
            }
        }
        if (CollectionUtils.isNotEmpty(tempList)) {
            iTbCategoryAdditionalAttrService.saveBatch(tempList,500);
        }
    }

    // 2. Service 层查询逻辑
    public Map<Long,TbCategoryAdditionalAttr> queryAttrMap(List<Long> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return Collections.emptyMap();
        }

        QueryWrapper<TbCategoryAdditionalAttr> wrapper = new QueryWrapper<>();

        // 组合 WHERE 条件（根据截图实际筛选逻辑优化）
        wrapper.and(wq -> wq
                .in("category_id", ids)
        );

        // 添加排序（根据截图中的 cate_pub_id 升序）
        wrapper.orderByAsc("category_id");

        List<TbCategoryAdditionalAttr> list = iTbCategoryAdditionalAttrService.list(wrapper);
        if (CollectionUtils.isEmpty(list)) {
            return Collections.emptyMap();
        }
        return list.stream().collect(Collectors.toMap(TbCategoryAdditionalAttr::getCategoryId, p -> p, (k1, k2) -> k1));

    }
}
