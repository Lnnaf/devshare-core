package com.lyn.devshare.services;

import com.lyn.devshare.dto.User;
import com.lyn.devshare.entity.UserEntity;
import com.lyn.devshare.repository.IUserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{
    private final IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserById(final Long id) {

        var userEntity = userRepository.findById(id).orElse(new UserEntity());
        var user = new User();
        BeanUtils.copyProperties(userEntity, user);
        return user;
    }
}
