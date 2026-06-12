package com.project.boardDB.controller;

import com.project.boardDB.dto.AuthRequest;
import com.project.boardDB.dto.LoginResponse;
import com.project.boardDB.dto.RegisterResponse;
import com.project.boardDB.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@RequestBody AuthRequest request) {
        RegisterResponse response = authService.register(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody AuthRequest request) {
        LoginResponse response = authService.login(request);

        return ResponseEntity.ok(response);
    }
}