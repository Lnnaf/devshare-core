package com.lyn.devshare.services;

import com.lyn.devshare.dto.PostDto;

import java.util.List;

public interface IPostService {
    List<PostDto> findAllByAuthorId(Long authorId);
    List<PostDto> findAllByCategoryIds(List<Long> categoryIds);
    List<PostDto> findAllSortedByNewest();
}
