package com.eshop.util.minio;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Service;

/**
 * 普通对象获取Ioc容器的Bean
 *
 * @author sheng
 * @date 2023-09-07 11:21
 */
@Service
public class BeanFactoryStaticUtil implements BeanFactoryAware {
    private static BeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory factory) throws BeansException {
        beanFactory = factory;
    }

    public static <T> T getBean(Class<T> var1) {
        return beanFactory.getBean(var1);
    }

    public static <T> T getBean(String name, Class<T> cls) {
        return beanFactory.getBean(name, cls);
    }
}
