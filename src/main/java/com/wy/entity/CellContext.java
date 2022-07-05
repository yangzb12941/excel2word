package com.wy.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Data
public class CellContext<T extends CellEntity> {
    private HashMap<String,List<T>> itmesMap;
    private String dataKey;
    private Integer index;
    public CellContext(){
        this.itmesMap = new HashMap<String,List<T>>(8);
    }
}
