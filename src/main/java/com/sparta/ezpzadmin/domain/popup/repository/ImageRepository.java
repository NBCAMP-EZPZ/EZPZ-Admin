package com.sparta.ezpzadmin.domain.popup.repository;

import com.sparta.ezpzadmin.domain.popup.entity.Image;
import com.sparta.ezpzadmin.domain.popup.entity.Popup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Long> {
    List<Image> findAllByPopup(Popup popup);
}
