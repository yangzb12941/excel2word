package com.wy.elementHandler;

import com.deepoove.poi.data.*;
import com.deepoove.poi.template.MetaTemplate;
import com.wy.dataToTable.Data2Table;
import com.wy.entity.CellContext;

import java.util.Objects;
public class TableElementHandler implements IElementHandler<TableRenderData>{

    private static volatile TableElementHandler instance;

    public static TableElementHandler getInstance(){
        if(instance == null){
            synchronized (TableElementHandler.class){
                if (instance == null) {
                    instance = new TableElementHandler();
                }
            }
        }
        return instance;
    }

    @Override
    public TableRenderData getElementValue(CellContext cellContext, MetaTemplate metaTemplate) {
        RowRenderData[] rowRenderData = soilPressureTable(cellContext);
        return Tables.create(rowRenderData);
    }

    private RowRenderData[] soilPressureTable(CellContext cellContext) {
        String[][] table = Data2Table.getInstance().toTable(cellContext.getDataKey(), cellContext);
        RowRenderData[] t1rows = new RowRenderData[table.length];
        for (int i = 0; i < table.length; i++) {
            RowRenderData t1row = null;
            for (int j = 0; j< table[i].length; j++) {
                if(Objects.nonNull(t1row)){
                    CellRenderData cellRenderData = Cells.of(table[i][j]).horizontalLeft().create();
                    t1row.addCell(cellRenderData);
                }else{
                    t1row = Rows.create(table[i][j]);
                }
            }
            t1rows[i] = t1row;
        }
        return t1rows;
    }
}
