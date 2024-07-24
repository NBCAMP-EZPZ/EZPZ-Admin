package com.sparta.ezpzadmin.domain.coupon.repository;

import com.sparta.ezpzadmin.domain.coupon.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon, Long> {

    boolean existsByName(String name);

}
