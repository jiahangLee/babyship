package com.jiahanglee.babyship.theone;

import org.hibernate.validator.constraints.ConstraintComposition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.lang.reflect.Field;
import java.util.List;

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

    @PostMapping(value = "/upload")
    public String save(
                       @RequestParam("name") String  fileList
    ) {
        System.out.print(fileList);
        return "ok";
    }
}
