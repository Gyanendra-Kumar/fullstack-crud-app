package com.learning.inventory.service;

import com.learning.inventory.dto.ProductRequestDTO;
import com.learning.inventory.dto.ProductResponseDTO;

import java.util.List;

/**
 * The Controller depends on THIS interface, never on ProductServiceImpl
 * directly (Dependency Inversion Principle). That means:
 *  - you can unit test the controller with a mock implementation
 *  - you could add a CachedProductService decorator later without touching
 *    the controller (Open/Closed Principle)
 */
public interface ProductService {
    ProductResponseDTO create(ProductRequestDTO request);
    ProductResponseDTO getById(Long id);
    List<ProductResponseDTO> getAll();
    List<ProductResponseDTO> getByCategory(Long categoryId);
    ProductResponseDTO update(Long id, ProductRequestDTO request);
    void delete(Long id);
}
