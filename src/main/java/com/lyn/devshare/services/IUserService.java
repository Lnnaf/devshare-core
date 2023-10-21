package com.lyn.devshare.services;

import com.lyn.devshare.dto.UserDto;

public interface IUserService {
    public UserDto getUserById(Long id);
}
