package com.needle.FsoFso.common.util;

import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyFormatter {

    private static final NumberFormat numberFormat = NumberFormat.getInstance(
            new Locale("kr", "KR"));

    public static String toCurrencyFormat(int value) {
        return numberFormat.format(value);
    }

    public static String toCurrencyFormat(String value) {
        return numberFormat.format(value);
    }
    
    public static String toCurrencyFormat(long value) {
        return numberFormat.format(value);
    }
    
    public static String toCurrencyFormat(Long value) {
        return numberFormat.format(value);
    }
}
