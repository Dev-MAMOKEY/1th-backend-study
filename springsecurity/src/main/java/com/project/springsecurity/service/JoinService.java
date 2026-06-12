package com.project.springsecurity.service;

import com.project.springsecurity.dto.JoinDto;
import com.project.springsecurity.entity.UserEntity;
import com.project.springsecurity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class JoinService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public void joinProcess(JoinDto joinDto){
        String name = joinDto.username();
        String password = joinDto.password();


        Boolean isExist = userRepository.existsByUsername(name);

        if(isExist){
            throw new IllegalStateException("이미 존재하는 아이디입니다.");
        }

        UserEntity user = UserEntity.builder().
                username(name).
                password(bCryptPasswordEncoder.encode(password)).
                role("ROLE_USER").build();

        userRepository.save(user);



    }
}
