package com.company.util;

/**
 * Утилитарный класс, предоставляющий методы для округления чисел
 */
public class NumberRoundingUtil {

    /**
     * Метод для округления числа
     *
     * @param number округляемое число в формате double
     * @return число после округления в формате String
     */
    public static String roundingAndReturnString(double number) {
        return String.format("%." + getRoundingIndex(String.valueOf(number)) + "f", number);
    }

    /**
     * Метод для округления числа
     *
     * @param number округляемое число в формате double
     * @return число после округления в формате int
     */
    public static int roundingAndReturnInt(double number) {
        return (int) Math.round(number);
    }

    /**
     * Вспомогательный метод для нахождения индекса округления (позиция последней цифры, отличной от нуля, плюс один)
     *
     * @param number число в формате String
     * @return индекс округления в формате int
     */
    private static int getRoundingIndex(String number) {
        var numberChars = number.substring(number.indexOf(".") + 1).toCharArray();
        int index = 0;

        for (int i = 0; i < numberChars.length; i++) {
            if (numberChars[i] != '0') {
                index = i + 1;
                break;
            }
        }
        return index;
    }
}
