package com.wy.utils;

import org.apache.commons.lang3.StringUtils;

public class GetYear {
    public static Integer getYear(String year) {
        Integer result = 0;
        if(StringUtils.isEmpty(year) || year.length()<4){
            result = 0;
        }else{
            result = Integer.valueOf(year.substring(0,4));
        }
       return result;
    }
}
