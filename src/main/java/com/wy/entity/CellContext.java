package com.wy.entity;

import com.wy.excelCell.ExcelCell;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Data
public class CellContext<T extends CellEntity> {
    //所有表格的数据聚合
    private HashMap<String,List<T>> itmesMap;
    //所有统计数据集合，统计数据需要经过加工之后，才能转化为 itmesMap数据
    private HashMap<String,List<ExcelCell>> allExcelCellMap;
    private String dataKey;
    private Integer index;
    public CellContext(){
        this.itmesMap = new HashMap<String,List<T>>(16);
        this.allExcelCellMap = new HashMap<String,List<ExcelCell>>(16);
    }
}
