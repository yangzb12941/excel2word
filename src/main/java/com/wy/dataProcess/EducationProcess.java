package com.wy.dataProcess;

import com.wy.entity.EducationCellEntity;
import com.wy.excelCell.*;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EducationProcess implements IProcess<ExcelCell>{
    @Override
    public List<EducationCellEntity> process(List<ExcelCell> rawMaterial, Class zlass) {
        List<EducationCellEntity> ageCellEntitys = excelDataToDaoModel(rawMaterial,zlass);
        return ageCellEntitys;
    }

    private List<EducationCellEntity> excelDataToDaoModel(List rawMaterial,Class zlass){
        List<EducationCellEntity> excelCellList = new ArrayList<EducationCellEntity>(rawMaterial.size());
        EducationCellEntity educationCellEntity = new EducationCellEntity();
        excelCellList.add(educationCellEntity);
        String 大类 = "";
        Integer 总量 = 0;
        Integer 本科以下 = 0;
        Integer 本科 = 0;
        Integer 硕博 = 0;
        Double 本科以上占比 = 0d;
        if(zlass == (BondArbitrageCell.class)){
            List<BondArbitrageCell> cells = (List<BondArbitrageCell>)rawMaterial;
            List<BondArbitrageCell> filterCollect = cells.stream().filter(e -> !e.get客户类型().equals("产品") && !e.get出生年月日().equals("0")).collect(Collectors.toList());
            Map<String, List<BondArbitrageCell>> mapCollect = filterCollect.stream().collect(Collectors.groupingBy(e -> e.get资金账号()));
            大类 = "债券套利";
            总量 = mapCollect.size();
            for (Map.Entry<String, List<BondArbitrageCell>> item:mapCollect.entrySet()) {
                List<BondArbitrageCell> value = item.getValue();
                if(!CollectionUtils.isEmpty(value)){
                    BondArbitrageCell valueItem = value.get(0);
                    Integer education = Integer.valueOf(valueItem.get学历());
                    if(education<=3){
                        硕博++;
                    }else if(education == 3){
                        本科++;
                    }else if(本科<3){
                        本科以下++;
                    }
                }
            }
            本科以上占比 = (总量-本科以下)/(总量*1.0)*100;
        }else if(zlass == (DailyLimitOrderCell.class)){
            List<DailyLimitOrderCell> cells = (List<DailyLimitOrderCell>)rawMaterial;
            List<DailyLimitOrderCell> filterCollect = cells.stream().filter(e -> !e.get客户类型().equals("产品") && !e.get出生年月日().equals("0")).collect(Collectors.toList());
            Map<String, List<DailyLimitOrderCell>> mapCollect = filterCollect.stream().collect(Collectors.groupingBy(e -> e.get资金账号()));
            大类 = "涨停板敢死队";
            总量 = mapCollect.size();
            for (Map.Entry<String, List<DailyLimitOrderCell>> item:mapCollect.entrySet()) {
                List<DailyLimitOrderCell> value = item.getValue();
                if(!CollectionUtils.isEmpty(value)){
                    DailyLimitOrderCell valueItem = value.get(0);
                    Integer education = Integer.valueOf(valueItem.get学历());
                    if(education<=3){
                        硕博++;
                    }else if(education == 3){
                        本科++;
                    }else if(本科<3){
                        本科以下++;
                    }
                }
            }
            本科以上占比 = (总量-本科以下)/(总量*1.0)*100;
        }else if(zlass == (NightOrderCell.class)){
            List<NightOrderCell> cells = (List<NightOrderCell>)rawMaterial;
            List<NightOrderCell> filterCollect = cells.stream().filter(e -> !e.get客户类型().equals("产品") && !e.get出生年月日().equals("0")).collect(Collectors.toList());
            Map<String, List<NightOrderCell>> mapCollect = filterCollect.stream().collect(Collectors.groupingBy(e -> e.get资金账号()));
            大类 = "夜盘委托";
            总量 = mapCollect.size();
            for (Map.Entry<String, List<NightOrderCell>> item:mapCollect.entrySet()) {
                List<NightOrderCell> value = item.getValue();
                if(!CollectionUtils.isEmpty(value)){
                    NightOrderCell valueItem = value.get(0);
                    Integer education = Integer.valueOf(valueItem.get学历());
                    if(education<=3){
                        硕博++;
                    }else if(education == 3){
                        本科++;
                    }else if(本科<3){
                        本科以下++;
                    }
                }
            }
            本科以上占比 = (总量-本科以下)/(总量*1.0)*100;
        }else if(zlass == (PositionBuildingCell.class)){
            List<PositionBuildingCell> cells = (List<PositionBuildingCell>)rawMaterial;
            List<PositionBuildingCell> filterCollect = cells.stream().filter(e -> !e.get客户类型().equals("产品") && !e.get出生年月日().equals("0")).collect(Collectors.toList());
            Map<String, List<PositionBuildingCell>> mapCollect = filterCollect.stream().collect(Collectors.groupingBy(e -> e.get客户号()));
            大类 = "建仓型";
            总量 = mapCollect.size();
            for (Map.Entry<String, List<PositionBuildingCell>> item:mapCollect.entrySet()) {
                List<PositionBuildingCell> value = item.getValue();
                if(!CollectionUtils.isEmpty(value)){
                    PositionBuildingCell valueItem = value.get(0);
                    Integer education = Integer.valueOf(valueItem.get学历());
                    if(education<=3){
                        硕博++;
                    }else if(education == 3){
                        本科++;
                    }else if(本科<3){
                        本科以下++;
                    }
                }
            }
            本科以上占比 = (总量-本科以下)/(总量*1.0)*100;
        }else if(zlass == (QuantificationNonHighFrequencyCell.class)){
            List<QuantificationNonHighFrequencyCell> cells = (List<QuantificationNonHighFrequencyCell>)rawMaterial;
            List<QuantificationNonHighFrequencyCell> filterCollect = cells.stream().filter(e -> !e.get客户类型().equals("产品") && !e.get出生年月日().equals("0")).collect(Collectors.toList());
            Map<String, List<QuantificationNonHighFrequencyCell>> mapCollect = filterCollect.stream().collect(Collectors.groupingBy(e -> e.get资金账号()));
            大类 = "量化-非高频";
            总量 = mapCollect.size();
            for (Map.Entry<String, List<QuantificationNonHighFrequencyCell>> item:mapCollect.entrySet()) {
                List<QuantificationNonHighFrequencyCell> value = item.getValue();
                if(!CollectionUtils.isEmpty(value)){
                    QuantificationNonHighFrequencyCell valueItem = value.get(0);
                    Integer education = Integer.valueOf(valueItem.get学历());
                    if(education<=3){
                        硕博++;
                    }else if(education == 3){
                        本科++;
                    }else if(本科<3){
                        本科以下++;
                    }
                }
            }
            本科以上占比 = (总量-本科以下)/(总量*1.0)*100;
        }else if(zlass == (StockDataSummaryCell.class)){
            List<StockDataSummaryCell> cells = (List<StockDataSummaryCell>)rawMaterial;
            List<StockDataSummaryCell> filterCollect = cells.stream().filter(e -> !e.get客户类型().equals("产品") && !e.get出生年月日().equals("0")).collect(Collectors.toList());
            Map<String, List<StockDataSummaryCell>> mapCollect = filterCollect.stream().collect(Collectors.groupingBy(e -> e.get资金账号()));
            大类 = "股票数据汇总";
            总量 = mapCollect.size();
            for (Map.Entry<String, List<StockDataSummaryCell>> item:mapCollect.entrySet()) {
                List<StockDataSummaryCell> value = item.getValue();
                if(!CollectionUtils.isEmpty(value)){
                    StockDataSummaryCell valueItem = value.get(0);
                    Integer education = Integer.valueOf(valueItem.get学历());
                    if(education<=3){
                        硕博++;
                    }else if(education == 3){
                        本科++;
                    }else if(本科<3){
                        本科以下++;
                    }
                }
            }
            本科以上占比 = (总量-本科以下)/(总量*1.0)*100;
        }else if(zlass == (WillDailyLimitCell.class)){
            List<WillDailyLimitCell> cells = (List<WillDailyLimitCell>)rawMaterial;
            List<WillDailyLimitCell> filterCollect = cells.stream().filter(e -> !e.get客户类型().equals("产品") && !e.get出生年月日().equals("0")).collect(Collectors.toList());
            Map<String, List<WillDailyLimitCell>> mapCollect = filterCollect.stream().collect(Collectors.groupingBy(e -> e.get资金账号()));
            大类 = "追涨停模型";
            总量 = mapCollect.size();
            for (Map.Entry<String, List<WillDailyLimitCell>> item:mapCollect.entrySet()) {
                List<WillDailyLimitCell> value = item.getValue();
                if(!CollectionUtils.isEmpty(value)){
                    WillDailyLimitCell valueItem = value.get(0);
                    Integer education = Integer.valueOf(valueItem.get学历());
                    if(education<=3){
                        硕博++;
                    }else if(education == 3){
                        本科++;
                    }else if(本科<3){
                        本科以下++;
                    }
                }
            }
            本科以上占比 = (总量-本科以下)/(总量*1.0)*100;
        }
        educationCellEntity.set总量(总量.toString());
        educationCellEntity.set本科(本科.toString());
        educationCellEntity.set本科以下(本科以下.toString());
        educationCellEntity.set硕博(硕博.toString());
        educationCellEntity.set本科以上占比(String.format("%.3f",本科以上占比)+"%");
        educationCellEntity.set大类(大类);
        return excelCellList;
    }
}
