package com.lyn.devshare.mapper;

import com.lyn.devshare.dto.CategoryDto;
import com.lyn.devshare.entity.CategoryEntity;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CategoryEntityMapper {
    CategoryEntity toEntity(CategoryDto categoryDto);

    CategoryDto toDto(CategoryEntity categoryEntity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    CategoryEntity partialUpdate(CategoryDto categoryDto, @MappingTarget CategoryEntity categoryEntity);
}
