package com.wy.dataProcess;

import com.wy.entity.CellEntity;
import com.wy.excelCell.ExcelCell;

import java.util.List;

/**
 * 数据加工接口
 */
public interface IProcess<T extends ExcelCell> {
    public List<? extends CellEntity> process(List<T> rawMaterial,Class zlass);
}
