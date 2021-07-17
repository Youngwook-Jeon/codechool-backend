package com.young.backendjava.service;

import com.young.backendjava.shared.dto.PostDto;
import com.young.backendjava.shared.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    UserDto createUser(UserDto userDto);
    UserDto getUser(String email);
    List<PostDto> getUserPosts(String email);
}
