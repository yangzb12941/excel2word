package com.wy.header;

import java.util.ArrayList;
import java.util.List;

/**
 * 重点关注
 */
public class EmphasisHeader extends Header{

    @Override
    public List<Cell> getHeader() {
        String[] headers = new String[] {"服务人员姓名","客户资金账号","交易日期","总资产","可用资金","现金资产","使用系统","出生年份","交易意向","适用系统","介绍物料"};
        List<Cell> cells = new ArrayList<Cell>(headers.length);
        for (int i = 0; i < headers.length; i++) {
            Cell cell = new Cell();
            cell.setCellName(headers[i]);
            cell.setCellIndex(i);
            cells.add(cell);
        }
        return cells;
    }
}
