package com.eshop.logistics;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.eshop.entity.config.TbCountry;
import com.eshop.entity.config.TbCountryExpand;
import com.eshop.entity.logistics.TbLogisticsFreight;
import com.eshop.entity.order.TbWaybill;
import com.eshop.entity.order.TbWaybillSite;
import com.eshop.service.config.ITbCountryExpandService;
import com.eshop.service.config.ITbCountryService;
import com.eshop.service.depot.ITbParcelService;
import com.eshop.service.log.ITbOrderLogService;
import com.eshop.service.logistics.ITbLogisticsFreightService;
import com.eshop.service.order.ITbWaybillService;
import com.eshop.service.order.ITbWaybillSiteService;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.SQLException;
import java.util.List;

@SpringBootTest
public class TestWeight {

    @Resource
    private ITbOrderLogService iTbOrderLogService;

    @Resource
    private ITbLogisticsFreightService iTbLogisticsFreightService;

    @Resource
    private ITbParcelService iTbParcelService;

    @Resource
    private ITbWaybillService iTbWaybillService;


    @Resource
    private ITbWaybillSiteService iTbWaybillSiteService;

    @Resource
    private ITbCountryService iTbCountryService;

    @Resource
    private ITbCountryExpandService iTbCountryExpandService;

    @Resource
    private ParcelCostUtils parcelCostUtils;

    @Test
    void getAllCategoriesAndSaveToJson() throws Exception {
        BigInteger parcelNo = BigInteger.valueOf(10000369273L);
        Long logisticsModeId = 29012L;
        Double weight = Double.valueOf("1910");
        BigDecimal bigDecimal = estimateFreightCalculate(parcelNo, logisticsModeId, weight);
        System.out.println(bigDecimal);
    }

    /**
     * 预估物流运费
     */
    public BigDecimal estimateFreightCalculate(BigInteger parcelNo, Long logisticsModeId, Double weight) throws Exception {
        List<TbLogisticsFreight> lfs = getLogisticsFreight(parcelNo, logisticsModeId);
        if (CollectionUtils.isEmpty(lfs)) {
            return null;
        }
        //重量 g -> kg
        weight = weightToKg(weight);
        BigDecimal estimateFreight = parcelCostUtils.estimateFreightCalculate(lfs, weight);
        return estimateFreight;
    }

    public List<TbLogisticsFreight> getLogisticsFreight(BigInteger parcelNo, Long modeId) throws SQLException, Exception {
        //国家
        String countryTwoCode = getCountryTwoCode(parcelNo);
        if (StringUtils.isBlank(countryTwoCode)) {
            return null;
        }
        //物流运费
        LambdaQueryWrapper<TbLogisticsFreight> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(TbLogisticsFreight::getModeId, modeId);
        queryWrapper.eq(TbLogisticsFreight::getCountryCode, countryTwoCode);
        List<TbLogisticsFreight> freights = iTbLogisticsFreightService.list(queryWrapper);
        return freights;
    }

    /**
     * 获取国家二字码
     */
    private String getCountryTwoCode(BigInteger parcelNo) throws Exception {
        //国家
        TbWaybill waybill = getTbWaybill(parcelNo);

        TbWaybillSite waybillSite = getTbWaybillSite(waybill);

        TbCountryExpand tbCountryExpand = getTbCountryExpand(waybillSite);

        TbCountry country = null;
        if (tbCountryExpand != null) {
            LambdaQueryWrapper<TbCountry> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(TbCountry::getId, tbCountryExpand.getCountryId());
            country = iTbCountryService.getOne(queryWrapper);
        } else {
            LambdaQueryWrapper<TbCountry> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(TbCountry::getCountryEnName, waybillSite.getCountry());
            country = iTbCountryService.getOne(queryWrapper);
        }
        if (country == null) {
            return null;
        }
        String countryTwoCode = country.getCountryTwoCode();
        return countryTwoCode;
    }

    private TbCountryExpand getTbCountryExpand(TbWaybillSite waybillSite) {

        LambdaQueryWrapper<TbCountryExpand> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(TbCountryExpand::getCountryEnName, waybillSite.getCountry());
        TbCountryExpand tbCountryExpand = iTbCountryExpandService.getOne(queryWrapper);
        return tbCountryExpand;
    }

    private TbWaybillSite getTbWaybillSite(TbWaybill waybill) {
        LambdaQueryWrapper<TbWaybillSite> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(TbWaybillSite::getWaybillId, waybill.getId());
        TbWaybillSite tbCountryExpand = iTbWaybillSiteService.getOne(queryWrapper);
        return tbCountryExpand;
    }

    private TbWaybill getTbWaybill(BigInteger parcelNo) {
        LambdaQueryWrapper<TbWaybill> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(TbWaybill::getParcelNo, parcelNo);
        TbWaybill waybill = iTbWaybillService.getOne(queryWrapper);
        return waybill;
    }

    /**
     * 重量 g -> kg
     *
     * @param weight
     * @return
     */
    private Double weightToKg(Double weight) {
        BigDecimal weightB = BigDecimal.valueOf(weight);
        BigDecimal kgB = BigDecimal.valueOf(1000);
        //保留4位数
        return weightB.divide(kgB, 4, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
