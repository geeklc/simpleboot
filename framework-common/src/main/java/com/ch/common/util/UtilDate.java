package com.ch.common.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author : lichong
 * @description : 日期转换类
 * @Date Create in 10:13 2022/4/27
 * @Modified By :
 **/
public abstract class UtilDate {

    /**
     * 获取一天中最大的时间
     *
     * @param date
     * @return
     */
    public static Date theDayMax(Date date) {
        LocalDateTime syncDateTmp = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        LocalDateTime todayStart = LocalDateTime.of(syncDateTmp.toLocalDate(), LocalTime.MAX);
        return Date.from(todayStart.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 获取一天中的初始化时间00
     *
     * @param date
     * @return
     */
    public static Date theDayMix(Date date) {
        LocalDateTime syncDateTmp = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        LocalDateTime todayStart = LocalDateTime.of(syncDateTmp.toLocalDate(), LocalTime.MIN);//当天零点
        return Date.from(todayStart.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date localDateTime2Date(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }


    /**
     * time 字符串转成date
     */
    public static Date timeStr2DateTime(String timeStr) {
        String[] timeStrArray = timeStr.split(":");
        LocalDateTime endTme = LocalDate.now().atTime(Integer.valueOf(timeStrArray[0]), Integer.valueOf(timeStrArray[1]), Integer.valueOf(timeStrArray[2]));
        return Date.from(endTme.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 将text转换为日期
     * <p>
     * 注意不能直接将time转为date，否则日期为1970年！！！
     */
    public static Date parse(String text) {
        if (StringUtils.isBlank(text)) {
            return null;
        }
        String[] datePatterns = {"yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "HH:mm:ss",
                "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd"};
        Date date = null;
        try {
            date = DateUtils.parseDate(text.trim(), datePatterns);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }


    /**
     * 时间禁止管理
     */
    private static final Map<String, Long> TIME_SPLITTER = new LinkedHashMap<String, Long>() {
        {
            put("年", 60 * 60 * 24 * 365L);
            put("月", 60 * 60 * 24 * 30L);
            put("天", 60 * 60 * 24L);
            put("时", 60 * 60L);
            put("分", 60L);
            put("秒", 1L);
        }
    };

    /**
     * 将秒转换为可读性的字符串
     *
     * @param seconds
     * @return
     */
    public static String secondToText(long seconds) {
        boolean flag = false;

        StringBuffer text = new StringBuffer();

        for (Map.Entry<String, Long> timeSplitter : TIME_SPLITTER.entrySet()) {
            String unit = timeSplitter.getKey();
            Long value = timeSplitter.getValue();
            //找到第一个可以比较的单位
            if (seconds < value && !flag) {
                continue;
            }
            flag = true;

            text.append(seconds / value + unit);
            //获取剩余的秒数
            seconds = seconds - seconds / value * value;

        }

        return text.toString();
    }


    /**
     * 是否合法的日期格式
     *
     * @param dataStr   日期格式
     * @param formatStr 校验格式
     * @return 是否符合格式
     */
    public static boolean isValidDate(String dataStr, String formatStr) {
        boolean convertSuccess = true;
        // （yyyy/MM/dd HH:mm）指定日期格式为四位年/两位月份/两位日期，注意yyyy/MM/dd区分大小写；
        SimpleDateFormat format = new SimpleDateFormat(formatStr);
        try {
            // 设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，
            // 比如2007/02/29会被接受，并转换成2007/03/01
            format.setLenient(false);
            format.parse(dataStr);
        } catch (Exception e) {
            // e.printStackTrace();
            // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
            convertSuccess = false;
        }
        return convertSuccess;
    }

    /**
     * 获取当前格式化时间
     *
     * @param dateFormatStr 格式化形式
     * @return
     */
    public static String getCurrentDateFormatStr(String dateFormatStr) {
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormatStr);
        String formatStr = formatter.format(new Date());
        return formatStr;
    }

    /**
     * 日期格式化
     *
     * @param date
     * @param dateFormatStr
     * @return
     */
    public static String getDateFormatStr(Date date, String dateFormatStr) {
        SimpleDateFormat formatter2 = new SimpleDateFormat(dateFormatStr);
        String formatStr = formatter2.format(date);
        return formatStr;
    }


}
