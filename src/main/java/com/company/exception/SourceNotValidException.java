package com.company.exception;

import com.company.constant.Constant;

import static com.company.constant.Constant.SOURCE_NOT_VALID_EXCEPTION_MESSAGE_FORMAT;

/**
 * Исключение, генерируемое при невалидных исходных данных
 *
 * @see Constant
 */
public class SourceNotValidException extends RuntimeException {

    private SourceNotValidException(String message) {
        super(message);
    }

    public static SourceNotValidException of(String source) {
        return new SourceNotValidException(
                String.format(SOURCE_NOT_VALID_EXCEPTION_MESSAGE_FORMAT, source)
        );
    }
}
