package com.sparta.ezpzadmin.domain.popup.repository.popup;

import com.sparta.ezpzadmin.common.util.PageUtil;
import com.sparta.ezpzadmin.domain.popup.entity.Popup;
import org.springframework.data.domain.Page;

public interface PopupRepositoryCustom {
    Page<Popup> findAllPopupsByStatus(PageUtil pageUtil);
}
