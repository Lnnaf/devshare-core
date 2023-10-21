package com.lyn.devshare.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.lyn.devshare.entity.CategoryEntity}
 */
@Value
public class CategoryDto implements Serializable {
    Long id;
    String name;
    String description;
}
