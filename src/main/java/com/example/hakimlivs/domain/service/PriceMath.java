package com.example.hakimlivs.domain.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * HelperClass for making calculations with dobule.
 * If this is not used random decimal number errors will occur.
 *
 */
public class PriceMath {

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
