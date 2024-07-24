package com.company.util;

import com.company.constant.Constant;
import com.company.enums.DigitalSystem;
import com.company.exception.DigitalSystemException;
import com.company.exception.SourceNotValidException;

import static com.company.constant.Constant.SOURCE_FORMAT_REGEX;
import static com.company.enums.DigitalSystem.ARABIC;
import static com.company.enums.DigitalSystem.ROMAN;

/**
 * Утилитарный класс, предоставляющий методы для валидации исходных данных
 *
 * @see Constant
 * @see DigitalSystem
 */
public class ValidationUtil {

    /**
     * Метод для проверки исходных данных на соответствие регулярному выражению
     *
     * @param source исходные данные в формате String
     * @return булево значение
     */
    public static boolean sourceFormatValidation(String source) {
        if (source.matches(SOURCE_FORMAT_REGEX)) {
            return true;
        } else {
            throw SourceNotValidException.of(source);
        }
    }

    /**
     * Метод для проверки чисел математической операции на вид системы счисления
     *
     * @param numbers       числа математической операции в формате String[]
     * @param digitalSystem вид системы счисления в формате {@link DigitalSystem}
     * @return булево значение
     */
    public static boolean digitalSystemValidation(String[] numbers, DigitalSystem digitalSystem) {
        if (ARABIC.equals(digitalSystem) || ROMAN.equals(digitalSystem)) {
            return true;
        } else {
            throw DigitalSystemException.of(numbers);
        }
    }
}
