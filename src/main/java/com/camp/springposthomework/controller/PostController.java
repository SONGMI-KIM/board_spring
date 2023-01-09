package com.camp.springposthomework.controller;


import com.camp.springposthomework.dto.PostRequestDto;
import com.camp.springposthomework.entity.Post;
import com.camp.springposthomework.service.PostService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@Getter
@RestController
public class PostController {

    private final PostService postService;

    // 전체 게시글 목록조회 -OK
    @GetMapping("api/posts")
    public List<Post> getPosts(){
        return postService.getPosts();
    }

    // 게시글 작성 -OK
   @PostMapping("/api/posts")
    public Post creatPost(@RequestBody PostRequestDto postRequestDto){
        return postService.creatPost(postRequestDto);
   }

    // 선택한 게시글 조회
    @GetMapping("/api/posts{id}")
    public List<Post> getPost(@PathVariable Long id){
        return postService.getPost(id);
    }

    // 선택한 게시글 수정 -OK
    @PutMapping("/api/posts{id}")
    public Long updatePost(@PathVariable Long id, @RequestBody PostRequestDto postRequestDto){
      return postService.updatePost(id, postRequestDto);
    }

    // 선택한 게시글 삭제 -OK
    @DeleteMapping("api/post{id}")
    public Long deletePost(@PathVariable Long id,PostRequestDto postRequestDto){ //Dto확인, Service도 함께 확인 필요
       return postService.deletePost(id,postRequestDto);
    }

}
