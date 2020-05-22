package com.aliyun.carManager.imp;

import com.aliyun.carManager.ocr.AliyunOCR;
import com.aliyun.carManager.pojo.RecognizeStatus;
import com.aliyun.carManager.service.OCRService;
import com.aliyun.ocr20191230.models.RecognizeDriverLicenseResponse;
import com.aliyun.ocr20191230.models.RecognizeIdentityCardResponse;
import com.aliyun.ocr20191230.models.RecognizeLicensePlateResponse;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class IOCRService implements OCRService {
    @Override
    public RecognizeStatus getIdCardInfo(File file) throws Exception {
        return AliyunOCR.recognizeIdentityCard(file);
    }

    @Override
    public RecognizeDriverLicenseResponse getDriveCardInfo(File file) throws Exception {
        return AliyunOCR.recognizeDriverLicense(file);
    }

    @Override
    public RecognizeLicensePlateResponse getCarCardInfo(File file) throws Exception {
        return AliyunOCR.recognizeLicensePlate(file);
    }
}
