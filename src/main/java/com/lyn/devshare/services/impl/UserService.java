package com.lyn.devshare.services.impl;

import com.lyn.devshare.dto.UserDto;
import com.lyn.devshare.entity.UserEntity;
import com.lyn.devshare.mapper.UserEntityMapper;
import com.lyn.devshare.repository.UserEntityRepository;

import com.lyn.devshare.services.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final UserEntityRepository userRepository;
    private final UserEntityMapper userEntityMapper;
    @Override
    public UserDto getUserById(final Long id) {
        var userEntity = userRepository.findById(id).orElse(null);
        return userEntityMapper.toDto(userEntity);
    }
}
