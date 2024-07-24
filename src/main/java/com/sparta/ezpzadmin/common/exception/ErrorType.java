package com.sparta.ezpzadmin.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static com.sparta.ezpzadmin.common.resolver.CustomPageableHandlerMethodArgumentResolver.MAX_PAGE_SIZE;
import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Getter
@AllArgsConstructor
public enum ErrorType {

    // Page
    INVALID_PAGE_NUMBER_FORMAT(BAD_REQUEST, "숫자 형식이 아닌 페이지 number입니다."),
    INVALID_PAGE_SIZE_FORMAT(BAD_REQUEST, "숫자 형식이 아닌 페이지 size입니다."),
    INVALID_PAGE_NUMBER(BAD_REQUEST, "페이지 number는 음수일 수 없습니다."),
    INVALID_PAGE_SIZE(BAD_REQUEST, "페이지 size는 0 이하일 수 없습니다."),
    EXCEED_MAX_PAGE_SIZE(BAD_REQUEST, "페이지 size는 " + MAX_PAGE_SIZE + "을 초과할 수 없습니다."),
    EMPTY_PAGE_ELEMENTS(BAD_REQUEST, "페이지의 요소가 존재하지 않습니다."),
    PAGE_NOT_FOUND(BAD_REQUEST, "존재하지 않는 페이지입니다."),

    // JWT
    INVALID_REFRESH_TOKEN(UNAUTHORIZED, "유효하지 않은 리프레시 토큰입니다. 다시 로그인 해주세요."),
    CARD_ACCESS_FORBIDDEN(FORBIDDEN, "카드 작성자 및 매니저만 접근할 수 있습니다."),

    // Admin
    DUPLICATED_USERNAME(BAD_REQUEST, "이미 존재하는 관리자 아이디입니다."),

    // Popup
    POPUP_NOT_FOUNT(HttpStatus.NOT_FOUND, "존재하지 않는 팝업입니다."),
    POPUP_ALREADY_APPROVED(HttpStatus.LOCKED, "이미 승인된 팝업입니다."),
    POPUP_ALREADY_REJECTED(HttpStatus.LOCKED, "이미 반려된 팝업입니다."),

    // Order

    // Item

    // Reservation

    // Coupon
    DUPLICATED_COUPON_NAME(BAD_REQUEST, "이미 존재하는 쿠폰명입니다."),
    INVALID_COUPON_EXPIRATION(BAD_REQUEST, "만료일이 현재 날짜보다 과거입니다."),

    ;
    private final HttpStatus httpStatus;
    private final String message;

}