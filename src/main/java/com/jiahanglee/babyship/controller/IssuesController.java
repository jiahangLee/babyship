package com.jiahanglee.babyship.controller;

import com.jiahanglee.babyship.entity.Issues;
import com.jiahanglee.babyship.service.IssuesService;
import com.jiahanglee.babyship.theone.SystemParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
@CrossOrigin
@RestController
public class IssuesController {
    @Autowired
    private IssuesService issuesService;
    @Autowired
    SystemParams systemParams;
    @PostMapping("/addIssues")
    public int addUser(Issues user) {
        return issuesService.addTeacher(user);
    }

    @GetMapping(value = "/allIssues")
    public Object findAllUser(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1")
                    int pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10")
                    int pageSize,
            HttpServletResponse response,HttpServletRequest request
    ) {
        response.setHeader("Access-Control-Allow-Origin", systemParams.getWeb_url());
        response.setHeader("Access-Control-Allow-Credentials", "true");
        return issuesService.findAllTeacher(pageNum, pageSize);
    }

    @GetMapping(value = "/deleteIssues")
    public int deleteTeacher(@RequestParam(name = "id",required = false) Integer id){
          return issuesService.deleteTeacher(id);
    }

    @PostMapping(value = "/updateIssues")
    public void update(Issues teacher){
         issuesService.update(teacher);
    }




}
