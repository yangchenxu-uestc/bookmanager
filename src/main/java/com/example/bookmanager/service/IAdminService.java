package com.example.bookmanager.service;


import com.example.bookmanager.entity.Admin;

public interface IAdminService {
    //验证用户是否存在
    boolean adminIsExist(String name);

    //管理员登陆
    Admin adminLogin(String name, String password);
}
