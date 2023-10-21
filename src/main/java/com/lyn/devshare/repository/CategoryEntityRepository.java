package com.lyn.devshare.repository;

import com.lyn.devshare.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryEntityRepository extends JpaRepository<CategoryEntity, Long> {
    List<CategoryEntity> findAllByIdIn(List<Long> ids);
}
