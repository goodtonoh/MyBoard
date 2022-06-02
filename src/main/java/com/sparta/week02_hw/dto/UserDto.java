package com.sparta.week02_hw.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Pattern;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class UserDto {
    @NotNull
    @Length(min=3, message="닉네임은 최소 3자 이상이어야 합니다.")
    @Pattern(regexp="^[a-zA-Z0-9]+$", message="유효하지 않은 닉네임 입니다.")
    private String username;

    @NotNull
    @Length(min=4, message="닉네임은 최소 4자 이상이어야 합니다.")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @NotNull
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String confirmPassword;


}
