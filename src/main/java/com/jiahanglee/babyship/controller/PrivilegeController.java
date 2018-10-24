package com.jiahanglee.babyship.controller;

import com.jiahanglee.babyship.entity.rbac_jpa.Privilege;
import com.jiahanglee.babyship.service.PrivilegeService;
import com.jiahanglee.babyship.util.treeAuth.ConvertTree;
import com.jiahanglee.babyship.util.treeAuth.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
 * @date 2018/10/24 16:32
 * @description //TODO
 */
    @RestController
    @CrossOrigin
    public class PrivilegeController {
        @Autowired
        private PrivilegeService privilegeService;

        @PostMapping(value = "/addPrivilege")
        public int addPrivilege(Privilege privilege) {
            return privilegeService.addPrivilege(privilege);
        }

        @GetMapping(value = "/deletePrivilege")
        public int deletePrivilege(@RequestParam(name = "id", required = false) Integer id) {
            return privilegeService.deletePrivilege(id);
        }

        @PostMapping(value = "/updatePrivilege")
        public void updatePrivilege(Privilege privilege) {
            privilegeService.update(privilege);
        }

        @GetMapping(value = "/allPrivilege")
        public Object allPrivilege(
                @RequestParam(name = "pageNum", required = false, defaultValue = "1")
                        int pageNum,
                @RequestParam(name = "pageSize", required = false, defaultValue = "10")
                        int pageSize
        ) {
            return privilegeService.findAllPrivilege(pageNum, pageSize);
        }


}
