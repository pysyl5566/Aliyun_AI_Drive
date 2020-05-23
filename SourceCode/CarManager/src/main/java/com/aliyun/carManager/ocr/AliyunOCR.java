package com.aliyun.carManager.ocr;

import com.alibaba.fastjson.JSON;
import com.aliyun.carManager.pojo.RecognizeStatus;
import com.aliyun.ocr20191230.Client;
import com.aliyun.ocr20191230.models.*;
import com.aliyun.tearpc.models.Config;
import com.aliyun.teautil.models.RuntimeOptions;
//import com.aliyuncs.AcsResponse;
//import com.aliyuncs.DefaultAcsClient;
//import com.aliyuncs.IAcsClient;
//import com.aliyuncs.RpcAcsRequest;
//import com.aliyuncs.exceptions.ClientException;
//import com.aliyuncs.exceptions.ServerException;
//import com.aliyuncs.profile.DefaultProfile;
import okhttp3.OkHttpClient;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AliyunOCR {
    static Config config = null;
    static Client client = null;

    static {
        if (config == null) {
            config = new Config();
            config.accessKeyId= "您的KeyId";
            config.accessKeySecret= "您的KeySecret";
            config.regionId="cn-shanghai";
            config.protocol = "https";
            config.endpoint="ocr.cn-shanghai.aliyuncs.com";
        }

        if (client == null) {
            try {
                client = new Client(config);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

//    public AliyunOCR() {
//        if (client == null) {
//            client = new DefaultAcsClient(profile);
//        }
//    }

//    private static <R extends RpcAcsRequest<T>, T extends AcsResponse> T getAcsResponse(R req) throws Exception {
//        try {
//            return client.getAcsResponse(req);
//        } catch (ServerException e) {
//            // 服务端异常
//            System.out.println(String.format("ServerException: errCode=%s, errMsg=%s", e.getErrCode(), e.getErrMsg()));
//            throw e;
//        } catch (ClientException e) {
//            // 客户端错误
//            System.out.println(String.format("ClientException: errCode=%s, errMsg=%s", e.getErrCode(), e.getErrMsg()));
//            throw e;
//        } catch (Exception e) {
//            System.out.println("Exception:" + e.getMessage());
//            throw e;
//        }
//    }

//    public static void printResponse(String actionName, String requestId, AcsResponse  data) {
//        System.out.println(String.format("actionName=%s, requestId=%s, data=%s", actionName, requestId,
//                JSON.toJSONString(data) ));
//    }

    public static RecognizeStatus recognizeIdentityCard(File file) throws Exception {
        System.out.println("--------  身份证识别 --------------");
        RecognizeIdentityCardAdvanceRequest req = new RecognizeIdentityCardAdvanceRequest();
        InputStream inputStream = new FileInputStream(file);
        req.side = "face";
        req.imageURLObject = inputStream;

        RecognizeIdentityCardResponse resp = null;
        RecognizeStatus recognizeStatus = new RecognizeStatus();
        try {
            resp = client.recognizeIdentityCardAdvance(req,new RuntimeOptions());
        } catch (Exception e) {
            recognizeStatus.setSuccess(false);
            e.printStackTrace();
            return recognizeStatus;
        }
        System.out.println(JSON.toJSONString(resp));
        recognizeStatus.setSuccess(true);
        recognizeStatus.setData(resp);
        return recognizeStatus;
        //RecognizeIdentityCardResponse resp = getAcsResponse(req);
        //printResponse(req.getSysActionName(), resp.getRequestId(), resp);
    }

    public static RecognizeDriverLicenseResponse recognizeDriverLicense(File file) throws Exception {
        System.out.println("--------  驾驶证识别 --------------");
        RecognizeDriverLicenseAdvanceRequest req = new RecognizeDriverLicenseAdvanceRequest();
        InputStream inputStream = new FileInputStream(file);
        req.side = "face";
        req.imageURLObject = inputStream;
        RecognizeDriverLicenseResponse resp = client.recognizeDriverLicenseAdvance(req,new RuntimeOptions());
        System.out.println(JSON.toJSONString(resp));
        return resp;
        //RecognizeIdentityCardResponse resp = getAcsResponse(req);
        //printResponse(req.getSysActionName(), resp.getRequestId(), resp);
    }

    public static RecognizeLicensePlateResponse recognizeLicensePlate(File file) throws Exception {
        System.out.println("--------  车牌号识别 --------------");
        RecognizeLicensePlateAdvanceRequest req = new RecognizeLicensePlateAdvanceRequest();
        InputStream inputStream = new FileInputStream(file);
        //req.side = "face";
        req.imageURLObject = inputStream;
        RecognizeLicensePlateResponse resp = client.recognizeLicensePlateAdvance(req,new RuntimeOptions());
        System.out.println(JSON.toJSONString(resp));
        return resp;
        //RecognizeIdentityCardResponse resp = getAcsResponse(req);
        //printResponse(req.getSysActionName(), resp.getRequestId(), resp);
    }

}
