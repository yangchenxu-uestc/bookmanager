package com.example.bookmanager.service.impl;

import com.example.bookmanager.entity.Admin;
import com.example.bookmanager.entity.AdminExample;
import com.example.bookmanager.mapper.AdminMapper;
import com.example.bookmanager.service.IAdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class IAdminServiceImpl implements IAdminService {
    @Resource
    private AdminMapper adminMapper;
    @Override
    public boolean adminIsExist(String name) {
        //Example类主要是用来对查询进行添加条件的。
        // Model类只能进行简单的查询操作，如果想要自己加一些查询的条件，可以使用Example类
        AdminExample adminExample = new AdminExample();
        AdminExample.Criteria criteria = adminExample.createCriteria();
        criteria.andAdminNameEqualTo(name);
        List<Admin> admin = adminMapper.selectByExample(adminExample);
        if(null == admin){
            return false;
        }
        if(admin.size() < 1){
            return false;
        }
        return true;
    }

    @Override
    public Admin adminLogin(String name, String password) {
        AdminExample adminExample = new AdminExample();
        AdminExample.Criteria criteria = adminExample.createCriteria();
        criteria.andAdminNameEqualTo(name);
        List<Admin> admin = adminMapper.selectByExample(adminExample);

        for(Admin a : admin){
            if(a.getAdminPwd().equals(password)){
                return a;
            }
        }
        return null;
    }
}
