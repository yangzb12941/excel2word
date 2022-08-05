package com.wy.wordWriter;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.wy.dataProcess.DataToTable;
import com.wy.entity.CellContext;
import com.wy.excelCell.*;
import com.wy.utils.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.List;

public class ExcelToWord {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExcelToWord.class);

    private static volatile ExcelToWord excelToWord;

    public static ExcelToWord getInstance(){
        if(excelToWord == null){
            synchronized (ExcelToWord.class){
                if (excelToWord == null) {
                    excelToWord = new ExcelToWord();
                }
            }
        }
        return excelToWord;
    }

    public void excelToWord(String fileName){
        //批量处理某一个文件夹下全部的excel文件
        try{
            String property = System.getProperty("user.dir");

            CellContext cellContext = new CellContext();
            ReadExcels instance = ReadExcels.getInstance();
            List<File> allFile = instance.getAllFile(fileName);
            for (File file : allFile) {
                try{
                    ExcelReaderBuilder excelReaderBuilder = EasyExcel.read(file);
                    ExcelReader excelReader = excelReaderBuilder.build();
                    List<ReadSheet> sheets = excelReader.excelExecutor().sheetList();
                    for (ReadSheet sheet : sheets) {
                        if(sheet.getSheetName().indexOf("夜盘委托")>=0){
                            EasyExcel.read(file, NightOrderCell.class,
                                    new NightOrderCellTools(cellContext,"夜盘委托"))
                                    .sheet(sheet.getSheetName()).headRowNumber(4).doRead();
                        }else if(sheet.getSheetName().indexOf("涨停板敢死队")>=0){
                            EasyExcel.read(file, DailyLimitOrderCell.class,
                                    new DailyLimitOrderCellTools(cellContext,"涨停板敢死队"))
                                    .sheet(sheet.getSheetName()).headRowNumber(4).doRead();
                        }else if(sheet.getSheetName().indexOf("追涨停模型")>=0){
                            EasyExcel.read(file, WillDailyLimitCell.class,
                                    new WillDailyLimitCellTools(cellContext,"追涨停模型"))
                                    .sheet(sheet.getSheetName()).headRowNumber(4).doRead();
                        }else if(sheet.getSheetName().indexOf("债券套利")>=0){
                            EasyExcel.read(file, BondArbitrageCell.class,
                                    new BondArbitrageCellTools(cellContext,"债券套利"))
                                    .sheet(sheet.getSheetName()).headRowNumber(4).doRead();
                        }else if(sheet.getSheetName().indexOf("量化-非高频")>=0){
                            EasyExcel.read(file, QuantificationNonHighFrequencyCell.class,
                                    new QuantificationNonHighFrequencyCellTools(cellContext,"量化-非高频"))
                                    .sheet(sheet.getSheetName()).headRowNumber(4).doRead();
                        }else if(sheet.getSheetName().indexOf("股票数据汇总")>=0){
                            EasyExcel.read(file, StockDataSummaryCell.class,
                                    new StockDataSummaryCellTools(cellContext,"股票数据汇总"))
                                    .sheet(sheet.getSheetName()).headRowNumber(4).doRead();
                        }
                    }
                }catch (Exception e) {
                    LOGGER.error("文件-{}读取失败;",file.getName());
                    LOGGER.error("{}",e);
                }
            }
            DataToTable.getInstance().dataToTable(cellContext);
            CellWriter2Word.getInstance().writeWord(cellContext,property);
        }catch (Exception e) {
            LOGGER.error("ExcelToWordTest error {}",e);
        }
    }
}
