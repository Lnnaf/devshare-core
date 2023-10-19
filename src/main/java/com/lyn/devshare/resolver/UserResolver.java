package com.lyn.devshare.resolver;

import com.lyn.devshare.dto.User;
import com.lyn.devshare.services.UserService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserResolver implements GraphQLQueryResolver {
    private final UserService userService;
    public User user (Long id) {
        return userService.getUserById(id);
    }
}
