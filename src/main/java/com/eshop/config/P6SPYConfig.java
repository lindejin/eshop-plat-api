package com.eshop.config;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.p6spy.engine.spy.appender.MessageFormattingStrategy;
import org.apache.commons.lang3.StringUtils;

/**
 * @author ldj
 * @date 2024/8/26 10:53
 * @Description: ...
 * @Version 1.0
 */
public class P6SPYConfig implements MessageFormattingStrategy {

    public static final String REGX = "\\s+";

    @Override
    public String formatMessage(int connectionId, String now, long elapsed, String category, String prepared, String sql, String url) {
        StringBuffer buf = new StringBuffer();
        buf.append("执行时间：").append(now).append("\n");
        buf.append("消耗时间:").append(elapsed).append(" ms").append("\n");
        buf.append("数据源:").append(url).append("\n");
        buf.append("执行的SQL:").append(StringUtils.isBlank(sql) ? sql : sql.replaceAll(REGX, StringPool.SPACE)).append("\n");
        return buf.toString();
    }
}
