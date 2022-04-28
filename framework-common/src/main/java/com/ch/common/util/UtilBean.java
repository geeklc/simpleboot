package com.ch.common.util;

import com.google.common.collect.Lists;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * @Author : lichong
 * @description :   bean操作类
 * @Date Create in 10:13 2022/4/27
 * @Modified By :
 **/
public class UtilBean extends BeanUtils {

    /**
     * 拷贝源对象到目标对象
     * @param sourceList
     * @param targetClass
     * @param ignoreProperties
     * @param <T>
     * @return
     */
    public static <T> List<T> copyBeans(List<?> sourceList , Class<T> targetClass , String... ignoreProperties) {
        if( sourceList == null ){
            return null ;
        }

        List<T> targetList = Lists.newArrayListWithCapacity( sourceList.size() ) ;

        for (Object item : sourceList) {
            if( item == null ){
                continue;
            }
            // 实例化对象
            T targetObject = BeanUtils.instantiateClass( targetClass ) ;

            copyProperties( item , targetObject , ignoreProperties ) ;

            targetList.add( targetObject ) ;
        }

        return targetList ;
    }

    /**
     * 拷贝源对象到目标对象
     * @param sourceObj
     * @param targetClass
     * @param ignoreProperties
     * @param <T>
     * @return
     */
    public static <T> T copyBean(Object sourceObj , Class<T> targetClass , String... ignoreProperties) {
        if( sourceObj == null ){
            return null ;
        }

        // 实例化对象
        T targetObject = BeanUtils.instantiateClass( targetClass ) ;

        copyProperties( sourceObj , targetObject , ignoreProperties ) ;

        return targetObject ;
    }

}
