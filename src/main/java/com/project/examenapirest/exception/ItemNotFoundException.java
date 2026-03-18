package com.project.examenapirest.exception;

/**
 * Excepción personalizada si el Id no se encuentra en la BD
 */
public class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException(String message) {
        super(message);
    }
}

