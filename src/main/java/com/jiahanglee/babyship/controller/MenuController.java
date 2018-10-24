package com.jiahanglee.babyship.controller;

import com.github.pagehelper.PageInfo;
import com.jiahanglee.babyship.entity.rbac_jpa.Menu;
import com.jiahanglee.babyship.service.MenuService;
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
    public class MenuController {
        @Autowired
        private MenuService menuService;

        @PostMapping(value = "/addMenu")
        public int addMenu(Menu menu) {
            return menuService.addMenu(menu);
        }

        @GetMapping(value = "/deleteMenu")
        public int deleteMenu(@RequestParam(name = "id", required = false) Integer id) {
            return menuService.deleteMenu(id);
        }

        @PostMapping(value = "/updateMenu")
        public void updateMenu(Menu menu) {
            menuService.update(menu);
        }

        @GetMapping(value = "/allMenu")
        public List<TreeNode<Menu>> allMenu(
                @RequestParam(name = "pageNum", required = false, defaultValue = "1")
                        int pageNum,
                @RequestParam(name = "pageSize", required = false, defaultValue = "10")
                        int pageSize
        ) {
            List<Menu> list =  menuService.findAllMenu(pageNum, pageSize);
            ConvertTree convertTree = new ConvertTree<>();
            return convertTree.getForest(list,"id","parentId");
        }


}
