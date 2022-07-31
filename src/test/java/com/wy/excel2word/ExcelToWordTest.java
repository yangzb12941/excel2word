package com.wy.excel2word;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.wy.dataProcess.DataToTable;
import com.wy.entity.CellContext;
import com.wy.excelCell.*;
import com.wy.utils.*;
import com.wy.wordWriter.CellWriter2Word;
import com.wy.wordWriter.ReadExcels;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.util.List;

@SpringBootTest
public class ExcelToWordTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExcelToWordTest.class);
    @Test
    public void test() {
    	//批量处理某一个文件夹下全部的excel文件
        try{
            CellContext cellContext = new CellContext();
            ReadExcels instance = ReadExcels.getInstance();
            List<File> allFile = instance.getAllFile("D:\\aaaa");
            for (File file : allFile) {
                try{
                    ExcelReaderBuilder excelReaderBuilder = EasyExcel.read(file);
                    ExcelReader excelReader = excelReaderBuilder.build();
                    List<ReadSheet> sheets = excelReader.excelExecutor().sheetList();
                    for (ReadSheet sheet : sheets) {
                        if(sheet.getSheetName().indexOf("夜盘委托")>=0){
                            EasyExcel.read(file, NightOrderCell.class,
                                    new NightOrderCellTools(cellContext,sheet.getSheetName()))
                                    .sheet(sheet.getSheetName()).headRowNumber(4).doRead();
                        }else if(sheet.getSheetName().indexOf("涨停板敢死队")>=0){
                            EasyExcel.read(file, DailyLimitOrderCell.class,
                                    new DailyLimitOrderCellTools(cellContext,sheet.getSheetName()))
                                    .sheet(sheet.getSheetName()).headRowNumber(4).doRead();
                        }else if(sheet.getSheetName().indexOf("追涨停模型")>=0){
                            EasyExcel.read(file, WillDailyLimitCell.class,
                                    new WillDailyLimitCellTools(cellContext,sheet.getSheetName()))
                                    .sheet(sheet.getSheetName()).headRowNumber(4).doRead();
                        }else if(sheet.getSheetName().indexOf("债券套利")>=0){
                            EasyExcel.read(file, BondArbitrageCell.class,
                                    new BondArbitrageCellTools(cellContext,sheet.getSheetName()))
                                    .sheet(sheet.getSheetName()).headRowNumber(4).doRead();
                        }else if(sheet.getSheetName().indexOf("量化-非高频")>=0){
                            EasyExcel.read(file, QuantificationNonHighFrequencyCell.class,
                                    new QuantificationNonHighFrequencyCellTools(cellContext,sheet.getSheetName()))
                                    .sheet(sheet.getSheetName()).headRowNumber(5).doRead();
                        }else if(sheet.getSheetName().indexOf("股票数据汇总")>=0){
                            EasyExcel.read(file, StockDataSummaryCell.class,
                                    new StockDataSummaryCellTools(cellContext,sheet.getSheetName()))
                                    .sheet(sheet.getSheetName()).headRowNumber(4).doRead();
                        }
                    }
                }catch (Exception e) {
                    LOGGER.error("文件-{}读取失败;",file.getName());
                }
            }
            DataToTable.getInstance().dataToTable(cellContext);
            CellWriter2Word.getInstance().writeWord(cellContext);
        }catch (Exception e) {
            LOGGER.error("ExcelToWordTest error {}",e);
        }
    }
}
