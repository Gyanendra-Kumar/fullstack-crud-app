package com.learning.inventory.mapper;

import com.learning.inventory.dto.CategoryDTO;
import com.learning.inventory.entity.Category;

/**
 * Interface Segregation + Dependency Inversion: services depend on this
 * abstraction, not a concrete mapping implementation. Swapping in MapStruct
 * later means writing a new implementation of this interface — nothing else
 * has to change.
 */
public interface CategoryMapper {
    CategoryDTO toDto(Category category);
    Category toEntity(CategoryDTO dto);
}
