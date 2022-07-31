package com.wy.configuration;

import java.util.HashMap;

public class Transaction2Introduce {

    public static HashMap<String,String> map;

    static {
        map = new HashMap<String, String>(6);
        map.put("夜盘委托","附件 图2-1");
        map.put("涨跌停敢死队","附件 图1-1");
        map.put("涨跌停模型","附件 图2-1");
        map.put("量化非高频","附件 图1-1");
        map.put("债券套利","附件 图1-1");
        map.put("股票数据汇总","附件 图1-1");
    }

    public static HashMap<String,String> getMap(){
        return map;
    }
}
