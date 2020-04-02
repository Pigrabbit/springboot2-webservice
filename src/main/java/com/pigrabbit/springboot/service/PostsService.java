package com.pigrabbit.springboot.service;

import com.pigrabbit.springboot.domain.posts.Posts;
import com.pigrabbit.springboot.domain.posts.PostsRepository;
import com.pigrabbit.springboot.web.dto.PostsResponseDto;
import com.pigrabbit.springboot.web.dto.PostsSaveRequestDto;
import com.pigrabbit.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("No corresponding posts. id=" + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    };

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("No corresponding posts. id=" + id));

        return new PostsResponseDto(entity);
    };
}
