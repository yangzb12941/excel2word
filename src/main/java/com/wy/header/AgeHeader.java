package com.wy.header;

import java.util.ArrayList;
import java.util.List;

/**
 * 年龄统计
 */
public class AgeHeader extends Header{

    @Override
    public List<Cell> getHeader() {
        String[] headers = new String[] {"大类","总量","1985以前","1985_1995","1995以后","1985后占比(%)","1995后占比(%)"};
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
