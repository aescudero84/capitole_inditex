package com.aescudero.capitole_inditex.domain.model;

import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum Priority {

    VERY_HIGH(4),
    HIGH(3),
    MEDIUM(2),
    LOW(1),
    VERY_LOW(0),
    UNKNOWN(-1);

    @Getter
    public final Integer value;

    Priority(Integer value) {
        this.value = value;
    }

    private static final Map<Integer, Priority> LOOKUPS;

    static {
        LOOKUPS = Arrays.stream(Priority.values())
                .collect(Collectors.toMap(Priority::getValue, Function.identity()));
    }


    public static Priority lookup(Integer value) {
        Priority priority = LOOKUPS.get(value);

        return null != priority ? priority : Priority.UNKNOWN;
    }
}
