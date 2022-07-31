package com.wy.dataProcess;

import com.wy.configuration.Transaction2Introduce;
import com.wy.configuration.Transaction2Sys;
import com.wy.entity.EmphasisCellEntity;
import com.wy.excelCell.*;
import com.wy.utils.GetYear;

import java.util.ArrayList;
import java.util.List;

public class EmphasisProcess implements IProcess<ExcelCell>{
    @Override
    public List<EmphasisCellEntity> process(List rawMaterial, Class zlass) {
        List<EmphasisCellEntity> wordTableModelEntities = excelDataToDaoModel(rawMaterial,zlass);
        return wordTableModelEntities;
    }

    private List<EmphasisCellEntity> excelDataToDaoModel(List rawMaterial,Class zlass){
        List<EmphasisCellEntity> excelCellList = new ArrayList<EmphasisCellEntity>(rawMaterial.size());
        if(zlass == (BondArbitrageCell.class)){
            List<BondArbitrageCell> cells = (List<BondArbitrageCell>)rawMaterial;
            cells.stream().forEach((element)->{
                if(Double.valueOf(element.get总资产()).compareTo(10000000d)>=0){
                    EmphasisCellEntity excelCell = new EmphasisCellEntity();
                    excelCell.set服务人员编号(element.get服务人员编号());
                    excelCell.set服务人员(element.get服务人员姓名());
                    excelCell.set客户资金账号(element.get资金账号());
                    excelCell.set交易日期(element.get批量日期());
                    excelCell.set总资产(element.get总资产());
                    excelCell.set可用资金("0");
                    excelCell.set现金资产("0");
                    excelCell.set使用系统(element.get使用系统());
                    excelCell.set出生年份(GetYear.getYear(element.get出生年月日()).toString());
                    excelCell.set交易意向("债券套利");
                    excelCell.set适用系统(Transaction2Sys.getMap().get("债券套利"));
                    excelCell.set介绍物料(Transaction2Introduce.getMap().get("债券套利"));
                    excelCellList.add(excelCell);
                }
            });
        }else if(zlass == (DailyLimitOrderCell.class)){
            List<DailyLimitOrderCell> cells = (List<DailyLimitOrderCell>)rawMaterial;
            cells.stream().forEach((element)->{
                if(Double.valueOf(element.get总资产()).compareTo(10000000d)>=0 && (
                   Double.valueOf(element.get可用资金()).compareTo(1000000d)>=0 ||
                   Double.valueOf(element.get现金资产()).compareTo(1000000d)>=0
                        )){
                    EmphasisCellEntity excelCell = new EmphasisCellEntity();
                    excelCell.set服务人员编号(element.get服务人员编号());
                    excelCell.set服务人员(element.get服务人员姓名());
                    excelCell.set客户资金账号(element.get资金账号());
                    excelCell.set交易日期(element.get交易日期());
                    excelCell.set总资产(element.get总资产());
                    excelCell.set可用资金(element.get可用资金());
                    excelCell.set现金资产(element.get现金资产());
                    excelCell.set使用系统(element.get使用系统());
                    excelCell.set出生年份(GetYear.getYear(element.get出生年月日()).toString());
                    excelCell.set交易意向("涨停板敢死队");
                    excelCell.set适用系统(Transaction2Sys.getMap().get("涨停板敢死队"));
                    excelCell.set介绍物料(Transaction2Introduce.getMap().get("涨停板敢死队"));
                    excelCellList.add(excelCell);
                }
            });
        }else if(zlass == (NightOrderCell.class)){
            List<NightOrderCell> cells = (List<NightOrderCell>)rawMaterial;
            cells.stream().forEach((element)->{
                if(Double.valueOf(element.get总资产()).compareTo(10000000d)>=0 && (
                   Double.valueOf(element.get可用资金()).compareTo(1000000d)>=0 ||
                   Double.valueOf(element.get现金资产()).compareTo(1000000d)>=0
                )){
                    EmphasisCellEntity excelCell = new EmphasisCellEntity();
                    excelCell.set服务人员编号(element.get服务人员编号());
                    excelCell.set服务人员(element.get服务人员姓名());
                    excelCell.set客户资金账号(element.get资金账号());
                    excelCell.set交易日期(element.get批量日期());
                    excelCell.set总资产(element.get总资产());
                    excelCell.set可用资金(element.get可用资金());
                    excelCell.set现金资产(element.get现金资产());
                    excelCell.set使用系统(element.get使用系统());
                    excelCell.set出生年份(GetYear.getYear(element.get出生年月日()).toString());
                    excelCell.set交易意向("夜盘委托");
                    excelCell.set适用系统(Transaction2Sys.getMap().get("夜盘委托"));
                    excelCell.set介绍物料(Transaction2Introduce.getMap().get("夜盘委托"));
                    excelCellList.add(excelCell);
                }
            });
        }else if(zlass == (PositionBuildingCell.class)){
            List<PositionBuildingCell> cells = (List<PositionBuildingCell>)rawMaterial;
            cells.stream().forEach((element)->{
                if(Double.valueOf(element.get资产规模()).compareTo(10000000d)>=0 &&
                   Double.valueOf(element.get现金资产()).compareTo(1000000d)>=0
                ){
                    EmphasisCellEntity excelCell = new EmphasisCellEntity();
                    excelCell.set服务人员编号(element.get服务人员编号());
                    excelCell.set服务人员(element.get服务人员姓名());
                    excelCell.set客户资金账号(element.get客户号());
                    excelCell.set交易日期(element.get批量日期());
                    excelCell.set总资产(element.get资产规模());
                    excelCell.set可用资金(element.get初次入金金额());
                    excelCell.set现金资产(element.get现金资产());
                    excelCell.set使用系统(element.get使用系统());
                    excelCell.set出生年份(GetYear.getYear(element.get出生年月日()).toString());
                    excelCell.set交易意向("建仓型");
                    excelCell.set适用系统(Transaction2Sys.getMap().get("建仓型"));
                    excelCell.set介绍物料(Transaction2Introduce.getMap().get("建仓型"));
                    excelCellList.add(excelCell);
                }
            });
        }else if(zlass == (QuantificationNonHighFrequencyCell.class)){
            List<QuantificationNonHighFrequencyCell> cells = (List<QuantificationNonHighFrequencyCell>)rawMaterial;
            cells.stream().forEach((element)->{
                if(Double.valueOf(element.get总资产()).compareTo(10000000d)>=0 && (
                   Double.valueOf(element.get可用资金()).compareTo(1000000d)>=0 ||
                   Double.valueOf(element.get现金资产()).compareTo(1000000d)>=0
                )){
                    EmphasisCellEntity excelCell = new EmphasisCellEntity();
                    excelCell.set服务人员编号(element.get服务人员编号());
                    excelCell.set服务人员(element.get服务人员姓名());
                    excelCell.set客户资金账号(element.get资金账号());
                    excelCell.set交易日期(element.get日期范围());
                    excelCell.set总资产(element.get总资产());
                    excelCell.set可用资金(element.get可用资金());
                    excelCell.set现金资产(element.get现金资产());
                    excelCell.set使用系统(element.get使用系统());
                    excelCell.set出生年份(GetYear.getYear(element.get出生年月日()).toString());
                    excelCell.set交易意向("量化-非高频");
                    excelCell.set适用系统(Transaction2Sys.getMap().get("量化-非高频"));
                    excelCell.set介绍物料(Transaction2Introduce.getMap().get("量化-非高频"));
                    excelCellList.add(excelCell);
                }
            });
        }else if(zlass == (StockDataSummaryCell.class)){
            List<StockDataSummaryCell> cells = (List<StockDataSummaryCell>)rawMaterial;
            cells.stream().forEach((element)->{
                if(Double.valueOf(element.get总资产()).compareTo(10000000d)>=0){
                    EmphasisCellEntity excelCell = new EmphasisCellEntity();
                    excelCell.set服务人员编号(element.get服务人员编号());
                    excelCell.set服务人员(element.get服务人员姓名());
                    excelCell.set客户资金账号(element.get资金账号());
                    excelCell.set交易日期(element.get批量日期());
                    excelCell.set总资产(element.get总资产());
                    excelCell.set可用资金("0");
                    excelCell.set现金资产("0");
                    excelCell.set使用系统(element.get使用系统());
                    excelCell.set出生年份(GetYear.getYear(element.get出生年月日()).toString());
                    excelCell.set交易意向("股票数据汇总");
                    excelCell.set适用系统(Transaction2Sys.getMap().get("股票数据汇总"));
                    excelCell.set介绍物料(Transaction2Introduce.getMap().get("股票数据汇总"));
                    excelCellList.add(excelCell);
                }
            });
        }else if(zlass == (WillDailyLimitCell.class)){
            List<WillDailyLimitCell> cells = (List<WillDailyLimitCell>)rawMaterial;
            cells.stream().forEach((element)->{
                if(Double.valueOf(element.get总资产()).compareTo(10000000d)>=0 && (
                   Double.valueOf(element.get可用资金()).compareTo(1000000d)>=0 ||
                   Double.valueOf(element.get现金资产()).compareTo(1000000d)>=0
                )){
                    EmphasisCellEntity excelCell = new EmphasisCellEntity();
                    excelCell.set服务人员编号(element.get服务人员编号());
                    excelCell.set服务人员(element.get服务人员姓名());
                    excelCell.set客户资金账号(element.get资金账号());
                    excelCell.set交易日期(element.get交易日期());
                    excelCell.set总资产(element.get总资产());
                    excelCell.set可用资金(element.get可用资金());
                    excelCell.set现金资产(element.get现金资产());
                    excelCell.set使用系统(element.get使用系统());
                    excelCell.set出生年份(GetYear.getYear(element.get出生年月日()).toString());
                    excelCell.set交易意向("追涨停模型");
                    excelCell.set适用系统(Transaction2Sys.getMap().get("追涨停模型"));
                    excelCell.set介绍物料(Transaction2Introduce.getMap().get("追涨停模型"));
                    excelCellList.add(excelCell);
                }
            });
        }
        return excelCellList;
    }
}
