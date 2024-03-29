package com.wy.element;

import org.apache.commons.collections4.CollectionUtils;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class BlockElement extends BaseElement<List<BaseElement>> {
    public BlockElement(Integer index,String tagName, List<BaseElement> value) {
        super(index,tagName, value);
    }

    public Map<String,Object> getValues(){
        Map<String,Object> valueMap = new Hashtable<String,Object>(64);
        List<BaseElement> value = super.getValue();
        if(CollectionUtils.isNotEmpty(value)){
            for (BaseElement element : value) {
                if(Objects.nonNull(element)){
                    valueMap.put(element.getTagName(),element.getValue());
                }
            }
        }
        return valueMap;
    }
}
