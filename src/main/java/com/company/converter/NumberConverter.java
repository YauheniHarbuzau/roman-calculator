package com.company.converter;

import com.company.converter.impl.NumberConverterImpl;

/**
 * Интерфейс, предоставляющий методы для преобразования чисел: римских в арабские и арабских в римские
 *
 * @see NumberConverterImpl
 */
public interface NumberConverter {

    int romanNumberToArabicNumber(String romanNumber);

    String arabicNumberToRomanNumber(int arabicNumber);
}
