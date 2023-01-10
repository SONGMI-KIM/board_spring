package com.camp.springposthomework.dto;

import com.camp.springposthomework.entity.Post;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostResponseDto {
    private String title;
    private String content;
    private String author;

    //private String password;
    private LocalDateTime createdimeAt;
    private LocalDateTime modifiedAt;

    //생성자
    public PostResponseDto(Post post) {
        this.title = post.getTitle();
        this.content = post.getContent();
        this.author = post.getAuthor();
        //this.password = post.getPassword();
        this.createdimeAt = post.getCreatedAt();
        this.modifiedAt = post.getModifiedAt();
    }
}
