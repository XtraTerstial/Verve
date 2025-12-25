package com.XtraCoder.Verve.controller;

import com.XtraCoder.Verve.dto.RegisterRequest;
import com.XtraCoder.Verve.dto.UserResponse;
import com.XtraCoder.Verve.entity.User;
import com.XtraCoder.Verve.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
//In this class new user registration, login, signup action proceeds

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody RegisterRequest registerRequest){
        
        return ResponseEntity.ok(userService.register(registerRequest));
    }
}
