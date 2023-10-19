package com.lyn.devshare.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "user_sys")
public class UserEntity {
    @Id
    @SequenceGenerator(name="user_sys_seq",sequenceName="user_sys_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="user_sys_seq")
    private Long id;
    private String name;
}
