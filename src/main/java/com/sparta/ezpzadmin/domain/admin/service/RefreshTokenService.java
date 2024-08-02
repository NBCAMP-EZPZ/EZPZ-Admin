package com.sparta.ezpzadmin.domain.admin.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sparta.ezpzadmin.domain.admin.entity.RefreshToken;
import com.sparta.ezpzadmin.domain.admin.repository.RefreshTokenRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RefreshTokenService {
    
    private final RefreshTokenRepository refreshTokenRepository;
    
    public void save(String username, String refreshToken) {
        refreshTokenRepository.save(new RefreshToken(username, refreshToken));
    }
    
    public Optional<RefreshToken> findByRefreshToken(String refreshToken) {
        return refreshTokenRepository.findByRefreshToken(refreshToken);
    }
    
    public void deleteByRefreshToken(String refreshToken) {
        refreshTokenRepository.deleteByRefreshToken(refreshToken);
    }
}