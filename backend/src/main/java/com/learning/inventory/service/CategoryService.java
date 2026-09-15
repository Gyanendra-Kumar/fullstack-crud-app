package com.learning.inventory.service;

import com.learning.inventory.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {
    CategoryDTO create(CategoryDTO dto);
    CategoryDTO getById(Long id);
    List<CategoryDTO> getAll();
    void delete(Long id);
}
