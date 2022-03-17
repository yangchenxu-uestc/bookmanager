package com.example.bookmanager.controller;

import com.example.bookmanager.entity.Admin;
import com.example.bookmanager.service.IAdminService;
import com.example.bookmanager.service.IUserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
public class AdminController {
    @Resource
    private IAdminService adminService;
    @Resource
    private IUserService userService;

    @RequestMapping("/isAdminExist")//用来处理请求地址映射
    @ResponseBody//该方法的返回的结果直接写入 HTTP 响应正文中
    public String adminIsExist(@Param("adminName") String adminName){
        boolean b = adminService.adminIsExist(adminName);
        if(b){
            return "管理员账号存在";
        }else{
            return "管理员账号不存在";
        }
    }

    @RequestMapping("/adminLogin")
    @ResponseBody
    public String adminLogin(@Param("userName") String userName, @Param("password") String password, HttpServletRequest request){
        Admin admin = adminService.adminLogin(userName, password);
        if(admin == null){
            request.getSession().setAttribute("flag", 1);
            return "账号不存在";
        }
        //服务器那里开辟一个内存出来用于存放一些数据
        // 而这些数据只要这个内存还存在就可以在任何地方访问到，
        // setAttribute(key,value.)这是给这个内存放东西用的
        request.getSession().setAttribute("flag", 0);
        request.getSession().setAttribute("admin", admin);
        return "登录成功";
    }

    @RequestMapping("/adminLogOut")
    @ResponseBody
    public String userLogOut(HttpServletRequest request){
        request.getSession().invalidate();
        return "退出登录成功";
    }
}
