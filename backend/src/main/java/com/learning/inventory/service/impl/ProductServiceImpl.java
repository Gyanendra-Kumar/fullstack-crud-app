package com.learning.inventory.service.impl;

import com.learning.inventory.dto.ProductRequestDTO;
import com.learning.inventory.dto.ProductResponseDTO;
import com.learning.inventory.entity.Category;
import com.learning.inventory.entity.Product;
import com.learning.inventory.exception.ResourceNotFoundException;
import com.learning.inventory.mapper.ProductMapper;
import com.learning.inventory.repository.CategoryRepository;
import com.learning.inventory.repository.ProductRepository;
import com.learning.inventory.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * All business logic lives here, not in the controller and not in the
 * repository. Constructor injection (via @RequiredArgsConstructor on final
 * fields) is how Spring performs Dependency Inversion: this class asks for
 * abstractions (ProductRepository, ProductMapper) and doesn't care how
 * they're implemented.
 */
@Service
@RequiredArgsConstructor
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ProductMapper productMapper;

    @Override
    public ProductResponseDTO create(ProductRequestDTO request) {
        Category category = findCategoryOrThrow(request.getCategoryId());
        Product product = productMapper.toEntity(request, category);
        Product saved = productRepository.save(product);
        return productMapper.toDto(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public ProductResponseDTO getById(Long id) {
        return productMapper.toDto(findProductOrThrow(id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductResponseDTO> getAll() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::toDto)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductResponseDTO> getByCategory(Long categoryId) {
        return productRepository.findByCategoryId(categoryId)
                .stream()
                .map(productMapper::toDto)
                .toList();
    }

    @Override
    public ProductResponseDTO update(Long id, ProductRequestDTO request) {
        Product existing = findProductOrThrow(id);
        Category category = findCategoryOrThrow(request.getCategoryId());
        productMapper.updateEntityFromDto(request, category, existing);
        Product saved = productRepository.save(existing);
        return productMapper.toDto(saved);
    }

    @Override
    public void delete(Long id) {
        if (!productRepository.existsById(id)) {
            throw new ResourceNotFoundException("Product not found with id: " + id);
        }
        productRepository.deleteById(id);
    }

    private Product findProductOrThrow(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
    }

    private Category findCategoryOrThrow(Long categoryId) {
        return categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + categoryId));
    }
}
