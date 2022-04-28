package com.ch.common.util;

import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;

import java.text.DecimalFormat;

/**
 * 格式化为前端可读方式
 * @Author : lichong
 * @Date : 2022-03-01
 * @Modified By
 */
public interface UtilDisplay {

    /**
     * 文件大小转换为可读大小
     * @param sizeObj
     * @return
     */
    static String sizeToDisplay(Object sizeObj){
        // 设置size为可读形式
        Long size = sizeObj!=null ? Longs.tryParse(sizeObj.toString()) : null ;
        if( size==null || size<=0){
            return "" ;
        }

        final String[] units = new String[]{"B", "KB", "MB", "GB", "TB"} ;

        int digitGroups = (int) (Math.log10(size) / Math.log10(1024)) ;

        return new DecimalFormat("#,##0.00").format(size / Math.pow(1024, digitGroups)) + " " + units[digitGroups];
    }

    /**
     * 将秒转换为可展示的方式
     * @param seconds
     * @return
     */
    static String secondToDisplay(Object seconds){
        if( seconds==null || Ints.tryParse( seconds.toString() ) ==null ){
            return "" ;
        }
        int secondNum = Ints.tryParse( seconds.toString() ) ;
        if( secondNum < 60 ){
            return secondNum+"秒" ;
        }else if( secondNum>=60 && secondNum<3600 ){
            return secondNum/60 +"分钟" ;
        }else {
            return secondNum/3600 +"小时" ;
        }
    }

    /**
     * 持续时间转换为可读
     * @param durationObj
     * @return
     */
    static String durationToDisplay(Object durationObj){
        Long duration = durationObj!=null ? Longs.tryParse(durationObj.toString()) : null ;
        if( duration==null ){
            return "" ;
        }

        long seconds = duration.intValue() ;
        long hour = seconds / 3600 ;
        long minute = (seconds - hour*3600) / 60 ;
        long second = (seconds - hour*3600 - minute * 60) ;

        return String.format("%02d" , hour)+":"+
                String.format("%02d" , minute)+":"+ String.format("%02d" , second) ;
    }

    /**
     * 将数字格式的比特率转换为文字描述
     * @param bitrateObj
     * @return
     */
    static String bitrateToDisplay(Object bitrateObj){
        Integer bitrate = bitrateObj!=null ? Ints.tryParse( bitrateObj.toString() ) : null ;
        if( bitrate==null || bitrate<0){
            return "" ;
        }
        String quality = "" ;
        if(bitrate<900){
            quality = "流畅" ;
        }else if(bitrate<1500){
            quality = "标清" ;
        }else if(bitrate<3000){
            quality = "高清" ;
        }else if(bitrate<3500){
            quality = "超清" ;
        }else if(bitrate<6000){
            quality = "2K" ;
        }else {
            quality = "4K" ;
        }
        return quality ;
    }

}
