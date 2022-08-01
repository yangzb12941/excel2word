package com.wy.dataToTable;

import com.wy.entity.CellContext;
import com.wy.entity.CellEntity;
import com.wy.header.Header;
import com.wy.header.HeaderFactory;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;

@Slf4j
public class Data2Table implements IData2Table{

    private static volatile Data2Table data2Table;

    public static Data2Table getInstance(){
        if(data2Table == null){
            synchronized (Data2Table.class){
                if (data2Table == null) {
                    data2Table = new Data2Table();
                }
            }
        }
        return data2Table;
    }

    @Override
    public String[][] toTable(String tableName, CellContext cellContext){
        //列头
        Header header = HeaderFactory.getHeader(tableName);
        //表格数据
        HashMap<String, List<CellEntity>> itmesMap = cellContext.getItmesMap();
        List<CellEntity> cellEntities = itmesMap.get(tableName);
        String[][] table = new String[cellEntities.size()+1][header.getHeader().size()];
        for (int i = 0; i < cellEntities.size() || i == 0; i++) {
            for (int j = 0; j < header.getHeader().size(); j++) {
                if(i==0){
                    //插入表头
                    table[i][j] = header.getHeader().get(j).getCellName();
                }else{
                    int curIndex = i-1;
                    //插入数据行
                    table[i][j] = getGetMethod(cellEntities.get(curIndex),header.getHeader().get(j).getCellName());
                }
            }
        }
        return table;
    }

    private String getGetMethod(Object ob , String name) {
        Method[] m = ob.getClass().getMethods();
        try{
            for(int i = 0;i < m.length;i++){
                if(m[i].getName().startsWith("get") && m[i].getName().indexOf(name)>=0){
                    return m[i].invoke(ob).toString();
                }
            }
        }catch (IllegalAccessException | InvocationTargetException e) {
            log.error("Data2Table error:{}",e);
        }
        return "";
    }
}
