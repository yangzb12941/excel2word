package com.wy.dataProcess;

import com.wy.entity.AgeCellEntity;
import com.wy.excelCell.*;
import com.wy.utils.GetYear;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AgeProcess implements IProcess<ExcelCell> {

    @Override
    public List<AgeCellEntity> process(List<ExcelCell> rawMaterial,Class zlass) {
        List<AgeCellEntity> ageCellEntitys = excelDataToDaoModel(rawMaterial,zlass);
        return ageCellEntitys;
    }

    private List<AgeCellEntity> excelDataToDaoModel(List rawMaterial,Class zlass){
        List<AgeCellEntity> excelCellList = new ArrayList<AgeCellEntity>(rawMaterial.size());
        AgeCellEntity ageCellEntity = new AgeCellEntity();
        excelCellList.add(ageCellEntity);
        String 大类 = "";
        Integer 总量 = 0;
        Integer 前1985 = 0;
        Integer 之间1985_1995 = 0;
        Integer 后1995 = 0;
        Double 占比1985 = 0d;
        Double 占比1995 = 0d;
        if(zlass.isInstance(BondArbitrageCell.class)){
            List<BondArbitrageCell> cells = (List<BondArbitrageCell>)rawMaterial;
            List<BondArbitrageCell> filterCollect = cells.stream().filter(e -> !e.get客户类型().equals("产品") && !e.get出生年月日().equals("0")).collect(Collectors.toList());
            Map<String, List<BondArbitrageCell>> mapCollect = filterCollect.stream().collect(Collectors.groupingBy(e -> e.get资金账号()));
            大类 = "债券套利";
            总量 = mapCollect.size();
            for (Map.Entry<String, List<BondArbitrageCell>> item:mapCollect.entrySet()) {
                List<BondArbitrageCell> value = item.getValue();
                if(!CollectionUtils.isEmpty(value)){
                    BondArbitrageCell bondArbitrageCell = value.get(0);
                    Integer year = GetYear.getYear(bondArbitrageCell.get出生年月日());
                    if(year<=1985){
                        前1985++;
                    }else if(year>1985 && year<1995){
                        之间1985_1995++;
                    }else if(year>=1995){
                        后1995++;
                    }
                }
            }
            占比1985 = (总量-前1985)/(总量*1.0);
            占比1995 = 后1995/(总量*1.0);
        }else if(zlass.isInstance(DailyLimitOrderCell.class)){
            List<DailyLimitOrderCell> cells = (List<DailyLimitOrderCell>)rawMaterial;
            List<DailyLimitOrderCell> filterCollect = cells.stream().filter(e -> !e.get客户类型().equals("产品") && !e.get出生年月日().equals("0")).collect(Collectors.toList());
            Map<String, List<DailyLimitOrderCell>> mapCollect = filterCollect.stream().collect(Collectors.groupingBy(e -> e.get资金账号()));
            大类 = "涨停板敢死队";
            总量 = mapCollect.size();
            for (Map.Entry<String, List<DailyLimitOrderCell>> item:mapCollect.entrySet()) {
                List<DailyLimitOrderCell> value = item.getValue();
                if(!CollectionUtils.isEmpty(value)){
                    DailyLimitOrderCell dailyLimitOrderCell = value.get(0);
                    Integer year = GetYear.getYear(dailyLimitOrderCell.get出生年月日());
                    if(year<=1985){
                        前1985++;
                    }else if(year>1985 && year<1995){
                        之间1985_1995++;
                    }else if(year>=1995){
                        后1995++;
                    }
                }
            }
            占比1985 = (总量-前1985)/(总量*1.0);
            占比1995 = 后1995/(总量*1.0);
        }else if(zlass.isInstance(NightOrderCell.class)){
            List<NightOrderCell> cells = (List<NightOrderCell>)rawMaterial;
            List<NightOrderCell> filterCollect = cells.stream().filter(e -> !e.get客户类型().equals("产品") && !e.get出生年月日().equals("0")).collect(Collectors.toList());
            Map<String, List<NightOrderCell>> mapCollect = filterCollect.stream().collect(Collectors.groupingBy(e -> e.get资金账号()));
            大类 = "夜盘委托";
            总量 = mapCollect.size();
            for (Map.Entry<String, List<NightOrderCell>> item:mapCollect.entrySet()) {
                List<NightOrderCell> value = item.getValue();
                if(!CollectionUtils.isEmpty(value)){
                    NightOrderCell nightOrderCell = value.get(0);
                    Integer year = GetYear.getYear(nightOrderCell.get出生年月日());
                    if(year<=1985){
                        前1985++;
                    }else if(year>1985 && year<1995){
                        之间1985_1995++;
                    }else if(year>=1995){
                        后1995++;
                    }
                }
            }
            占比1985 = (总量-前1985)/(总量*1.0);
            占比1995 = 后1995/(总量*1.0);
        }else if(zlass.isInstance(PositionBuildingCell.class)){
            List<PositionBuildingCell> cells = (List<PositionBuildingCell>)rawMaterial;
            List<PositionBuildingCell> filterCollect = cells.stream().filter(e -> !e.get客户类型().equals("产品") && !e.get出生年月日().equals("0")).collect(Collectors.toList());
            Map<String, List<PositionBuildingCell>> mapCollect = filterCollect.stream().collect(Collectors.groupingBy(e -> e.get客户号()));
            大类 = "建仓型";
            总量 = mapCollect.size();
            for (Map.Entry<String, List<PositionBuildingCell>> item:mapCollect.entrySet()) {
                List<PositionBuildingCell> value = item.getValue();
                if(!CollectionUtils.isEmpty(value)){
                    PositionBuildingCell positionBuildingCell = value.get(0);
                    Integer year = GetYear.getYear(positionBuildingCell.get出生年月日());
                    if(year<=1985){
                        前1985++;
                    }else if(year>1985 && year<1995){
                        之间1985_1995++;
                    }else if(year>=1995){
                        后1995++;
                    }
                }
            }
            占比1985 = (总量-前1985)/(总量*1.0);
            占比1995 = 后1995/(总量*1.0);
        }else if(zlass.isInstance(QuantificationNonHighFrequencyCell.class)){
            List<QuantificationNonHighFrequencyCell> cells = (List<QuantificationNonHighFrequencyCell>)rawMaterial;
            List<QuantificationNonHighFrequencyCell> filterCollect = cells.stream().filter(e -> !e.get客户类型().equals("产品") && !e.get出生年月日().equals("0")).collect(Collectors.toList());
            Map<String, List<QuantificationNonHighFrequencyCell>> mapCollect = filterCollect.stream().collect(Collectors.groupingBy(e -> e.get资金账号()));
            大类 = "量化-非高频";
            总量 = mapCollect.size();
            for (Map.Entry<String, List<QuantificationNonHighFrequencyCell>> item:mapCollect.entrySet()) {
                List<QuantificationNonHighFrequencyCell> value = item.getValue();
                if(!CollectionUtils.isEmpty(value)){
                    QuantificationNonHighFrequencyCell quantificationNonHighFrequencyCell = value.get(0);
                    Integer year = GetYear.getYear(quantificationNonHighFrequencyCell.get出生年月日());
                    if(year<=1985){
                        前1985++;
                    }else if(year>1985 && year<1995){
                        之间1985_1995++;
                    }else if(year>=1995){
                        后1995++;
                    }
                }
            }
            占比1985 = (总量-前1985)/(总量*1.0);
            占比1995 = 后1995/(总量*1.0);
        }else if(zlass.isInstance(StockDataSummaryCell.class)){
            List<StockDataSummaryCell> cells = (List<StockDataSummaryCell>)rawMaterial;
            List<StockDataSummaryCell> filterCollect = cells.stream().filter(e -> !e.get客户类型().equals("产品") && !e.get出生年月日().equals("0")).collect(Collectors.toList());
            Map<String, List<StockDataSummaryCell>> mapCollect = filterCollect.stream().collect(Collectors.groupingBy(e -> e.get资金账号()));
            大类 = "股票数据汇总";
            总量 = mapCollect.size();
            for (Map.Entry<String, List<StockDataSummaryCell>> item:mapCollect.entrySet()) {
                List<StockDataSummaryCell> value = item.getValue();
                if(!CollectionUtils.isEmpty(value)){
                    StockDataSummaryCell stockDataSummaryCell = value.get(0);
                    Integer year = GetYear.getYear(stockDataSummaryCell.get出生年月日());
                    if(year<=1985){
                        前1985++;
                    }else if(year>1985 && year<1995){
                        之间1985_1995++;
                    }else if(year>=1995){
                        后1995++;
                    }
                }
            }
            占比1985 = (总量-前1985)/(总量*1.0);
            占比1995 = 后1995/(总量*1.0);
        }else if(zlass.isInstance(WillDailyLimitCell.class)){
            List<WillDailyLimitCell> cells = (List<WillDailyLimitCell>)rawMaterial;
            List<WillDailyLimitCell> filterCollect = cells.stream().filter(e -> !e.get客户类型().equals("产品") && !e.get出生年月日().equals("0")).collect(Collectors.toList());
            Map<String, List<WillDailyLimitCell>> mapCollect = filterCollect.stream().collect(Collectors.groupingBy(e -> e.get资金账号()));
            大类 = "追涨停模型";
            总量 = mapCollect.size();
            for (Map.Entry<String, List<WillDailyLimitCell>> item:mapCollect.entrySet()) {
                List<WillDailyLimitCell> value = item.getValue();
                if(!CollectionUtils.isEmpty(value)){
                    WillDailyLimitCell sillDailyLimitCell = value.get(0);
                    Integer year = GetYear.getYear(sillDailyLimitCell.get出生年月日());
                    if(year<=1985){
                        前1985++;
                    }else if(year>1985 && year<1995){
                        之间1985_1995++;
                    }else if(year>=1995){
                        后1995++;
                    }
                }
            }
            占比1985 = (总量-前1985)/(总量*1.0);
            占比1995 = 后1995/(总量*1.0);
        }
        ageCellEntity.set总量(总量.toString());
        ageCellEntity.set前1985(前1985.toString());
        ageCellEntity.set之间1985_1995(之间1985_1995.toString());
        ageCellEntity.set后1995(后1995.toString());
        ageCellEntity.set占比1985(String.format("%.3f",占比1985));
        ageCellEntity.set占比1995(String.format("%.3f",占比1995));
        ageCellEntity.set大类(大类);
        return excelCellList;
    }
}
