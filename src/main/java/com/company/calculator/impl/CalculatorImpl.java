package com.company.calculator.impl;

import com.company.calculator.Calculator;
import com.company.calculator.MathOperationPerform;
import com.company.converter.NumberConverter;
import com.company.converter.impl.NumberConverterImpl;
import com.company.entity.MathExpression;
import com.company.enums.DigitalSystem;
import com.company.enums.MathOperation;
import com.company.exception.DivisionByZeroException;
import com.company.util.NumberRoundingUtil;
import com.company.util.SourceHandlingUtil;

import static com.company.enums.DigitalSystem.ARABIC;
import static com.company.enums.DigitalSystem.ROMAN;
import static com.company.enums.MathOperation.DIVISION;

/**
 * Класс, реализующий функционал вычислений математических операций
 *
 * @see Calculator
 * @see MathExpression
 * @see MathOperation
 * @see DigitalSystem
 * @see NumberConverter
 * @see NumberConverterImpl
 * @see MathOperationPerform
 * @see MathOperationPerformImpl
 * @see SourceHandlingUtil
 * @see NumberRoundingUtil
 */
public class CalculatorImpl implements Calculator {

    private final NumberConverter numberConverter = new NumberConverterImpl();
    private final MathOperationPerform mathOperationPerform = new MathOperationPerformImpl();

    /**
     * Метод, реализующий выполнение вычислений математических операций
     *
     * @param source исходные данные в формате String
     * @return результат вычисления математической операции в формате String
     */
    @Override
    public String calculate(String source) {
        var mathExpression = SourceHandlingUtil.getMathExpression(source);

        var firstNumber = mathExpression.firstNumber();
        var secondNumber = mathExpression.secondNumber();
        var mathOperation = mathExpression.mathOperation();
        var digitalSystem = mathExpression.digitalSystem();

        if (ARABIC.equals(digitalSystem)) {
            return arabicNumbersCalculate(firstNumber, secondNumber, mathOperation);
        } else if (ROMAN.equals(digitalSystem)) {
            return romanNumbersCalculate(firstNumber, secondNumber, mathOperation);
        }
        return null;
    }

    /**
     * Вспомогательный метод для выполнения вычислений над арабскими числами
     *
     * @param firstNumber   первое арабское число математической операции в формате String
     * @param secondNumber  второе арабское число математической операции в формате String
     * @param mathOperation вид математической операции в формате {@link MathOperation}
     * @return результат вычисления математической операции в формате String
     */
    private String arabicNumbersCalculate(String firstNumber, String secondNumber, MathOperation mathOperation) {
        var firstArabicNumber = Double.parseDouble(firstNumber);
        var secondArabicNumber = Double.parseDouble(secondNumber);

        divisionByZeroCheck(secondArabicNumber, mathOperation);

        return NumberRoundingUtil.roundingAndReturnString(
                mathOperationPerform(firstArabicNumber, secondArabicNumber, mathOperation)
        );
    }

    /**
     * Вспомогательный метод для выполнения вычислений над римскими числами
     *
     * @param firstNumber   первое римское число математической операции в формате String
     * @param secondNumber  второе римское число математической операции в формате String
     * @param mathOperation вид математической операции в формате {@link MathOperation}
     * @return результат вычисления математической операции в формате String
     */
    private String romanNumbersCalculate(String firstNumber, String secondNumber, MathOperation mathOperation) {
        var firstArabicNumber = numberConverter.romanNumberToArabicNumber(firstNumber);
        var secondArabicNumber = numberConverter.romanNumberToArabicNumber(secondNumber);

        return numberConverter.arabicNumberToRomanNumber(
                NumberRoundingUtil.roundingAndReturnInt(
                        mathOperationPerform(firstArabicNumber, secondArabicNumber, mathOperation)
                )
        );
    }

    /**
     * Вспомогательный метод для выполнения вычислений
     *
     * @param firstNumber   первое число математической операции в формате double
     * @param secondNumber  второе число математической операции в формате double
     * @param mathOperation вид математической операции в формате {@link MathOperation}
     * @return результат вычисления математической операции в формате double
     */
    private double mathOperationPerform(double firstNumber, double secondNumber, MathOperation mathOperation) {
        return switch (mathOperation) {
            case ADDITION -> mathOperationPerform.addition(firstNumber, secondNumber);
            case SUBTRACTION -> mathOperationPerform.subtraction(firstNumber, secondNumber);
            case MULTIPLICATION -> mathOperationPerform.multiplication(firstNumber, secondNumber);
            case DIVISION -> mathOperationPerform.division(firstNumber, secondNumber);
        };
    }

    /**
     * Вспомогательный метод для проверки операции деления на ноль
     *
     * @param secondArabicNumber второе арабское число математической операции в формате Double
     * @param mathOperation      вид математической операции в формате {@link MathOperation}
     */
    private void divisionByZeroCheck(Double secondArabicNumber, MathOperation mathOperation) {
        if (DIVISION.equals(mathOperation) && secondArabicNumber == 0.0) {
            throw DivisionByZeroException.of();
        }
    }
}
