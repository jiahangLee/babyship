package com.jiahanglee.babyship.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jiahanglee.babyship.dao.IssuesDao;
import com.jiahanglee.babyship.entity.Issues;
import com.jiahanglee.babyship.service.IssuesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "issuesService")
public class IssuesServiceImpl implements IssuesService{

    @Autowired
    private IssuesDao issuesDao;
    @Override
    public int addTeacher(Issues Issues) {
        return issuesDao.insert(Issues);
    }

    @Override
    public PageInfo<Issues> findAllTeacher(int pageNum, int pageSize) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, pageSize);
        List<Issues> userDomains = issuesDao.selectTeachers();
        PageInfo result = new PageInfo(userDomains);
        return result;
    }

    @Override
    public int deleteTeacher(Integer id) {
        return issuesDao.delete(id);
    }

    @Override
    public void update(Issues Issues) {
         issuesDao.update(Issues);
    }
}
