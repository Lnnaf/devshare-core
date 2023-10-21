package com.lyn.devshare.mapper;

import com.lyn.devshare.dto.PostDto;
import com.lyn.devshare.entity.PostEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface PostEntityMapper {

    PostEntity toEntity(PostDto postDto);

    List<PostEntity> toEntity(List<PostDto> postDto);

    PostDto toDto(PostEntity postEntity);

    List<PostDto> toDto(List<PostEntity> postEntity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)PostEntity partialUpdate(PostDto postDto, @MappingTarget PostEntity postEntity);
}
