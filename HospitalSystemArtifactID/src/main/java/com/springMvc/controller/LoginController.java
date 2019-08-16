package com.springMvc.controller;

import com.springMvc.service.PasswordChecker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    PasswordChecker checker;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLoginPage(){
        // 返回登陆页面
        return "login";
    }

    @RequestMapping(value = "/userLogin", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> login(@RequestParam("userId") int userId, @RequestParam("password") String password,
                                     @RequestParam("userType") int userType, HttpServletRequest request){
        // 检查用户账号密码是否正确
        boolean flag = checker.check(userId, password, userType);
        Map<String, String> rs = new HashMap<String, String>();

        if (!flag){
            rs.put("success", "false");
            return rs;
        }else{
            rs.put("success", "true");
            HttpSession session = request.getSession();
            session.setAttribute("userId", userId);
            session.setAttribute("password", password);
            session.setAttribute("userType", userType);
            return rs;
        }
    }
}
