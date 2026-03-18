package com.project.examenapirest.repository;

import com.project.examenapirest.model.Item;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repositorio para la entidad Item
 */
@Repository
public interface ItemRepository extends MongoRepository<Item, String> {

    // HU - B
    void deleteByItemId(Integer itemId);

    // HU - C
    Optional<Item> findByItemId(Integer itemId);

    // HU - E
    Optional<List<Item>> findByCategory(String category);

    // auxiliar para determinar si el item es inferior al mínimo low stock (100 por defecto)
    List<Item> countByCountLessThan(Integer countIsLessThan);
}

