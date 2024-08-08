package com.sparta.ezpzadmin.domain.coupon.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class CouponRequestDto {

    @NotBlank(message = "쿠폰명은 공백일 수 없습니다.")
    private String name;

    @NotNull(message = "할인 금액은 필수 값입니다.")
    @Min(value = 1000, message = "할인 금액은 최소 1,000원 이상이어야 합니다.")
    @Max(value = 100000, message = "할인 금액은 최대 100,000원 이하이어야 합니다.")
    private int discountAmount;

    @NotNull(message = "발행 개수는 필수 값입니다.")
    @Min(value = 1, message = "발행 개수는 최소 1개이어야 합니다.")
    private int totalCount;

    @NotNull(message = "만료일은 필수 값입니다.")
    private LocalDate expiredAt;

}
