package com.sparta.ezpzadmin.domain.admin.controller;

import com.sparta.ezpzadmin.common.dto.CommonResponse;
import com.sparta.ezpzadmin.common.security.UserDetailsImpl;
import com.sparta.ezpzadmin.domain.admin.dto.SignupRequestDto;
import com.sparta.ezpzadmin.domain.admin.dto.AdminResponseDto;
import com.sparta.ezpzadmin.domain.admin.entity.Admin;
import com.sparta.ezpzadmin.domain.admin.service.AdminService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.sparta.ezpzadmin.common.util.ControllerUtil.getResponseEntity;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class AdminController {

    private final AdminService adminService;

    /**
     * 이용자 회원가입
     *
     * @param dto 회원가입 시 필요한 정보
     * @return 회원가입된 이용자 정보와 응답 메시지를 포함한 ResponseEntity
     */
    @PostMapping("/signup")
    public ResponseEntity<CommonResponse<?>> signup(
            @Valid @RequestBody SignupRequestDto dto) {

        Admin admin = adminService.signup(dto);
        return getResponseEntity(AdminResponseDto.of(admin), "회원가입 성공");
    }

    /**
     * 이용자 로그아웃
     *
     * @param userDetails 이용자 인증 정보
     * @return 응답 메시지만 포함한 ResponseEntity
     */
    @PostMapping("/logout")
    public ResponseEntity<CommonResponse<?>> logout(
            @AuthenticationPrincipal UserDetailsImpl userDetails) {

        adminService.logout(userDetails.getAdmin());
        return getResponseEntity("로그아웃 성공");
    }

}
