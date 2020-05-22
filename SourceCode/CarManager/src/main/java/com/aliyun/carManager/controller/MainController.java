package com.aliyun.carManager.controller;

import com.aliyun.carManager.dao.UserDao;
import com.aliyun.carManager.pojo.User;
import com.aliyun.carManager.service.OCRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;

@Controller
public class MainController {
    @Resource
    private OCRService ocrService;
    @Resource
    private UserDao userDao;

    //@RequestMapping(method = RequestMethod.POST,value = "/getIdCardInfo")
    @PostMapping("/getIdCardInfo")
    @ResponseBody
    public Object getIdCardInfo(@RequestParam("file") MultipartFile file) throws Exception {
        if (file.isEmpty()) {
            System.out.println("上传失败");
        }
        String fileName = file.getOriginalFilename();
        String filePath = ClassUtils.getDefaultClassLoader().getResource("static").getPath() + "/idCard/images/";
        System.out.println(filePath);
        File saveFile = new File(filePath);
        if (!saveFile.exists()) {
            saveFile.mkdirs();
        }

        saveFile = new File(filePath + fileName);

        try {
            file.transferTo(saveFile);
            System.out.println("上传成功！");
        } catch (IOException e) {
            System.out.println(e.toString());
        }

        return ocrService.getIdCardInfo(saveFile);
    }

    @PostMapping("/uploadIdCard")
    @ResponseBody
    public Object uploadIdCard(@RequestParam("file") MultipartFile file, User user,String idCardImg) throws Exception {
        if (file.isEmpty()) {
            System.out.println("上传失败");
        }
        System.out.println("UserID:" + user.getUid());
        String fileName = file.getOriginalFilename();
        String filePath = ClassUtils.getDefaultClassLoader().getResource("static").getPath() + "/idCard/images/";
        String suffix = fileName.substring(fileName.lastIndexOf("."),fileName.length());
        System.out.println(filePath);
        System.out.println("UID:" + user.getUid());
        File saveFile = new File(filePath);
        if (!saveFile.exists()) {
            saveFile.mkdirs();
        }

        if (user.getUid() == null) {
            saveFile = new File(filePath + idCardImg + fileName.substring(fileName.lastIndexOf("."),fileName.length()));
        } else {
            user.setIdCardImg(user.getUid().toString() + suffix);
            userDao.updateUserIdCardImg(user,suffix);
            saveFile = new File(filePath + user.getUid().toString() + suffix);
        }

        try {
            file.transferTo(saveFile);
            System.out.println("上传成功！");
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        return ocrService.getIdCardInfo(saveFile);
    }

    @PostMapping("/getDriveCardInfo")
    @ResponseBody
    public Object getDriveCardInfo(@RequestParam("file") MultipartFile file) throws Exception {
        if (file.isEmpty()) {
            System.out.println("上传失败");
        }
        String fileName = file.getOriginalFilename();
        String filePath = ClassUtils.getDefaultClassLoader().getResource("static").getPath() + "/driveCard/images/";
        System.out.println(filePath);
        File saveFile = new File(filePath);
        if (!saveFile.exists()) {
            saveFile.mkdirs();
        }

        saveFile = new File(filePath + fileName);

        try {
            file.transferTo(saveFile);
            System.out.println("上传成功！");
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        return ocrService.getDriveCardInfo(saveFile);
    }

    @PostMapping("/getCarCardInfo")
    @ResponseBody
    public Object getCarCardInfo(@RequestParam("file") MultipartFile file) throws Exception {
        if (file.isEmpty()) {
            System.out.println("上传失败");
        }
        String fileName = file.getOriginalFilename();
        String filePath = ClassUtils.getDefaultClassLoader().getResource("static").getPath() + "/carCard/images/";
        System.out.println(filePath);
        File saveFile = new File(filePath);
        if (!saveFile.exists()) {
            saveFile.mkdirs();
        }

        saveFile = new File(filePath + fileName);

        try {
            file.transferTo(saveFile);
            System.out.println("上传成功！");
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        return ocrService.getCarCardInfo(saveFile);
    }
}