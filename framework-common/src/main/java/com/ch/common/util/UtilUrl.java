package com.ch.common.util;


import com.ch.common.exception.AppException;

import java.io.File;
import java.net.URI;
import java.util.regex.Matcher;

public interface UtilUrl {

    /**
     * 格式化url，示例：http://10.243.25.30:9000//resource-vpn/transcode/20200319/3402949298554416853/1669/avi/3402950097418333155.avi
     * @return
     */
    static String formatUrl(String url){
        // 不能带着空格
        url = url.replaceAll("( )|(\\[)|(\\])|(\\{)|(\\})" , "") ;
        URI uri = null ;
        try{
            uri = URI.create( url.trim() ) ;
        }catch( IllegalArgumentException e ){
            throw new AppException("文件名称不能包括特殊字符") ;
        }

        String formatedUrl = uri.getScheme()+"://"+uri.getHost() ;
        if( uri.getPort()!=-1 ){
            formatedUrl += ":" + uri.getPort() ;
        }

        formatedUrl += uri.getPath().replaceAll("//" , "/") ;

        return formatedUrl ;
    }


    /**
     * 格式化路径
     * @param path
     * @return
     */
    static String formatPath(String path){
        return formatPath( path , File.separator ) ;
    }

    /**
     * 格式化路径
     * @param path
     * @param fileSeparator 文件路径分隔符
     * @return
     */
    static String formatPath(String path, String fileSeparator){
        if( UtilString.isBlank( path ) ){
            return path ;
        }

        int i = 0 ;
        while (i++<5){
            path = path.replaceAll("/+" , Matcher.quoteReplacement( fileSeparator ) )
                    .replaceAll("\\\\+" , Matcher.quoteReplacement( fileSeparator ) ) ;
        }


        return path ;
    }

//    public static void main(String[] args) {
//
//        System.out.println( formatUrl("R[9A]2_{AV}K523580G7LYT64.png") );
//
////        System.out.println( Matcher.quoteReplacement(File.separator) );
////
////        System.out.println( formatPath("D:\\tmp\\tmp//20200320\\\\3403060712539437786.wmv" , "/") );
//    }

}
