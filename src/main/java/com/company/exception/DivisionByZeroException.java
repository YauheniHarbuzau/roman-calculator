package com.company.exception;

import com.company.constant.Constant;

import static com.company.constant.Constant.DIVISION_BY_ZERO_EXCEPTION_MESSAGE_FORMAT;

/**
 * Исключение, генерируемое при выполнении математической операции деления на ноль
 *
 * @see Constant
 */
public class DivisionByZeroException extends RuntimeException {

    private DivisionByZeroException(String message) {
        super(message);
    }

    public static DivisionByZeroException of() {
        return new DivisionByZeroException(DIVISION_BY_ZERO_EXCEPTION_MESSAGE_FORMAT);
    }
}
