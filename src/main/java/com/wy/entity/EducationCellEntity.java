package com.wy.entity;

import lombok.Data;

@Data
public class EducationCellEntity extends CellEntity{
    private String 大类;

    private String 总量;

    private String 本科以下数量;

    private String 本科数量;

    private String 硕博数量;

    private String 本科及以上占比;
}
