package com.young.backendjava.service;

import com.young.backendjava.shared.dto.PostCreationDto;
import com.young.backendjava.shared.dto.PostDto;

import java.util.List;

public interface PostService {
    PostDto createPost(PostCreationDto post);

    List<PostDto> getLastPosts();

    PostDto getPost(String postId);

    void deletePost(String postId, long userId);

    PostDto updatePost(String postId, long userId, PostCreationDto postUpdateDto);
}
