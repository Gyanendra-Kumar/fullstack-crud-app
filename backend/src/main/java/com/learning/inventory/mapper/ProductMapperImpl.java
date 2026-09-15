package com.learning.inventory.mapper;

import com.learning.inventory.dto.ProductRequestDTO;
import com.learning.inventory.dto.ProductResponseDTO;
import com.learning.inventory.entity.Category;
import com.learning.inventory.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductMapperImpl implements ProductMapper {

    private final CategoryMapper categoryMapper;

    @Override
    public ProductResponseDTO toDto(Product product) {
        if (product == null) return null;
        return ProductResponseDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .category(categoryMapper.toDto(product.getCategory()))
                .createdAt(product.getCreatedAt())
                .updatedAt(product.getUpdatedAt())
                .build();
    }

    @Override
    public Product toEntity(ProductRequestDTO dto, Category category) {
        return Product.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .price(dto.getPrice())
                .quantity(dto.getQuantity())
                .category(category)
                .build();
    }

    @Override
    public void updateEntityFromDto(ProductRequestDTO dto, Category category, Product target) {
        target.setName(dto.getName());
        target.setDescription(dto.getDescription());
        target.setPrice(dto.getPrice());
        target.setQuantity(dto.getQuantity());
        target.setCategory(category);
    }
}
