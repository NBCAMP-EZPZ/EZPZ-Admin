package com.sparta.ezpzadmin.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorType {

    // JWT
    INVALID_REFRESH_TOKEN(HttpStatus.UNAUTHORIZED, "유효하지 않은 리프레시 토큰입니다. 다시 로그인 해주세요."),
    CARD_ACCESS_FORBIDDEN(HttpStatus.FORBIDDEN, "카드 작성자 및 매니저만 접근할 수 있습니다."),

    // User

    // Popup
    POPUP_NOT_FOUNT(HttpStatus.NOT_FOUND, "존재하지 않는 팝업입니다."),
    POPUP_ALREADY_APPROVED(HttpStatus.LOCKED, "이미 승인된 팝업입니다.");

    // Order

    // Item

    // Reservation

    //

    private final HttpStatus httpStatus;
    private final String message;

}