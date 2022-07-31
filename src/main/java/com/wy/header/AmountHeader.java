package com.wy.header;

/**
 * 数量统计
 */
public class AmountHeader extends Header{

    @Override
    public String[] getHeader() {
        String[] headers = new String[] {"大类","数量"};
        return headers;
    }
}
