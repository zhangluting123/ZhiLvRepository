package com.zhilv.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ProjectName:    ZhiLv
 * @Description:    日期转换工具类
 * @Author:         张璐婷
 * @CreateDate:     2021/1/19  15:25
 * @Version:        1.0
 */
public class DateUtil {
    private static SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
    private static SimpleDateFormat formatDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static Date getDate(String str){
        try {
            return formatDate.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Date getDateTime(String str){
        try {
            return formatDateTime.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getDateStr(Date date){
        return formatDate.format(date);
    }

    public static String getDateTimeStr(Date date){
        return formatDateTime.format(date);
    }
    
    public static Date getCurrentTimes() {
    	Date date = new Date(System.currentTimeMillis());
    	return date;
    }

}
