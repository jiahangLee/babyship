package com.jiahanglee.babyship.util;

import java.util.List;

public class MyUtil {
    public static Boolean MyListContent(List<String> a,String b){
        for(String x : a){
            if(x.equals(b)){
                return true;
            }
        }
        return false;
    }
}
