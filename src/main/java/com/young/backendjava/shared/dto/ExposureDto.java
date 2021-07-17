package com.young.backendjava.shared.dto;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExposureDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private long id;
    private String type;
    private List<PostDto> posts;
}
