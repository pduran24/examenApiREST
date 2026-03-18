package com.project.examenapirest.controller;

import com.project.examenapirest.dto.StatsDTO;
import com.project.examenapirest.model.Item;
import com.project.examenapirest.service.ItemService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST que expone los endpoints de la API de los Items.
 * Cada cumple según la HU
 */
@RestController
@RequestMapping("/items")
@SecurityRequirement(name = "basicAuth")
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    /**
     * HU A - endpoint para agregar Item
     */
    @PostMapping
    public ResponseEntity<Void> agregarItem(@RequestBody Item item) {
        itemService.agregarItem(item);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * HU B - endpoint para eliminar Item
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarItem(@PathVariable Integer id) {
        itemService.eliminarItem(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    /**
     * HU C - obtener los detalles de un Item
     */
    @GetMapping("/{id}")
    public ResponseEntity<Item> obtenerDetalles(@PathVariable Integer id) {
        return ResponseEntity.ok(itemService.findById(id));
    }

    /**
     * HU D - Listar Items por Categoria
     */
    @GetMapping("/categoria/{categoria}")
    public ResponseEntity<List<Item>> listarPorCategoria(@PathVariable String categoria) {
        return ResponseEntity.ok(itemService.findByCategory(categoria));
    }

    /**
     * HU E - cambiar categoria de Item
     */
    @PutMapping("/categoria")
    public ResponseEntity<Void> cambiarCategoria(
            @RequestParam String catAntigua,
            @RequestParam String catNueva
    ) {
        itemService.cambiarCategoria(catAntigua, catNueva);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    /**
     * HU F - mostrar stats de la tienda
     */
    @GetMapping("/stats")
    public ResponseEntity<StatsDTO> mostrarEstadisticas() {
        return ResponseEntity.ok(itemService.obtenerStats());
    }
}
