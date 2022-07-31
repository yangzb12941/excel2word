package com.wy.entity;

import lombok.Data;

@Data
public class AgeCellEntity extends CellEntity{
    private String 大类;

    private String 总量;

    private String 前1985;

    private String 之间1985_1995;

    private String 后1995;

    private String 占比1985;

    private String 占比1995;
}
