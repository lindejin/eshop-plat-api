package com.eshop.config.appender;

import com.p6spy.engine.logging.Category;
import com.p6spy.engine.spy.appender.FormattedLogger;
import org.apache.commons.lang3.StringUtils;

import java.io.PrintStream;

public class StdoutLogger extends FormattedLogger {

    protected PrintStream getStream() {
        return System.out;
    }

    @Override
    public void logException(Exception e) {
        e.printStackTrace(getStream());
    }

    @Override
    public void logText(String text) {
        if (StringUtils.isBlank(text)) {
            return;
        }
        getStream().println(text);
    }

    @Override
    public boolean isCategoryEnabled(Category category) {
        // no restrictions on logger side
        return true;
    }
}
