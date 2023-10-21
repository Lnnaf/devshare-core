package com.lyn.devshare.dto;

import com.lyn.devshare.enums.RoleType;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * DTO for {@link com.lyn.devshare.entity.UserEntity}
 */
@Data
public class UserDto implements Serializable {
    Long id;
    String username;
    String displayName;
    Date dateJoin;
    Date birthday;
    String email;
    RoleType roleType;

}
