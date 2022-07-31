package com.wy.header;

/**
 * 重点关注
 */
public class EmphasisHeader extends Header{

    @Override
    public String[] getHeader() {
        String[] headers = new String[] {"服务人员","客户资金账号","交易日期","总资产","可用资金","现金资产","使用系统","出生年份","交易意向","适用系统","介绍物料"};
        return headers;
    }
}
