package com.project.examenapirest.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Clase auxiliar config para determinar el mínimo stock
 * Por defecto está a 100 en properties
 */
@Component
@ConfigurationProperties(prefix = "item")
public class ItemConfig {

    @Getter
    @Setter
    private Integer minStock;
}
