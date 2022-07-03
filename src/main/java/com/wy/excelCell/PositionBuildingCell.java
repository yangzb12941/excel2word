package com.wy.excelCell;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * 1.建仓型
 */
@Data
public class PositionBuildingCell extends ExcelCell{
    @ExcelProperty(index = 0)
    private String 客户号;

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
    private String 开户日期;

    @ExcelProperty(index = 7)
    private String 初次入金金额;

    @ExcelProperty(index =8)
    private String 资产规模;

    @ExcelProperty(index = 9)
    private String 可用金额;

    @ExcelProperty(index = 10)
    private String 现金资产;

    @ExcelProperty(index = 11)
    private String 现有证券数量;

    @ExcelProperty(index = 12)
    private String 使用系统;

    @ExcelProperty(index = 13)
    private String 使用系统次数;

    @ExcelProperty(index = 14)
    private String 批量日期;
}
