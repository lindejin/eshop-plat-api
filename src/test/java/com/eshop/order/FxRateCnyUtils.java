package com.eshop.order;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.eshop.entity.config.TbExchangeRateRecord;
import com.eshop.service.config.ITbExchangeRateRecordService;
import com.eshop.service.config.ITbExchangeRateService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;

@Component
public class FxRateCnyUtils {

    @Resource
    private ITbExchangeRateService iTbExchangeRateService;

    @Resource
    private ITbExchangeRateRecordService iTbExchangeRateRecordService;

    public BigDecimal getFxRateCny(String currencyCode) {
        return getFxRateCny(currencyCode, null);
    }

    public BigDecimal getFxRateCny(String currencyCode, Date syncDate) {
        if (syncDate != null) {
            // 查询汇率数据
            BigDecimal bigDecimal = selectExchangeRateByTypeAndSyncDate(currencyCode, syncDate);
            if (bigDecimal != null) {
                return bigDecimal;
            }
        }
        // 查询汇率数据
        return selectExchangeRateByType(currencyCode);
    }

    private BigDecimal selectExchangeRateByTypeAndSyncDate(String currencyCode, Date syncDate) {
        // 第一步：查询最新 sync_date 的 TbExchangeRateRecord
        LambdaQueryWrapper<TbExchangeRateRecord> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper
                .eq(TbExchangeRateRecord::getCurrencyType, currencyCode)
                .eq(TbExchangeRateRecord::getSyncDate, syncDate)
                .orderByDesc(TbExchangeRateRecord::getSyncDate)
                .last("LIMIT 1");

        TbExchangeRateRecord latestRecord = iTbExchangeRateRecordService.getOne(queryWrapper);
        if (latestRecord == null) {
            return null; // 无数据
        }
        TbExchangeRateRecord targetRecord = iTbExchangeRateRecordService.getOne(queryWrapper);
        return targetRecord != null ? targetRecord.getExecuteExchangeRate() : null;
    }

    private BigDecimal selectExchangeRateByType(String currencyType) {
        // 第一步：查询最新 sync_date 的 TbExchangeRateRecord
        LambdaQueryWrapper<TbExchangeRateRecord> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(TbExchangeRateRecord::getCurrencyType, currencyType)
                .orderByDesc(TbExchangeRateRecord::getSyncDate)
                .last("LIMIT 1");

        TbExchangeRateRecord latestRecord = iTbExchangeRateRecordService.getOne(queryWrapper);
        if (latestRecord == null) {
            return null; // 无数据
        }
        TbExchangeRateRecord targetRecord = iTbExchangeRateRecordService.getOne(queryWrapper);
        return targetRecord != null ? targetRecord.getExecuteExchangeRate() : null;
    }
}
