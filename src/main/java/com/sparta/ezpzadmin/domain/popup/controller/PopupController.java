package com.sparta.ezpzadmin.domain.popup.controller;

import com.sparta.ezpzadmin.common.util.PageUtil;
import com.sparta.ezpzadmin.domain.popup.dto.PopupResponseDto;
import com.sparta.ezpzadmin.domain.popup.service.PopupService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.sparta.ezpzadmin.common.util.ControllerUtil.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PopupController {

    private final PopupService popupService;

    /**
     * 승인 상태별 팝업 목록 조회
     * @param page 페이지
     * @param size 개수
     * @param sortBy 정렬 기준
     * @param approvalStatus 승인 상태
     * @return 팝업 목록
     */
    @GetMapping("/v1/popups")
    public ResponseEntity<?> findAllPopupsByStatus(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "createdAt") String sortBy,
            @RequestParam(defaultValue = "all") String approvalStatus) {
        // todo : Admin 구현 시 추가

        PageUtil pageUtil = PageUtil.builder()
                .page(page)
                .size(size)
                .sortBy(sortBy)
                .firstStatus(approvalStatus)
                .build();

        Page<?> popupList = popupService.findAllPopupsByStatus(pageUtil);
        return getResponseEntity(popupList, "승인 상태별 팝업 목록 조회 성공");
    }

    /**
     * 팝업 상세 조회
     * @param popupId 팝업 ID
     * @return 팝업 상세정보
     */
    @GetMapping("/v1/popups/{popupId}")
    public ResponseEntity<?> findPopup(
            @PathVariable Long popupId) {
        PopupResponseDto responseDto = popupService.findPopup(popupId);
        return getResponseEntity(responseDto, "팝업스토어 상세보기 조회 성공");
    }

    /**
     * 팝업 승인/반려
     * @param popupId 팝업 ID
     * @param approval 승인 여부
     * @return 승인 여부 메시지
     */
    @PatchMapping("/v1/popups/{popupId}")
    public ResponseEntity<?> approvePopup(
            @PathVariable Long popupId,
            @RequestParam boolean approval) {
        popupService.approvePopup(popupId, approval);
        return getResponseEntity(approval ? "팝업 승인 성공" : "팝업 반려 성공");
    }
}
