package com.project.examenapirest.dto;

/**
 * DTO para mostrar error de loggin
 */
public record ErrorResponseDTO(
        String error,
        String message,
        Integer errorCode
) {
}
