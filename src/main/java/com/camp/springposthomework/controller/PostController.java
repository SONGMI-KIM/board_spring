package com.camp.springposthomework.controller;


import com.camp.springposthomework.dto.PostRequestDto;
import com.camp.springposthomework.dto.PostResponseDto;
import com.camp.springposthomework.repository.PostRepository;
import com.camp.springposthomework.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostService postService;
    private final PostRepository postRepository;

    // 게시글 작성
    @PostMapping("/api/posts")
    public PostResponseDto creatPost(@RequestBody PostRequestDto postRequestDto) {
        return postService.creatPost(postRequestDto);
    }

    // 전체 게시글 목록조회
    @GetMapping("api/posts")
    public List<PostResponseDto> getPosts() {
        return postService.getPosts();
    }

    // 선택한 게시글 조회
    @GetMapping("/api/posts/{id}")
    public PostResponseDto getPost(@PathVariable Long id) {
        return postService.getPost(id);
    }


    // 선택한 게시글 수정
    @PutMapping("/api/posts/{id}")
    public PostResponseDto updatePost(@PathVariable Long id, @RequestBody PostRequestDto postRequestDto) {
        return postService.updatePost(id, postRequestDto);
    }

    // 선택한 게시글 삭제
//    @DeleteMapping("api/posts/{id}")
//    public Long deletePost(@PathVariable Long id, PostRequestDto postRequestDto){
//        return postService.deletePost(id, postRequestDto);
//    }

    // 선택한 게시글 삭제 - 비밀번호 확인 후 삭제가능
    @DeleteMapping("api/posts/{id}/{password}")
    public Long deletePost(@PathVariable Long id, @PathVariable String password) {//추가
        return postService.deletePost(id, password);
    }
}
