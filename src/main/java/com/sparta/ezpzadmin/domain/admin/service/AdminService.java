package com.sparta.ezpzadmin.domain.admin.service;

import com.sparta.ezpzadmin.common.exception.CustomException;
import com.sparta.ezpzadmin.common.exception.ErrorType;
import com.sparta.ezpzadmin.domain.admin.dto.SignupRequestDto;
import com.sparta.ezpzadmin.domain.admin.entity.Admin;
import com.sparta.ezpzadmin.domain.admin.repository.AdminRepository;
import com.sparta.ezpzadmin.domain.admin.repository.RefreshTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AdminService {

    private final PasswordEncoder passwordEncoder;
    private final AdminRepository adminRepository;
    private final RefreshTokenRepository refreshTokenRepository;

    /**
     * 이용자 회원가입
     *
     * @param dto 회원가입 시 필요한 정보
     * @return 회원가입된 이용자 엔티티
     */
    @Transactional
    public Admin signup(SignupRequestDto dto) {
        if (adminRepository.existsByUsername(dto.getUsername())) {
            throw new CustomException(ErrorType.DUPLICATED_USERNAME);
        }
        String encodedPassword = passwordEncoder.encode(dto.getPassword());
        return adminRepository.save(Admin.of(dto, encodedPassword));
    }

    /**
     * 이용자 로그아웃
     *
     * @param user 로그아웃 요청한 이용자
     */
    @Transactional
    public void logout(Admin user) {
        refreshTokenRepository.deleteById(user.getUsername());
    }

}
