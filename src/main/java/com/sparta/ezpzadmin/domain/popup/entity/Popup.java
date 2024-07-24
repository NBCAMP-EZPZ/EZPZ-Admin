package com.sparta.ezpzadmin.domain.popup.entity;

import com.sparta.ezpzadmin.common.entity.Timestamped;
import com.sparta.ezpzadmin.common.exception.CustomException;
import com.sparta.ezpzadmin.common.exception.ErrorType;
import com.sparta.ezpzadmin.domain.host.entity.Host;
import com.sparta.ezpzadmin.domain.popup.enums.ApprovalStatus;
import com.sparta.ezpzadmin.domain.popup.enums.PopupStatus;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Popup extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "popup_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "host_id", nullable = false)
    private Host host;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(name = "thumbnail_url", nullable = false)
    private String thumbnailUrl;

    @Column(name = "thumbnail_name", nullable = false)
    private String thumbnailName;

    @Column(nullable = false)
    private String address;

    @Column(name = "manager_name", nullable = false)
    private String managerName;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "popup_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private PopupStatus popupStatus;

    @Column(name = "approval_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private ApprovalStatus approvalStatus;

    @Column(name = "like_count")
    private int likeCount;

    @Column(name = "start_date", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDateTime endDate;

    /**
     * 팝업 승인/반려
     * @param approval 승인 여부
     */
    public void approvePopup(boolean approval) {
        if (this.approvalStatus == ApprovalStatus.APPROVED) {
            throw new CustomException(ErrorType.POPUP_ALREADY_APPROVED);
        }else if (this.approvalStatus == ApprovalStatus.REJECTED) {
            throw new CustomException(ErrorType.POPUP_ALREADY_REJECTED);
        }
        if (approval) {
            this.approvalStatus = ApprovalStatus.APPROVED;
        }else {
            this.approvalStatus = ApprovalStatus.REJECTED;
            this.popupStatus = PopupStatus.CANCELED;
        }
    }
}
