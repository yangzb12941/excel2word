package com.wy.header;

/**
 * 学历统计
 */
public class EducationHeader extends Header{

    @Override
    public String[] getHeader() {
        String[] headers = new String[] {"大类","总量","本科以下","本科","硕博","本科以上占比(%)"};
        return headers;
    }
}
