package com.young.backendjava.shared.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostCreationDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String title;
    private String content;
    private long exposureId;
    private long expirationTime;
    private String userEmail;
}
