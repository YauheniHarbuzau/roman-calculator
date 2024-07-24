package com.company.calculator;

import com.company.calculator.impl.MathOperationPerformImpl;

/**
 * Интерфейс, предоставляющий методы для математических операций сложения, вычитания, умножения и деления
 *
 * @see MathOperationPerformImpl
 */
public interface MathOperationPerform {

    double addition(double firstNumber, double secondNumber);

    double subtraction(double firstNumber, double secondNumber);

    double multiplication(double firstNumber, double secondNumber);

    double division(double firstNumber, double secondNumber);
}
