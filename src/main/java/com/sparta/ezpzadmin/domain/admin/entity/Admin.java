package com.sparta.ezpzadmin.domain.admin.entity;

import com.sparta.ezpzadmin.common.entity.Timestamped;
import com.sparta.ezpzadmin.domain.admin.dto.SignupRequestDto;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Admin extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id")
    private Long id;

    private String username;

    private String password;

    private String email;

    private Admin(SignupRequestDto dto, String encodedPassword) {
        username = dto.getUsername();
        password = encodedPassword;
        email = dto.getEmail();
    }

    public static Admin of(SignupRequestDto dto, String encodedPassword) {
        return new Admin(dto, encodedPassword);
    }

}
