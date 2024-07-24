package com.sparta.ezpzadmin.domain.coupon.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class CouponRequestDto {

    @NotBlank(message = "쿠폰명은 공백일 수 없습니다.")
    private String name;

    @NotNull(message = "할인 금액은 필수 값입니다.")
    @Size(min = 1_000, max = 100_000, message = "할인 금액은 최소 1,000원 이상, 최대 100,000원 이하이어야 합니다.")
    private int discountAmount;

    @NotNull(message = "발행 개수는 필수 값입니다.")
    @Size(min = 1, message = "발행 개수는 최소 1개입니다.")
    private int totalCount;

    @NotNull(message = "만료일은 필수 값입니다.")
    private LocalDate expiredAt;

}
