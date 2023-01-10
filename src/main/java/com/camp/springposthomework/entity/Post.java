package com.camp.springposthomework.entity;


import com.camp.springposthomework.dto.PostRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@NoArgsConstructor
@Getter
@Entity
public class Post extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String password;


    // 1. 이게 원래 생성자 -> 생성자는 원래 만드는 것 처럼 본 클래스, 데이터가 있는 클래스에 만든다.
    // 2. 데이터를 가지고 이동하는 Dto를 만들고 나서는 Dto가 데이터를 가지고 움직여햐 하기 때문에 생성자를 아래와 같이 변경해준다.

//    public Post(Long id, String title, String content, String author, String password) {
//        this.id = id;
//        this.title = title;
//        this.content = content;
//        this.author = author;
//        this.password = password;
//    }

    // Dto 생성에 따라 변경된 생성자
    // 중요) Dto로 정보를 받으면 다른 정보가 변경되는게 아니라 본 클래스에 생성자만 변경된다!
    public Post(PostRequestDto postRequestDto) {
        this.title = postRequestDto.getTitle();
        this.content = postRequestDto.getContent();
        this.author = postRequestDto.getAuthor();
        //this.password = postRequestDto.getPassword();
    }

    //update 메소드
    public void updatePost(PostRequestDto postRequestDto){
        this.title = postRequestDto.getTitle();
        this.content = postRequestDto.getContent();
        this.author =postRequestDto.getAuthor();
    }

}
