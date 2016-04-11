package com.sinoway.zero.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sinoway.zero.bean.User;
import com.sinoway.zero.service.UserService;


@Controller
public class LoginController
{
    @RequestMapping("/login")
    public String login()
    {
        return "index";
    }

     /*@Autowired
     private UserService userService;
    
    
     @RequestMapping("/login")
     public String login(HttpSession session, String username, String
     password)
     throws Exception {
    
     // 调用service进行用户身份验证
     // ...
     User user = new User();
     user.setPassword(password);
     user.setUsername(username);
     //List<User> ulist = userService.FindUser(user);
     if (username != null && !username.equals("")) {//ulist.size() > 0
     // 在session中保存用户身份信息
     session.setAttribute("username", username);
    // ModelAndView modelandview = new ModelAndView();
    // modelandview.setViewName("index");
     // 重定向到商品列表页面
     return "index";
     } else {
    
     return "login";
     }
     }*/
    
    // 退出
    @RequestMapping("/logout")
    public String logout(HttpSession session) throws Exception
    {
        // 清除session
        session.invalidate();
        // 重定向到商品列表页面
        return "redirect:index.jsp";
    }

}
