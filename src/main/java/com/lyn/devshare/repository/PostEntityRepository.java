package com.lyn.devshare.repository;

import com.lyn.devshare.entity.CategoryEntity;
import com.lyn.devshare.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostEntityRepository extends JpaRepository<PostEntity, Long> {
    List<PostEntity> findPostEntitiesByAuthor_Id(Long authorId);
    List<PostEntity> findDistinctByCategories_IdIn(List<Long> ids);
}
