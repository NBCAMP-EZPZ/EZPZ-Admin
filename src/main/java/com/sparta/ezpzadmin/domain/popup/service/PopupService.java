package com.sparta.ezpzadmin.domain.popup.service;

import com.sparta.ezpzadmin.common.exception.CustomException;
import com.sparta.ezpzadmin.common.exception.ErrorType;
import com.sparta.ezpzadmin.common.util.PageUtil;
import com.sparta.ezpzadmin.domain.popup.dto.PopupPageResponseDto;
import com.sparta.ezpzadmin.domain.popup.dto.PopupResponseDto;
import com.sparta.ezpzadmin.domain.popup.entity.Popup;
import com.sparta.ezpzadmin.domain.popup.repository.popup.PopupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PopupService {

    private final PopupRepository popupRepository;
    private final ImageService imageService;

    /**
     * 승인 상태별 팝업 목록 조회
     * @param pageUtil 페이지 정보
     * @return 팝업 목록
     */
    public Page<?> findAllPopupsByStatus(PageUtil pageUtil) {
        // todo : Admin 구현 완료 시 수정
        String companyName = "companyName";

        return popupRepository.findAllPopupsByStatus(pageUtil)
                .map(p -> PopupPageResponseDto.of(p.getId(), p.getName(), companyName, p.getCreatedAt()));
    }

    /**
     * 팝업 상세 조회
     * @param popupId 팝업 ID
     * @return 팝업 상세정보
     */
    public PopupResponseDto findPopup(Long popupId) {
        Popup popup = popupRepository.findById(popupId)
                .orElseThrow(() -> new CustomException(ErrorType.POPUP_NOT_FOUNT));

        List<String> imageUrls = imageService.findAllByPopup(popup);

        return PopupResponseDto.of(popup, imageUrls);
    }

    /**
     * 팝업 승인/빈려
     * @param popupId 팝업 ID
     * @param approval 승인 여부
     */
    @Transactional
    public void approvePopup(Long popupId, boolean approval) {
        Popup popup = popupRepository.findById(popupId)
                .orElseThrow(() -> new CustomException(ErrorType.POPUP_NOT_FOUNT));
        popup.approvePopup(approval);
        popupRepository.save(popup);
    }
}
