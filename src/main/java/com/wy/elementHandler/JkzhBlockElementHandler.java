package com.wy.elementHandler;

import com.deepoove.poi.template.IterableTemplate;
import com.deepoove.poi.template.MetaTemplate;
import com.deepoove.poi.template.run.RunTemplate;
import com.wy.entity.CellContext;
import com.wy.entity.CellEntity;
import com.wy.wordWriter.ElementHandlerUtils;
import lombok.extern.slf4j.Slf4j;
import java.util.*;

@Slf4j
public class JkzhBlockElementHandler extends BlockElementHandler{

    private static volatile JkzhBlockElementHandler instance;

    public static JkzhBlockElementHandler getInstance(){
        if(instance == null){
            synchronized (JkzhBlockElementHandler.class){
                if (instance == null) {
                    instance = new JkzhBlockElementHandler();
                }
            }
        }
        return instance;
    }

    @Override
    public Object getElementValue(CellContext cellContext, MetaTemplate metaTemplate) {
        IterableTemplate iterableTemplate = (IterableTemplate) metaTemplate;
        List<Map<String, Object>> mapList = new ArrayList<>(8);
        if(iterableTemplate.getStartMark().getTagName().equals("ExcelTable")){
            Object workingConditions = multipleWorkingConditions(cellContext, iterableTemplate);
            return workingConditions;
        }
        return mapList;
    }

    /**
     * 多表格模板值匹配
     * @param cellContext
     * @param iterableTemplate
     * @return
     */
    private Object multipleWorkingConditions(CellContext cellContext, IterableTemplate iterableTemplate){
        List<Map<String, Object>> values = new ArrayList<>();
        int index = 1;
        for (Object item:cellContext.getItmesMap().entrySet()) {
            Map.Entry<String,List<CellEntity>> entry = (Map.Entry<String, List<CellEntity>> )item;
            cellContext.setDataKey(entry.getKey());
            cellContext.setIndex(index++);
            Map<String, Object> valueMap = new HashMap<String, Object>() {
                {
                    for (MetaTemplate item:iterableTemplate.getTemplates()) {
                        if(item instanceof RunTemplate){
                            String tagName = ((RunTemplate) item).getTagName();
                            log.info("RunTemplate TagName:{}",tagName);
                            put(tagName, ElementHandlerUtils.getElementValue(cellContext,item));
                        }else if (item instanceof IterableTemplate){
                            String tagName = ((IterableTemplate)item).getStartMark().getTagName();
                            log.info("IterableTemplate TagName:{}",tagName);
                            put(tagName, ElementHandlerUtils.getElementValue(cellContext,item));
                        }
                    }
                }
            };
            values.add(valueMap);
        }
        //多工况模板元素迭代完，重新设置回解析模板非多工况部分填充值
        return values;
    }
}
