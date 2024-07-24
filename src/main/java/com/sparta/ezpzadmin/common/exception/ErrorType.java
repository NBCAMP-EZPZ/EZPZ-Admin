package com.sparta.ezpzadmin.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Getter
@AllArgsConstructor
public enum ErrorType {

    // JWT
    INVALID_REFRESH_TOKEN(UNAUTHORIZED, "유효하지 않은 리프레시 토큰입니다. 다시 로그인 해주세요."),
    CARD_ACCESS_FORBIDDEN(FORBIDDEN, "카드 작성자 및 매니저만 접근할 수 있습니다."),

    // Admin
    DUPLICATED_USERNAME(BAD_REQUEST, "이미 존재하는 관리자 아이디입니다."),

    // Popup
    POPUP_NOT_FOUNT(HttpStatus.NOT_FOUND, "존재하지 않는 팝업입니다."),
    POPUP_ALREADY_APPROVED(HttpStatus.LOCKED, "이미 승인된 팝업입니다."),
    POPUP_ALREADY_REJECTED(HttpStatus.LOCKED, "이미 반려된 팝업입니다.");

    // Order

    // Item

    // Reservation

    // Coupon
    DUPLICATED_COUPON_NAME(BAD_REQUEST, "이미 존재하는 쿠폰명입니다."),
    INVALID_COUPON_EXPIRATION(BAD_REQUEST, "만료일이 현재 날짜보다 과거입니다.")

    ;
    private final HttpStatus httpStatus;
    private final String message;

}