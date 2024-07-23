package com.sparta.ezpzadmin.domain.popup.dto;

import lombok.Getter;

@Getter
public class ImageResponseDto {

    private final String name;
    private final String url;

    public ImageResponseDto(String name, String url) {
        this.name = name;
        this.url = url;
    }
}
