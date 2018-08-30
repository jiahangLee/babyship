package com.jiahanglee.babyship.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class FileUploadUtil {
    public static String upload(MultipartFile file,String path,String fileName){
        String realPath = path + "/" + FileNameUtils.getFileName(fileName);

        File dest = new File(realPath);

        if(!dest.getParentFile().exists()){
            dest.getParentFile().mkdir();
        }

        try {
            file.transferTo(dest);
            return realPath;
        } catch (IOException e) {
            e.printStackTrace();
            return "false";
        }
    }
}
