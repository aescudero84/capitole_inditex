package com.aescudero.capitole_inditex.domain.model;

import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum Currency {

    EUR("EUR", 978, "Euro"),
    USD("USD", 840, "United States dollar"),
    UNKNOWN("UNKNOWN", -1, "Unknown currency");

    @Getter
    public final String code;
    public final Integer num;
    public final String description;

    Currency(String code, Integer num, String description) {
        this.code = code;
        this.num = num;
        this.description = description;
    }

    private static final Map<String, Currency> LOOKUPS;

    static {
        LOOKUPS = Arrays.stream(Currency.values())
                .collect(Collectors.toMap(Currency::getCode, Function.identity()));
    }


    public static Currency lookup(String value) {
        Currency currency = LOOKUPS.get(value);

        return null != currency ? currency : Currency.UNKNOWN;
    }
}
