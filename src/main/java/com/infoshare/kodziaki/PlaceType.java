package com.infoshare.kodziaki;

public enum PlaceType {
    APARTMENT,
    ROOM,
    BED;

    public static PlaceType fromPolishString(String s) {
        if ("pokoj".equals(s)) {
            return ROOM;
        } else if ("lozko".equals(s)) {
            return BED;
        } else {
            return APARTMENT;
        }
    }
}
