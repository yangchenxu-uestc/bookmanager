package com.example.bookmanager.controller;

import com.example.bookmanager.entity.User;
import com.example.bookmanager.service.IUserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UserController {
    @Resource
    private IUserService userService;

    @RequestMapping("/userLogin")
    @ResponseBody
    public  String userlogin(@Param("userName") String userName,
                             @Param("password") String password,
                             HttpServletRequest request){
        User user = userService.userLogin(userName, password);
        if(user != null){
            request.getSession().setAttribute("flag", 0);
            request.getSession().setAttribute("user", user);
            return "登录成功";
        }
        request.getSession().setAttribute("flag", 1);
        return "登录失败";
    }

    @RequestMapping("/isUserExist")
    @ResponseBody
    public String isUserExist(@Param("userName") String userName){
        boolean b = userService.findUserByUserName(userName);
        if(b){
            return "用户账号存在";
        }else{
            return "用户账号不存在";
        }
    }
}
