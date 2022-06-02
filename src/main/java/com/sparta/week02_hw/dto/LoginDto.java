package com.sparta.week02_hw.dto;

import com.sun.istack.NotNull;
import lombok.*;

import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class LoginDto {

    @NotNull
    @Size(min=3, max=50)
    private String username;

    @NotNull
    @Size(min=4, max=100)
    private String password;
}
