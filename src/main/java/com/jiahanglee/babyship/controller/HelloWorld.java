package com.jiahanglee.babyship.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiahanglee
 * @version 0.0.1
 * @date 2018/8/28 15:31
 * @description //TODO
 */
@RestController
public class HelloWorld {
   /**
    * @author jiahanglee
    * @description //TODO
    * @date 15:30 2018/8/28
    * @Param [sddd]
    * @return java.lang.String
    **/
    @RequestMapping("/hello")
    public static String test(String sddd){
        return "hello world!!!5555ere55erewr4545454ddfdffdfdfdytytyty";
    }
    public static String test2(String jiji){
        return "zhehsiwo";
    }

}
