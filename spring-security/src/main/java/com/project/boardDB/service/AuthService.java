package com.project.boardDB.service;

import com.project.boardDB.config.JwtUtil;
import com.project.boardDB.dto.AuthRequest;
import com.project.boardDB.dto.LoginResponse;
import com.project.boardDB.dto.RegisterResponse;
import com.project.boardDB.entity.User;
import com.project.boardDB.exception.InvalidPasswordException;
import com.project.boardDB.exception.UserAlreadyExistsException;
import com.project.boardDB.exception.UserNotFoundException;
import com.project.boardDB.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    // 회원가입
    @Transactional
    public RegisterResponse register(AuthRequest request) {

        // 아이디 중복 확인
        if (userRepository.existsByUsername(request.username())) {
            throw new UserAlreadyExistsException();
        }

        // 비밀번호 암호화
        String encodedPassword = passwordEncoder.encode(request.password());

        // 회원 생성
        User user = new User(request.username(), encodedPassword);

        // DB 저장
        User savedUser = userRepository.save(user);

        // DTO 변환 후 반환
        return changeToRegisterResponse(savedUser);
    }

    // 로그인
    public LoginResponse login(AuthRequest request) {

        // 회원 조회
        User user = userRepository.findByUsername(request.username())
                .orElseThrow(UserNotFoundException::new);

        // 비밀번호 확인
        if (!passwordEncoder.matches(request.password(), user.getPassword())) {
            throw new InvalidPasswordException();
        }

        // JWT 토큰 생성
        String token = jwtUtil.createToken(user.getUsername());

        // DTO 변환 후 반환
        return changeToLoginResponse(token);
    }

    // Entity -> DTO 변환
    private RegisterResponse changeToRegisterResponse(User user) {
        return new RegisterResponse(
                user.getId(),
                user.getUsername()
        );
    }

    // Token -> DTO 변환
    private LoginResponse changeToLoginResponse(String token) {
        return new LoginResponse(token);
    }

}