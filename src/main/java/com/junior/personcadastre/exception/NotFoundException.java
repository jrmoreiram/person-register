package com.junior.personcadastre.exception;

/**
 * Excessão customizada para NotFound.
 *
 * Lançado quando não é encontrado o que foi solicitado.
 *
 * @author Júnior Moreira Martins
 */
public class NotFoundException extends BaseException {

    private static final String title = "Not Found";

    private static final Integer status = 404;

    public NotFoundException(String title, String message) {
        super(title, status, message);
    }

    public NotFoundException(String message) {
        this(title, message);
    }

}
