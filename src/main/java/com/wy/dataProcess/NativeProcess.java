package com.wy.dataProcess;

import com.wy.entity.WordTableModelEntity;
import com.wy.excelCell.*;
import java.util.ArrayList;
import java.util.List;

public class NativeProcess implements IProcess<ExcelCell>{

    @Override
    public List<WordTableModelEntity> process(List rawMaterial) {
        List<WordTableModelEntity> wordTableModelEntities = excelDataToDaoModel(rawMaterial);
        return wordTableModelEntities;
    }

    private List<WordTableModelEntity> excelDataToDaoModel(List rawMaterial){
        List<WordTableModelEntity> excelCellList = new ArrayList<WordTableModelEntity>(rawMaterial.size());
        rawMaterial.stream().forEach((e)->{
            WordTableModelEntity excelCell = new WordTableModelEntity();
            if(e instanceof BondArbitrageCell){
                BondArbitrageCell element = (BondArbitrageCell) e;
                excelCell.set账户(element.get资金账号());
                excelCell.set营业部(element.get营业部());
                excelCell.set客户类型(element.get客户类型());
                excelCell.set服务人员姓名(element.get服务人员姓名());
                excelCell.set服务人员编号(element.get服务人员编号());
                excelCell.set服务人员团队(element.get服务人员团队());
                excelCell.set使用系统(element.get使用系统());
                excelCell.set学历(element.get学历());
                excelCell.set年份("");
                excelCellList.add(excelCell);
            }else if(e instanceof DailyLimitOrderCell){
                DailyLimitOrderCell element = (DailyLimitOrderCell) e;
                excelCell.set账户(element.get资金账号());
                excelCell.set营业部(element.get营业部());
                excelCell.set客户类型(element.get客户类型());
                excelCell.set服务人员姓名(element.get服务人员姓名());
                excelCell.set服务人员编号(element.get服务人员编号());
                excelCell.set服务人员团队(element.get服务人员团队());
                excelCell.set使用系统(element.get使用系统());
                excelCell.set学历(element.get学历());
                excelCell.set年份("");
                excelCellList.add(excelCell);
            }else if(e instanceof NightOrderCell){
                NightOrderCell element = (NightOrderCell) e;
                excelCell.set账户(element.get资金账号());
                excelCell.set营业部(element.get营业部());
                excelCell.set客户类型(element.get客户类型());
                excelCell.set服务人员姓名(element.get服务人员姓名());
                excelCell.set服务人员编号(element.get服务人员编号());
                excelCell.set服务人员团队(element.get服务人员团队());
                excelCell.set使用系统(element.get使用系统());
                excelCell.set学历(element.get学历());
                excelCell.set年份("");
                excelCellList.add(excelCell);
            }else if(e instanceof PositionBuildingCell){
                PositionBuildingCell element = (PositionBuildingCell) e;
                excelCell.set账户(element.get客户号());
                excelCell.set营业部(element.get营业部());
                excelCell.set客户类型(element.get客户类型());
                excelCell.set服务人员姓名(element.get服务人员姓名());
                excelCell.set服务人员编号(element.get服务人员编号());
                excelCell.set服务人员团队(element.get服务人员团队());
                excelCell.set使用系统(element.get使用系统());
                excelCell.set学历(element.get学历());
                excelCell.set年份("");
                excelCellList.add(excelCell);
            }else if(e instanceof QuantificationNonHighFrequencyCell){
                QuantificationNonHighFrequencyCell element = (QuantificationNonHighFrequencyCell) e;
                excelCell.set账户(element.get资金账号());
                excelCell.set营业部(element.get营业部());
                excelCell.set客户类型(element.get客户类型());
                excelCell.set服务人员姓名(element.get服务人员姓名());
                excelCell.set服务人员编号(element.get服务人员编号());
                excelCell.set服务人员团队(element.get服务人员团队());
                excelCell.set使用系统(element.get使用系统());
                excelCell.set学历(element.get学历());
                excelCell.set年份("");
                excelCellList.add(excelCell);
            }else if(e instanceof StockDataSummaryCell){
                StockDataSummaryCell element = (StockDataSummaryCell) e;
                excelCell.set账户(element.get资金账号());
                excelCell.set营业部(element.get营业部());
                excelCell.set客户类型(element.get客户类型());
                excelCell.set服务人员姓名(element.get服务人员姓名());
                excelCell.set服务人员编号(element.get服务人员编号());
                excelCell.set服务人员团队(element.get服务人员团队());
                excelCell.set使用系统(element.get使用系统());
                excelCell.set学历(element.get学历());
                excelCell.set年份("");
                excelCellList.add(excelCell);
            }else if(e instanceof WillDailyLimitCell){
                WillDailyLimitCell element = (WillDailyLimitCell) e;
                excelCell.set账户(element.get资金账号());
                excelCell.set营业部(element.get营业部());
                excelCell.set客户类型(element.get客户类型());
                excelCell.set服务人员姓名(element.get服务人员姓名());
                excelCell.set服务人员编号(element.get服务人员编号());
                excelCell.set服务人员团队(element.get服务人员团队());
                excelCell.set使用系统(element.get使用系统());
                excelCell.set学历(element.get学历());
                excelCell.set年份("");
                excelCellList.add(excelCell);
            }
        });
        return excelCellList;
    }
}
