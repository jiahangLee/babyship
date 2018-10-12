package com.jiahanglee.babyship.theone;


import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
 * @date 2018/10/11 10:01
 * @description //TODO
 */
public class Demo {
    public static void main(String[] args){
//        createJson();
//        createJsonByMap();
//        jsonOS();
        mapAndJson();
    }

    private static void mapAndJson() {
        String soap = "1111";
        List<String> list = new ArrayList<>();
        JSONObject param1 = new JSONObject();
        Map<String, String> param0 = new HashMap<String, String>();
        list.add(soap);
        list.add(soap);
        try {
            param1.put("soap",soap);
            param1.put("soap","2222");
            param0.put("soap",soap);
            param0.put("soap","3333");

            System.out.println("这是list的输出：" + list);
            System.out.println("这是json的输出：" + param1);
            System.out.println("这是map的输出：" + param0);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private static void jsonOS() {
        JSONObject json = new JSONObject();
        try {
            JSONObject j = new JSONObject("{\"a\":\"苹果\"}");
            System.out.println(j.toString().getClass().getName());
            System.out.println(j.toString());
            System.out.println(j.getClass().getTypeName());
            System.out.println(j);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    private static void createJsonByMap() {
        //只能调用map有的方法，解除依赖
        Map<String,Object> jiahangLee = new HashMap<>();
        jiahangLee.put("name","李佳航");
        jiahangLee.put("sex","男");
        jiahangLee.put("age",24);
        jiahangLee.put("money",true);
        jiahangLee.put("major",new String[] {"理发", "挖掘机"} );
        System.out.println(jiahangLee.toString());
        System.out.println(new JSONObject(jiahangLee));
        System.out.println(new JSONObject(jiahangLee).toString());
    }

    private static void createJson() {
        JSONObject jiahangLee = new JSONObject();
        Object object = null;
        //创建JsonArray方法2
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("柯文修");
        arrayList.add("23");
        arrayList.add("5");
//        System.out.println("jsonArray2：" + JSONArray.fromObject(arrayList));
        try {
            jiahangLee.put("name","李佳航");
            jiahangLee.put("sex","男");
            jiahangLee.put("age",24);
            jiahangLee.put("money",true);
            jiahangLee.put("major",new String[] {"理发", "挖掘机"} );
            jiahangLee.put("major2222",arrayList);
            jiahangLee.put("girlfriend",object);
            System.out.println(jiahangLee.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
