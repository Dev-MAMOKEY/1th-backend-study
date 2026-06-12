package com.haonkr.jwt.config;

import com.haonkr.jwt.filter.JwtAuthFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.nio.charset.StandardCharsets;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthFilter jwtAuthFilter;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                // REST API이므로 CSRF 비활성화
                .csrf(csrf -> csrf.disable())

                // JWT를 사용하므로 세션을 생성하지 않음
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

                // 기본 로그인 화면 비활성화
                .formLogin(form -> form.disable())

                // HTTP Basic 인증 비활성화
                .httpBasic(basic -> basic.disable())

                // 인증 및 권한 오류 응답 설정
                .exceptionHandling(exception -> exception

                        // 인증되지 않은 사용자의 접근
                        .authenticationEntryPoint(
                                (request, response, authException) -> {
                                    response.setStatus(401);
                                    response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                                    response.setCharacterEncoding(StandardCharsets.UTF_8.name());
                                    response.getWriter().write("{\"message\":\"인증이 필요합니다.\"}");
                                }
                        )

                        // 인증은 되었지만 권한이 부족한 경우
                        .accessDeniedHandler(
                                ((request, response, accessDeniedException) -> {
                                    response.setStatus(403);
                                    response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                                    response.setCharacterEncoding(StandardCharsets.UTF_8.name());
                                    response.getWriter().write("{\"message\":\"접근 권한이 없습니다.\"}");
                                })
                        )
                )

                // 엔드포인트 권한 설정
                .authorizeHttpRequests(auth -> auth

                        // 회원 가입과 로그인은 인증 없이 접근 가능
                        .requestMatchers(HttpMethod.POST, "/auth/register", "/auth/login").permitAll()

                        // 오류 처리 경로 허용
                        .requestMatchers("/error").permitAll()

                        // 나머지 모든 요청은 인증 필요
                        .anyRequest().authenticated()
                )

                // JWT 필터를 UsernamePasswordAuthenticationFilter보다 앞에서 실행
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
