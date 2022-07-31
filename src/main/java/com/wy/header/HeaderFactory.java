package com.wy.header;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HeaderFactory {

    public static Header getHeader(String tableName){
        Header header = null;
        switch (tableName) {
            case "夜盘委托":
            case "涨停板敢死队":
            case "追涨停模型":
            case "量化-非高频":
            case "债券套利":
            case "股票数据汇总":{
                header = new NativeHeader();
                break;
            }
            case "数量统计":{
                header = new AmountHeader();
                break;
            }
            case "学历统计":{
                header = new EducationHeader();
                break;
            }
            case "年龄统计":{
                header = new AgeHeader();
                break;
            }
            case "重点关注":{
                header = new EmphasisHeader();
                break;
            }
            default :{
                log.error("没有对应的列头:{}",tableName);
                break;
            }
        }
        return header;
    }
}
