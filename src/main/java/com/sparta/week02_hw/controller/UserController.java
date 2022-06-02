package com.sparta.week02_hw.controller;
import com.sparta.week02_hw.dto.SignupRequestDto;
import com.sparta.week02_hw.dto.UserDto;
import com.sparta.week02_hw.models.User;
import com.sparta.week02_hw.repository.UserRepository;
import com.sparta.week02_hw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class UserController {

    private final UserRepository userRepository;
    private final UserService userService;

    @Autowired
    public UserController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }


    // 회원 가입 요청
    @PostMapping("/user/signup")
    public void registerUser(SignupRequestDto requestDto) {
        userService.registerUser(requestDto);
    }

    // 회원 정보 조회
    @GetMapping("/user/")
    public List<User> getUsers() {
        return userRepository.findAll();
    }













}