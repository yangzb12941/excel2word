package com.wy.elementHandler;

import com.deepoove.poi.data.*;
import com.deepoove.poi.data.style.CellStyle;
import com.deepoove.poi.template.MetaTemplate;
import com.deepoove.poi.template.run.RunTemplate;
import com.wy.entity.CellContext;
import com.wy.entity.WordTableModelEntity;

import java.util.ArrayList;
import java.util.List;
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

    private RowRenderData[] soilPressureTable(CellContext cellContext){
        String[][] table = object2Array(cellContext);
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

    private String[][] object2Array(CellContext cellContext){
        List itmes = (ArrayList)cellContext.getItmesMap().get(cellContext.getDataKey());
        String[][] table = new String[itmes.size()+1][9];
        for (int i = 0; i <= itmes.size(); i++) {
            if(i==0){
                //插入表头
                table[0][0] = "账号";
                table[0][1] = "营业部";
                table[0][2] = "客户类型";
                table[0][3] = "使用系统";
                table[0][4] = "服务人员姓名";
                table[0][5] = "服务人员编号";
                table[0][6] = "服务人员团队";
                table[0][7] = "月份";
                table[0][8] = "批次";
            }else{
                int curIndex = i-1;
                table[i][0] = ((WordTableModelEntity)itmes.get(curIndex)).get账户();
                table[i][1] = ((WordTableModelEntity)itmes.get(curIndex)).get营业部();
                table[i][2] = ((WordTableModelEntity)itmes.get(curIndex)).get客户类型();
                table[i][3] = ((WordTableModelEntity)itmes.get(curIndex)).get使用系统();
                table[i][4] = ((WordTableModelEntity)itmes.get(curIndex)).get服务人员姓名();
                table[i][5] = ((WordTableModelEntity)itmes.get(curIndex)).get服务人员编号();
                table[i][6] = ((WordTableModelEntity)itmes.get(curIndex)).get服务人员团队();
                table[i][7] = ((WordTableModelEntity)itmes.get(curIndex)).get月份();
                table[i][8] = ((WordTableModelEntity)itmes.get(curIndex)).get批次();
            }
        }
        return table;
    }
}
