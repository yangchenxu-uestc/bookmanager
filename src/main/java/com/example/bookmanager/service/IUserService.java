package com.example.bookmanager.service;


import com.example.bookmanager.entity.User;

public interface IUserService {
    User userLogin(String username, String password);

    boolean findUserByUserName(String userName);
}
