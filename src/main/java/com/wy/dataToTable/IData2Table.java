package com.wy.dataToTable;

import com.wy.entity.CellContext;

import java.lang.reflect.InvocationTargetException;

public interface IData2Table {
    public String[][] toTable(String tableName, CellContext cellContext) throws InvocationTargetException, IllegalAccessException;
}
