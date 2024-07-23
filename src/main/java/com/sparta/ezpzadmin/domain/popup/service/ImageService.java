package com.sparta.ezpzadmin.domain.popup.service;

import com.sparta.ezpzadmin.domain.popup.entity.Image;
import com.sparta.ezpzadmin.domain.popup.entity.Popup;
import com.sparta.ezpzadmin.domain.popup.repository.ImageRepository;
import com.sparta.ezpzadmin.domain.popup.util.S3Util;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ImageService {

    private final ImageRepository imageRepository;
    private final S3Util s3Util;

    /**
     * 팝업으로 이미지 url 목록 조회
     * @param popup 팝업
     * @return 이미지 url 목록
     */
    public List<String> findAllByPopup(Popup popup) {
        return imageRepository.findAllByPopup(popup).stream()
                .map(Image::getUrl)
                .toList();
    }

    /**
     * 팝업으로 이미지 목록 조회
     * @param popup 팝업
     * @return 이미지 목록
     */
    public List<Image> findAllImageByPopup(Popup popup) {
        return imageRepository.findAllByPopup(popup);
    }

    /**
     * 썸네일 삭제 (S3)
     * @param thumbnailName 썸네일 저장명
     */
    public void deleteThumbnail(String thumbnailName) {
        s3Util.deleteFile(thumbnailName);
    }

    /**
     * 추가 사진 목록 삭제 (S3)
     * @param images 추가 사진 목록
     */
    public void deleteImages(List<Image> images) {
        if (CollectionUtils.isEmpty(images)) {
            return;
        }

        for (Image image : images) {
            s3Util.deleteFile(image.getName());
        }

        imageRepository.deleteAll(images);
    }
}
