package com.eshop.service.api.marketplace.biz.order.normal.domain.registrar;


import com.eshop.annotation.StrategyKey;
import com.eshop.annotation.StrategyKeys;
import com.eshop.service.api.marketplace.biz.order.normal.domain.repository.OrderClient;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.aop.framework.AopProxyUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Component
public class OrderStrategyKeyRegistrar implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Getter
    private final Map<String, List<OrderClient>> strategyMap = new ConcurrentHashMap<>();

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @PostConstruct
    public void registerStrategies() {
        // 获取所有实现了OrderClient接口的Bean
        Map<String, OrderClient> beansOfType = applicationContext.getBeansOfType(OrderClient.class);
        for (OrderClient bean : beansOfType.values()) {
            Class<?> clazz = AopProxyUtils.ultimateTargetClass(bean);

            // 处理 StrategyKey 注解
            StrategyKey singleAnnotation = clazz.getAnnotation(StrategyKey.class);
            if (singleAnnotation != null) {
                if (StringUtils.isNotBlank(singleAnnotation.value())) {
                    // 使用注解中的值作为Map的键
                    strategyMap.computeIfAbsent(singleAnnotation.value(), k -> new ArrayList<>()).add(bean);

                }
            }

            // 处理 StrategyKeys 注解
            StrategyKeys multiAnnotation = clazz.getAnnotation(StrategyKeys.class);
            if (multiAnnotation != null && multiAnnotation.value() != null) {
                for (String type : multiAnnotation.value()) {
                    if (StringUtils.isNotBlank(type)) {
                        strategyMap.computeIfAbsent(type, k -> new ArrayList<>()).add(bean);
                    } else {
                        log.error("初始化 平台订单 服务失败！");
                    }
                }
            }
        }
    }

}
