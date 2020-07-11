package com.junior.personcadastre.exception;

/**
 * Custom exception for BadRequest.
 *
 * @author Júnior Moreira Martins
 */
public class BadRequestException extends BaseException {

    private static final String title = "Bad Request";

    private static final Integer status = 400;

    public BadRequestException(String message) {
        this(title, message);
    }

    public BadRequestException(String title, String message) {
        super(title, status, message);
    }

}
