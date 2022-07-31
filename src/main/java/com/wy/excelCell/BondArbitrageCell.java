package com.wy.excelCell;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * 7.债券套利
 */
@Data
public class BondArbitrageCell extends ExcelCell{

    @ExcelProperty(index = 0)
    private String 资金账号;

    @ExcelProperty(index = 1)
    private String 营业部;

    @ExcelProperty(index = 2)
    private String 客户类型;

    @ExcelProperty(index = 3)
    private String 服务人员姓名;

    @ExcelProperty(index = 4)
    private String 服务人员编号;

    @ExcelProperty(index = 5)
    private String 服务人员团队;

    @ExcelProperty(index = 6)
    private String 总资产;

    @ExcelProperty(index = 7)
    private String 总委托笔数;

    @ExcelProperty(index = 8)
    private String 总净佣金;

    @ExcelProperty(index = 9)
    private String 总净收入;

    @ExcelProperty(index = 10)
    private String 是否取消最低5元佣金;

    @ExcelProperty(index = 11)
    private String 债券委托笔数;

    @ExcelProperty(index = 12)
    private String 深圳债券委托笔数;

    @ExcelProperty(index = 13)
    private String 深圳债券净佣金;

    @ExcelProperty(index = 14)
    private String 深圳债券净收入;

    @ExcelProperty(index = 15)
    private String 使用系统;

    @ExcelProperty(index = 16)
    private String 使用系统次数;

    @ExcelProperty(index = 17)
    private String 批量日期;

    @ExcelProperty(index = 18)
    private String 学历;

    @ExcelProperty(index = 19)
    private String 出生年月日;
}
