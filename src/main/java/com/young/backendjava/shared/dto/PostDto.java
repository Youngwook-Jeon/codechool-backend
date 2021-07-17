package com.young.backendjava.shared.dto;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private long id;
    private String postId;
    private String title;
    private String content;
    private LocalDateTime expiredAt;
    private LocalDateTime createdAt;
    private UserDto user;
    private ExposureDto exposure;
}
