package com.portfolio.cms.webTest.posts.service;

import com.portfolio.cms.webTest.posts.dto.PostsListResponseDto;
import com.portfolio.cms.webTest.posts.dto.PostsResponseDto;
import com.portfolio.cms.webTest.posts.dto.PostsSaveRequestDto;
import com.portfolio.cms.webTest.posts.dto.PostsUpdateRequestDto;
import com.portfolio.cms.webTest.posts.repository.PostsRepository;
import com.portfolio.cms.webTest.posts.vo.Posts;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No Posts. id : " + id));
        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }
    
    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No Posts. id : " + id));
        
        return new PostsResponseDto(entity);
    }
    
    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc() {
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }
    
    @Transactional
    public void delete(Long id) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No Posts. id : " + id));
        postsRepository.delete(posts);
    }
}
