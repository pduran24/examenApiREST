package com.project.examenapirest.service;



import com.project.examenapirest.config.ItemConfig;
import com.project.examenapirest.dto.StatsDTO;
import com.project.examenapirest.exception.CategoryNotFoundException;
import com.project.examenapirest.exception.ItemNotFoundException;
import com.project.examenapirest.model.Item;
import com.project.examenapirest.repository.ItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio para la entidad Item
 * Cumple la lógica de negocio
 */
@Service
@AllArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;
    private final ItemConfig itemConfig;

    /**
     * HISTORIA A - Añade un nuevo ítem a la tienda
     */
    public void agregarItem(Item item) {
        itemRepository.save(item);
    }

    /**
     * HISTORIA B - Elimina item de la tienda
     */
    public void eliminarItem(Integer itemId) {
        findById(itemId);
        itemRepository.deleteByItemId(itemId);
    }

    /**
     * HISTORIA C - devuelve un Item por su Id
     */
    public Item findById(Integer itemId) {
        return itemRepository.findByItemId(itemId)
                .orElseThrow(() -> new ItemNotFoundException("Item no encontrado"));
    }

    /**
     * HISTORIA D - Devuelve lista de Items según la categoría
     */
    public List<Item> findByCategory(String category) {
        return itemRepository.findByCategory(category)
                .orElseThrow(() -> new CategoryNotFoundException("Category no encontrada"));
    }

    /**
     * HISTORIA E - Cambia la categoría de un Item
     */
    public void cambiarCategoria(String catAntigua, String catNueva) {
        List<Item> items = findByCategory(catAntigua);

        items.forEach(item -> item.setCategory(catNueva));

        itemRepository.saveAll(items);
    }


    /**
     * HISTORIA F - Devuelve los stats de la tienda
     */
    public StatsDTO obtenerStats() {
        List<String> manufacturers = itemRepository.findAll()
                .stream()
                .map(Item::getManufacturer)
                .distinct()
                .toList();

        return new  StatsDTO(
                itemRepository.count(),
                itemRepository.countByCountLessThan(itemConfig.getMinStock()),
                manufacturers
        );
    }
}
