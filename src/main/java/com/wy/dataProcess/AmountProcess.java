package com.wy.dataProcess;

import com.wy.entity.AmountCellEntity;
import com.wy.excelCell.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AmountProcess implements IProcess<ExcelCell>{
    @Override
    public List<AmountCellEntity> process(List<ExcelCell> rawMaterial, Class zlass) {
        List<AmountCellEntity> ageCellEntitys = excelDataToDaoModel(rawMaterial,zlass);
        return ageCellEntitys;
    }

    private List<AmountCellEntity> excelDataToDaoModel(List rawMaterial,Class zlass){
        List<AmountCellEntity> excelCellList = new ArrayList<AmountCellEntity>(rawMaterial.size());
        AmountCellEntity amountCellEntity = new AmountCellEntity();
        excelCellList.add(amountCellEntity);
        String 大类 = "";
        Integer 数量 = 0;

        if(zlass.isInstance(BondArbitrageCell.class)){
            List<BondArbitrageCell> cells = (List<BondArbitrageCell>)rawMaterial;
            List<BondArbitrageCell> filterCollect = cells.stream().filter(e -> !e.get客户类型().equals("产品") && !e.get出生年月日().equals("0")).collect(Collectors.toList());
            Map<String, List<BondArbitrageCell>> mapCollect = filterCollect.stream().collect(Collectors.groupingBy(e -> e.get资金账号()));
            大类 = "债券套利";
            数量 = mapCollect.size();
        }else if(zlass.isInstance(DailyLimitOrderCell.class)){
            List<DailyLimitOrderCell> cells = (List<DailyLimitOrderCell>)rawMaterial;
            List<DailyLimitOrderCell> filterCollect = cells.stream().filter(e -> !e.get客户类型().equals("产品") && !e.get出生年月日().equals("0")).collect(Collectors.toList());
            Map<String, List<DailyLimitOrderCell>> mapCollect = filterCollect.stream().collect(Collectors.groupingBy(e -> e.get资金账号()));
            大类 = "涨停板敢死队";
            数量 = mapCollect.size();
        }else if(zlass.isInstance(NightOrderCell.class)){
            List<NightOrderCell> cells = (List<NightOrderCell>)rawMaterial;
            List<NightOrderCell> filterCollect = cells.stream().filter(e -> !e.get客户类型().equals("产品") && !e.get出生年月日().equals("0")).collect(Collectors.toList());
            Map<String, List<NightOrderCell>> mapCollect = filterCollect.stream().collect(Collectors.groupingBy(e -> e.get资金账号()));
            大类 = "夜盘委托";
            数量 = mapCollect.size();
        }else if(zlass.isInstance(PositionBuildingCell.class)){
            List<PositionBuildingCell> cells = (List<PositionBuildingCell>)rawMaterial;
            List<PositionBuildingCell> filterCollect = cells.stream().filter(e -> !e.get客户类型().equals("产品") && !e.get出生年月日().equals("0")).collect(Collectors.toList());
            Map<String, List<PositionBuildingCell>> mapCollect = filterCollect.stream().collect(Collectors.groupingBy(e -> e.get客户号()));
            大类 = "建仓型";
            数量 = mapCollect.size();
        }else if(zlass.isInstance(QuantificationNonHighFrequencyCell.class)){
            List<QuantificationNonHighFrequencyCell> cells = (List<QuantificationNonHighFrequencyCell>)rawMaterial;
            List<QuantificationNonHighFrequencyCell> filterCollect = cells.stream().filter(e -> !e.get客户类型().equals("产品") && !e.get出生年月日().equals("0")).collect(Collectors.toList());
            Map<String, List<QuantificationNonHighFrequencyCell>> mapCollect = filterCollect.stream().collect(Collectors.groupingBy(e -> e.get资金账号()));
            大类 = "量化-非高频";
        }else if(zlass.isInstance(StockDataSummaryCell.class)){
            List<StockDataSummaryCell> cells = (List<StockDataSummaryCell>)rawMaterial;
            List<StockDataSummaryCell> filterCollect = cells.stream().filter(e -> !e.get客户类型().equals("产品") && !e.get出生年月日().equals("0")).collect(Collectors.toList());
            Map<String, List<StockDataSummaryCell>> mapCollect = filterCollect.stream().collect(Collectors.groupingBy(e -> e.get资金账号()));
            大类 = "股票数据汇总";
            数量 = mapCollect.size();
        }else if(zlass.isInstance(WillDailyLimitCell.class)){
            List<WillDailyLimitCell> cells = (List<WillDailyLimitCell>)rawMaterial;
            List<WillDailyLimitCell> filterCollect = cells.stream().filter(e -> !e.get客户类型().equals("产品") && !e.get出生年月日().equals("0")).collect(Collectors.toList());
            Map<String, List<WillDailyLimitCell>> mapCollect = filterCollect.stream().collect(Collectors.groupingBy(e -> e.get资金账号()));
            大类 = "追涨停模型";
            数量 = mapCollect.size();
        }
        amountCellEntity.set数量(数量.toString());
        amountCellEntity.set大类(大类);
        return excelCellList;
    }
}
