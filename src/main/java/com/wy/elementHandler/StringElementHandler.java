package com.wy.elementHandler;

import com.deepoove.poi.template.MetaTemplate;
import com.deepoove.poi.template.run.RunTemplate;
import com.wy.entity.CellContext;

import java.util.Objects;


public class StringElementHandler implements IElementHandler<String>{

    private static volatile StringElementHandler instance;

    public static StringElementHandler getInstance(){
        if(instance == null){
            synchronized (StringElementHandler.class){
                if (instance == null) {
                    instance = new StringElementHandler();
                }
            }
        }
        return instance;
    }

    @Override
    public String getElementValue(CellContext cellContext, MetaTemplate metaTemplate) {
        int indexOf = cellContext.getDataKey().indexOf(".");
        String tableName = "";
        if(indexOf != -1){
            tableName = cellContext.getIndex()+"、"+cellContext.getDataKey().substring(indexOf+1,cellContext.getDataKey().length());
        }else{
            tableName = cellContext.getIndex()+"、"+cellContext.getDataKey();
        }
        return tableName;
    }
}
