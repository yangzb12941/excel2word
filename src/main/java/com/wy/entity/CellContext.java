package com.wy.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CellContext<T extends CellEntity> {
    private List<T> itmes;

    public CellContext(){
        this.itmes = new ArrayList<>(128);
    }
}
