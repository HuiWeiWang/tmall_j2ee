package com.huiwei.util;

/**
 * @ClassName DateUtil
 * @Description 日期转换工具类
 * @Author HuiWei
 * @Date 2019/6/15 18:16
 **/
public class DateUtil {
    public static java.sql.Timestamp d2t(java.util.Date d) {
        if (null == d)
            return null;
        return new java.sql.Timestamp(d.getTime());
    }

    public static java.util.Date t2d(java.sql.Timestamp t) {
        if (null == t)
            return null;
        return new java.util.Date(t.getTime());
    }
}
