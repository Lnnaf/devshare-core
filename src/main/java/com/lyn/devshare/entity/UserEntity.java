package com.lyn.devshare.entity;

import com.lyn.devshare.enums.RoleType;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "user_sys")
public class UserEntity {
    @Id
    @SequenceGenerator(name="user_sys_seq",sequenceName="user_sys_seq", allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="user_sys_seq")
    private Long id;
    private String username;
    private String password;
    private String displayName;
    private Date dateJoin;
    private Date birthday;
    private String email;
    @Enumerated(EnumType.STRING)
    private RoleType roleType;
    @OneToMany(mappedBy = "author")
    private List<PostEntity> posts;
}
