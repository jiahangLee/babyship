package com.jiahanglee.babyship.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jiahanglee.babyship.dao.*;
import com.jiahanglee.babyship.entity.rbac_jpa.Privilege;
import com.jiahanglee.babyship.entity.rbac_jpa.Role;
import com.jiahanglee.babyship.service.RoleService;
import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service(value = "roleService")
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleDao roleDao;
    @Autowired
    private PrivilegeDao privilegeDao;
    @Autowired
    private MenuDao menuDao;
    @Autowired
    private PrivilegeMenuDao privilegeMenuDao;
    @Autowired
    private RolePrivilegeDao rolePrivilegeDao;
    @Override
    @Transactional(rollbackFor=Exception.class)
    public int addRole(Role role,String editor) {
        //插入role表
        roleDao.insert(role);

        //插入privilege表
        Privilege privilege = new Privilege();
        privilege.setLevel(1);
        privilege.setDescription(role.getName()+"的菜单权限");
        privilegeDao.insert(privilege);
        //插入关联表
        //获取二级菜单id的集合
        List<String> list= new ArrayList<>();
        List needMenuId = new ArrayList();
        try {
            JSONArray jsonArray = new JSONArray(editor);
            System.out.println("转成的JSONArray:"+jsonArray);
            for(int i=0;i<jsonArray.length();i++){
                list.add(jsonArray.get(i).toString());
            }
                     //流操作
             needMenuId = list.stream()
                    .filter(x->(x.charAt(0)>='0' && x.charAt(0)<='9'))
                    .map(x->menuDao.selectByKeyId(x))
                    .distinct()
                    .collect(toList());
            System.out.println("原数组是："+list);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        System.out.println("a是："+needMenuId);

        //插入privilege_menu关联表
        needMenuId.stream()
                .forEach(x->{
                    privilegeMenuDao.insert(privilege.getId(),(int)x);
                });
        //插入role_privilege关联表
        rolePrivilegeDao.insert(role.getId(),privilege.getId());
        return 1;
    }

    @Override
    public PageInfo<Role> findAllRole(int pageNum, int pageSize) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, pageSize);
        List<Role> roleDomains = roleDao.selectRole();
        return new PageInfo(roleDomains);
    }

    @Override
    public int deleteRole(Integer id) {
        return roleDao.delete(id);
    }

    @Override
    @Transactional(rollbackFor=Exception.class)
    public void update(Role role,String editor) {
        //修改常规字段
         roleDao.update(role);
        //获取二级菜单id的集合
        List<String> list= new ArrayList<>();
        List needMenuId = new ArrayList();
        try {
            JSONArray jsonArray = new JSONArray(editor);
            System.out.println("转成的JSONArray:"+jsonArray);
            for(int i=0;i<jsonArray.length();i++){
                list.add(jsonArray.get(i).toString());
            }
            //流操作
            needMenuId = list.stream()
                    .filter(x->(x.charAt(0)>='0' && x.charAt(0)<='9'))
                    .map(x->menuDao.selectByKeyId(x))
                    .distinct()
                    .collect(toList());
            System.out.println("原数组是："+list);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        //通过roleId获取privilegeId
        int privilegeId = rolePrivilegeDao.selectByRole(role.getId());
        //修改privilege_menu表
        privilegeMenuDao.delete(privilegeId);
        //插入privilege_menu关联表
        needMenuId.stream()
                .forEach(x->{
                    privilegeMenuDao.insert(privilegeId,(int)x);
                });
    }

    @Override
    public Role selectRole(Integer id) {
        return roleDao.selectById(id);
    }

}
