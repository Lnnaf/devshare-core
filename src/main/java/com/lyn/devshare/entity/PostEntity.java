package com.lyn.devshare.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostEntity {
    @Id
    @SequenceGenerator(name="post_seq",sequenceName="post_seq", allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="post_seq")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    @JsonBackReference
    private UserEntity author;
    private Date createdDate;
    private Date modifiedDate;
    @ManyToOne
    @JoinColumn(name = "modified_by_id")
    private UserEntity modifiedBy;
    private String content;
    private String title;
    private String shortDescription;
    @Column(columnDefinition = "int default 0")
    private int viewed;
    private String thumbImageUrl;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "category_post",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<CategoryEntity> categories = new LinkedHashSet<>();

}
