package com.company.entity;

import com.company.enums.DigitalSystem;
import com.company.enums.MathOperation;

/**
 * Класс для задания математической операции
 *
 * @param firstNumber   первое число математической операции в формате String
 * @param secondNumber  второе число математической операции в формате String
 * @param mathOperation вид математической операции в формате перечисляемого типа {@link MathOperation}
 * @param digitalSystem вид системы счисления в формате перечисляемого типа {@link DigitalSystem}
 */
public record MathExpression(
        String firstNumber,
        String secondNumber,
        MathOperation mathOperation,
        DigitalSystem digitalSystem
) {
}
