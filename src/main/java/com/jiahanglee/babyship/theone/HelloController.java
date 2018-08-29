package com.jiahanglee.babyship.theone;

import com.jiahanglee.babyship.util.FileUploadUtil;
import org.hibernate.validator.constraints.ConstraintComposition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.lang.reflect.Field;
import java.util.List;

import static org.springframework.data.repository.init.ResourceReader.Type.JSON;

/**
 * @author jiahanglee
 * @version 0.0.1
 * @date 2018/8/28 15:31
 * @description //TODO
 */
@RestController
public class HelloController {

    @Autowired
    private GirlProperties girlProperties;

    /**
     * @return java.lang.String
     * @author jiahanglee
     * @description //TODO
     * @date 15:30 2018/8/28
     * @Param [sddd]
     **/
    @GetMapping(value = "/hello")
    public String say() {
        return girlProperties.getCupSize();
    }

    @CrossOrigin
    @PostMapping(value = "/upload")
    public String save(MultipartFile file) {
        System.out.print( file.getName());
        String msg = "";
        // 要上传的目标文件存放路径
        String localPath = "C:/Users/Administrator/Desktop/upload";
        if(FileUploadUtil.upload(file,localPath,file.getOriginalFilename())){
            msg = "上传成功";
        }else{
            msg = "上传失败";
        }
        return "okok";
    }
}
