package com.wy.header;

import java.util.ArrayList;
import java.util.List;

/**
 * 夜盘委托、
 * 涨停板敢死队、
 * 追涨停模型
 * 量化-非高频
 * 债券套利
 * 股票数据汇总
 */
public class NativeHeader extends Header{

    @Override
    public List<Cell> getHeader() {
        String[] headers = new String[] {"账号","营业部","客户类型","使用系统","服务人员姓名","服务人员编号","服务人员团队","学历","年份"};
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
