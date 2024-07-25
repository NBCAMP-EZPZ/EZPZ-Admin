package com.sparta.ezpzadmin.domain.popup.repository.popup;

import com.sparta.ezpzadmin.domain.popup.dto.PopupCondition;
import com.sparta.ezpzadmin.domain.popup.entity.Popup;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PopupRepositoryCustom {
    Page<Popup> findAllPopupsByStatus(Pageable pageable, PopupCondition cond);
}
