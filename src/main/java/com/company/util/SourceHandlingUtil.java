package com.company.util;

import com.company.constant.Constant;
import com.company.entity.MathExpression;
import com.company.enums.DigitalSystem;
import com.company.enums.MathOperation;
import com.company.exception.UnknownMathOperationException;

import static com.company.constant.Constant.ARABIC_NUMBER_REGEX;
import static com.company.constant.Constant.ROMAN_NUMBER_REGEX;
import static com.company.enums.DigitalSystem.ARABIC;
import static com.company.enums.DigitalSystem.ROMAN;
import static com.company.enums.DigitalSystem.UNKNOWN;
import static com.company.enums.MathOperation.ADDITION;
import static com.company.enums.MathOperation.DIVISION;
import static com.company.enums.MathOperation.MULTIPLICATION;
import static com.company.enums.MathOperation.SUBTRACTION;

/**
 * Утилитарный класс, предоставляющий методы для обработки исходных данных
 *
 * @see MathExpression
 * @see MathOperation
 * @see DigitalSystem
 * @see Constant
 * @see ValidationUtil
 */
public class SourceHandlingUtil {

    /**
     * Метод для получения математической операции в формате {@link MathExpression}
     *
     * @param source исходные данные в формате String
     * @return математическая операция в формате {@link MathExpression}
     */
    public static MathExpression getMathExpression(String source) {
        source = sourceRemoveSpaces(source);
        ValidationUtil.sourceFormatValidation(source);

        var mathOperation = getMathOperation(source);
        var numbers = getNumbers(source, mathOperation);
        var digitalSystem = getDigitalSystem(numbers);
        ValidationUtil.digitalSystemValidation(numbers, digitalSystem);

        return new MathExpression(numbers[0], numbers[1], mathOperation, digitalSystem);
    }

    /**
     * Вспомогательный метод для удаления интервалов между символами в исходных данных
     *
     * @param source исходные данные в формате String
     * @return исходные данные без интервалов между символами в формате String
     */
    private static String sourceRemoveSpaces(String source) {
        return source.contains(" ") ? source.replace(" ", "") : source;
    }

    /**
     * Вспомогательный метод для предоставления вида математической операции в формате {@link MathOperation}
     *
     * @param source исходные данные в формате String
     * @return вид математической операции в формате {@link MathOperation}
     */
    private static MathOperation getMathOperation(String source) {
        if (source.contains("+")) {
            return ADDITION;
        } else if (source.contains("-")) {
            return SUBTRACTION;
        } else if (source.contains("*")) {
            return MULTIPLICATION;
        } else if (source.contains("/")) {
            return DIVISION;
        } else {
            throw UnknownMathOperationException.of(source);
        }
    }

    /**
     * Вспомогательный метод для предоставления чисел математической операции в формате String[]
     *
     * @param source        исходные данные в формате String
     * @param mathOperation вид математической операции в формате {@link MathOperation}
     * @return числа математической операции в формате String[]
     */
    private static String[] getNumbers(String source, MathOperation mathOperation) {
        return switch (mathOperation) {
            case ADDITION -> source.split("\\+");
            case SUBTRACTION -> source.split("-");
            case MULTIPLICATION -> source.split("\\*");
            case DIVISION -> source.split("/");
        };
    }

    /**
     * Вспомогательный метод для предоставления вида системы счисления
     *
     * @param numbers числа математической операции в формате String[]
     * @return вид системы счисления в формате {@link DigitalSystem}
     */
    private static DigitalSystem getDigitalSystem(String[] numbers) {
        return numbers[0].matches(ARABIC_NUMBER_REGEX) && numbers[1].matches(ARABIC_NUMBER_REGEX) ?
                ARABIC :
                numbers[0].matches(ROMAN_NUMBER_REGEX) && numbers[1].matches(ROMAN_NUMBER_REGEX) ?
                ROMAN :
                UNKNOWN;
    }
}
