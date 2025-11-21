package com.eshop.util.platform.api.service.order.jushuitan.converter;


import com.eshop.util.platform.api.service.order.jushuitan.converter.vo.JushuitanErpOrderVO;

import java.util.List;

// 统一的转换器接口
public interface JushuitanErpOrderConverter<T> {

    /**
     * 转换方法
     *
     * @param source
     * @return
     */
    List<JushuitanErpOrderVO> convert(T source);
}
