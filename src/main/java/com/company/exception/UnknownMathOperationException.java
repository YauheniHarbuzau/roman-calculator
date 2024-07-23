package com.company.exception;

import com.company.constant.Constant;

import static com.company.constant.Constant.UNKNOWN_MATH_OPERATION_EXCEPTION_MESSAGE_FORMAT;

/**
 * Исключение, генерируемое при неправильном виде математической операции
 *
 * @see Constant
 */
public class UnknownMathOperationException extends RuntimeException {

    private UnknownMathOperationException(String message) {
        super(message);
    }

    public static UnknownMathOperationException of(String source) {
        return new UnknownMathOperationException(
                String.format(UNKNOWN_MATH_OPERATION_EXCEPTION_MESSAGE_FORMAT, source)
        );
    }
}
