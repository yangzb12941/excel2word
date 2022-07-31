package com.wy.entity;

import lombok.Data;

@Data
public class EducationCellEntity extends CellEntity{
    private String 大类;

    private String 总量;

    private String 本科以下;

    private String 本科;

    private String 硕博;

    private String 本科以上占比;
}
