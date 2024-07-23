package com.company.exception;

import com.company.constant.Constant;

import static com.company.constant.Constant.DIGITAL_SYSTEM_EXCEPTION_MESSAGE_FORMAT;

/**
 * Исключение, генерируемое при разном виде системы счисления двух чисел математической операции
 *
 * @see Constant
 */
public class DigitalSystemException extends RuntimeException {

    private DigitalSystemException(String message) {
        super(message);
    }

    public static DigitalSystemException of(String[] numbers) {
        return new DigitalSystemException(
                String.format(DIGITAL_SYSTEM_EXCEPTION_MESSAGE_FORMAT, numbers[0], numbers[1])
        );
    }
}
