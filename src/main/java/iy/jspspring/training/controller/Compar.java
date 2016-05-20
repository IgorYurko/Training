package iy.jspspring.training.controller;

import java.util.Comparator;

public enum Compar{
    STRING((Comparator<String>) String::compareTo),
    STRING_REVERS((String aStr,String bStr) -> bStr.compareTo(aStr));

    private final Comparator<?> comparator;

    Compar(Comparator<?> comparator) {
        this.comparator = comparator;
    }

    public Comparator<?> get() {
        return comparator;
    }
}
