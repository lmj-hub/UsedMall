package com.feng.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @描述：时间格式化的工具类
 */

public class DateUtil {

    /**
     * 时间格式 : 年-月-日
     */
    public static final String FORMAT1 = "yyyy-MM-dd";
    /**
     * 时间格式 : 年-月-日 时:分      24小时制  HH小写为12小时制
     */
    public static final String FORMAT2 = "yyyy-MM-dd HH:mm";
    /**
     * 时间格式 : 年-月-日 时:分:秒   24小时制
     */
    public static final String FORMAT3 = "yyyy-MM-dd HH:mm:ss";

    /**
     * 获取当前日期(年月日)
     *
     * @return
     */
    public static String getNowDay() {
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT1);
        Date date = new Date();
        String _time = sdf.format(date);
        return _time;
    }

    /**
     * 获取当前时间(年-月-日 时:分)
     *
     * @return
     */
    public static String getNowDate() {
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT2);
        Date date = new Date();
        String _time = sdf.format(date);
        return _time;
    }

    /**
     * 获取当前时间(年-月-日 时:分:秒)
     *
     * @return
     */
    public static String getNowTime() {
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT3);
        Date date = new Date();
        String _time = sdf.format(date);
        return _time;
    }
}
