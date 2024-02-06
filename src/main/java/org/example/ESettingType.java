package org.example;

import java.util.HashMap;
import java.util.Map;

public enum ESettingType {
    ALGORITHM_NAME("-a"), HEX_CONTROL_SUM("-h"), CHAR_ARRAY_SIZE("-l");
    private final String title;

    static final Map<String, ESettingType> typeMap = new HashMap<>();

    static {
        for (ESettingType type : ESettingType.values()) {
            typeMap.put(type.title, type);
        }
    }

    public static ESettingType getType(String type) {
        return typeMap.get(type);
    }

    ESettingType(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
