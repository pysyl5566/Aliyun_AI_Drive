package com.aliyun.carManager.service;

import com.aliyun.carManager.pojo.RecognizeStatus;
import com.aliyun.ocr20191230.models.RecognizeDriverLicenseResponse;
import com.aliyun.ocr20191230.models.RecognizeIdentityCardResponse;
import com.aliyun.ocr20191230.models.RecognizeLicensePlateResponse;
import org.springframework.stereotype.Service;

import java.io.File;

public interface OCRService {
    public RecognizeStatus getIdCardInfo(File file) throws Exception;
    public RecognizeDriverLicenseResponse getDriveCardInfo(File file) throws Exception;
    public RecognizeLicensePlateResponse getCarCardInfo(File file) throws Exception;
}
