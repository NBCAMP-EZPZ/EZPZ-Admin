package com.sparta.ezpzadmin.domain.popup.util;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class S3Util {

    // AWS S3 클라이언트
    private final AmazonS3 amazonS3;

    @Value("${cloud.aws.s3.bucketName}")
    private String bucketName;

    /**
     * AWS S3 파일 삭제
     * @param fileName 파일 url
     */
    public void deleteFile(String fileName) {
        DeleteObjectRequest request = new DeleteObjectRequest(bucketName, fileName);
        amazonS3.deleteObject(request);
    }
}
