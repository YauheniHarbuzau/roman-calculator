package com.company.calculator;

import com.company.calculator.impl.CalculatorImpl;

/**
 * Интерфейс, предоставляющий метод вычислений математических операций
 *
 * @see CalculatorImpl
 */
public interface Calculator {

    String calculate(String source);
}
