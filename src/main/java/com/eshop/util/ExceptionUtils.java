package com.eshop.util;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @author swordsman
 * @Title: ExceptionUtils
 * @Version 1.0
 * @date 2022/3/2816:44
 * 异常详细信息打印
 */
public class ExceptionUtils {


    public static String exToString(Throwable e){
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw, true);
        e.printStackTrace(pw);
        pw.flush();
        sw.flush();
        return sw.toString();
    }

}
