package com.wy.wordWriter;

import com.alibaba.excel.util.DateUtils;
import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.template.IterableTemplate;
import com.deepoove.poi.template.MetaTemplate;
import com.deepoove.poi.template.run.RunTemplate;
import com.wy.entity.CellContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.*;

public class CellWriter2Word {
    private static final Logger LOGGER = LoggerFactory.getLogger(CellWriter2Word.class);
    private volatile static CellWriter2Word cellWriter2Word = null;

    private CellWriter2Word() {}

    public static CellWriter2Word getInstance(){
        if(Objects.isNull(cellWriter2Word)){
            synchronized (CellWriter2Word.class){
                if(Objects.nonNull(cellWriter2Word)){
                    return cellWriter2Word;
                }else{
                    cellWriter2Word = new CellWriter2Word();
                    return cellWriter2Word;
                }
            }
        }else{
            return cellWriter2Word;
        }
    }

    public void writeWord(CellContext cellContext) throws IOException {
        XWPFTemplate compile = XWPFTemplate.compile("src\\test\\templates\\吴莹Excel2Word模板.docx");
        List<MetaTemplate> elementTemplates = compile.getElementTemplates();
        Map<String, Object> values = new HashMap<String, Object>() {
            {
                for (MetaTemplate item:elementTemplates) {
                    if(item instanceof RunTemplate){
                        String tagName = ((RunTemplate) item).getTagName();
                        LOGGER.info("RunTemplate TagName:{}",tagName);
                        put(tagName, ElementHandlerUtils.getElementValue(cellContext,item));
                    }else if (item instanceof IterableTemplate){
                        String tagName = ((IterableTemplate)item).getStartMark().getTagName();
                        LOGGER.info("IterableTemplate TagName:{}",tagName);
                        put(tagName, ElementHandlerUtils.getElementValue(cellContext,item));
                    }
                }
            }
        };
        compile.render(values).writeToFile("吴莹Excel2Word"+ DateUtils.format(new Date(),"yyyyMMddHHmmss")+".docx");
    }
}
