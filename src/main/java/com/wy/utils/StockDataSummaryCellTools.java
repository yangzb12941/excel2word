package com.wy.utils;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.util.DateUtils;
import com.wy.entity.CellContext;
import com.wy.entity.WordTableModelEntity;
import com.wy.excelCell.StockDataSummaryCell;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 12.股票数据汇总
 */
public class StockDataSummaryCellTools extends ExcelImportTools<StockDataSummaryCell> {
    private static final Logger LOGGER = LoggerFactory.getLogger(StockDataSummaryCellTools.class);
    private static final Date curDate = new Date();
    //插入数据脚本，写入文件
    private CellContext cellContext;

    public StockDataSummaryCellTools(CellContext CellContext) {
        this.cellContext = CellContext;
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
        List<WordTableModelEntity> excelCellList = excelDataToDaoModel();
        this.cellContext.getItmes().addAll(excelCellList);
    }

    private List<WordTableModelEntity> excelDataToDaoModel(){
        List<WordTableModelEntity> excelCellList = new ArrayList<WordTableModelEntity>(super.list.size());
        super.list.stream().forEach((e)->{
            WordTableModelEntity excelCell = new WordTableModelEntity();
            excelCell.set账户(e.get资金账号());
            excelCell.set营业部(e.get营业部());
            excelCell.set客户类型(e.get客户类型());
            excelCell.set服务人员姓名(e.get服务人员姓名());
            excelCell.set服务人员编号(e.get服务人员编号());
            excelCell.set服务人员团队(e.get服务人员团队());
            excelCell.set使用系统(e.get使用系统());
            excelCell.set月份(DateUtils.format(curDate,"yyyyMM"));
            excelCell.set批次("");
            excelCellList.add(excelCell);
        });
        return excelCellList;
    }
}
