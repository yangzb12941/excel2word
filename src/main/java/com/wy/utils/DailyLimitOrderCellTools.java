package com.wy.utils;

import com.alibaba.excel.context.AnalysisContext;
import com.wy.entity.CellContext;
import com.wy.excelCell.DailyLimitOrderCell;
import com.wy.excelCell.ExcelCell;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 4.涨停板敢死队
 */
public class DailyLimitOrderCellTools extends ExcelImportTools<DailyLimitOrderCell> {
    private static final Logger LOGGER = LoggerFactory.getLogger(DailyLimitOrderCellTools.class);
    private static final Date curDate = new Date();
    //插入数据脚本，写入文件
    private CellContext cellContext;

    private String sheetName;

    public DailyLimitOrderCellTools(CellContext cellContext,String sheetName) {
        this.cellContext = cellContext;
        this.sheetName = sheetName;
    }

    /**
     * 这个每一条数据解析都会来调用
     *
     * @param data
     *            one row value. Is is same as {@link AnalysisContext#readRowHolder()}
     * @param context
     */
    @Override
    public void invoke(DailyLimitOrderCell data, AnalysisContext context) {
        super.invoke(data,context);
    }
    /**
     * 所有数据解析完成了 都会来调用
     *
     * @param context
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        // 这里也要保存数据，确保最后遗留的数据也存储到数据库
        super.doAfterAllAnalysed(context);
    }

    @Override
    public void doSomething() {
        //统计表格数据
        excleDataToExcelCell();
    }

    private void excleDataToExcelCell(){
        List<DailyLimitOrderCell> excelCellList = super.list.stream().filter(e->Integer.valueOf(e.get使用系统次数())>=400).collect(Collectors.toList());
        HashMap itmesMap = this.cellContext.getAllExcelCellMap();
        if(itmesMap.containsKey(this.sheetName)){
            ((ArrayList<ExcelCell>) itmesMap.get(this.sheetName)).addAll(excelCellList);
        }else{
            itmesMap.put(this.sheetName, excelCellList);
        }
    }
}
