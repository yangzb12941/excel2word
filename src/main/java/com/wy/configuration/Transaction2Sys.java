package com.wy.configuration;

import java.util.HashMap;

public class Transaction2Sys {

    public static HashMap<String,String> map;

    static {
        map = new HashMap<String, String>(6);
        map.put("夜盘委托","QMT");
        map.put("涨停板敢死队","PTRADE");
        map.put("追涨停模型","QMT");
        map.put("量化-非高频","PTRADE");
        map.put("债券套利","PTRADE");
        map.put("股票数据汇总","PTRADE");
    }

    public static HashMap<String,String> getMap(){
        return map;
    }
}
