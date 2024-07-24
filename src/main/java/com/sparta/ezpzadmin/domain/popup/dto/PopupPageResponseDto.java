package com.sparta.ezpzadmin.domain.popup.dto;

import com.sparta.ezpzadmin.domain.popup.entity.Popup;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PopupPageResponseDto {

    private final Long popupId;
    private final String name;
    private final String companyName;
    private final int likeCount;
    private final LocalDateTime createdAt;

    public PopupPageResponseDto(Popup popup) {
        this.popupId = popup.getId();
        this.name = popup.getName();
        this.companyName = popup.getHost().getCompanyName();
        this.likeCount = popup.getLikeCount();
        this.createdAt = popup.getCreatedAt();
    }

    public static PopupPageResponseDto of(Popup popup) {
        return new PopupPageResponseDto(popup);
    }
}
