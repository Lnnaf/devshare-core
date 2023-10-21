package com.lyn.devshare.dto;

import com.lyn.devshare.enums.RoleType;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * DTO for {@link com.lyn.devshare.entity.PostEntity}
 */
@Data
public class PostDto implements Serializable {
    Long id;
    UserDto author;
    String content;
    private Date createdDate;
    private Date modifiedDate;
    private String title;
    private String shortDescription;
    private int viewed;
    private String thumbImageUrl;

    private UserDto modifiedBy;
    private Set<CategoryDto> categories = new LinkedHashSet<>();
}
