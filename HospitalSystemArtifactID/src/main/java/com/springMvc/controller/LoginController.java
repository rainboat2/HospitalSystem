package com.springMvc.controller;

import com.springMvc.service.PasswordChecker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
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

    @RequestMapping(value = "/quit", method = RequestMethod.GET)
    public void quit(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession(false).invalidate();
        response.sendRedirect(request.getContextPath() + "/" + "login");
    }

    // 处理用户的登陆请求
    @RequestMapping(value = "/userLogin", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> userLogin(@RequestParam("userId") int userId, @RequestParam("password") String password,
                                         @RequestParam("userType") int userType,
                                         HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 检查用户账号密码是否正确
        boolean valid = checker.check(userId, password, userType);
        Map<String, String> rs = new HashMap<>();

        if (!valid){
            rs.put("success", "false");
            return rs;
        }else{
            rs.put("success", "true");
            // 登陆成功，添加会话
            HttpSession session = request.getSession();
            session.setAttribute("userId", userId);
            session.setAttribute("userType", userType);
            rs.put("path", request.getContextPath() + "/" + getPath(userType));
            return rs;
        }
    }

    // 根据用户类型，返回指定的页面路径
    private String getPath(int userType){
        switch (userType){
            case PasswordChecker.ADMINISTRATOR:
                return "/administrator";

            case PasswordChecker.CASHIER:
                return "/cashier";

            case PasswordChecker.MEDICAL_DOCTOR:
                return "/medicalDoctor";

            case PasswordChecker.OUTPATIENT_DOCTOR:
                return "/doctor";

            case PasswordChecker.PHARMACY_OPERATOR:
                return "/pharmacyOperator";

            default:
                throw new RuntimeException("未知用户类型");
        }
    }
}
