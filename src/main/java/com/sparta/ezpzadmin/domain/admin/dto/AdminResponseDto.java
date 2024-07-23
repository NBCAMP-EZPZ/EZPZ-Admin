package com.sparta.ezpzadmin.domain.admin.dto;

import com.sparta.ezpzadmin.domain.admin.entity.Admin;
import lombok.Getter;

@Getter
public class AdminResponseDto {

    private final Long id;
    private final String username;
    private final String email;

    private AdminResponseDto(Admin admin) {
        this.id = admin.getId();
        this.username = admin.getUsername();
        this.email = admin.getEmail();
    }

    public static AdminResponseDto of(Admin admin) {
        return new AdminResponseDto(admin);
    }

}