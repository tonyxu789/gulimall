package com.xhc.common.enums;

import org.springframework.util.StringUtils;

public enum LanguageEnum {

    LANGUAGE_EN_US("en_us"),
    LANGUAGE_ZH_CN("zh_cn");

    private String name;

    LanguageEnum(String name) {
        this.name = name;
    }

    public static LanguageEnum getLanguageByName(String name) {
        if (StringUtils.isEmpty(name)) {
            return LANGUAGE_ZH_CN;
        }
        for (LanguageEnum languageEnum : LanguageEnum.values()) {
            if (languageEnum.name.equalsIgnoreCase(name)) {
                return languageEnum;
            }
        }
        return null;
    }
}
