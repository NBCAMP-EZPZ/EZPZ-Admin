package com.sparta.ezpzadmin.domain.coupon.entity;

import com.sparta.ezpzadmin.domain.coupon.dto.CouponRequestDto;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coupon_id")
    private Long id;

    private String name;

    private int discountAmount;

    private int totalCount;

    private LocalDate expiredAt;

    private Coupon(CouponRequestDto dto) {
        this.name = dto.getName();
        this.discountAmount = dto.getDiscountAmount();
        this.totalCount = dto.getTotalCount();
        this.expiredAt = dto.getExpiredAt();
    }

    public static Coupon of(CouponRequestDto dto) {
        return new Coupon(dto);
    }

}
