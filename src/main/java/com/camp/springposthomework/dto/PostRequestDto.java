package com.camp.springposthomework.dto;

import com.camp.springposthomework.entity.Post;
import lombok.Getter;



// Dto에는 사용하는 정보만 입력하고 따로 생성자를 만들지 않는다.
// 생성자처리는 본 클래서에서 작성한다. 여기는 정말 정보를 가지고 이동하는 역할만 한다.

@Getter
public class PostRequestDto {

    private Long id;
    private String title;
    private String content;
   private String author;
   private String password;

    }

