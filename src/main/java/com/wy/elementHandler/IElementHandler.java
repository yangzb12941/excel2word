package com.wy.elementHandler;

import com.deepoove.poi.template.MetaTemplate;
import com.wy.entity.CellContext;

/**
 * 在上下文中解析出各个模板元素
 * @param <T>
 */
public interface IElementHandler<T> {
    T getElementValue(CellContext cellContext, MetaTemplate metaTemplate);
}
