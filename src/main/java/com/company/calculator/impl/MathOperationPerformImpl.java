package com.company.calculator.impl;

import com.company.calculator.MathOperationPerform;

import java.util.function.DoubleBinaryOperator;

/**
 * Класс, реализующий методы для математических операций сложения, вычитания, умножения и деления
 *
 * @see MathOperationPerform
 */
public class MathOperationPerformImpl implements MathOperationPerform {

    private DoubleBinaryOperator doubleBinaryOperator;

    /**
     * Метод, реализующий математическую операцию сложения
     *
     * @param firstNumber  первое число математической операции сложения в формате double
     * @param secondNumber второе число математической операции сложения в формате double
     * @return результат математической операции сложения в формате double
     */
    @Override
    public double addition(double firstNumber, double secondNumber) {
        doubleBinaryOperator = (x, y) -> x + y;
        return doubleBinaryOperator.applyAsDouble(firstNumber, secondNumber);
    }

    /**
     * Метод, реализующий математическую операцию вычитания
     *
     * @param firstNumber  первое число математической операции вычитания в формате double
     * @param secondNumber второе число математической операции вычитания в формате double
     * @return результат математической операции вычитания в формате double
     */
    @Override
    public double subtraction(double firstNumber, double secondNumber) {
        doubleBinaryOperator = (x, y) -> x - y;
        return doubleBinaryOperator.applyAsDouble(firstNumber, secondNumber);
    }

    /**
     * Метод, реализующий математическую операцию умножения
     *
     * @param firstNumber  первое число математической операции умножения в формате double
     * @param secondNumber второе число математической операции умножения в формате double
     * @return результат математической операции умножения в формате double
     */
    @Override
    public double multiplication(double firstNumber, double secondNumber) {
        doubleBinaryOperator = (x, y) -> x * y;
        return doubleBinaryOperator.applyAsDouble(firstNumber, secondNumber);
    }

    /**
     * Метод, реализующий математическую операцию деления
     *
     * @param firstNumber  первое число математической операции деления в формате double
     * @param secondNumber второе число математической операции деления в формате double
     * @return результат математической операции деления в формате double
     */
    @Override
    public double division(double firstNumber, double secondNumber) {
        doubleBinaryOperator = (x, y) -> x / y;
        return doubleBinaryOperator.applyAsDouble(firstNumber, secondNumber);
    }
}
