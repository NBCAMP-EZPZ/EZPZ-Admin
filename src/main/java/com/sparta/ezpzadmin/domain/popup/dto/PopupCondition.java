package com.sparta.ezpzadmin.domain.popup.dto;

import lombok.Getter;

@Getter
public class PopupCondition {

    private final String approvalStatus;

    private PopupCondition(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public static PopupCondition of(String approvalStatus) {
        return new PopupCondition(approvalStatus);
    }
}
