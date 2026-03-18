package com.project.examenapirest.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Entidad que representa un artículo de la tienda.
 */
@Document(collection = "examenCollection")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Item {

    @Id
    private String _id;

    @Indexed(unique=true)
    @Field("id")
    @JsonProperty("id")
    private Integer itemId;

    private String title;
    private Double price;
    private String category;
    private String description;
    private Double rate;
    private Integer count;
    private String color;
    private String manufacturer;
    private String ean;
    private String image;
}
