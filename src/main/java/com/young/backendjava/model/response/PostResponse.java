package com.young.backendjava.model.response;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostResponse {

    private String postId;
    private String title;
    private String content;
    private LocalDateTime expiredAt;
    private LocalDateTime createdAt;
    private boolean expired;
    private UserResponse user;
    private ExposureResponse exposure;

}
