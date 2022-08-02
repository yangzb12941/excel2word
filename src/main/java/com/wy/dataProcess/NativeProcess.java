package com.wy.dataProcess;

import com.wy.entity.WordTableModelEntity;
import com.wy.enumClass.EducationEnum;
import com.wy.enumClass.EnumUtils;
import com.wy.excelCell.*;
import com.wy.utils.GetYear;

import java.util.ArrayList;
import java.util.List;

public class NativeProcess implements IProcess<ExcelCell>{

    @Override
    public List<WordTableModelEntity> process(List rawMaterial,Class zlass) {
        List<WordTableModelEntity> wordTableModelEntities = excelDataToDaoModel(rawMaterial,zlass);
        return wordTableModelEntities;
    }

    private List<WordTableModelEntity> excelDataToDaoModel(List rawMaterial,Class zlass){
        List<WordTableModelEntity> excelCellList = new ArrayList<WordTableModelEntity>(rawMaterial.size());
        if(zlass == BondArbitrageCell.class){
            List<BondArbitrageCell> cells = (List<BondArbitrageCell>)rawMaterial;
            cells.stream().forEach((element)->{
                WordTableModelEntity excelCell = new WordTableModelEntity();
                excelCell.set账户(element.get资金账号());
                excelCell.set营业部(element.get营业部());
                excelCell.set客户类型(element.get客户类型());
                excelCell.set服务人员姓名(element.get服务人员姓名());
                excelCell.set服务人员编号(element.get服务人员编号());
                excelCell.set服务人员团队(element.get服务人员团队());
                excelCell.set使用系统(element.get使用系统());
                excelCell.set学历(EnumUtils.getTypeName(EducationEnum.class,element.get学历()));
                excelCell.set年份(GetYear.getYear(element.get出生年月日()).toString());
                excelCellList.add(excelCell);
            });
        }else if(zlass == DailyLimitOrderCell.class){
            List<DailyLimitOrderCell> cells = (List<DailyLimitOrderCell>)rawMaterial;
            cells.stream().forEach((element)->{
                WordTableModelEntity excelCell = new WordTableModelEntity();
                excelCell.set账户(element.get资金账号());
                excelCell.set营业部(element.get营业部());
                excelCell.set客户类型(element.get客户类型());
                excelCell.set服务人员姓名(element.get服务人员姓名());
                excelCell.set服务人员编号(element.get服务人员编号());
                excelCell.set服务人员团队(element.get服务人员团队());
                excelCell.set使用系统(element.get使用系统());
                excelCell.set学历(EnumUtils.getTypeName(EducationEnum.class,element.get学历()));
                excelCell.set年份(GetYear.getYear(element.get出生年月日()).toString());
                excelCellList.add(excelCell);
            });
        }else if(zlass == NightOrderCell.class){
            List<NightOrderCell> cells = (List<NightOrderCell>)rawMaterial;
            cells.stream().forEach((element)->{
                WordTableModelEntity excelCell = new WordTableModelEntity();
                excelCell.set账户(element.get资金账号());
                excelCell.set营业部(element.get营业部());
                excelCell.set客户类型(element.get客户类型());
                excelCell.set服务人员姓名(element.get服务人员姓名());
                excelCell.set服务人员编号(element.get服务人员编号());
                excelCell.set服务人员团队(element.get服务人员团队());
                excelCell.set使用系统(element.get使用系统());
                excelCell.set学历(EnumUtils.getTypeName(EducationEnum.class,element.get学历()));
                excelCell.set年份(GetYear.getYear(element.get出生年月日()).toString());
                excelCellList.add(excelCell);
            });
        }else if(zlass == PositionBuildingCell.class){
            List<PositionBuildingCell> cells = (List<PositionBuildingCell>)rawMaterial;
            cells.stream().forEach((element)->{
                WordTableModelEntity excelCell = new WordTableModelEntity();
                excelCell.set账户(element.get客户号());
                excelCell.set营业部(element.get营业部());
                excelCell.set客户类型(element.get客户类型());
                excelCell.set服务人员姓名(element.get服务人员姓名());
                excelCell.set服务人员编号(element.get服务人员编号());
                excelCell.set服务人员团队(element.get服务人员团队());
                excelCell.set使用系统(element.get使用系统());
                excelCell.set学历(EnumUtils.getTypeName(EducationEnum.class,element.get学历()));
                excelCell.set年份(GetYear.getYear(element.get出生年月日()).toString());
                excelCellList.add(excelCell);
            });
        }else if(zlass == QuantificationNonHighFrequencyCell.class){
            List<QuantificationNonHighFrequencyCell> cells = (List<QuantificationNonHighFrequencyCell>)rawMaterial;
            cells.stream().forEach((element)->{
                WordTableModelEntity excelCell = new WordTableModelEntity();
                excelCell.set账户(element.get资金账号());
                excelCell.set营业部(element.get营业部());
                excelCell.set客户类型(element.get客户类型());
                excelCell.set服务人员姓名(element.get服务人员姓名());
                excelCell.set服务人员编号(element.get服务人员编号());
                excelCell.set服务人员团队(element.get服务人员团队());
                excelCell.set使用系统(element.get使用系统());
                excelCell.set学历(EnumUtils.getTypeName(EducationEnum.class,element.get学历()));
                excelCell.set年份(GetYear.getYear(element.get出生年月日()).toString());
                excelCellList.add(excelCell);
            });
        }else if(zlass == StockDataSummaryCell.class){
            List<StockDataSummaryCell> cells = (List<StockDataSummaryCell>)rawMaterial;
            cells.stream().forEach((element)->{
                WordTableModelEntity excelCell = new WordTableModelEntity();
                excelCell.set账户(element.get资金账号());
                excelCell.set营业部(element.get营业部());
                excelCell.set客户类型(element.get客户类型());
                excelCell.set服务人员姓名(element.get服务人员姓名());
                excelCell.set服务人员编号(element.get服务人员编号());
                excelCell.set服务人员团队(element.get服务人员团队());
                excelCell.set使用系统(element.get使用系统());
                excelCell.set学历(EnumUtils.getTypeName(EducationEnum.class,element.get学历()));
                excelCell.set年份(GetYear.getYear(element.get出生年月日()).toString());
                excelCellList.add(excelCell);
            });
        }else if(zlass == WillDailyLimitCell.class){
            List<WillDailyLimitCell> cells = (List<WillDailyLimitCell>)rawMaterial;
            cells.stream().forEach((element)->{
                WordTableModelEntity excelCell = new WordTableModelEntity();
                excelCell.set账户(element.get资金账号());
                excelCell.set营业部(element.get营业部());
                excelCell.set客户类型(element.get客户类型());
                excelCell.set服务人员姓名(element.get服务人员姓名());
                excelCell.set服务人员编号(element.get服务人员编号());
                excelCell.set服务人员团队(element.get服务人员团队());
                excelCell.set使用系统(element.get使用系统());
                excelCell.set学历(EnumUtils.getTypeName(EducationEnum.class,element.get学历()));
                excelCell.set年份(GetYear.getYear(element.get出生年月日()).toString());
                excelCellList.add(excelCell);
            });
        }
        return excelCellList;
    }
}
