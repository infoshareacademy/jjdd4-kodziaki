package com.infoshare.kodziaki;

import java.util.Arrays;

public enum PlaceType {
    APARTMENT("MIESZKANIE"),
    ROOM("POKOJ"),
    BED("LOZKO");

    private String polishString;

    PlaceType(String polishString) {
        this.polishString = polishString;
    }

    public static PlaceType fromPolishString(String s) {
        return Arrays.stream(values())
                .filter(p -> p.polishString.equalsIgnoreCase(s))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Given place type is not valid " + s));

    }
}
