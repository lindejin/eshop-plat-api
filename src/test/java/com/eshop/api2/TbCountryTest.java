package com.eshop.api2;

import cn.idev.excel.FastExcel;
import cn.idev.excel.read.listener.PageReadListener;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.eshop.entity.config.TbCountry;
import com.eshop.service.config.ITbCountryService;
import com.eshop.service.config.ITbShopService;
import com.eshop.util.platform.api.service.im.dhpage.DhGateImCall;
import com.eshop.util.platform.api.service.im.dhpage.dto.DhContactListReqDTO;
import com.eshop.util.platform.api.structure.dhgate.dto.DhAppClientDTO;
import com.eshop.util.platform.utils.FastJsonUtil;
import com.eshop.util.poi.DemoData;
import com.eshop.util.poi.DemoData2;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@SpringBootTest
public class TbCountryTest {

    @Resource
    private ITbCountryService iTbCountryService;

    @Test
    void getContactList() throws Exception {
        List<TbCountry> list = iTbCountryService.list();

        Map<String, DemoData2> mapCountry = new HashMap<>();
        Map<String, DemoData2> mapCountryNum = new HashMap<>();
        String fileName = "D:\\temp\\国家代码 - 副本.xlsx"; // Replace with actual path
        // Read Excel file
        FastExcel.read(fileName, DemoData2.class, new PageReadListener<DemoData2>(dataList -> {
            for (DemoData2 demoData : dataList) {
                if (StringUtils.isNotBlank(demoData.getAlpha3())){
                    mapCountry.put(demoData.getAlpha3().trim().toLowerCase(), demoData);
                    mapCountryNum.put(demoData.getEnName().trim().toLowerCase(), demoData);
                }
            }
        })).sheet().doRead();


        Map<String, DemoData> mapCodeNum = new HashMap<>();
        String fileName2 = "D:\\temp\\货币代码 - 副本.xlsx"; // Replace with actual path
        // Read Excel file
        FastExcel.read(fileName2, DemoData.class, new PageReadListener<DemoData>(dataList -> {
            for (DemoData demoData : dataList) {
                mapCodeNum.put(demoData.getEntity().trim().toLowerCase(), demoData);
            }
        })).sheet().doRead();

        List<TbCountry> listUp = new ArrayList<>();
        for (TbCountry tbCountry : list) {
            DemoData2 demoData2 = mapCountry.get(tbCountry.getCountryThreeCode().trim().toLowerCase());
            if (demoData2 == null) {
                log.info(tbCountry.getCountryThreeCode()+"三字码查询国家失败");
                continue;
            }
            String enName = demoData2.getEnName().trim().toLowerCase();

            DemoData demoData = mapCodeNum.get(enName);
            if (demoData == null) {
                log.info(enName+"enName查询货币失败");
                continue;
            }
            String alphabeticCode = demoData.getAlphabeticCode();
            System.out.println(tbCountry.getCountryThreeCode()+"三字码，货币"+ alphabeticCode);

            if (StringUtils.isNotBlank(alphabeticCode)){
                TbCountry up = new TbCountry();
                up.setId(tbCountry.getId());
                up.setCurrencyCode(alphabeticCode);
                listUp.add(up);
            }else {
                System.out.println(tbCountry.getCountryThreeCode()+"三字码，货币为空");
            }

        }
        if (listUp.size() > 0) {
            iTbCountryService.updateBatchById(listUp);
        }
    }
}
