package com.company.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * Класс для хранения констант
 */
public class Constant {

    public static final String ROMAN_CALCULATOR = "Roman Calculator";
    public static final String INPUT = "Input:";
    public static final String RESULT = "Result:";
    public static final String CLEAN = "Clean";
    public static final String CALCULATE = "Calculate";
    public static final String INFO = "Info";
    public static final String EXIT = "Exit";

    public static final String SOURCE_FORMAT_REGEX = "^[0-9IVXLC]+[*/+-][0-9IVXLC]+$";
    public static final String ARABIC_NUMBER_REGEX = "^[0-9]+";
    public static final String ROMAN_NUMBER_REGEX = "^[IVXLC]+";

    public static final String SOURCE_NOT_VALID_EXCEPTION_MESSAGE_FORMAT = "Source %s not valid";
    public static final String UNKNOWN_MATH_OPERATION_EXCEPTION_MESSAGE_FORMAT = "Unknown math operation %s";
    public static final String DIGITAL_SYSTEM_EXCEPTION_MESSAGE_FORMAT = "Numbers %s, %s must be of the same numeric system";
    public static final String DIVISION_BY_ZERO_EXCEPTION_MESSAGE_FORMAT = "Division by zero";

    public static final String[] ROMAN_NUMBERS = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    public static final int[] ARABIC_NUMBERS = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    public static final Map<Character, Integer> ROMAN_ARABIC_NUMBERS_MAP = new HashMap<>();

    static {
        ROMAN_ARABIC_NUMBERS_MAP.put('I', 1);
        ROMAN_ARABIC_NUMBERS_MAP.put('V', 5);
        ROMAN_ARABIC_NUMBERS_MAP.put('X', 10);
        ROMAN_ARABIC_NUMBERS_MAP.put('L', 50);
        ROMAN_ARABIC_NUMBERS_MAP.put('C', 100);
        ROMAN_ARABIC_NUMBERS_MAP.put('D', 500);
        ROMAN_ARABIC_NUMBERS_MAP.put('M', 1000);
    }
}
