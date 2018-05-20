package com.codegym.file.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

public class FileUtils {
    public static String UPLOAD_LOCATION = "/Users/nhat/Desktop/upload/";

    public static String generateRandomName(){
        return UUID.randomUUID().toString();
    }

    public static void saveFile(MultipartFile multipartFile, String filePath) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(multipartFile.getInputStream());
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
        byte[] buffer = new byte[1024];
        int length;
        while ((length = bis.read(buffer)) > 0){
            bos.write(buffer, 0, length);
        }
        bis.close();
        bos.close();
    }

    public static String getExtension(String fileName){
        int dotIndex = fileName.lastIndexOf('.');
        return fileName.substring(dotIndex);
    }
}
