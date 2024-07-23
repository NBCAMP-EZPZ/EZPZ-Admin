package com.sparta.ezpzadmin.domain.popup.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PopupPageResponseDto {

    private final Long popupId;
    private final String name;
    private final String companyName;
    private final LocalDateTime createdAt;

    private PopupPageResponseDto(Long popupId, String name, String companyName, LocalDateTime createdAt) {
        this.popupId = popupId;
        this.name = name;
        this.companyName = companyName;
        this.createdAt = createdAt;
    }

    public static PopupPageResponseDto of(Long popupId, String name, String companyName, LocalDateTime createdAt) {
        return new PopupPageResponseDto(popupId, name, companyName, createdAt);
    }
}
