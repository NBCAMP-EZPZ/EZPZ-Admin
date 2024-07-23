package com.sparta.ezpzadmin.domain.admin.service;

import com.sparta.ezpzadmin.domain.admin.entity.RefreshToken;
import com.sparta.ezpzadmin.domain.admin.repository.RefreshTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RefreshTokenService {

    private final RefreshTokenRepository refreshTokenRepository;

    @Transactional
    public void save(String username, String refreshToken) {
        refreshTokenRepository.save(new RefreshToken(username, refreshToken));
    }

    @Transactional
    public void delete(String refreshToken) {
        refreshTokenRepository.deleteByRefreshToken(refreshToken);
    }

}