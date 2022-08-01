package com.wy.elementHandler;

import com.deepoove.poi.template.IterableTemplate;
import com.deepoove.poi.template.MetaTemplate;
import com.deepoove.poi.template.run.RunTemplate;
import com.wy.entity.CellContext;
import com.wy.entity.CellEntity;
import com.wy.wordWriter.ElementHandlerUtils;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        List<String> tableNames = orderTableNames();
        for(String tableName : tableNames){
            cellContext.setDataKey(tableName);
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


    private List<String> orderTableNames(){
        List<String> order = new ArrayList<>(10);
        order.add("数量统计");
        order.add("年龄统计");
        order.add("学历统计");
        order.add("重点关注");

        order.add("夜盘委托");
        order.add("涨停板敢死队");
        order.add("追涨停模型");
        order.add("债券套利");
        order.add("量化-非高频");
        order.add("股票数据汇总");
        return order;
    }
}
