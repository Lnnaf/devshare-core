package com.lyn.devshare.controller.graphql;

import com.lyn.devshare.dto.UserDto;
import com.lyn.devshare.services.impl.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
@RequiredArgsConstructor
public class UserGraphqlController {
    private final UserService userService;
    @QueryMapping
    public UserDto getUserById(@Argument Long id) {
        return userService.getUserById(id);
    }
}
