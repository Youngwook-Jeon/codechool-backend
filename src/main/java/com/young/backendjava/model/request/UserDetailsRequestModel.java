package com.young.backendjava.model.request;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class UserDetailsRequestModel {

    @NotEmpty(message = "이름이 필요합니다.")
    private String firstName;

    @NotEmpty(message = "성씨가 필요합니다.")
    private String lastName;

    @NotEmpty(message = "이메일 주소가 필요합니다.")
    @Email(message = "유효한 이메일 주소가 아닙니다.")
    private String email;

    @NotEmpty(message = "패스워드가 필요합니다.")
    @Size(min = 8, max = 30, message = "8자 이상, 30자 이하로 입력하세요.")
    private String password;
}
