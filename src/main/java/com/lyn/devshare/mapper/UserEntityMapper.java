package com.lyn.devshare.mapper;

import com.lyn.devshare.dto.UserDto;
import com.lyn.devshare.entity.PostEntity;
import com.lyn.devshare.entity.UserEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserEntityMapper {
    UserEntity toEntity(UserDto userDTO);
    UserDto toDto(UserEntity userEntity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    UserEntity partialUpdate(UserDto userDTO, @MappingTarget UserEntity userEntity);

}
