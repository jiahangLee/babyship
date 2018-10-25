package com.jiahanglee.babyship.controller;

import com.github.pagehelper.PageInfo;
import com.jiahanglee.babyship.entity.rbac_jpa.Menu;
import com.jiahanglee.babyship.service.MenuService;
import com.jiahanglee.babyship.util.treeAuth.ConvertTree;
import com.jiahanglee.babyship.util.treeAuth.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    //获得单个menu和他的子菜单，无法向上延伸
    @GetMapping(value = "/allMenu")
    public TreeNode<Menu> allMenu(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1")
                    int pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10")
                    int pageSize
    ) {
        List<Menu> list = menuService.findAllMenu();

        for (Menu menu : list) {
            if (menu.getId() == 4) {
                TreeNode<Menu> test2 = new TreeNode<>(menu, new ArrayList<>());
                test2.setChildrenNode(test2.childrenNode(list, "id", "parentId"));
                return test2;
            }
        }
        return null;
    }

    //**************************** 返回菜单树 ********************************

    //通过role获取privilege，通过privilege获取所有menu，最后形成菜单森林返回前台
    @GetMapping(value = "/selectMenusByRole")
    public List<TreeNode<Menu>> getMenuTree(Integer role) {
        //获取所有菜单
        List<Menu> allMenus = menuService.findAllMenu();
        //获取该role下所有menus
        List<Menu> aboutMenus = menuService.selectByRole(2);
        System.out.println(aboutMenus);
        //向上拓展，获取完整上级
        List<Menu> menuTree = initMenuData(allMenus,aboutMenus);
        System.out.println(menuTree);
        //生成树和森林
        ConvertTree convertTree2 = new ConvertTree<>();
        ConvertTree<Menu> convertTree = new ConvertTree<>();
        List<TreeNode<Menu>> forest = convertTree.getForest(menuTree, "id", "parentId");
        return forest;
    }
    //
    /**
     * 初始化菜单数据
     * @param aboutMenus
     * @return
     */
    private List<Menu> initMenuData(List<Menu> allMenus,List<Menu> aboutMenus) {
        List<Menu> funcData = new ArrayList<>();
        Menu menu = new Menu();
        List<Menu> list = allMenus;
        for (Menu mnu : aboutMenus) {
            boolean flag = true;
            for (Menu func : funcData) {
                if (mnu.getId() == func.getId()) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                funcData.add(mnu);
                this.getParentMenus((long) mnu.getParentId(), list, funcData);
            }
        }
        return funcData;
    }
    //获取上级菜单
    private void getParentMenus(Long mnuId, List<Menu> list, List<Menu> funcData){
        for(Menu mnu : list){
            if(mnu.getId() == mnuId){
                boolean flag = true;
                for(Menu func : funcData){
                    if(mnu.getId() == func.getId()){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    funcData.add(mnu);
                }
                if(mnu.getParentId() < 0 || !flag){
                    return ;
                }
                getParentMenus((long) mnu.getParentId(),list,funcData);
            }

        }
    }

}
