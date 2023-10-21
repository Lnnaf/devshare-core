package com.lyn.devshare.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryEntity {
    @ManyToMany(mappedBy = "categories", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private Set<PostEntity> posts = new LinkedHashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_entity_seq")
    @SequenceGenerator(name = "category_entity_seq", sequenceName = "category_entity_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private String description;
}
