package com.wy.enumClass;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public enum EducationEnum {

    博士 ("1","博士"),
    硕士("2","硕士"),
    本科 ("3","本科"),
    大专("4","大专"),
    中专 ("5","中专"),
    高中("6","高中"),
    初中及以下 ("7","初中及以下"),
    其他("8","其他"),
    ;
    private String code;
    private String name;
}
