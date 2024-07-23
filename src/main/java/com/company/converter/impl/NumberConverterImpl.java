package com.company.converter.impl;

import com.company.constant.Constant;
import com.company.converter.NumberConverter;

import static com.company.constant.Constant.ARABIC_NUMBERS;
import static com.company.constant.Constant.ROMAN_ARABIC_NUMBERS_MAP;
import static com.company.constant.Constant.ROMAN_NUMBERS;

/**
 * Класс, реализующий функционал преобразования чисел: римских в арабские и арабских в римские
 *
 * @see NumberConverter
 * @see Constant
 */
public class NumberConverterImpl implements NumberConverter {

    /**
     * Метод для преобразования римских чисел в арабские числа
     *
     * @param romanNumber римское число в формате String
     * @return арабское число в формате int
     */
    @Override
    public int romanNumberToArabicNumber(String romanNumber) {
        var romanNumberEnd = romanNumber.length() - 1;
        var romanNumberChars = romanNumber.toCharArray();
        var result = ROMAN_ARABIC_NUMBERS_MAP.get(romanNumberChars[romanNumberEnd]);

        for (int i = romanNumberEnd - 1; i >= 0; i--) {
            var arabicNumber = ROMAN_ARABIC_NUMBERS_MAP.get(romanNumberChars[i]);

            if (arabicNumber < ROMAN_ARABIC_NUMBERS_MAP.get(romanNumberChars[i + 1])) {
                result -= arabicNumber;
            } else {
                result += arabicNumber;
            }
        }
        return result;
    }

    /**
     * Метод для преобразования арабских чисел в римские числа
     *
     * @param arabicNumber арабское число в формате int
     * @return римское число в формате String
     */
    @Override
    public String arabicNumberToRomanNumber(int arabicNumber) {
        var result = new StringBuilder();

        for (int i = 0; i < ARABIC_NUMBERS.length; i++) {
            while (arabicNumber >= ARABIC_NUMBERS[i]) {
                arabicNumber -= ARABIC_NUMBERS[i];
                result.append(ROMAN_NUMBERS[i]);
            }
        }
        return result.toString();
    }
}
