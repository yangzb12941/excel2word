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
        return cellContext.getDataKey();
    }
}
