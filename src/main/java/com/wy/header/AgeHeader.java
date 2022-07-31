package com.wy.header;

/**
 * 年龄统计
 */
public class AgeHeader extends Header{

    @Override
    public String[] getHeader() {
        String[] headers = new String[] {"大类","总量","1985以前","1985~1995","1995以后","1985后占比(%)","1995后占比(%)"};
        return headers;
    }
}
