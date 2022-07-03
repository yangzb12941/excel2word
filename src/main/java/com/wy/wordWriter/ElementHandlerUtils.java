package com.wy.wordWriter;

import com.deepoove.poi.template.MetaTemplate;
import com.deepoove.poi.template.run.RunTemplate;
import com.wy.elementHandler.TableElementHandler;
import com.wy.entity.CellContext;

public class ElementHandlerUtils {
    public static Object getElementValue(CellContext cellContext, MetaTemplate metaTemplate){
        Object value = null;
        if(metaTemplate instanceof RunTemplate){
            String source = ((RunTemplate) metaTemplate).getSource();
            if(source.indexOf("#")>=0){
                TableElementHandler tableElementHandler = TableElementHandler.getInstance();
                value = tableElementHandler.getElementValue(cellContext, metaTemplate);
            }
        }
        return value;
    }
}
