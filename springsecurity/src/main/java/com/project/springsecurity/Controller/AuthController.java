package com.project.springsecurity.Controller;

import com.project.springsecurity.dto.JoinDto;
import com.project.springsecurity.global.RsData.RsData;
import com.project.springsecurity.service.JoinService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final JoinService joinService;

    @PostMapping("/register")
    public ResponseEntity<RsData<Void>> joinProcess(@RequestBody JoinDto joinDto) {
        joinService.joinProcess(joinDto);
        RsData<Void> rsData = new RsData<>("201-6", "회원가입이 완료되었습니다");
        return ResponseEntity.status(rsData.statusCode()).body(rsData);
    }
}
