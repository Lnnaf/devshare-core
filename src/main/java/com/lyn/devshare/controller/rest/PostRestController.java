package com.lyn.devshare.controller.rest;

import com.lyn.devshare.dto.PostDto;
import com.lyn.devshare.dto.ResponseBase;
import com.lyn.devshare.enums.ResponseStatus;
import com.lyn.devshare.services.impl.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("post")
@RequiredArgsConstructor
@Slf4j
public class PostRestController {
    private final PostService postService;
    @PostMapping
    public ResponseEntity<ResponseBase> addNewPost (@RequestBody PostDto postDto) {
        PostDto result = null;
        var resBuilder = ResponseBase.builder();
        try {
          result = postService.save(postDto);
        } catch (Exception e) {
            log.error("error: {}", e.getMessage());
            resBuilder.msg(e.getMessage());
            resBuilder.code(500);
            resBuilder.status(ResponseStatus.ERROR);
            return new ResponseEntity<>(resBuilder.build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        var isSuccess = result != null;
        resBuilder.data(result);
        resBuilder.code(isSuccess ? 201 : 400);
        resBuilder.status(isSuccess ? ResponseStatus.SUCCESS : ResponseStatus.FAIL);
        var res = resBuilder.build();
        return new ResponseEntity<>(res, HttpStatus.valueOf(res.getCode()));
    }
}
