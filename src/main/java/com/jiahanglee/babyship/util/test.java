package com.jiahanglee.babyship.util;



import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * code is far away from bug with the animal protecting
 * ┏┓　　　┏┓
 * ┏┛┻━━━┛┻┓
 * ┃　　　　　　　┃
 * ┃　　　━　　　┃
 * ┃　┳┛　┗┳　┃
 * ┃　　　　　　　┃
 * ┃　　　┻　　　┃
 * ┃　　　　　　　┃
 * ┗━┓　　　┏━┛
 * 　　┃　　　┃神兽保佑
 * 　　┃　　　┃代码无BUG！
 * 　　┃　　　┗━━━┓
 * 　　┃　　　　　　　┣┓
 * 　　┃　　　　　　　┏┛
 * 　　┗┓┓┏━┳┓┏┛
 * 　　　┃┫┫　┃┫┫
 * 　　　┗┻┛　┗┻┛
 *
 * @author jiahanglee
 * @version 0.0.1
 * @date 2018/9/6 18:06
 * @description //TODO
 */
public class test {

    public static void main(String[] args) {
        String json = "{'name':'lijiahang'}";
        JSONObject jsonObj;


        try {
            jsonObj = new JSONObject(json);
            Map<String, String> ingredients = new HashMap<String, String>();
            ingredients.put("data","http://localhost:8002/babyship/download?url=");
            jsonObj.put("hello", ingredients);
            System.out.println(jsonObj);
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}
