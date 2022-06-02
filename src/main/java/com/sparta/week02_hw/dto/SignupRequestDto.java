package com.sparta.week02_hw.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SignupRequestDto {
    private String username;
    private String name;
    private String password;
    private boolean admin = false;
    private String adminToken = "";
}