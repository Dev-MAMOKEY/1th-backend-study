package com.haonkr.jwt.service;

import com.haonkr.jwt.config.JwtUtil;
import com.haonkr.jwt.dto.LoginRequest;
import com.haonkr.jwt.dto.RegisterRequest;
import com.haonkr.jwt.dto.TokenResponse;
import com.haonkr.jwt.entity.User;
import com.haonkr.jwt.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private static final String DEFAULT_ROLE = "ROLE_USER";

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    // 회원가입
    @Transactional
    public void register(RegisterRequest request) {
        validateRequest(request.username(), request.password());

        if (userRepository.existsByUsername(request.username())) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                "이미 사용 중인 사용자 이름입니다."
            );
        }

        String encodedPassword = passwordEncoder.encode(request.password());

        User user = new User(request.username(), encodedPassword, DEFAULT_ROLE);

        userRepository.save(user);
    }

    // 로그인
    @Transactional(readOnly = true)
    public TokenResponse login(LoginRequest request) {
        validateRequest(request.username(), request.password());

        User user = userRepository.findByUsername(request.username())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.UNAUTHORIZED,
                        "사용자 이름 또는 패스워드가 올바르지 않습니다."
                ));

        // 입력한 패스워드와 DB의 암호화된 패스워드 비교
        if (!passwordEncoder.matches(request.password(), user.getPassword())) {
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED,
                    "사용자 이름 또는 패스워드가 올바르지 않습니다."
            );
        }

        String token = jwtUtil.createToken(user);

        return new TokenResponse(token, "Bearer");
    }

    private void validateRequest(String username, String password) {
        if (username == null || username.isBlank()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "사용자 이름을 입력해야 합니다."
            );
        }

        if (password == null || password.isBlank()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "패스워드를 입력해야 합니다."
            );
        }
    }
}
