package com.learning.inventory.mapper;

import com.learning.inventory.dto.ProductRequestDTO;
import com.learning.inventory.dto.ProductResponseDTO;
import com.learning.inventory.entity.Category;
import com.learning.inventory.entity.Product;

public interface ProductMapper {
    ProductResponseDTO toDto(Product product);
    Product toEntity(ProductRequestDTO dto, Category category);
    /** Copies request fields onto an existing entity, for updates. */
    void updateEntityFromDto(ProductRequestDTO dto, Category category, Product target);
}
