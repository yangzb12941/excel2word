package com.wy.entity;

import lombok.Data;

@Data
public class AgeCellEntity extends CellEntity{
    private String 大类;

    private String 总量;

    private String _1985以前;

    private String _1985_1995;

    private String _1995以后;

    private String _1985后占比;

    private String _1995后占比;
}
