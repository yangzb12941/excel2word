package com.wy.dataProcess;

import com.wy.entity.*;
import com.wy.excelCell.*;
import com.wy.wordWriter.CellWriter2Word;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * 把数据转换成对应的Table数据
 */
public class DataToTable {
    private static final Logger LOGGER = LoggerFactory.getLogger(DataToTable.class);
    private volatile static DataToTable dataToTable = null;

    private DataToTable() {}

    public static DataToTable getInstance(){
        if(Objects.isNull(dataToTable)){
            synchronized (CellWriter2Word.class){
                if(Objects.nonNull(dataToTable)){
                    return dataToTable;
                }else{
                    dataToTable = new DataToTable();
                    return dataToTable;
                }
            }
        }else{
            return dataToTable;
        }
    }

    public void dataToTable(CellContext cellContext){
        nativeDataToTable(cellContext);
        ageDataToTable(cellContext);
        amountDataToTable(cellContext);
        educationDataToTable(cellContext);
        emphasisDataToTable(cellContext);
    }

    private void nativeDataToTable(CellContext cellContext){
        HashMap<String,List<ExcelCell>> allExcelCellMap = cellContext.getAllExcelCellMap();
        NativeProcess nativeProcess = new NativeProcess();
        //遍历数据
        for (Map.Entry<String, List<ExcelCell>> mapEntry : allExcelCellMap.entrySet()) {
            String key = mapEntry.getKey();
            List<ExcelCell> excelCells = mapEntry.getValue();
            Class zlass = getZlass(key);
            List<WordTableModelEntity> processReturn = nativeProcess.process(excelCells, zlass);
            HashMap itmesMap = cellContext.getItmesMap();
            if(itmesMap.containsKey(key)){
                ((ArrayList<CellEntity>) itmesMap.get(key)).addAll(processReturn);
            }else{
                itmesMap.put(key, processReturn);
            }
        }
    }

    private void ageDataToTable(CellContext cellContext){
        HashMap<String,List<ExcelCell>> allExcelCellMap = cellContext.getAllExcelCellMap();
        String tableName = "年龄统计";
        AgeProcess process = new AgeProcess();
        //遍历数据
        for (Map.Entry<String, List<ExcelCell>> mapEntry : allExcelCellMap.entrySet()) {
            List<ExcelCell> excelCells = mapEntry.getValue();
            String key = mapEntry.getKey();
            Class zlass = getZlass(key);
            List<AgeCellEntity> processReturn = process.process(excelCells, zlass);
            HashMap itmesMap = cellContext.getItmesMap();
            if(itmesMap.containsKey(tableName)){
                ((ArrayList<CellEntity>) itmesMap.get(tableName)).addAll(processReturn);
            }else{
                itmesMap.put(tableName, processReturn);
            }
        }
    }

    private void amountDataToTable(CellContext cellContext){
        HashMap<String,List<ExcelCell>> allExcelCellMap = cellContext.getAllExcelCellMap();
        String tableName = "数量统计";
        AmountProcess process = new AmountProcess();
        //遍历数据
        for (Map.Entry<String, List<ExcelCell>> mapEntry : allExcelCellMap.entrySet()) {
            List<ExcelCell> excelCells = mapEntry.getValue();
            String key = mapEntry.getKey();
            Class zlass = getZlass(key);
            List<AmountCellEntity> processReturn = process.process(excelCells, zlass);
            HashMap itmesMap = cellContext.getItmesMap();
            if(itmesMap.containsKey(tableName)){
                ((ArrayList<CellEntity>) itmesMap.get(tableName)).addAll(processReturn);
            }else{
                itmesMap.put(tableName, processReturn);
            }
        }
    }

    private void educationDataToTable(CellContext cellContext){
        HashMap<String,List<ExcelCell>> allExcelCellMap = cellContext.getAllExcelCellMap();
        String tableName = "学历统计";
        EducationProcess process = new EducationProcess();
        //遍历数据
        for (Map.Entry<String, List<ExcelCell>> mapEntry : allExcelCellMap.entrySet()) {
            List<ExcelCell> excelCells = mapEntry.getValue();
            String key = mapEntry.getKey();
            Class zlass = getZlass(key);
            List<EducationCellEntity> processReturn = process.process(excelCells, zlass);
            HashMap itmesMap = cellContext.getItmesMap();
            if(itmesMap.containsKey(tableName)){
                ((ArrayList<CellEntity>) itmesMap.get(tableName)).addAll(processReturn);
            }else{
                itmesMap.put(tableName, processReturn);
            }
        }
    }

    private void emphasisDataToTable(CellContext cellContext){
        HashMap<String,List<ExcelCell>> allExcelCellMap = cellContext.getAllExcelCellMap();
        String tableName = "重点关注";
        EmphasisProcess process = new EmphasisProcess();
        //遍历数据
        for (Map.Entry<String, List<ExcelCell>> mapEntry : allExcelCellMap.entrySet()) {
            List<ExcelCell> excelCells = mapEntry.getValue();
            String key = mapEntry.getKey();
            Class zlass = getZlass(key);
            List<EmphasisCellEntity> processReturn = process.process(excelCells, zlass);
            HashMap itmesMap = cellContext.getItmesMap();
            if(itmesMap.containsKey(tableName)){
                ((ArrayList<CellEntity>) itmesMap.get(tableName)).addAll(processReturn);
            }else{
                itmesMap.put(tableName, processReturn);
            }
        }
    }

    private Class getZlass(String key){
        Class zlass = null;
        if(key.indexOf("夜盘委托")>=0){
            zlass = NightOrderCell.class;
        }else if(key.indexOf("涨停板敢死队")>=0){
            zlass = DailyLimitOrderCell.class;
        }else if(key.indexOf("追涨停模型")>=0){
            zlass = WillDailyLimitCell.class;
        }else if(key.indexOf("债券套利")>=0){
            zlass = BondArbitrageCell.class;
        }else if(key.indexOf("量化-非高频")>=0){
            zlass = QuantificationNonHighFrequencyCell.class;
        }else if(key.indexOf("股票数据汇总")>=0){
            zlass = StockDataSummaryCell.class;
        }
        return zlass;
    }
}
