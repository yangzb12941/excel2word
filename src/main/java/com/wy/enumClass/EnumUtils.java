package com.wy.enumClass;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


/**
 * @author yangzb
 * @description 枚举工具类
 * @date 2021-08-08
 */
@Slf4j
public class EnumUtils {
    public static String getTypeName(Class<?> clzz, String code) {
        String include = "";
        try {
            if(clzz.isEnum()){
                Object[] enumConstants = clzz.getEnumConstants();
                Method getType = clzz.getMethod("getCode");
                for (Object enumConstant:enumConstants){
                    if (getType.invoke(enumConstant).toString().equals(code)) {
                        Method getTypeName = clzz.getMethod("getName");
                        include = getTypeName.invoke(enumConstant).toString();
                        break;
                    }
                }
            }

        }catch (InvocationTargetException | IllegalAccessException | NoSuchMethodException e) {
            log.error("EnumUtils error:{}",e);
        }
        return include;
    }
}
