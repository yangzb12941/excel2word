package com.wy.utils;

import com.alibaba.excel.context.AnalysisContext;
import com.wy.entity.CellContext;
import com.wy.excelCell.ExcelCell;
import com.wy.excelCell.StockDataSummaryCell;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * 12.股票数据汇总
 */
public class StockDataSummaryCellTools extends ExcelImportTools<StockDataSummaryCell> {
    private static final Logger LOGGER = LoggerFactory.getLogger(StockDataSummaryCellTools.class);
    private static final Date curDate = new Date();
    //插入数据脚本，写入文件
    private CellContext cellContext;

    private String sheetName;
    public StockDataSummaryCellTools(CellContext cellContext,String sheetName) {
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
    public void invoke(StockDataSummaryCell data, AnalysisContext context) {
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
        List<StockDataSummaryCell> excelCellList =super.list;
        HashMap itmesMap = this.cellContext.getAllExcelCellMap();
        if(itmesMap.containsKey(this.sheetName)){
            ((ArrayList<ExcelCell>) itmesMap.get(this.sheetName)).addAll(excelCellList);
        }else{
            itmesMap.put(this.sheetName, excelCellList);
        }
    }
}
