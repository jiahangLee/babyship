package com.jiahanglee.babyship.theone;

import com.jiahanglee.babyship.util.FileUploadUtil;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;


/**
 * @author jiahanglee
 * @version 0.0.1
 * @date 2018/8/28 15:31
 * @description //TODO
 */
@CrossOrigin
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

    @GetMapping(value = "/hello2")
    public void say2(HttpServletResponse response, HttpServletRequest request) {
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map<String, String> map = new HashMap<>();
        map.put("status", "success");
        if (writer != null) {
            writer.write(new JSONObject(map).toString());
        }

    }
    @PostMapping(value = "/upload")
    public String save(MultipartFile file) {
        System.out.print( file.getName());
        String msg = "";
        // 要上传的目标文件存放路径
        String localPath = "C:/Users/Administrator/Desktop/upload";
        msg= FileUploadUtil.upload(file,localPath,file.getOriginalFilename());

        System.out.println(msg);
        return msg;
    }

    @PostMapping(value = "/uploadplus")
    public String save2(MultipartFile file) throws JSONException {

        String json = "{}";
        JSONObject jsonObj = new JSONObject(json);
        Map<String, String> ingredients = new HashMap<String, String>();
//
//
        System.out.print( file.getName());
        String msg = "";
        // 要上传的目标文件存放路径
        String localPath = "C:/Users/Administrator/Desktop/uploadplus";
        msg= FileUploadUtil.upload(file,localPath,file.getOriginalFilename());

        ingredients.put("link","http://localhost:8002/babyship/download?url="+msg );
        jsonObj.put("data",new JSONObject(ingredients));
        System.out.println(msg);
        return jsonObj.toString().replaceAll("\\\\","");

//        String json = "{}";
//        JSONObject jsonObj;
//        JSONObject jsonObj2;
//        jsonObj2 = new JSONObject(json);
//
//
//        try {
//            jsonObj = new JSONObject(json);
//            Map<String, String> ingredients = new HashMap<String, String>();
//            ingredients.put("data", "http://localhost:8002/babyship/download?url=");
//            jsonObj.put("hello", new JSONObject(ingredients));
//            System.out.println(jsonObj.toString());
//            return jsonObj.toString();
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//            return jsonObj2.toString();

    }
}
