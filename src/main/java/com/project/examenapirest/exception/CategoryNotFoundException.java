package com.project.examenapirest.exception;

/**
 * Excepción personalizada para Categoría no encontrada
 */
public class CategoryNotFoundException extends RuntimeException {
    public CategoryNotFoundException(String message) {
        super(message);
    }
}
