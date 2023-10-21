package com.lyn.devshare.controller.graphql;

import com.lyn.devshare.dto.PostDto;
import com.lyn.devshare.services.impl.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class PostGraphqlController {
    private final PostService postService;

    @QueryMapping
    public List<PostDto> getPostsByAuthorId(@Argument Long authorId) {
        return postService.findAllByAuthorId(authorId);
    }

    @QueryMapping
    public PostDto getPostByPostId(@Argument Long postId) {
        return postService.findById(postId);
    }

    @QueryMapping
    public List<PostDto> getPostsByCategoryIds(@Argument List<Long> categoryIds) {
        return postService.findAllByCategoryIds(categoryIds);
    }

    @QueryMapping
    public List<PostDto> getPostsSortedByNewest() {
        return postService.findAllSortedByNewest();
    }
}
