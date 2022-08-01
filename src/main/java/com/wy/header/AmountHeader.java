package com.wy.header;

import java.util.ArrayList;
import java.util.List;

/**
 * 数量统计
 */
public class AmountHeader extends Header{

    @Override
    public List<Cell> getHeader() {
        String[] headers = new String[] {"大类","数量"};
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
