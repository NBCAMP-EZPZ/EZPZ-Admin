package com.sparta.ezpzadmin.domain.coupon.service;

import com.sparta.ezpzadmin.common.exception.CustomException;
import com.sparta.ezpzadmin.common.exception.ErrorType;
import com.sparta.ezpzadmin.domain.coupon.dto.CouponRequestDto;
import com.sparta.ezpzadmin.domain.coupon.entity.Coupon;
import com.sparta.ezpzadmin.domain.coupon.repository.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static com.sparta.ezpzadmin.common.exception.ErrorType.*;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CouponService {

    private final CouponRepository couponRepository;

    @Transactional
    public Coupon createCoupon(CouponRequestDto dto) {
        // 쿠폰명 중복 확인
        if (couponRepository.existsByName(dto.getName())) {
            throw new CustomException(DUPLICATED_COUPON_NAME);
        }
        // 만료일이 현재 날짜보다 과거인지 확인
        if (dto.getExpiredAt().isBefore(LocalDate.now())) {
            throw new CustomException(INVALID_COUPON_EXPIRATION);
        }
        return couponRepository.save(Coupon.of(dto));
    }

}
