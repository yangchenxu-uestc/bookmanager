package com.example.bookmanager.service.impl;


import com.example.bookmanager.entity.User;
import com.example.bookmanager.entity.UserExample;
import com.example.bookmanager.mapper.UserMapper;
import com.example.bookmanager.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class IUserServiceImpl implements IUserService {

    @Resource
    private UserMapper userMapper;
    @Override
    public User userLogin(String username, String password) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();

        criteria.andUserNameEqualTo(username);
        List<User> users = userMapper.selectByExample(userExample);

        for(User a : users){
            if(a.getUserPwd().equals(password)){
                return a;
            }
        }
        return null;
    }

    @Override
    public boolean findUserByUserName(String userName) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();

        criteria.andUserNameEqualTo(userName);
        List<User> users = userMapper.selectByExample(userExample);
        if(null == users){
            return false;
        }
        if(users.size() < 1){
            return false;
        }
        return true;
    }
}
