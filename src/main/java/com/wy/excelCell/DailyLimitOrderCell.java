package com.wy.excelCell;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * 4.涨停板敢死队
 */
@Data
public class DailyLimitOrderCell extends ExcelCell{

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
    private String 可用资金;

    @ExcelProperty(index = 8)
    private String 现金资产;

    @ExcelProperty(index = 9)
    private String 交易日期;

    @ExcelProperty(index = 10)
    private String 使用系统;

    @ExcelProperty(index = 11)
    private String 使用系统次数;
}
