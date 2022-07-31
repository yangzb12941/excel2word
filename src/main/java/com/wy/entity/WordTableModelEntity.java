package com.wy.entity;

import lombok.Data;

/**
 * word 表格字段
 */
@Data
public class WordTableModelEntity extends CellEntity{

    private String 账户;

    private String 营业部;

    private String 客户类型;

    private String 使用系统;

    private String 服务人员姓名;

    private String 服务人员编号;

    private String 服务人员团队;

    private String 学历;

    private String 年份;
}
