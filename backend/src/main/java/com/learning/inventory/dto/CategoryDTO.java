package com.learning.inventory.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTOs exist so the API contract (what clients see) is decoupled from the
 * database schema (the Entity). You can change the entity without breaking
 * the frontend, and vice versa. This one doubles as request + response
 * since Category is simple; Product below splits them because request and
 * response genuinely differ (request takes categoryId, response returns
 * a nested CategoryDTO).
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryDTO {
    private Long id;

    @NotBlank(message = "Category name is required")
    private String name;
}
