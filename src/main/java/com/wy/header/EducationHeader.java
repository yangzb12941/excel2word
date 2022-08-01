package com.wy.header;

import java.util.ArrayList;
import java.util.List;

/**
 * 学历统计
 */
public class EducationHeader extends Header{

    @Override
    public List<Cell> getHeader() {
        String[] headers = new String[] {"大类","总量","本科以下","本科","硕博","本科以上占比(%)"};
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
