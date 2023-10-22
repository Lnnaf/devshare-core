package com.lyn.devshare.services.impl;

import com.lyn.devshare.dto.CategoryDto;
import com.lyn.devshare.dto.PostDto;
import com.lyn.devshare.entity.CategoryEntity;
import com.lyn.devshare.mapper.CategoryEntityMapper;
import com.lyn.devshare.mapper.PostEntityMapper;
import com.lyn.devshare.repository.CategoryEntityRepository;
import com.lyn.devshare.repository.PostEntityRepository;
import com.lyn.devshare.services.GenericService;
import com.lyn.devshare.services.IPostService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.BooleanUtils;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PostService implements IPostService, GenericService<PostDto, Long> {
    private final PostEntityRepository postEntityRepository;
    private final CategoryEntityRepository categoryEntityRepository;
    private final PostEntityMapper postEntityMapper;
    private final CategoryEntityMapper categoryEntityMapper;

    @Override
    public List<PostDto> findAll() {
        return postEntityMapper.toDto(postEntityRepository.findAll());
    }

    @Override
    public PostDto findById(Long id) {
        return postEntityMapper.toDto(postEntityRepository.findById(id).orElse(null));
    }

    @Override
    public PostDto save(PostDto postDto) {
        var entity = postEntityMapper.toEntity(postDto);
        var categories = categoryEntityRepository.findAllByIdIn(postDto.getCategories().stream().map(CategoryDto::getId).toList());
        entity.setCategories(new HashSet<>(categories));
        return postEntityMapper.toDto(postEntityRepository.save(entity));
    }

    @Override
    public boolean delete(PostDto postDto) {
        var entity = postEntityMapper.toEntity(postDto);
        postEntityRepository.delete(entity);
        return BooleanUtils.isFalse(postEntityRepository.existsById(entity.getId()));
    }

    @Override
    public List<PostDto> findAllByAuthorId(Long authorId) {
        return postEntityMapper.toDto(postEntityRepository.findPostEntitiesByAuthor_Id(authorId));
    }

    @Override
    public List<PostDto> findAllByCategoryIds(List<Long> categoryIds) {
        var posts = postEntityRepository.findDistinctByCategories_IdIn(categoryIds);
        return postEntityMapper.toDto(posts);
    }

    @Override
    public List<PostDto> findAllSortedByNewest() {
        return null;
    }
}
