package com.sparta.ezpzadmin.domain.coupon.controller;

import com.sparta.ezpzadmin.common.dto.CommonResponse;
import com.sparta.ezpzadmin.domain.coupon.dto.CouponRequestDto;
import com.sparta.ezpzadmin.domain.coupon.dto.CouponResponseDto;
import com.sparta.ezpzadmin.domain.coupon.entity.Coupon;
import com.sparta.ezpzadmin.domain.coupon.service.CouponService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.sparta.ezpzadmin.common.util.ControllerUtil.getResponseEntity;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/coupons")
public class CouponController {

    private final CouponService couponService;

    @PostMapping
    public ResponseEntity<CommonResponse<?>> createCoupon(
            @Valid @RequestBody CouponRequestDto dto) {

        Coupon coupon = couponService.createCoupon(dto);
        return getResponseEntity(CouponResponseDto.of(coupon), "쿠폰 생성 성공");
    }

}
