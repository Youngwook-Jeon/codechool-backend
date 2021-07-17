package com.young.backendjava.controller;

import com.young.backendjava.model.request.UserDetailsRequestModel;
import com.young.backendjava.model.response.PostResponse;
import com.young.backendjava.model.response.UserResponse;
import com.young.backendjava.service.UserService;
import com.young.backendjava.shared.dto.PostDto;
import com.young.backendjava.shared.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private final ModelMapper modelMapper;
    private final UserService userService;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public UserResponse getUser() {
        String email = getEmailFromLoggedInUser();
        UserDto userDto = userService.getUser(email);
        return modelMapper.map(userDto, UserResponse.class);
    }

    @PostMapping
    public UserResponse createUser(@RequestBody @Valid UserDetailsRequestModel userDetails) {
        UserDto userDto = modelMapper.map(userDetails, UserDto.class);
        UserDto newUser = userService.createUser(userDto);
        return modelMapper.map(newUser, UserResponse.class);
    }

    @GetMapping("/posts")
    public List<PostResponse> getPosts() {
        String email = getEmailFromLoggedInUser();
        List<PostDto> postDtos = userService.getUserPosts(email);
        List<PostResponse> postResponses = new ArrayList<>();
        for (PostDto postDto: postDtos) {
            PostResponse postResponse = modelMapper.map(postDto, PostResponse.class);
            if (postResponse.getExpiredAt().isBefore(LocalDateTime.now())) {
                postResponse.setExpired(true);
            }
            postResponses.add(postResponse);
        }

        return postResponses;
    }

    private String getEmailFromLoggedInUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getPrincipal().toString();
    }
}
