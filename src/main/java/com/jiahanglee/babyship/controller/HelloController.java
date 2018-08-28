package com.jiahanglee.babyship.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    * @author jiahanglee
    * @description //TODO
    * @date 15:30 2018/8/28
    * @Param [sddd]
    * @return java.lang.String
    **/
    @GetMapping(value = "/hello")
    public  String say() {
        return girlProperties.getCupSize();
    }

}
