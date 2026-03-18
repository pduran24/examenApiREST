package com.project.examenapirest.dto;

import com.project.examenapirest.model.Item;

import java.util.List;

/**
 * DTO para los stats de la tienda
 * Uso record ya que es más moderno, rápido y seguro
 */
public record StatsDTO(
        Long totalItems,
        List<Item> lowStock,
        List<String> manufacturers
) {
}
