package com.dydko.utils;

import java.util.Random;

public class DataUtils {

    private static final Random RANDOM = new Random();

    public static String generatePesel() {
        StringBuilder pesel = new StringBuilder();

        for (int i = 0; i < 10; i++) {
            pesel.append(RANDOM.nextInt(10));
        }

        int control = calculateControlDigit(pesel.toString());
        pesel.append(control);

        return pesel.toString();
    }

    private static int calculateControlDigit(String pesel) {
        int[] weights = {1, 3, 7, 9, 1, 3, 7, 9, 1, 3};
        int sum = 0;

        for (int i = 0; i < weights.length; i++) {
            sum += Character.getNumericValue(pesel.charAt(i)) * weights[i];
        }

        return (10 - (sum % 10)) % 10;
    }
}
