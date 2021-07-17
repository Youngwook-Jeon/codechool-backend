package com.young.backendjava.model.request;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class PostCreationRequestModel {

    @NotEmpty(message = "제목이 필요합니다.")
    private String title;

    @NotEmpty(message = "내용이 필요합니다.")
    private String content;

    @NotNull(message = "공개/비공개 여부가 필요합니다.")
    @Range(min = 1, max = 2, message = "유효하지 않은 값입니다.")
    private Long exposureId;

    @NotNull(message = "만료시간이 필요합니다.")
    @Range(min = 0, max = 1440, message = "유효하지 않은 값입니다.")
    private Integer expirationTime;
}
