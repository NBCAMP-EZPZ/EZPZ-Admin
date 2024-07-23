package com.sparta.ezpzadmin.domain.popup.repository.popup;

import com.sparta.ezpzadmin.domain.popup.entity.Popup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PopupRepository extends JpaRepository<Popup, Long>, PopupRepositoryQuery {
}
