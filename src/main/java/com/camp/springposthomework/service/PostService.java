package com.camp.springposthomework.service;


import com.camp.springposthomework.dto.PostRequestDto;
import com.camp.springposthomework.dto.PostResponseDto;
import com.camp.springposthomework.entity.Post;
import com.camp.springposthomework.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    // 게시글 작성
    @Transactional
    public PostResponseDto creatPost(PostRequestDto postRequestDto){
        Post post = new Post(postRequestDto);
        postRepository.save(post);
        return new PostResponseDto(post);
    }

    // 전체 게시글 목록조회
    @Transactional(readOnly = true)
    public List<PostResponseDto> getPosts() {
        List<Post> postList = postRepository.findAllByOrderByModifiedAtDesc();
        List<PostResponseDto> postResponseDto = new ArrayList<>();
        for (Post post : postList) {
            postResponseDto.add(new PostResponseDto(post));
        }
        return postResponseDto;
    }
        //findAllByOrderByModifiedAtDesc() 자동으로 생성되지 않는 메소드 사용하려면 repository에 작성해줘야함


    // 선택한 게시글 조회
    @Transactional(readOnly = true)
    public PostResponseDto getPost(Long id){
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("게시글이 존재하지 않습니다.")
        );
        return new PostResponseDto(post);
    }

    // 선택한 게시글 수정 - 게시글 수정하고 수정한 게시물 id 반환
//    @Transactional
//    public Long updatePost(Long id, PostRequestDto postRequestDto) {
//        Post post = postRepository.findById(id).orElseThrow( // 기존에 있는 메모에 수정을 하는거니까 실제로 메모가 있는지 id로 확인을 해보는 과정
//                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
//        );
//        // 가지고온 메모의 값을 update메소드를 사용해서 client에서 보내준 값으로 변경을 해줄꺼다.client에서 보내준값이 뭐냐면 바로 postRequest
//        // 근데 update메소드가 아직 없기때문에 Post 엔티티 클래스 안에 만든다.
//        post.updatePost((postRequestDto));
//        return post.getId();
//    }

    // 선택한 게시글 수정 - 비밀번호 확인하고 게시물 수정 가능
    @Transactional
    public PostResponseDto updatePost(Long id, PostRequestDto postRequestDto) {
        Post post = postRepository.findById(id).orElseThrow( // 기존에 있는 메모에 수정을 하는거니까 실제로 메모가 있는지 id로 확인을 해보는 과정
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        if (postRequestDto.getPassword().equals(post.getPassword())) {
            post.updatePost(id, postRequestDto);
        } else {
            throw new IllegalArgumentException("수정 권한이 없습니다.");
        }
        return new PostResponseDto(post);
    }

    // 선택한 게시글 삭제 - 그냥 입력한 id의 게시믈 바로 삭제
//    @Transactional
//    public Long deletePost(Long id) {
//        postRepository.deleteById(id);
//        return id;
//    }

    // 선택한 게시글 삭제 - id, 비밀번호 확인후 삭제
    @Transactional
    public Long deletePost(Long id, String password){
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        if (post.getPassword().equals(password)){
            postRepository.deleteById(id);
            return id;
        }
        else {
            throw new IllegalArgumentException("삭제 권한이 없습니다.");
        }
    }


}
